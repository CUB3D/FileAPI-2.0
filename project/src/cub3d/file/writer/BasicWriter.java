package cub3d.file.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BasicWriter extends Writer
{
	private BufferedWriter output;
	
	public BasicWriter(Writer wr)
	{
		super(wr.getStream());
		
		this.output = new BufferedWriter(new OutputStreamWriter(getStream()));
	}
	
	public void writeLine(String s) throws IOException
	{
		this.writeString(s + System.lineSeparator());
	}
	
	@Override
	public void writeString(String s) throws IOException
	{
		this.output.write(s);
	}
	
	@Override
	public void writeInt(int i) throws IOException
	{
		this.writeString("" + i);
	}
	
	@Override
	public void writeFloat(float f) throws IOException
	{
		this.writeString("" + f);
	}
	
	@Override
	public void writeDouble(double d) throws IOException
	{
		this.writeString("" + d);
	}
	
	@Override
	public void writeLong(long l) throws IOException
	{
		this.writeString("" + l);
	}
	
	@Override
	public void writeByte(byte b) throws IOException
	{
		this.writeString("" + b);
	}
	
	@Override
	public void cleanup() throws IOException
	{
		this.output.flush();
		this.output.close();
	}
}
