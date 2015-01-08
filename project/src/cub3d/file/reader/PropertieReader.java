package cub3d.file.reader;

import java.io.IOException;
import java.util.HashSet;

import cub3d.file.main.DataReadException;
import cub3d.file.main.Value;

public class PropertieReader extends BasicReader
{
	private HashSet<Value> values = new HashSet<Value>();

	private String seperator;

	private boolean loaded = false;

	public PropertieReader(Reader re)
	{
		this(re, ":");
	}

	public PropertieReader(Reader re, String seperator)
	{
		super(re);

		this.seperator = seperator;
	}

	public String getString(String name) throws DataReadException, IOException
	{
		if(!loaded)
			load();

		Value v = getValue(name);
		
		if(v != null)
			return v.getString();

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

	public Value getValue(String name)
	{
		for(Value val : values)
			if(val.getName().equals(name))
				return val;
		
		return null;
	}

	public void load() throws IOException, DataReadException
	{
		loaded = true;

		if(available() > 0)
		{
			String line = readLine();

			String[] sections = line.split(seperator);

			if(sections.length == 2)
				values.add(new Value(sections[0], sections[1]));
			else
				if(sections.length < 2)
					throw new DataReadException("Incomplete propertie!");
				else
					if(sections.length > 2)
						throw new DataReadException("Overcomplete propertie!");
		}
	}
}
