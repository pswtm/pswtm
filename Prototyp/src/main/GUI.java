package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{
	
final static int hoehe=1000,weite =1600;

public GUI()
{
	 System.out.println("test");
	 JFrame jframe =new JFrame("E-Designer");
	 jframe.setSize(weite,hoehe);
	 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 jframe.setResizable(false);
	 jframe.setLocationRelativeTo(null);
	 jframe.setBackground(Color.BLACK);
	 jframe.setForeground(Color.BLACK);
	 jframe.setVisible(true);

}
@Override
public void paint(Graphics g)
{
	super.paintComponent(g);
	
	g.setColor(Color.BLACK);
	//Gitter
	  for (int j=0;j<500;j+=40)
	  {
	  g.fillRect(0, j, weite, 1);
	  g.fillRect(j, 0, 1, hoehe);
	  System.out.println(j);
	  }
	
}



}
