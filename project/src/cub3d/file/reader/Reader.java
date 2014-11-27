package cub3d.file.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Reader
{
	private DataInputStream input;
	
	public Reader(InputStream is)
	{
		this.input = new DataInputStream(is);
	}
	
	public String readString() throws IOException
	{
		return input.readUTF();
	}
	
	public int readInt() throws IOException
	{
		return input.readInt();
	}
	
	public float readFloat() throws IOException
	{
		return input.readFloat();
	}
	
	public double readDouble() throws IOException
	{
		return input.readDouble();
	}
	
	public long readLong() throws IOException
	{
		return input.readLong();
	}
	
	public byte readByte() throws IOException
	{
		return input.readByte();
	}
	
	public int available() throws IOException
	{
		return input.available();
	}
}
