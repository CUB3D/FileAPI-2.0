package cub3d.file.reader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader extends Reader
{
	private boolean hasLoaded;

	private Map<ZipEntry, ByteArrayOutputStream> entrys = new HashMap<ZipEntry, ByteArrayOutputStream>();

	private ZipInputStream input = null;

	public ZipReader(Reader r)
	{
		super(r.getStream());

		this.input = new ZipInputStream(getStream());
	}

	private void load() throws IOException
	{
		if(!hasLoaded)
		{
			hasLoaded = true;
			ZipEntry ze = null;

			while((ze = input.getNextEntry()) != null)
			{	
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				while(input.available() > 0)
					baos.write(input.read());

				entrys.put(ze, baos);
			}
		}
	}

	public Reader getReaderFor(String filename) throws IOException
	{
		load();
		
		for(ZipEntry ze : entrys.keySet())
			if(ze.getName().equals(filename))
			{
				ByteArrayOutputStream baos = entrys.get(ze);

				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

				return new Reader(bais);
			}

		return null;
	}
}
