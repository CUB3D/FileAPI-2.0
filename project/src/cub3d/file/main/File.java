package cub3d.file.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import cub3d.file.reader.Reader;
import cub3d.file.writer.Writer;


public class File
{
	private String location;
	
	public File(String s)
	{
		this.location = s;
	}
	
	public Writer getWriter() throws IOException
	{
		
		Path p = Paths.get(location);
		
		OutputStream os = Files.newOutputStream(p, StandardOpenOption.WRITE);
		
		return new Writer(os);
	}
	
	public Reader getReader() throws IOException
	{	
		Path p = Paths.get(location);
		
		InputStream is = Files.newInputStream(p, StandardOpenOption.READ);
		
		return new Reader(is);
	}
}
