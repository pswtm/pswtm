package Starter;
/*
 Programm von Fabi, Sven, Buesra, Gaetano, Merve
 V 0.0001
 */
import GUI.GUI;
import XML.XML;
public class Starter {
	public static void main(String[] args) 
	{
		
		GUI gui=new GUI();		
		XML xml= new XML();
		xml.toXML();
		xml.xmlheader+=xml.xmltext;
		xml.makexml(xml.xmlheader);
		System.out.println(xml.xmltext);			
	}
}
