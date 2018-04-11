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
	private static final long THREAD_PERIOD = 10; //ms - max poll rate on sensor.
	
	
	private static final byte BNO055_ADDRESS_A = 0x28;
	private static final int BNO055_ID = 0xA0;

	private static BNO055 _SingletonInstance;
	
	private static I2C _imu;
	
	private EBMOStates _CurrentState = EBMOStates.eInitialize;
	private EBMOStates _PrevCurrentState = EBMOStates.eRunning;
	
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
	private CalibrationStatus _CalibrationStatus;
	
	/* Page id register definition */
	private static final byte BNO055_PAGE_ID_ADDR = 0X07;

	/* PAGE0 REGISTER DEFINITION START*/
	private static final byte BNO055_CHIP_ID_ADDR = 0x00;
	private static final byte BNO055_ACCEL_REV_ID_ADDR = 0x01;
	private static final byte BNO055_MAG_REV_ID_ADDR = 0x02;
	private static final byte BNO055_GYRO_REV_ID_ADDR = 0x03;
	private static final byte BNO055_SW_REV_ID_LSB_ADDR = 0x04;
	private static final byte BNO055_SW_REV_ID_MSB_ADDR = 0x05;
	private static final byte BNO055_BL_REV_ID_ADDR = 0X06;

	/* Accel data register */
	private static final byte BNO055_ACCEL_DATA_X_LSB_ADDR = 0X08;
	private static final byte BNO055_ACCEL_DATA_X_MSB_ADDR = 0X09;
	private static final byte BNO055_ACCEL_DATA_Y_LSB_ADDR = 0X0A;
	private static final byte BNO055_ACCEL_DATA_Y_MSB_ADDR = 0X0B;
	private static final byte BNO055_ACCEL_DATA_Z_LSB_ADDR = 0X0C;
	private static final byte BNO055_ACCEL_DATA_Z_MSB_ADDR = 0X0D;

	/* Mag data register */
	private static final byte BNO055_MAG_DATA_X_LSB_ADDR = 0X0E;
	private static final byte BNO055_MAG_DATA_X_MSB_ADDR = 0X0F;
	private static final byte BNO055_MAG_DATA_Y_LSB_ADDR = 0X10;
	private static final byte BNO055_MAG_DATA_Y_MSB_ADDR = 0X11;
	private static final byte BNO055_MAG_DATA_Z_LSB_ADDR = 0X12;
	private static final byte BNO055_MAG_DATA_Z_MSB_ADDR = 0X13;

	/* Gyro data registers */
	private static final byte BNO055_GYRO_DATA_X_LSB_ADDR = 0X14;
	private static final byte BNO055_GYRO_DATA_X_MSB_ADDR = 0X15;
	private static final byte BNO055_GYRO_DATA_Y_LSB_ADDR = 0X16;
	private static final byte BNO055_GYRO_DATA_Y_MSB_ADDR = 0X17;
	private static final byte BNO055_GYRO_DATA_Z_LSB_ADDR = 0X18;
	private static final byte BNO055_GYRO_DATA_Z_MSB_ADDR = 0X19;

	/* Euler data registers */
	private static final byte BNO055_EULER_H_LSB_ADDR = 0X1A;
	private static final byte BNO055_EULER_H_MSB_ADDR = 0X1B;
	private static final byte BNO055_EULER_R_LSB_ADDR = 0X1C;
	private static final byte BNO055_EULER_R_MSB_ADDR = 0X1D;
	private static final byte BNO055_EULER_P_LSB_ADDR = 0X1E;
	private static final byte BNO055_EULER_P_MSB_ADDR = 0X1F;

	/* Quaternion data registers */
	private static final byte BNO055_QUATERNION_DATA_W_LSB_ADDR = 0X20;
	private static final byte BNO055_QUATERNION_DATA_W_MSB_ADDR = 0X21;
	private static final byte BNO055_QUATERNION_DATA_X_LSB_ADDR = 0X22;
	private static final byte BNO055_QUATERNION_DATA_X_MSB_ADDR = 0X23;
	private static final byte BNO055_QUATERNION_DATA_Y_LSB_ADDR = 0X24;
	private static final byte BNO055_QUATERNION_DATA_Y_MSB_ADDR = 0X25;
	private static final byte BNO055_QUATERNION_DATA_Z_LSB_ADDR = 0X26;
	private static final byte BNO055_QUATERNION_DATA_Z_MSB_ADDR = 0X27;

	/* Linear acceleration data registers */
	private static final byte BNO055_LINEAR_ACCEL_DATA_X_LSB_ADDR = 0X28;
	private static final byte BNO055_LINEAR_ACCEL_DATA_X_MSB_ADDR = 0X29;
	private static final byte BNO055_LINEAR_ACCEL_DATA_Y_LSB_ADDR = 0X2A;
	private static final byte BNO055_LINEAR_ACCEL_DATA_Y_MSB_ADDR = 0X2B;
	private static final byte BNO055_LINEAR_ACCEL_DATA_Z_LSB_ADDR = 0X2C;
	private static final byte BNO055_LINEAR_ACCEL_DATA_Z_MSB_ADDR = 0X2D;

	/* Gravity data registers */
	private static final byte BNO055_GRAVITY_DATA_X_LSB_ADDR = 0X2E;
	private static final byte BNO055_GRAVITY_DATA_X_MSB_ADDR = 0X2F;
	private static final byte BNO055_GRAVITY_DATA_Y_LSB_ADDR = 0X30;
	private static final byte BNO055_GRAVITY_DATA_Y_MSB_ADDR = 0X31;
	private static final byte BNO055_GRAVITY_DATA_Z_LSB_ADDR = 0X32;
	private static final byte BNO055_GRAVITY_DATA_Z_MSB_ADDR = 0X33;

	/* Temperature data register */
	private static final byte BNO055_TEMP_ADDR = 0X34;

	/* Status registers */
	private static final byte BNO055_CALIB_STAT_ADDR = 0X35;
	private static final byte BNO055_SELFTEST_RESULT_ADDR = 0X36;
	private static final byte BNO055_INTR_STAT_ADDR = 0X37;

	private static final byte BNO055_SYS_CLK_STAT_ADDR = 0X38;
	private static final byte BNO055_SYS_STAT_ADDR = 0X39;
	private static final byte BNO055_SYS_ERR_ADDR = 0X3A;

	/* Unit selection register */
	private static final byte BNO055_UNIT_SEL_ADDR = 0X3B;
	private static final byte BNO055_DATA_SELECT_ADDR = 0X3C;

	/* Mode registers */
	private static final byte BNO055_OPR_MODE_ADDR = 0X3D;
	private static final byte BNO055_PWR_MODE_ADDR = 0X3E;

	private static final byte BNO055_SYS_TRIGGER_ADDR = 0X3F;
	private static final byte BNO055_TEMP_SOURCE_ADDR = 0X40;

	/* Axis remap registers */
	private static final byte BNO055_AXIS_MAP_CONFIG_ADDR = 0X41;
	private static final byte BNO055_AXIS_MAP_SIGN_ADDR = 0X42;

	/* SIC registers */
	private static final byte BNO055_SIC_MATRIX_0_LSB_ADDR = 0X43;
	private static final byte BNO055_SIC_MATRIX_0_MSB_ADDR = 0X44;
	private static final byte BNO055_SIC_MATRIX_1_LSB_ADDR = 0X45;
	private static final byte BNO055_SIC_MATRIX_1_MSB_ADDR = 0X46;
	private static final byte BNO055_SIC_MATRIX_2_LSB_ADDR = 0X47;
	private static final byte BNO055_SIC_MATRIX_2_MSB_ADDR = 0X48;
	private static final byte BNO055_SIC_MATRIX_3_LSB_ADDR = 0X49;
	private static final byte BNO055_SIC_MATRIX_3_MSB_ADDR = 0X4A;
	private static final byte BNO055_SIC_MATRIX_4_LSB_ADDR = 0X4B;
	private static final byte BNO055_SIC_MATRIX_4_MSB_ADDR = 0X4C;
	private static final byte BNO055_SIC_MATRIX_5_LSB_ADDR = 0X4D;
	private static final byte BNO055_SIC_MATRIX_5_MSB_ADDR = 0X4E;
	private static final byte BNO055_SIC_MATRIX_6_LSB_ADDR = 0X4F;
	private static final byte BNO055_SIC_MATRIX_6_MSB_ADDR = 0X50;
	private static final byte BNO055_SIC_MATRIX_7_LSB_ADDR = 0X51;
	private static final byte BNO055_SIC_MATRIX_7_MSB_ADDR = 0X52;
	private static final byte BNO055_SIC_MATRIX_8_LSB_ADDR = 0X53;
	private static final byte BNO055_SIC_MATRIX_8_MSB_ADDR = 0X54;

	/* Accelerometer Offset registers */
	private static final byte ACCEL_OFFSET_X_LSB_ADDR = 0X55;
	private static final byte ACCEL_OFFSET_X_MSB_ADDR = 0X56;
	private static final byte ACCEL_OFFSET_Y_LSB_ADDR = 0X57;
	private static final byte ACCEL_OFFSET_Y_MSB_ADDR = 0X58;
	private static final byte ACCEL_OFFSET_Z_LSB_ADDR = 0X59;
	private static final byte ACCEL_OFFSET_Z_MSB_ADDR = 0X5A;

	/* Magnetometer Offset registers */
	private static final byte MAG_OFFSET_X_LSB_ADDR = 0X5B;
	private static final byte MAG_OFFSET_X_MSB_ADDR = 0X5C;
	private static final byte MAG_OFFSET_Y_LSB_ADDR = 0X5D;
	private static final byte MAG_OFFSET_Y_MSB_ADDR = 0X5E;
	private static final byte MAG_OFFSET_Z_LSB_ADDR = 0X5F;
	private static final byte MAG_OFFSET_Z_MSB_ADDR = 0X60;

	/* Gyroscope Offset register s*/
	private static final byte GYRO_OFFSET_X_LSB_ADDR = 0X61;
	private static final byte GYRO_OFFSET_X_MSB_ADDR = 0X62;
	private static final byte GYRO_OFFSET_Y_LSB_ADDR = 0X63;
	private static final byte GYRO_OFFSET_Y_MSB_ADDR = 0X64;
	private static final byte GYRO_OFFSET_Z_LSB_ADDR = 0X65;
	private static final byte GYRO_OFFSET_Z_MSB_ADDR = 0X66;

	/* Radius registers */
	private static final byte ACCEL_RADIUS_LSB_ADDR = 0X67;
	private static final byte ACCEL_RADIUS_MSB_ADDR = 0X68;
	private static final byte MAG_RADIUS_LSB_ADDR = 0X69;
	private static final byte MAG_RADIUS_MSB_ADDR = 0X6A;


	
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
		eEnterConfigModeAfterReset,
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
			System.out.println("BNO state: " + _CurrentState);
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
					if((0xFF & read8(BNO055_CHIP_ID_ADDR)) == BNO055_ID) {
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
					write8(BNO055_PAGE_ID_ADDR,(byte)0);
					_CurrentState = EBMOStates.eResetDevice;
				}
				break;
			case eResetDevice:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					write8(BNO055_SYS_TRIGGER_ADDR, (byte) 0x20);
					_CurrentState = EBMOStates.eWaitResetComplete;
				}
				break;
			case eWaitResetComplete:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					if((0xFF & read8(BNO055_CHIP_ID_ADDR)) == BNO055_ID) {
						_CurrentState = EBMOStates.eEnterConfigModeAfterReset;

					}
				}
				break;
			case eEnterConfigModeAfterReset:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					setMode(OPERATION_MODE_CONFIG);
					write8(BNO055_PAGE_ID_ADDR,(byte)0);
					_CurrentState = EBMOStates.eSetNormalPower;
				}
				break;
			case eSetNormalPower:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					//write8(BNO055_PWR_MODE_ADDR, POWER_MODE_NORMAL);
					_CurrentState = EBMOStates.eSetUseCrystal;
				}
				break;
			case eSetUseCrystal:
				if (_dCurrentTime_sec >= _dExpirationTime_sec) {
					_dExpirationTime_sec = _dCurrentTime_sec + 0.050;
					//write8(BNO055_SYS_TRIGGER_ADDR, (byte) 0x80);
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
					
					read8(BNO055_SYS_STAT_ADDR);
					read8(BNO055_SYS_ERR_ADDR);
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
			strBytes += "".format("0x%x", _CalibrationDataBuffer[iIndex]);
		}
		System.out.println("byte calibrationData[] = {" + strBytes + "\"};");
	}
	
	
	
	private void GetEulerValues() {
		readLen(BNO055_EULER_H_LSB_ADDR, _EulerBuffer);

		// convert to short values
		_sRawHeading = (short)((_EulerBuffer[0] & 0xFF) | ((_EulerBuffer[1] << 8) & 0xFF00));
		_sRawRoll = (short)((_EulerBuffer[2] & 0xFF) | ((_EulerBuffer[3] << 8) & 0xFF00));
		_sRawPitch = (short)((_EulerBuffer[4] & 0xFF) | ((_EulerBuffer[5] << 8) & 0xFF00));

		/* 1 degree = 16 LSB */
		_dHeading = ((double)_sRawHeading) * _dConvRawEuler;
		_dRoll = ((double)_sRawRoll) * _dConvRawEuler;
		_dPitch = ((double)_sRawPitch) * _dConvRawEuler;
	}
	
	
	
	private void setMode(byte mode) {
		write8(BNO055_OPR_MODE_ADDR, (byte) mode);
	}



	public boolean isSensorPresent() {
		return _IsSensorPresent;
	}


	
	public boolean isInitialized() {
		return _IsInitialized;
	}

	
	
	public String getCalibrationStatusString() {
		String StatusNames[] = {"No", "Almost", "Good", "Done"};
		return "Sys: " + StatusNames[_CalibrationStatus.sys]
				+ ", Gyro: " + StatusNames[_CalibrationStatus.gyro]
				+ ", Accel: " + StatusNames[_CalibrationStatus.accel]
				+ ", Mag: " + StatusNames[_CalibrationStatus.mag];
	}
	
	

	private void getCalibrationStatus() {
		_CalibrationStatus = new CalibrationStatus();
		int rawCalData = read8(BNO055_CALIB_STAT_ADDR);

		_CalibrationStatus.sys = (byte) ((rawCalData >> 6) & 0x03);
		_CalibrationStatus.gyro = (byte) ((rawCalData >> 4) & 0x03);
		_CalibrationStatus.accel = (byte) ((rawCalData >> 2) & 0x03);
		_CalibrationStatus.mag = (byte) (rawCalData & 0x03);
	}
	
	

	private boolean isFullyCalibrated() {
		return (_CalibrationStatus.sys >= 3) && (_CalibrationStatus.accel >= 3) && (_CalibrationStatus.mag >= 3) && (_CalibrationStatus.gyro >= 3);
	}
	
	
	
	private void getSensorOffsets() {
		readLen(ACCEL_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer);
	}
	
	
	
	private void setSensorOffsets()	{
	    setMode(OPERATION_MODE_CONFIG);
	    
	    write8(ACCEL_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[0]);
	    write8(ACCEL_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[1]);
	    write8(ACCEL_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[2]);
	    write8(ACCEL_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[3]);
	    write8(ACCEL_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[4]);
	    write8(ACCEL_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[5]);

	    write8(MAG_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[6]);
	    write8(MAG_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[7]);
	    write8(MAG_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[8]);
	    write8(MAG_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[9]);
	    write8(MAG_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[10]);
	    write8(MAG_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[11]);

	    write8(GYRO_OFFSET_X_LSB_ADDR, _CalibrationDataBuffer[12]);
	    write8(GYRO_OFFSET_X_MSB_ADDR, _CalibrationDataBuffer[13]);
	    write8(GYRO_OFFSET_Y_LSB_ADDR, _CalibrationDataBuffer[14]);
	    write8(GYRO_OFFSET_Y_MSB_ADDR, _CalibrationDataBuffer[15]);
	    write8(GYRO_OFFSET_Z_LSB_ADDR, _CalibrationDataBuffer[16]);
	    write8(GYRO_OFFSET_Z_MSB_ADDR, _CalibrationDataBuffer[17]);

	    write8(ACCEL_RADIUS_LSB_ADDR, _CalibrationDataBuffer[18]);
	    write8(ACCEL_RADIUS_MSB_ADDR, _CalibrationDataBuffer[19]);

	    write8(MAG_RADIUS_LSB_ADDR, _CalibrationDataBuffer[20]);
	    write8(MAG_RADIUS_MSB_ADDR, _CalibrationDataBuffer[21]);

	    setMode(OPERATION_MODE_NDOF);
	}	
	
	
	
	public double Pitch() {
		return _dPitch;
	}

	

	public double Roll() {
		return _dRoll;
	}
	

	
	public double Heading() {
		return _dHeading;
	}

	
	
	private boolean write8(byte reg, byte value) {
		//System.out.println("I2C write8(" + String.format("0x%02X ", reg) + ", " + String.format("0x%02X ", value) + ")");

		return _imu.write(reg, value);
	}

	
	
	private byte read8(byte reg) {
		byte[] vals = new byte[1];
		readLen(reg, vals);
		return vals[0];
	}

	
	
	public static String byteArrayToString(byte[] bytes) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[ ");
	    for (byte b : bytes) {
	        sb.append(String.format("0x%02X ", b));
	    }
	    sb.append("]");
	    return sb.toString();
	}	
	
	
	
	private boolean readLen(byte reg, byte[] buffer) {
		if (buffer == null || buffer.length < 1)
			return false;
		boolean RetVal = !_imu.read(reg, buffer.length, buffer);
		//System.out.println("I2C readLen(" + String.format("0x%02X ", reg) + ", " + byteArrayToString(buffer) + ")");
		return RetVal;
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