package cn.hebei.main;


import java.awt.Container;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BiaoGe {

	

	/**
	 * Launch the application.
	 */
	
	
	
	BiaoGe(){}
	
	
	public BiaoGe(String[][] xinxi){
	  
		JFrame jf = new JFrame("–≈œ¢≤È—Ø");
		jf.setSize(600, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = jf.getContentPane();
		
		
		
		String []title = {"id","name","sex","age","dept"};
		
		JTable table = new JTable(xinxi,title);
		contentpane.add(new JScrollPane(table));
		jf.setVisible(true);
		
	}


	
	
	
	
	
}

