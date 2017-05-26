import java.io.Serializable;

/**
 * @author Rajeev Sreedharan
 * 
 * Sample object to test serialization
 *
 */
public class DefaultPackageMyObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	byte	 myByte = 8;
	short	 myShort = 16;
	int		 myInt = 32;
	long	 myLong = 64;
	float	 myFloat = 32;
	double	 myDouble = 64.00;
	boolean	 myBoolean = true;
	char	 myChar = 'c';
	String	 myString = "STRING";
	
	int[]		myIntArray = {0,1};
	String[]	myStringArray = {"S1","S2"};

	
	public byte getMyByte() {
		return myByte;
	}
	public void setMyByte(byte myByte) {
		this.myByte = myByte;
	}
	public short getMyShort() {
		return myShort;
	}
	public void setMyShort(short myShort) {
		this.myShort = myShort;
	}
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public float getMyFloat() {
		return myFloat;
	}
	public void setMyFloat(float myFloat) {
		this.myFloat = myFloat;
	}
	public double getMyDouble() {
		return myDouble;
	}
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	public boolean isMyBoolean() {
		return myBoolean;
	}
	public void setMyBoolean(boolean myBoolean) {
		this.myBoolean = myBoolean;
	}
	public char getMyChar() {
		return myChar;
	}
	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public int[] getMyIntArray() {
		return myIntArray;
	}
	public void setMyIntArray(int[] myIntArray) {
		this.myIntArray = myIntArray;
	}
	public String[] getMyStringArray() {
		return myStringArray;
	}
	public void setMyStringArray(String[] myStringArray) {
		this.myStringArray = myStringArray;
	}

}
