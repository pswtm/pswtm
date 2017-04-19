package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
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
	 /*
	 jframe.setLayout(new GridLayout(5, 4));
	    jframe.add(new JButton("Button 1"));
	    jframe.add(new JButton("Button 2"));
	    jframe.add(new JButton("Button 3"));
	    jframe.add(new JButton("Button 4"));
	    jframe.add(new JButton("Button 5"));
	    jframe.add(new JButton("Button 6"));
	    jframe.add(new JButton("Button 7"));
	    jframe.add(new JButton("Button 8"));
	    */
	 jframe.setVisible(true);
	 
	 repaint();
}
@Override
public void paintComponent(Graphics g)
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
