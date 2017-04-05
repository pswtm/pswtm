/*
 Programm von Fabi, Sven, B�sra, Gaetano, Merve
 V 0.0001
 */
package XML;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class XML {
	String Kondensator="Kondensator 1";
	String Spule="Spule 1";
	String Widerstand="Widerstand 1";
	String Spannungsquelle="Spannungsquelle 1";
	String xkon="1";
	String ykon="2";
	String xspu="3";
	String yspu="4";
	String xwid="5";
	String ywid="6";
	String xspa="7";
	String yspa="8";
	public String xmltext="";
	public String xmlheader="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	
	

public String toXML()
{
	//foreach schleife f�r jedes Teil mit get und set methoden drauf zugreifen arraylist
	xmltext+= "			XML Datei\n"
            + "        <leer>\n"
            + "                <name>XML File</name>\n"
            + "		<Teile>\n\n"
            + "		<Kondensator>" + Kondensator + "</Kondensator>\n" //Kondensatorname in fett
            + "		<x>"+xkon+"</x>\n"
            + "		<y>"+ykon+"</y>\n"
            + "		<Spule>" + Spule + "</Spule>\n"
            + "		<x>"+xspu+"</x>\n"
            + "		<y>"+yspu+"</y>\n"
            + "		<Widerstand>" + Widerstand  + "</Widerstand>\n"
            + "		<x>"+xwid+"</x>\n"
            + "		<y>"+ywid+"</y>\n"
            + "		<Spannungsquelle>" + Spannungsquelle +  "</Spannungsquelle>\n"
            + "		<x>"+xspa+"</x>\n"
            + "		<y>"+yspa+"</y>\n"
            +"\n"
            + "		</Teile>\n"
            + "        </leer>\n";
	
	return xmltext;
}
public void makexml(String str)
{
	try
    {
    	PrintWriter pWriter = new PrintWriter(new FileWriter("test.xml"), true);
    	pWriter.println(str);
    }
     catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
}	
}
