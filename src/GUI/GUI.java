/*
 Programm von Fabi, Sven, Buesra, Gaetano, Merve
 V 0.0001
 */



package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionListener;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javafx.geometry.Orientation;

public class GUI extends JFrame implements ActionListener//, MouseListener
{
	 JFrame jframe;
     JMenuBar menubar;
     JToolBar toolbar;
     JMenu menu;
     JMenu help;
     JMenuItem open;
     JMenuItem save;
     JMenuItem faq;
     JMenuItem about;
     JTextArea textarea;
     JButton ButtonSave;//=new JButton();
     JButton Theme;
     Icon IconSaveblack;
     Icon IconSavewhite;
     Icon IconTheme;
     Icon IconTrashBlack;
     Icon IconTrashWhite;
     Icon IconKondensatorBlack;
     Icon IconKondensatorWhite;
     Icon IconKondensatorBlackSchrift;
     JButton ButtonQuickSave;
     JButton ButtonTrash;
     JButton ButtonKondensator;
 	 JFileChooser fc= new JFileChooser();
 	 File file;
 	 int val;
 	 Color black= Color.black;
 	 Color white= Color.white;
     
	public GUI()
	{
		
		jframe = new JFrame("Schaltplan Editor");
        menubar = new JMenuBar();
        toolbar = new JToolBar(JToolBar.VERTICAL);
        
        //Menues und Unteroptionen erstellen
        menu = new JMenu("Menu");
        help = new JMenu("Hilfe");    
        open = new JMenuItem("oeffnen");
        open.addActionListener(this);
        save = new JMenuItem("Speichern");
        save.addActionListener(this);
        faq = new JMenuItem("F.A.Q.");
        faq.addActionListener(this);
        about = new JMenuItem("Info");
        about.addActionListener(this);    

        //Button Speichern Unter erstellen
        IconSaveblack=new ImageIcon("speichernschwarz.png");
        IconSavewhite=new ImageIcon("speichernweiss.png");
        ButtonSave= new JButton(IconSaveblack);
        ButtonSave.addActionListener(this);
        ButtonSave.setBackground(white);
        ButtonSave.setBorder(null);

        //Button Quick Save erstellen
        ButtonQuickSave=new JButton("Speichern");
        ButtonQuickSave.addActionListener(this);
        ButtonQuickSave.setForeground(black);
        ButtonQuickSave.setBackground(white);
        ButtonQuickSave.setBorder(null); 
        
        //Button trash erstellen
        IconTrashBlack=new ImageIcon("Papierkorbschwarz.png");
        IconTrashWhite=new ImageIcon("Papierkorbweiss.png");
        ButtonTrash=new JButton(IconTrashBlack);
        ButtonTrash.addActionListener(this);
        ButtonTrash.setBackground(white);
        ButtonTrash.setBorder(null);
        
        //Button Kondensator erstellen
        IconKondensatorBlack=new ImageIcon("Kondensatorschwarz.png");
        IconKondensatorWhite=new ImageIcon("Kondensatorweiss.png");
        IconKondensatorBlackSchrift=new ImageIcon("Kondensatorschwarzschrift.png");
        ButtonKondensator=new JButton(IconKondensatorBlack);
        ButtonKondensator.addActionListener(this);
        ButtonKondensator.setBackground(white);
        ButtonKondensator.setBorder(null);
       // ButtonKondensator.addMouseListener(this);
        ButtonKondensator.addMouseListener(new java.awt.event.MouseAdapter(){
        	public void mouseEntered(java.awt.event.MouseEvent evt){
        		System.out.println("maus drauf");
        		 if(jframe.getContentPane().getBackground()==white){
        		 //ButtonKondensator.setIcon(IconKondensatorBlackSchrift);
        			 ButtonKondensator.setIcon(IconKondensatorWhite);
        		 }
        		 else if(jframe.getContentPane().getBackground()==black)
                 {
        			 ButtonKondensator.setIcon(IconKondensatorBlack);
                 }
        		 
        	}
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		System.out.println("maus weg");
        		 if(jframe.getContentPane().getBackground()==white){
        			 ButtonKondensator.setIcon(IconKondensatorBlack);
            		 }
            		 else if(jframe.getContentPane().getBackground()==black)
                     {
            			 ButtonKondensator.setIcon(IconKondensatorWhite);
                     }
        		 
        	}
        });


        
        //Button Theme erstellen
        IconTheme= new ImageIcon("schwarzweiss.png");
        Theme=new JButton(IconTheme);
        Theme.addActionListener(this);
        Theme.setBackground(white);
        Theme.setBorder(null);
        
        //Zur menuebar die Buttons und Menues hinzufuegen
        menubar.add(menu);
        menubar.add(help); 
        menubar.add(ButtonSave);
        menubar.add(ButtonQuickSave);
        menubar.add(Theme);
        menubar.setBackground(white);
        menubar.setBorder(null);
        
        //Optionen zum Menue hinzufuegen
        menu.add(open);
        menu.add(save);
        menu.setForeground(black);
        menu.setBackground(white);
        
        //Optionen zur Hilfe hinzufuegen
        help.add(faq);
        help.add(about);
        help.setForeground(black);
        help.setBackground(white);
        
        //Toolbar
        //toolbar.addSeparator();    
        JTextField textfeld = new JTextField("Test");
        toolbar.setForeground(black);
        toolbar.setBackground(white);
        toolbar.add(textfeld);
        toolbar.add(ButtonKondensator);
        toolbar.add(ButtonTrash);
         
        //Menuebar zum Frame hinzufuegen
        jframe.add(menubar, BorderLayout.NORTH);
        jframe.add(toolbar, BorderLayout.WEST);
        
        //Jframe Eigenschaften
        jframe.setSize(800, 600);
        jframe.setLocation(450,250);
        jframe.getContentPane().setBackground(white);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
		
	}
    public void mouseEntered(MouseEvent e){
    	if (e.getSource() == ButtonKondensator){
            System.out.println("ButtonKondensator");
        }
      
   }
	public void themen()
	{
		 if(jframe.getContentPane().getBackground()==white)
         {
         jframe.getContentPane().setBackground(black);
         
         menubar.setBackground(black);           
         ButtonSave.setBackground(black);
         ButtonSave.setIcon(IconSavewhite);
         Theme.setBackground(white);
         Theme.setBackground(black); 
         ButtonQuickSave.setForeground(white);
         ButtonQuickSave.setBackground(black);
         menu.setForeground(white);
         menu.setOpaque(true);
         menu.setBackground(black);
         help.setForeground(white);
         help.setOpaque(true);
         help.setBackground(black);                     
         toolbar.setForeground(white);
         toolbar.setBackground(black);
         ButtonKondensator.setIcon(IconKondensatorWhite);
         ButtonKondensator.setBackground(black);
         ButtonTrash.setIcon(IconTrashWhite);
         ButtonTrash.setBackground(black);
         
         }
         else if(jframe.getContentPane().getBackground()==black)
         {
         jframe.getContentPane().setBackground(white);
         menubar.setBackground(white);            
         ButtonQuickSave.setForeground(black);
         ButtonQuickSave.setBackground(white);
         ButtonSave.setBackground(white);
         ButtonSave.setIcon(IconSaveblack);
         Theme.setBackground(white);
         Theme.setBackground(white); 
         menu.setForeground(black);
         menu.setBackground(white);
         menu.setOpaque(false);
         help.setForeground(black);
         help.setBackground(white);
         help.setOpaque(false);         
         toolbar.setForeground(black);
         toolbar.setBackground(white);
         ButtonKondensator.setIcon(IconKondensatorBlack);
         ButtonKondensator.setBackground(white);
         ButtonTrash.setIcon(IconTrashBlack);
         ButtonTrash.setBackground(white);
         }    
	}
	//Funktion Speichern unter
	public void saveAsPicture() 
	{
		val = fc.showSaveDialog(GUI.this); 

        int w = jframe.getWidth(); 
        int h = jframe.getHeight(); 
        float quality = 1f; 
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
        Graphics2D big2d = bi.createGraphics(); 
        jframe.paint(big2d); 
        Iterator<ImageWriter> iter = ImageIO 
                .getImageWritersByFormatName("jpeg"); 
        ImageWriter writer = (ImageWriter) iter.next(); 
        ImageWriteParam iwp = writer.getDefaultWriteParam(); 
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); 
        iwp.setCompressionQuality(quality); 
        
        if (val == JFileChooser.APPROVE_OPTION) {        
        } 
        try { 
        	file = new File(fc.getSelectedFile().toString()+".jpg");
            FileImageOutputStream fos = new FileImageOutputStream(file);
            writer.setOutput(fos); 
            IIOImage img = new IIOImage((RenderedImage) bi, null, null); 
            writer.write(null, img, iwp); 

        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
	}
	//Funktion Quick save
	public void QuickSave()
	{
		if(file==null)
		{
            System.out.println("Error kein Dateipfad vorhanden");
		}
		else
		{
        int w = jframe.getWidth(); 
        int h = jframe.getHeight(); 
        float quality = 1f; 
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
        Graphics2D big2d = bi.createGraphics(); 
        jframe.paint(big2d); 
        Iterator<ImageWriter> iter = ImageIO 
                .getImageWritersByFormatName("jpeg"); 
        ImageWriter writer = (ImageWriter) iter.next(); 
        ImageWriteParam iwp = writer.getDefaultWriteParam(); 
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); 
        iwp.setCompressionQuality(quality); 
        
        if (val == JFileChooser.APPROVE_OPTION) {        
        } 
        try { 
        	File file = new File(fc.getSelectedFile().toString()+".jpg");
            FileImageOutputStream fos = new FileImageOutputStream(file);
            writer.setOutput(fos); 
            IIOImage img = new IIOImage((RenderedImage) bi, null, null); 
            writer.write(null, img, iwp); 

        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
		}
	}
	//Action Listener
	 public void actionPerformed(ActionEvent object) {
         if (object.getSource() == open){
             System.out.println("Datei oeffnen");
         }
         if (object.getSource() == save){
              //System.out.println("sichern");
              saveAsPicture();
         }
         if (object.getSource() == faq){
              System.out.println("faq");
         }
         if (object.getSource() == about){
              System.out.println("Info");
         }
         if(object.getSource()==ButtonSave){
             //System.out.println("Button sichern");           
             saveAsPicture();
         }
         if(object.getSource()==ButtonQuickSave){
             System.out.println("autosave");
             //automatisches sichern mit timer????
             //test
             QuickSave();            
         }
         if(object.getSource()==ButtonTrash)
         {
        	 System.out.println("Papierkorb");
         }
         if(object.getSource()==Theme){
        	 themen();        	 
         }
    }

}
