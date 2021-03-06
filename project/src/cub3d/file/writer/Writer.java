package cub3d.file.writer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Writer
{
	protected DataOutputStream output;

	public Writer(OutputStream os)
	{
		this.output = new DataOutputStream(os);
	}

	public void writeRawByte(byte b) throws IOException
	{
		this.output.write(b);
	}

	public void writeRawBytes(byte[] bytes, int start, int end) throws IOException
	{
		for(int i = 0; i < end; i++)
			writeRawByte(bytes[start + i]);
	}


	public boolean cleanup()
	{
		try
		{
			this.output.flush();
			this.output.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public OutputStream getStream()
	{
		return output;
	}
}
