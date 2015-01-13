package cub3d.file.writer;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter extends Writer
{
	private ZipOutputStream output;
	
	public ZipWriter(Writer w)
	{
		super(w.getStream());
		
		this.output = new ZipOutputStream(getStream());
	}
	
	public void setEntry(ZipEntry entry) throws IOException
	{
		this.output.putNextEntry(entry);
	}
	
	public Writer getCurrentWriter()
	{
		return new Writer(this.output);
	}
	
	public void finishEntry() throws IOException
	{
		this.output.closeEntry();
	}
	
	public Writer getWriterFor(String name) throws IOException
	{
		ZipEntry entry = new ZipEntry(name);
		
		setEntry(entry);
		
		return getCurrentWriter();
	}
	
	@Override
	public void cleanup() throws IOException
	{
		this.output.flush();
		
		this.output.close();
		
		super.cleanup();
	}
	
}
