package cub3d.file.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cub3d.file.main.Element;
import cub3d.file.main.Value;


public class CallReader extends BasicReader
{
	private boolean hasLoaded;
	
	private List<Element> elements = new ArrayList<Element>();
	
	private String startElement = "{";
	private String endElement = "}";
	
	private String split = "=";

	public CallReader(BasicReader r) throws IOException
	{
		super(r);
		
		load();
	}

	
	public List<Element> getElements()
	{
		return elements;
	}
	
	public Element getElementByName(String name)
	{
		for(Element e : elements)
			if(e.getName().equals(name))
				return e;
		
		return null;
	}

	private void load() throws IOException
	{
		if(!hasLoaded)
		{
			hasLoaded = true;

			List<String> contents = getFileContents();

			for(int i = 0; i < contents.size(); i++)
			{
				String key = contents.get(i).trim().replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");

				if(key.length() > 2)
					i = pharseElement(i, key, contents, elements);
			}
		}
	}

	private List<String> getFileContents() throws IOException
	{
		List<String> s = new ArrayList<String>();
		
		String ss;
		
		while((ss = readLine()) != null)
		{
			s.add(ss);
		}

		return s;
	}

	private int pharseElement(int i, String key, List<String> content, List<Element> elements)
	{
		i++;

		if(content.get(i).trim().equals(startElement))
		{
			Element element = new Element(key);

			String line = null;


			while(true)
			{
				i++;

				if(i >= content.size())
					break;

				line = content.get(i).trim();

				if(line.equals(endElement))
					break;

				if(line.startsWith("["))
					i = pharseElement(i, line.trim().replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", ""), content, element.getElements());
				else
					if(line.startsWith("\""))
						element.addValue(pharseValue(line.replaceAll("\"", "")));
			}

			elements.add(element);
		}

		return i;
	}

	private Value pharseValue(String line)
	{
		String[] line2 = line.trim().split(split);
		Value val = new Value(line2[0], line2[1]);

		return val;
	}
}
