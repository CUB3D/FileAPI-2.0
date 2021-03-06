package cub3d.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicReader extends Reader
{
	protected BufferedReader input;
	
	public BasicReader(Reader r)
	{
		super(r.getStream());
		
		input = new BufferedReader(new InputStreamReader(getStream()));
	}
	
	public String readLine() throws IOException
	{
		return input.readLine();
	}
	
	public int readInt() throws IOException
	{
		return Integer.parseInt(readLine());
	}
	
	public float readFloat() throws IOException
	{
		return Float.parseFloat(readLine());
	}
	
	public double readDouble() throws IOException
	{
		return Double.parseDouble(readLine());
	}
	
	public long readLong() throws IOException
	{
		return Long.parseLong(readLine());
	}
	
	public byte readByte() throws IOException
	{
		return Byte.parseByte(readLine());
	}
}
