package redcore;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;

/**
 * BNO055 IMU for the FIRST Robotics Competition.
 * 
 * RNR4576 customization
 *
 *ORIGINAL C++ ADAFRUIT HEADER - https://github.com/adafruit/Adafruit_BNO055/
 *=======================================================================
 *This is a library for the BNO055 orientation sensor
 *
 *Designed specifically to work with the Adafruit BNO055 Breakout.
 *
 *Pick one up today in the adafruit shop!
 *------> http://www.adafruit.com/products
 *
 *These sensors use I2C to communicate, 2 pins are required to interface.
 *
 */
public class BNO055 {
	//Tread variables
	private java.util.Timer _UpateTimer;
	private static final long THREAD_PERIOD = 20; //ms - max poll rate on sensor.
	
	
	private static final byte BNO055_ADDRESS_A = 0x28;
	private static final int BNO055_ID = 0xA0;

	private static BNO055 _SingletonInstance;
	
	private static I2C _imu;
	
	private EBMOStates _CurrentState = EBMOStates.eInitialize;
	private EBMOStates _PrevCurrentState = EBMOStates.eInitialize;
	
	private volatile boolean _IsSensorPresent = false;
	private volatile boolean _IsInitialized = false;
	private volatile double _dCurrentTime_sec; //seconds
	private volatile double _dExpirationTime_sec; //seconds
	private volatile byte[] _EulerBuffer = new byte[6];
	private volatile byte[] _CalibrationDataBuffer = new byte[22];
	
	private volatile short _sRawPitch = 0;
	private volatile short _sRawRoll = 0;
	private volatile short _sRawHeading = 0;
	private volatile double _dConvRawEuler = 1.0 / 16.0;
	private volatile double _dPitch;
	private volatile double _dRoll;
	private volatile double  _dHeading;
	private volatile boolean _HaveNewCalibrationData = false;
	private volatile boolean _IsPendingCalibrationDisplay = true;
	private volatile CalibrationStatus _CalibrationStatus;
	

	
	private enum reg_t {
		/* Page id register definition */
		BNO055_PAGE_ID_ADDR                                     (0X07),

		/* PAGE0 REGISTER DEFINITION START*/
		BNO055_CHIP_ID_ADDR                                     (0x00),
		BNO055_ACCEL_REV_ID_ADDR                                (0x01),
		BNO055_MAG_REV_ID_ADDR                                  (0x02),
		BNO055_GYRO_REV_ID_ADDR                                 (0x03),
		BNO055_SW_REV_ID_LSB_ADDR                               (0x04),
		BNO055_SW_REV_ID_MSB_ADDR                               (0x05),
		BNO055_BL_REV_ID_ADDR                                   (0X06),

		/* Accel data register */
		BNO055_ACCEL_DATA_X_LSB_ADDR                            (0X08),
		BNO055_ACCEL_DATA_X_MSB_ADDR                            (0X09),
		BNO055_ACCEL_DATA_Y_LSB_ADDR                            (0X0A),
		BNO055_ACCEL_DATA_Y_MSB_ADDR                            (0X0B),
		BNO055_ACCEL_DATA_Z_LSB_ADDR                            (0X0C),
		BNO055_ACCEL_DATA_Z_MSB_ADDR                            (0X0D),

		/* Mag data register */
		BNO055_MAG_DATA_X_LSB_ADDR                              (0X0E),
		BNO055_MAG_DATA_X_MSB_ADDR                              (0X0F),
		BNO055_MAG_DATA_Y_LSB_ADDR                              (0X10),
		BNO055_MAG_DATA_Y_MSB_ADDR                              (0X11),
		BNO055_MAG_DATA_Z_LSB_ADDR                              (0X12),
		BNO055_MAG_DATA_Z_MSB_ADDR                              (0X13),

		/* Gyro data registers */
		BNO055_GYRO_DATA_X_LSB_ADDR                             (0X14),
		BNO055_GYRO_DATA_X_MSB_ADDR                             (0X15),
		BNO055_GYRO_DATA_Y_LSB_ADDR                             (0X16),
		BNO055_GYRO_DATA_Y_MSB_ADDR                             (0X17),
		BNO055_GYRO_DATA_Z_LSB_ADDR                             (0X18),
		BNO055_GYRO_DATA_Z_MSB_ADDR                             (0X19),

		/* Euler data registers */
		BNO055_EULER_H_LSB_ADDR                                 (0X1A),
		BNO055_EULER_H_MSB_ADDR                                 (0X1B),
		BNO055_EULER_R_LSB_ADDR                                 (0X1C),
		BNO055_EULER_R_MSB_ADDR                                 (0X1D),
		BNO055_EULER_P_LSB_ADDR                                 (0X1E),
		BNO055_EULER_P_MSB_ADDR                                 (0X1F),

		/* Quaternion data registers */
		BNO055_QUATERNION_DATA_W_LSB_ADDR                       (0X20),
		BNO055_QUATERNION_DATA_W_MSB_ADDR                       (0X21),
		BNO055_QUATERNION_DATA_X_LSB_ADDR                       (0X22),
		BNO055_QUATERNION_DATA_X_MSB_ADDR                       (0X23),
		BNO055_QUATERNION_DATA_Y_LSB_ADDR                       (0X24),
		BNO055_QUATERNION_DATA_Y_MSB_ADDR                       (0X25),
		BNO055_QUATERNION_DATA_Z_LSB_ADDR                       (0X26),
		BNO055_QUATERNION_DATA_Z_MSB_ADDR                       (0X27),

		/* Linear acceleration data registers */
		BNO055_LINEAR_ACCEL_DATA_X_LSB_ADDR                     (0X28),
		BNO055_LINEAR_ACCEL_DATA_X_MSB_ADDR                     (0X29),
		BNO055_LINEAR_ACCEL_DATA_Y_LSB_ADDR                     (0X2A),
		BNO055_LINEAR_ACCEL_DATA_Y_MSB_ADDR                     (0X2B),
		BNO055_LINEAR_ACCEL_DATA_Z_LSB_ADDR                     (0X2C),
		BNO055_LINEAR_ACCEL_DATA_Z_MSB_ADDR                     (0X2D),

		/* Gravity data registers */
		BNO055_GRAVITY_DATA_X_LSB_ADDR                          (0X2E),
		BNO055_GRAVITY_DATA_X_MSB_ADDR                          (0X2F),
		BNO055_GRAVITY_DATA_Y_LSB_ADDR                          (0X30),
		BNO055_GRAVITY_DATA_Y_MSB_ADDR                          (0X31),
		BNO055_GRAVITY_DATA_Z_LSB_ADDR                          (0X32),
		BNO055_GRAVITY_DATA_Z_MSB_ADDR                          (0X33),

		/* Temperature data register */
		BNO055_TEMP_ADDR                                        (0X34),

		/* Status registers */
		BNO055_CALIB_STAT_ADDR                                  (0X35),
		BNO055_SELFTEST_RESULT_ADDR                             (0X36),
		BNO055_INTR_STAT_ADDR                                   (0X37),

		BNO055_SYS_CLK_STAT_ADDR                                (0X38),
		BNO055_SYS_STAT_ADDR                                    (0X39),
		BNO055_SYS_ERR_ADDR                                     (0X3A),

		/* Unit selection register */
		BNO055_UNIT_SEL_ADDR                                    (0X3B),
		BNO055_DATA_SELECT_ADDR                                 (0X3C),

		/* Mode registers */
		BNO055_OPR_MODE_ADDR                                    (0X3D),
		BNO055_PWR_MODE_ADDR                                    (0X3E),

		BNO055_SYS_TRIGGER_ADDR                                 (0X3F),
		BNO055_TEMP_SOURCE_ADDR                                 (0X40),

		/* Axis remap registers */
		BNO055_AXIS_MAP_CONFIG_ADDR                             (0X41),
		BNO055_AXIS_MAP_SIGN_ADDR                               (0X42),

		/* SIC registers */
		BNO055_SIC_MATRIX_0_LSB_ADDR                            (0X43),
		BNO055_SIC_MATRIX_0_MSB_ADDR                            (0X44),
		BNO055_SIC_MATRIX_1_LSB_ADDR                            (0X45),
		BNO055_SIC_MATRIX_1_MSB_ADDR                            (0X46),
		BNO055_SIC_MATRIX_2_LSB_ADDR                            (0X47),
		BNO055_SIC_MATRIX_2_MSB_ADDR                            (0X48),
		BNO055_SIC_MATRIX_3_LSB_ADDR                            (0X49),
		BNO055_SIC_MATRIX_3_MSB_ADDR                            (0X4A),
		BNO055_SIC_MATRIX_4_LSB_ADDR                            (0X4B),
		BNO055_SIC_MATRIX_4_MSB_ADDR                            (0X4C),
		BNO055_SIC_MATRIX_5_LSB_ADDR                            (0X4D),
		BNO055_SIC_MATRIX_5_MSB_ADDR                            (0X4E),
		BNO055_SIC_MATRIX_6_LSB_ADDR                            (0X4F),
		BNO055_SIC_MATRIX_6_MSB_ADDR                            (0X50),
		BNO055_SIC_MATRIX_7_LSB_ADDR                            (0X51),
		BNO055_SIC_MATRIX_7_MSB_ADDR                            (0X52),
		BNO055_SIC_MATRIX_8_LSB_ADDR                            (0X53),
		BNO055_SIC_MATRIX_8_MSB_ADDR                            (0X54),

		/* Accelerometer Offset registers */
		ACCEL_OFFSET_X_LSB_ADDR                                 (0X55),
		ACCEL_OFFSET_X_MSB_ADDR                                 (0X56),
		ACCEL_OFFSET_Y_LSB_ADDR                                 (0X57),
		ACCEL_OFFSET_Y_MSB_ADDR                                 (0X58),
		ACCEL_OFFSET_Z_LSB_ADDR                                 (0X59),
		ACCEL_OFFSET_Z_MSB_ADDR                                 (0X5A),

		/* Magnetometer Offset registers */
		MAG_OFFSET_X_LSB_ADDR                                   (0X5B),
		MAG_OFFSET_X_MSB_ADDR                                   (0X5C),
		MAG_OFFSET_Y_LSB_ADDR                                   (0X5D),
		MAG_OFFSET_Y_MSB_ADDR                                   (0X5E),
		MAG_OFFSET_Z_LSB_ADDR                                   (0X5F),
		MAG_OFFSET_Z_MSB_ADDR                                   (0X60),

		/* Gyroscope Offset register s*/
		GYRO_OFFSET_X_LSB_ADDR                                  (0X61),
		GYRO_OFFSET_X_MSB_ADDR                                  (0X62),
		GYRO_OFFSET_Y_LSB_ADDR                                  (0X63),
		GYRO_OFFSET_Y_MSB_ADDR                                  (0X64),
		GYRO_OFFSET_Z_LSB_ADDR                                  (0X65),
		GYRO_OFFSET_Z_MSB_ADDR                                  (0X66),

		/* Radius registers */
		ACCEL_RADIUS_LSB_ADDR                                   (0X67),
		ACCEL_RADIUS_MSB_ADDR                                   (0X68),
		MAG_RADIUS_LSB_ADDR                                     (0X69),
		MAG_RADIUS_MSB_ADDR                                     (0X6A);

		private final int val;
		reg_t(int val) { this.val = val; }
		public int getVal() { return val; }
	};

	
	private static final byte POWER_MODE_NORMAL = 0X00;
	private static final byte OPERATION_MODE_CONFIG = 0X00;
	private static final byte OPERATION_MODE_NDOF = 0X0C;
	
	

	private class CalibrationStatus {
		public byte sys;
		public byte gyro;
		public byte accel;
		public byte mag;
	}
	
	
	
	private enum EBMOStates {
		eInitialize,
		eWaitForUnitToRespond,
		eEnterConfigMode,
		eResetDevice,
		eWaitResetComplete,
		eSetNormalPower,
		eSetUseCrystal,
		eEnterFusionMode,
		eWaitForFusionMode,
		eWaitingForCalibration,
		eRunning
	};	


	
	private BNO055(I2C.Port port, byte address) {
		_imu = new I2C(port, address);
		
		_UpateTimer = new java.util.Timer();
		_UpateTimer.schedule(new BNO055UpdateTask(this), 0L, THREAD_PERIOD);
	}

	
	
	public static BNO055 Instance() {
		if(_SingletonInstance == null) {
			_SingletonInstance = new BNO055(I2C.Port.kOnboard, BNO055_ADDRESS_A);
		}
		return _SingletonInstance;
	}

	
		
	public void SetCalibrationData(byte calibrationData[]) {
		_CalibrationDataBuffer = calibrationData;
		_HaveNewCalibrationData = true;
	}
	
	
	
	public boolean isCalibrated() {
		return _CurrentState == EBMOStates.eRunning;
	}
	
	
	
	/**
	 * Called periodically. Communicates with the sensor, and checks its state. 
	 */
	private void update() {
		if(_CurrentState != _PrevCurrentState) {
			System.out.println("BNO");
			_PrevCurrentState = _CurrentState;
		}
		_dCurrentTime_sec = Timer.getFPGATimestamp(); //seconds
		switch(_CurrentState) {
			case eInitialize:
				_HaveNewCalibrationData = false;
				_IsSensorPresent = false;
				_IsInitialized = false;
				_IsPendingCalibrationDisplay = true;
				_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
				_CurrentState = EBMOStates.eWaitForUnitToRespond;
				break;
			case eWaitForUnitToRespond:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					if((0xFF & read8(reg_t.BNO055_CHIP_ID_ADDR)) == BNO055_ID) {
						_IsSensorPresent = true;
						_dExpirationTime_sec = Timer.getFPGATimestamp() + 0.050;
						_CurrentState = EBMOStates.eEnterConfigMode;
					}				
				}
				break;
			case eEnterConfigMode:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					setMode(OPERATION_MODE_CONFIG);
					_CurrentState = EBMOStates.eResetDevice;
				}
				break;
			case eResetDevice:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					write8(reg_t.BNO055_SYS_TRIGGER_ADDR, (byte) 0x20);
					_CurrentState = EBMOStates.eWaitResetComplete;
				}
				break;
			case eWaitResetComplete:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					if((0xFF & read8(reg_t.BNO055_CHIP_ID_ADDR)) == BNO055_ID) {
						_CurrentState = EBMOStates.eSetNormalPower;
					}
				}
				break;
			case eSetNormalPower:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					write8(reg_t.BNO055_PWR_MODE_ADDR, POWER_MODE_NORMAL);
					_CurrentState = EBMOStates.eSetUseCrystal;
				}
				break;
			case eSetUseCrystal:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					write8(reg_t.BNO055_SYS_TRIGGER_ADDR, (byte) 0x80);
					_CurrentState = EBMOStates.eEnterFusionMode;
				}
				break;
			case eEnterFusionMode:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					setMode(OPERATION_MODE_NDOF);
					_CurrentState = EBMOStates.eWaitForFusionMode;
				}
				break;
			case eWaitForFusionMode:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_IsInitialized = true;
					_dExpirationTime_sec = _dCurrentTime_sec + 0.100;
					_CurrentState = EBMOStates.eWaitingForCalibration;
				}
				break;
			case eWaitingForCalibration:
				GetEulerValues();
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.100;

					if (_HaveNewCalibrationData) {
						_IsPendingCalibrationDisplay = false;
						setSensorOffsets();
						_HaveNewCalibrationData = false;
						_CurrentState = EBMOStates.eRunning;
					}
					else if (_IsPendingCalibrationDisplay) {
						getCalibrationStatus();
						if (isFullyCalibrated()) {
							getSensorOffsets();
							PrintCalibrationData();
							_IsPendingCalibrationDisplay = false;
							_CurrentState = EBMOStates.eRunning;
						}
					}
				}
				break;
			case eRunning:
				GetEulerValues();
				break;
		}
	}


	
	@SuppressWarnings("static-access")
	private void PrintCalibrationData() {
		String strBytes = "";
		for(int iIndex = 0; iIndex < _CalibrationDataBuffer.length; iIndex++) {
			if (strBytes.length() > 0)
				strBytes += ", ";
			strBytes += "".format("%x", _CalibrationDataBuffer[iIndex]);
		}
		System.out.println("byte calibrationData[] = {" + strBytes + "\"};");
	}
	
	
	
	private void GetEulerValues() {
		readLen(reg_t.BNO055_EULER_H_LSB_ADDR.getVal(), _EulerBuffer);

		// convert to short values
		_sRawHeading = (short)((_EulerBuffer[0] & 0xFF)
				| ((_EulerBuffer[1] << 8) & 0xFF00));
		_sRawRoll = (short)((_EulerBuffer[2] & 0xFF)
				| ((_EulerBuffer[3] << 8) & 0xFF00));
		_sRawPitch = (short)((_EulerBuffer[4] & 0xFF)
				| ((_EulerBuffer[5] << 8) & 0xFF00));

		/* 1 degree = 16 LSB */
		_dHeading = ((double)_sRawHeading) * _dConvRawEuler;
		_dRoll = ((double)_sRawRoll) * _dConvRawEuler;
		_dPitch = ((double)_sRawPitch) * _dConvRawEuler;
	}
	
	
	
	private void setMode(byte mode) {
		write8(reg_t.BNO055_OPR_MODE_ADDR, (byte) mode);
	}



	public boolean isSensorPresent() {
		return _IsSensorPresent;
	}


	
	public boolean isInitialized() {
		return _IsInitialized;
	}

	
	
	public String getCalibrationStatusString() {
		String StatusNames[] = {"No", "Almost", "Good"};
		return "Sys: " + StatusNames[_CalibrationStatus.sys]
				+ ", Gyro: " + StatusNames[_CalibrationStatus.gyro]
				+ ", Accel: " + StatusNames[_CalibrationStatus.accel]
				+ ", Mag: " + StatusNames[_CalibrationStatus.mag];
	}
	
	

	private void getCalibrationStatus() {
		_CalibrationStatus = new CalibrationStatus();
		int rawCalData = read8(reg_t.BNO055_CALIB_STAT_ADDR);

		_CalibrationStatus.sys = (byte) ((rawCalData >> 6) & 0x03);
		_CalibrationStatus.gyro = (byte) ((rawCalData >> 4) & 0x03);
		_CalibrationStatus.accel = (byte) ((rawCalData >> 2) & 0x03);
		_CalibrationStatus.mag = (byte) (rawCalData & 0x03);
	}
	
	

	private boolean isFullyCalibrated() {
		return (_CalibrationStatus.sys >= 3) && (_CalibrationStatus.accel >= 3) && (_CalibrationStatus.mag >= 3) && (_CalibrationStatus.gyro >= 3);
	}
	
	
	
	private void getSensorOffsets() {
		readLen(reg_t.ACCEL_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer);
	}
	
	
	
	private void setSensorOffsets()	{
	    setMode(OPERATION_MODE_CONFIG);
	    
	    write8(reg_t.ACCEL_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[0]);
	    write8(reg_t.ACCEL_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[1]);
	    write8(reg_t.ACCEL_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[2]);
	    write8(reg_t.ACCEL_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[3]);
	    write8(reg_t.ACCEL_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[4]);
	    write8(reg_t.ACCEL_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[5]);

	    write8(reg_t.MAG_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[6]);
	    write8(reg_t.MAG_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[7]);
	    write8(reg_t.MAG_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[8]);
	    write8(reg_t.MAG_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[9]);
	    write8(reg_t.MAG_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[10]);
	    write8(reg_t.MAG_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[11]);

	    write8(reg_t.GYRO_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[12]);
	    write8(reg_t.GYRO_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[13]);
	    write8(reg_t.GYRO_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[14]);
	    write8(reg_t.GYRO_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[15]);
	    write8(reg_t.GYRO_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[16]);
	    write8(reg_t.GYRO_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[17]);

	    write8(reg_t.ACCEL_RADIUS_LSB_ADDR, _CalibrationDataBuffer[18]);
	    write8(reg_t.ACCEL_RADIUS_MSB_ADDR, _CalibrationDataBuffer[19]);

	    write8(reg_t.MAG_RADIUS_LSB_ADDR, _CalibrationDataBuffer[20]);
	    write8(reg_t.MAG_RADIUS_MSB_ADDR, _CalibrationDataBuffer[21]);

	    setMode(OPERATION_MODE_NDOF);
	}	
	
	
	
	public double Picth() {
		return _dPitch;
	}

	

	public double Roll() {
		return _dRoll;
	}
	

	
	public double Heading() {
		return _dHeading;
	}

	
	
	private boolean write8(reg_t reg, byte value) {
		return _imu.write(reg.getVal(), value);
	}

	
	
	private byte read8(reg_t reg) {
		byte[] vals = new byte[1];
		readLen(reg, vals);
		return vals[0];
	}

	
	
	private boolean readLen(reg_t reg, byte[] buffer) {
		return readLen(reg.getVal(), buffer);
	}

	
	
	private boolean readLen(int reg, byte[] buffer) {
		if (buffer == null || buffer.length < 1)
			return false;
		return !_imu.read(reg, buffer.length, buffer);
	}
	
	
	
	/**
	 * Calls the update timer function to read the sensor
	 */
	private class BNO055UpdateTask extends TimerTask {
		private BNO055 _imuInstance;
		private BNO055UpdateTask(BNO055 imuInstance) {
			if (imuInstance == null)
				throw new NullPointerException("BNO055 pointer null");
			this._imuInstance = imuInstance;
		}
		public void run() {
			_imuInstance.update();
		}
	}
	
	
	
}