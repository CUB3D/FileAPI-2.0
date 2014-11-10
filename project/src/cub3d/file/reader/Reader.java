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
}
