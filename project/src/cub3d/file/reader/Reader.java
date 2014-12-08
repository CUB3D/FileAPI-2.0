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
	
	public String readLine() throws IOException
	{
		String s = "";
		
		while(available() > 0)
		{
			char c = (char) readByte();
			
			if(c == '\n') break;
			
			s += c;
		}
		
		return s;
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
