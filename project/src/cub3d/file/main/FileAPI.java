package cub3d.file.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import cub3d.file.reader.Reader;
import cub3d.file.writer.Writer;


public class FileAPI
{
	private boolean isLocal = false;
	
	private String location;
	
	public FileAPI(String s)
	{
		if(s.startsWith("\\/"))
			this.isLocal = true;
		
		this.location = s;
	}
	
	public Writer getWriter() throws IOException
	{
		if(isLocal())
			throw new UnsupportedOperationException("Cannot write to a local file!");
		
		Path p = Paths.get(URI.create(location));
		
		OutputStream os = Files.newOutputStream(p, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		
		return new Writer(os);
	}
	
	public Reader getReader() throws IOException
	{	
		Path p = Paths.get(URI.create(location));
		
		InputStream is = Files.newInputStream(p, StandardOpenOption.READ, StandardOpenOption.CREATE);
		
		return new Reader(is);
	}
	
	public boolean isLocal()
	{
		return this.isLocal;
	}
}
