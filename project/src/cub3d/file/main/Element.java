package cub3d.file.main;

import java.util.ArrayList;
import java.util.List;

public class Element
{
	private String name;
	private List<Value> values;
	private List<Element> elements;


	public Element(String name)
	{
		this.name = name;
		values = new ArrayList<Value>();
		elements = new ArrayList<Element>();
	}

	public Value getValue(String name)
	{
		for(Value val : values)
			if(val.getName().equals(name))
				return val;
		
		return new Value(name, null);
	}

	public void addValue(String name, String value)
	{
		addValue(new Value(name, value));
	}
	
	public void addValue(Value val)
	{
		values.add(val);
	}
	
	public List<Value> getValues()
	{
		return values;
	}
	
	public Element getElement(String name)
	{
		for(Element e : elements)
			if(e.getName().equals(name))
				return e;
		
		return null;
	}
	
	public void addElements(Element e)
	{
		elements.add(e);
	}
	
	public List<Element> getElements()
	{
		return elements;
	}
	
	public String getName()
	{
		return name;
	}
}
