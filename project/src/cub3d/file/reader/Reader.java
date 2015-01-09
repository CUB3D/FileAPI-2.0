package cub3d.file.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reader
{
	protected DataInputStream input;
	
	public Reader(InputStream is)
	{
		this.input = new DataInputStream(is);
	}
	
	public byte readRawByte() throws IOException
	{
		return (byte) this.input.read();
	}
	
	public int available() throws IOException
	{
		return input.available();
	}
	
	public InputStream getStream()
	{
		return input;
	}
}
