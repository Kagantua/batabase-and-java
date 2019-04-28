package cn.hebei.main;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class tubiao {
  
	
	tubiao()
	{
		JFrame jf = new JFrame();
		JButton jb = new JButton( new ImageIcon(".\\pict\\É¾³ý.png"));
		
		jf.getContentPane().add(jb);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		  new tubiao();
		
		
		
		
		
		
	}
	
	
	
	
}
