package cub3d.file.writer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Writer
{
	private DataOutputStream output;
	
	public Writer(OutputStream os)
	{
		this.output = new DataOutputStream(os);
	}
	
	public void writeString(String s) throws IOException
	{
		this.output.writeUTF(s);
	}
	
	public void writeInt(int i) throws IOException
	{
		this.output.writeInt(i);
	}
	
	public void writeFloat(float f) throws IOException
	{
		this.output.writeFloat(f);
	}
	
	public void writeDouble(double d) throws IOException
	{
		this.output.writeDouble(d);
	}
	
	public void writeLong(long l) throws IOException
	{
		this.output.writeLong(l);
	}
	
	public void writeByte(byte b) throws IOException
	{
		this.output.writeByte(b);
	}
}
