package cub3d.file.main;

public class Value
{
	private String name;
	private String value;
	
	public Value(String name, String value)
	{
		this.name = name;
		this.value = value;
	}
	
	public String getString()
	{
		return value;
	}
	
	public String getString(String def)
	{
		return getString() == null ? def : getString();
	}
	
	public byte getByte() throws ParseException
	{
		try
		{
			return Byte.parseByte(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Byte!");
		}
	}
	
	public byte getByte(byte def)
	{
		try
		{
			return getByte();
		}catch(ParseException e) {
			return def;
		}
	}
	

	public boolean getBoolean() throws ParseException
	{
		try
		{
			return Boolean.parseBoolean(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Boolean!");
		}
	}
	
	public boolean getBoolean(boolean def)
	{
		try
		{
			return getBoolean();
		}catch(ParseException e) {
			return def;
		}
	}
	
	public int getInt() throws ParseException
	{
		try
		{
			return Integer.parseInt(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Integer!");
		}
	}
	
	public int getInt(int def)
	{
		try
		{
			return getInt();
		}catch(ParseException e) {
			return def;
		}
	}
	
	public long getLong() throws ParseException
	{
		try
		{
			return Long.parseLong(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Long!");
		}
	}
	
	public long getLong(long def)
	{
		try
		{
			return getLong();
		}catch(ParseException e) {
			return def;
		}
	}
	
	public float getFloat() throws ParseException
	{
		try
		{
			return Float.parseFloat(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Float!");
		}
	}
	
	public float getFloat(float def)
	{
		try
		{
			return getFloat();
		}catch(ParseException e) {
			return def;
		}
	}
	
	public double getDouble() throws ParseException
	{
		try
		{
			return Double.parseDouble(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Float!");
		}
	}
	
	public double getDouble(double def)
	{
		try
		{
			return getDouble();
		}catch(ParseException e) {
			return def;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return "Value [name=" + this.getName() + ", value=" + this.getString() + "]";
	}
}
