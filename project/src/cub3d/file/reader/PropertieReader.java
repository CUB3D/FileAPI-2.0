package cub3d.file.reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cub3d.file.main.DataReadException;

public class PropertieReader
{
	private Map<String, String> values = new HashMap<String, String>();
	
	private String seperator;
	
	private boolean loaded = false;
	
	private Reader reader;
	
	public PropertieReader(Reader re)
	{
		this(re, ":");
	}
	
	public PropertieReader(Reader re, String seperator)
	{
		this.reader = re;
		
		this.seperator = seperator;
	}
	
	public String getString(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return values.get(name);
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public int getInteger(String name) throws DataReadException, IOException
	{
		return Integer.parseInt(getString(name));
	}
	
	public float getFloat(String name) throws DataReadException, IOException
	{
		return Float.parseFloat(getString(name));
	}
	
	public double getDouble(String name) throws DataReadException, IOException
	{
		return Double.parseDouble(getString(name));
	}
	
	public long getLong(String name) throws DataReadException, IOException
	{
		return Long.parseLong(getString(name));
	}
	
	public byte getbyte(String name) throws DataReadException, IOException
	{
		return Byte.parseByte(getString(name));
	}
	
	public void load() throws IOException
	{
		loaded = true;
		
		if(reader.available() > 0)
		{
			String line = reader.readLine();
			
			String[] sections = line.split(seperator);
			
			values.put(sections[0], sections[1]);
		}
	}
}
