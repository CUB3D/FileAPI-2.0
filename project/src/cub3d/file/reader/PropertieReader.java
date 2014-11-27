package cub3d.file.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import cub3d.file.main.DataReadException;

public class PropertieReader extends Reader
{
	private Map<String, String> values = new HashMap<String, String>();
	
	private String seperator;
	
	private boolean loaded = false;
	
	public PropertieReader(InputStream i)
	{
		this(i, ":");
	}
	
	public PropertieReader(InputStream i, String seperator)
	{
		super(i);
		
		this.seperator = seperator;
	}
	
	public String getString(String name) throws IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return values.get(name);
		else
			return null;
	}
	
	public int getInteger(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return Integer.parseInt(values.get(name));
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public float getFloat(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return Float.parseFloat(values.get(name));
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public double getDouble(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return Double.parseDouble(values.get(name));
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public long getLong(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return Long.parseLong(values.get(name));
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public byte getbyte(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();
		
		if(values.containsValue(name))
			return Byte.parseByte(values.get(name));
		else
			throw new DataReadException("Value '" + name + "' doesn't exist.");
	}
	
	public void load() throws IOException
	{
		loaded = true;
		
		if(available() > 0)
		{
			String line = readString();
			
			String[] sections = line.split(seperator);
			
			values.put(sections[0], sections[1]);
		}
	}
}
