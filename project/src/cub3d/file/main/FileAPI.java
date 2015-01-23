package cub3d.file.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import cub3d.file.reader.Reader;
import cub3d.file.writer.Writer;


public class FileAPI
{
	private String location;
	private Path path;

	public FileAPI(String s)
	{
		this.location = s;

		this.path = Paths.get(location);
	}

	public FileAPI(File f)
	{
		this(f.getAbsolutePath());
	}



	public Writer getWriter() throws IOException
	{
		return getWriter(StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}

	public Writer getWriter(OpenOption... options) throws IOException
	{
		OutputStream os = Files.newOutputStream(path, options);

		return new Writer(os);
	}


	public Reader getReader() throws IOException
	{
		return getReader(StandardOpenOption.READ);
	}

	public Reader getReader(OpenOption... options) throws IOException
	{
		InputStream is = Files.newInputStream(path, options);

		return new Reader(is);
	}



	public void createFile() throws IOException
	{
		if(!Files.exists(path))
			Files.createFile(path);
	}

	public void deleteFile() throws IOException
	{
		if(Files.exists(path))
			Files.delete(this.path);
	}


	public Path getPath()
	{
		return this.path;
	}
}
