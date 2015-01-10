package cub3d.file.writer;

import java.io.IOException;

import cub3d.file.main.Element;
import cub3d.file.main.Value;

public class CallWriter extends BasicWriter
{
	private String indent = "    ";
	
	private String startElement = "{";
	private String endElement = "}";
	
	private String split = "=";
	
	public CallWriter(BasicWriter bw)
	{
		super(bw);
	}
	
	public void writeElement(Element e) throws IOException
	{
		writeElement(e, 0);
	}
	
	private void writeElement(Element e, int inde) throws IOException
	{
		String ind = "";
		
		for(int i = 0; i < inde; i++)
			ind += this.indent;
		
		writeLine(ind + "[\"" + e.getName() + "\"]");
		writeLine(ind + startElement);
		
		for(Value v : e.getValues())
			writeLine(ind + this.indent + "\"" + v.getName() + "\"" + this.split + "\"" + v.getString() + "\"");
		
		for(Element ee : e.getElements())
			writeElement(ee, inde + 1);
		
		writeLine(ind + endElement);
	}
}
