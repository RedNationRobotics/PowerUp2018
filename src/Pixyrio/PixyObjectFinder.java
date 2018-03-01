package Pixyrio;

import java.io.IOException;
import java.util.Scanner;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;





public class PixyObjectFinder {
	SerialPort _PixyPort;
	protected byte[] _ReadBuffer = {};
	protected static final byte _Token1 = (byte)0x55;
	protected static final byte _Token2 = (byte)0xaa;
	public PixyObject _FoundPixyObject = new PixyObject(); 
	
	
	
	public PixyObjectFinder() {
		_PixyPort = new SerialPort(19200, Port.kUSB, 8); 
	}
	
	
	
	
	
    public void UpdatePeriodic() {
    	byte[] ReadBytes = _PixyPort.read(4096);
    	if(ReadBytes.length > 0) {
    	
	    	// copy data into buffer
	    	byte[] NewReadBuffer = new byte[_ReadBuffer.length + ReadBytes.length];
	    	System.arraycopy(_ReadBuffer, 0, NewReadBuffer, 0, _ReadBuffer.length);
	    	System.arraycopy(ReadBytes, 0, NewReadBuffer, _ReadBuffer.length, ReadBytes.length);
	    	_ReadBuffer = NewReadBuffer;
	    	HandleNewData();
    	}
    }	
        
    
    
    protected int ValueFromUnsignedShort(byte first, byte second) {
    	// java doesn't understand unsigned so we do this
		return (0x000000FF & ((int)second)) << 8 | (0x000000FF & ((int)first));
    }

    
    
    protected void TruncateReadBuffer(int iBlockPos) {
		int PosToCopyFrom = iBlockPos + 16;
		int NewBufferSize = _ReadBuffer.length - PosToCopyFrom;
    	byte[] NewReadBuffer = new byte[NewBufferSize];
    	System.arraycopy(_ReadBuffer, PosToCopyFrom, NewReadBuffer, 0, NewBufferSize);
    	_ReadBuffer = NewReadBuffer;
    }

    
    
    protected boolean StartBlock(int iSearchBlockPos) {
		return (_ReadBuffer[iSearchBlockPos] == _Token1 
				&& _ReadBuffer[iSearchBlockPos+1] == _Token2
				&& _ReadBuffer[iSearchBlockPos+2] == _Token1
				&& _ReadBuffer[iSearchBlockPos+3] == _Token2);
    }
    
    
    protected void HandleNewData() {
    	int BufferSize = _ReadBuffer.length;
    	int MinBufferSize = BufferSize - 16;
    	for(int iSearchBlockPos = 0; iSearchBlockPos < MinBufferSize; iSearchBlockPos++) {
    		if (StartBlock(iSearchBlockPos)) {
    			GetObjectData(iSearchBlockPos);
    			TruncateReadBuffer(iSearchBlockPos);
            	return;
    		}
    	}
    }
    
	
    
    protected void GetObjectData(int iBlockPos) {
    	_FoundPixyObject._Checksum = ValueFromUnsignedShort(_ReadBuffer[iBlockPos+4], _ReadBuffer[iBlockPos+5]);
    	_FoundPixyObject._Signature = ValueFromUnsignedShort(_ReadBuffer[iBlockPos+6], _ReadBuffer[iBlockPos+7]);
    	_FoundPixyObject._X= ValueFromUnsignedShort(_ReadBuffer[iBlockPos+8], _ReadBuffer[iBlockPos+9]);
    	_FoundPixyObject._Y = ValueFromUnsignedShort(_ReadBuffer[iBlockPos+10], _ReadBuffer[iBlockPos+11]);
    	_FoundPixyObject._Width = ValueFromUnsignedShort(_ReadBuffer[iBlockPos+12], _ReadBuffer[iBlockPos+13]);
    	_FoundPixyObject._Height = ValueFromUnsignedShort(_ReadBuffer[iBlockPos+14], _ReadBuffer[iBlockPos+15]);
    	
		HandleFoundPixyObject();
    }    
    
    
    
    protected void HandleFoundPixyObject() {
    	System.out.printf("%s at %.1fdeg\r", _FoundPixyObject.GetObjectType(), _FoundPixyObject.GetObjectCourse());
    }
    
    
    
}
