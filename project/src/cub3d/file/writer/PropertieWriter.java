package cub3d.file.writer;

import java.io.IOException;
import java.io.OutputStream;

public class PropertieWriter extends Writer
{
	private String seperator;
	
	public PropertieWriter(OutputStream os)
	{
		this(os, ":");
	}
	
	public PropertieWriter(OutputStream os, String seperator)
	{
		super(os);
		
		this.seperator = seperator;
	}
	
	public void addPropertie(String name, String value) throws IOException
	{
		super.writeString(name + seperator + value);
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
