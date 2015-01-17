package cub3d.file.main;

import java.util.HashSet;
import java.util.Set;

public class Element
{
	private String name;
	private Set<Value> values;
	private Set<Element> elements;


	public Element(String name)
	{
		this.name = name;
		values = new HashSet<Value>();
		elements = new HashSet<Element>();
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
	
	public Set<Value> getValues()
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
	
	public void addElement(Element e)
	{
		elements.add(e);
	}
	
	public Set<Element> getElements()
	{
		return elements;
	}
	
	public String getName()
	{
		return name;
	}
}
