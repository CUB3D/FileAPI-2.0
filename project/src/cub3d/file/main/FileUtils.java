package cub3d.file.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.zip.ZipEntry;

import cub3d.file.reader.Reader;
import cub3d.file.reader.ZipReader;
import cub3d.file.writer.Writer;

public class FileUtils
{
	public static byte[] getBytes(FileAPI api) throws IOException
	{
		return Files.readAllBytes(api.getPath());
	}
	
	public static void extractZip(ZipReader reader, File outDir) throws IOException
	{
		Set<ZipEntry> ent = reader.getEntrys().keySet();
		
		for(ZipEntry ze : ent)
		{
			File outF = new File(outDir, ze.getName());
			
			FileAPI api = new FileAPI(outF);
			
			try
			{
				api.createFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Reader in = reader.getReaderFor(ze.getName());
			
			Writer out = api.getWriter();
			
			while(in.available() > 0)
				out.writeRawByte(in.readRawByte());
		}
	}
}
