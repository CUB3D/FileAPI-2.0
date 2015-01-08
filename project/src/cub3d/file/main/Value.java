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
	
	public byte getByte() throws ParseException
	{
		try
		{
			return Byte.parseByte(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Byte!");
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
	
	public int getInt() throws ParseException
	{
		try
		{
			return Integer.parseInt(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Integer!");
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
	
	public float getFloat() throws ParseException
	{
		try
		{
			return Float.parseFloat(value);
		}catch(Exception e) {
			throw new ParseException("Cannot parse \'" + this.value + "\' as a Float!");
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
