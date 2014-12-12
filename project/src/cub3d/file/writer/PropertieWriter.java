package cub3d.file.writer;

import java.io.IOException;

public class PropertieWriter
{
	private Writer writer;
	
	private String seperator;
	
	public PropertieWriter(Writer wr)
	{
		this(wr, ":");
	}
	
	public PropertieWriter(Writer wr, String seperator)
	{
		
		this.seperator = seperator;
	}
	
	
	
	public void addPropertie(String name, String value) throws IOException
	{
		writer.writeString(name + seperator + value);
	}
	
	public void addPropertie(String name, int value) throws IOException
	{
		addPropertie(name, "" + value);
	}
	
	public void addPropertie(String name, long value) throws IOException
	{
		addPropertie(name, "" + value);
	}
	
	public void addPropertie(String name, float value) throws IOException
	{
		addPropertie(name, "" + value);
	}
	
	public void addPropertie(String name, double value) throws IOException
	{
		addPropertie(name, "" + value);
	}
}
