package cub3d.file.writer;

import java.io.IOException;

public class BasicWriter extends Writer
{
	public BasicWriter(Writer wr)
	{
		super(wr.getStream());
	}
	
	public void writeString(String s) throws IOException
	{
		byte[] bytes = s.getBytes();
		
		this.writeRawBytes(bytes, 0, bytes.length);
	}
	
	public void writeLine(String s) throws IOException
	{
		this.writeString(s + System.lineSeparator());
	}
	
	public void writeInt(int i) throws IOException
	{
		this.writeString("" + i);
	}
	
	public void writeFloat(float f) throws IOException
	{
		this.writeString("" + f);
	}
	
	public void writeDouble(double d) throws IOException
	{
		this.writeString("" + d);
	}
	
	public void writeLong(long l) throws IOException
	{
		this.writeString("" + l);
	}
	
	public void writeByte(byte b) throws IOException
	{
		this.writeString("" + b);
	}
}
