package cn.hebei.main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JTextField;

import cn.hebei.dao.PersonDAO;
import cn.hebei.dao.impl.PersonDAOImpl;
import cn.hebei.domain.Person;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class QianTai{

	private JFrame frame;
	private JTextField delid;
	private JTextField alterid;
	private JTextField findid;
	private JTextField findresult;
	private JTextField delstat;
	private JTextField addid;
	private JTextField addname;
	private JTextField addsex;
	private JTextField addage;
	private JTextField addsdept;
	private JTextField addstat;
	private JTextField textField;
	private JTextField altercontent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QianTai window = new QianTai();
					window.frame.setVisible(true);
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QianTai() {
		initialize();
		
		String path = ".\\pict\\27.jpg";  
        // 背景图片  
        ImageIcon background = new ImageIcon(path);  
        // 把背景图片显示在一个标签里面  
        JLabel label = new JLabel(background);  
        // 把标签的大小位置设置为图片刚好填充整个面板  
        label.setBounds(0, 0, frame.getWidth(), frame.getHeight());  
        // 把内容窗格转化为 JPanel，否则不能用方法 setOpaque() 来使内容窗格透明  
        JPanel imagePanel = (JPanel) frame.getContentPane();  
        
        JTextArea zuozhe = new JTextArea();
        zuozhe.setFont(new Font("Arial", 20, 20));
        zuozhe.setText("Made by LQS");
        zuozhe.setBounds(527, 205, 127, 24);
        zuozhe.setOpaque(false);
        frame.getContentPane().add(zuozhe);
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        // 设置可见  
        
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\pict\\sql.png"));
		frame.setTitle("\u6570\u636E\u5E93\u67E5\u8BE2");
		frame.setBounds(100, 100, 850, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add = new JButton("\u589E\u52A0");  //增加信息
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonDAO pd = new PersonDAOImpl();
				
				try {
					pd.insertPerson(new Person(addid.getText(),addname.getText(),addsex.getText(),addage.getText(),addsdept.getText()));
					addstat.setText("添加成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					addstat.setText("添加失败");
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		add.setBounds(15, 15, 123, 29);
		frame.getContentPane().add(add);
		
		JButton del = new JButton("删除");     // 删除
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonDAO pd = new PersonDAOImpl();
				String id = delid.getText();
				     try {
						pd.deletePerson(id);
						delstat.setText("删除成功");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						  delstat.setText( "删除失败");
						e1.printStackTrace();
						
					}
				
				
				
				
				
				
			}
		});
		del.setBounds(15, 65, 123, 29);
		frame.getContentPane().add(del);
		
		
		JButton alter = new JButton("\u4FEE\u6539");  //更新修改数据
		alter.setBounds(15, 120, 123, 29);
		frame.getContentPane().add(alter);
		
		JButton find = new JButton("\u67E5\u627E");  // 按照id进行查找
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonDAO pd = new PersonDAOImpl();
				String id = findid.getText();
				try {
					Person  arr = pd.selectById(id);
					String str [][]  = new String[1][5];
					
						str[0][0]= arr.getId();
						str[0][1]= arr.getName();
						str[0][2]= arr.getSex();
						str[0][3]= arr.getAge();
						str[0][4]= arr.getDept();  
						new BiaoGe(str);
						
					findresult.setText("查找成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					findresult.setText("查找失败");
					
				}
				
				
				
				
				
			}
		});
		find.setBounds(15, 183, 123, 29);
		frame.getContentPane().add(find);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setBackground(SystemColor.menu);
		txtrId.setText("id");
		txtrId.setBounds(153, 70, 23, 24);
		txtrId.setOpaque(false);
		frame.getContentPane().add(txtrId);
		
		delid = new JTextField();
		delid.setBounds(185, 66, 96, 27);
		delid.setOpaque(false);
		frame.getContentPane().add(delid);
		delid.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("id");
		textArea.setBackground(SystemColor.menu);
		textArea.setOpaque(false);
		textArea.setBounds(153, 125, 23, 24);
		frame.getContentPane().add(textArea);
		
		alterid = new JTextField();
		alterid.setColumns(10);
		alterid.setBounds(185, 121, 96, 27);
		alterid.setOpaque(false);
		frame.getContentPane().add(alterid);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("id");
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(153, 188, 23, 24);
		textArea_1.setOpaque(false);
		frame.getContentPane().add(textArea_1);
		
		findid = new JTextField();
		findid.setColumns(10);
		findid.setBounds(185, 184, 96, 27);
		findid.setOpaque(false);
		frame.getContentPane().add(findid);
		
		findresult = new JTextField();
		findresult.setColumns(10);
		findresult.setBounds(297, 184, 123, 27);
		findresult.setOpaque(false);
		frame.getContentPane().add(findresult);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBackground(SystemColor.menu);
		textArea_3.setText("\u5220\u9664\u72B6\u6001");
		textArea_3.setBounds(296, 70, 56, 24);
		textArea_3.setOpaque(false);
		frame.getContentPane().add(textArea_3);
		
		delstat = new JTextField();
		delstat.setBounds(367, 66, 53, 27);
		frame.getContentPane().add(delstat);
		delstat.setOpaque(false);
		delstat.setColumns(10);
		
		JTextArea txtrId_1 = new JTextArea();
		txtrId_1.setBackground(SystemColor.menu);
		txtrId_1.setText("id");
		txtrId_1.setBounds(153, 20, 18, 24);
		txtrId_1.setOpaque(false);
		frame.getContentPane().add(txtrId_1);
		
		addid = new JTextField();
		addid.setBounds(172, 16, 23, 27);
		frame.getContentPane().add(addid);
		addid.setColumns(10);
		addid.setOpaque(false);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setBackground(SystemColor.menu);
		txtrName.setText("name");
		txtrName.setBounds(199, 20, 28, 24);
		txtrName.setOpaque(false);
		frame.getContentPane().add(txtrName);
		
		addname = new JTextField();
		addname.setColumns(10);
		addname.setOpaque(false);
		addname.setBounds(232, 16, 54, 27);
		
		frame.getContentPane().add(addname);
		
		JTextArea txtrSex = new JTextArea();
		txtrSex.setBackground(SystemColor.menu);
		txtrSex.setText("sex");
		txtrSex.setBounds(296, 20, 28, 24);
		txtrSex.setOpaque(false);
		addid.setOpaque(false);
		frame.getContentPane().add(txtrSex);
		
		addsex = new JTextField();
		addsex.setColumns(10);
		addsex.setBounds(339, 16, 54, 27);
		addsex.setOpaque(false);
		frame.getContentPane().add(addsex);
		
		JTextArea txtrAge = new JTextArea();
		txtrAge.setBackground(SystemColor.menu);
		txtrAge.setText("age");
		txtrAge.setOpaque(false);
		txtrAge.setBounds(397, 20, 28, 24);
		
		frame.getContentPane().add(txtrAge);
		
		addage = new JTextField();
		addage.setColumns(10);
		addage.setBounds(428, 16, 54, 27);
		addage.setOpaque(false);
		frame.getContentPane().add(addage);
		
		JTextArea txtrSdept = new JTextArea();
		txtrSdept.setBackground(SystemColor.menu);
		txtrSdept.setText("sdept");
		txtrSdept.setBounds(486, 20, 40, 24);
		txtrSdept.setOpaque(false);
		frame.getContentPane().add(txtrSdept);
		
		addsdept = new JTextField();
		addsdept.setColumns(10);
		addsdept.setBounds(527, 16, 54, 27);
		addsdept.setOpaque(false);
		frame.getContentPane().add(addsdept);
		
		JButton quancha = new JButton("\u5927\u62DB\uFF1A\u5168\u67E5");
		quancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonDAO pd = new PersonDAOImpl();
				try {
					pd.selectAll();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					pd.selectAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		quancha.setBounds(690, 120, 123, 109);
		frame.getContentPane().add(quancha);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBackground(SystemColor.menu);
		textArea_4.setText("\u589E\u52A0\u72B6\u6001");
		textArea_4.setBounds(591, 20, 63, 24);
		textArea_4.setOpaque(false);
		frame.getContentPane().add(textArea_4);
		
		addstat = new JTextField();
		addstat.setColumns(10);
		addstat.setBounds(659, 16, 54, 27);
		addstat.setOpaque(false);
		frame.getContentPane().add(addstat);
		
		textField = new JTextField();
		textField.setBounds(345, 121, -33, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JComboBox choose = new JComboBox();
		choose.setModel(new DefaultComboBoxModel(new String[] {"name", "sex", "age", "dept"}));
		choose.setBounds(306, 121, 41, 27);
		frame.getContentPane().add(choose);
		
		altercontent = new JTextField();
		altercontent.setBounds(368, 123, 49, 27);
		altercontent.setOpaque(false);
		frame.getContentPane().add(altercontent);
		altercontent.setColumns(10);
		
		
		
		alter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonDAO pd = new PersonDAOImpl();
				String id = alterid.getText();
				     try {
				    	 pd.updatePerson((String)choose.getSelectedItem(), altercontent.getText(), alterid.getText());
				    	 
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						  
						e1.printStackTrace();
						
					}
				
				
				
				
				
			}
		});
		
		
		
		
		
	}
}
