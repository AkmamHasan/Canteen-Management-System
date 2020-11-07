package mp;
import java.awt.Color;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Swing extends signUp{
	
	Container c;				//this will contain the whole login project;
	JButton SignIn,SignUp;
	JLabel l,imglabel,user,tpass;
	JTextField t1;
	JPasswordField t2;
	Font f,f2,f3;
	int flag=1;
	
	String text1,text2,text3;
	
	public Cursor cur;
	
	
	
	
	public void interfacee() {
		
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		cur=new Cursor(Cursor.HAND_CURSOR);
		
		f=new Font("Verdana",Font.BOLD,24);
		f2=new Font("Verdana",Font.BOLD,17);
		f3=new Font("Arial",Font.BOLD,16);
		cur=new Cursor(Cursor.HAND_CURSOR);
		
		ImageIcon img=new ImageIcon(getClass().getResource("log.jpg"));   //used to set  the image
		imglabel=new JLabel(img);
		imglabel.setBounds(0,0,400,600);
		
		ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
		this.setIconImage(img2.getImage());
		
		l=new JLabel("ABC CANTEEN");
		l.setBounds(470,10,300,20);
		l.setFont(f);
		l.setForeground(Color.BLACK);
		l.setVisible(true);
		
		user= new JLabel("User Name:");
		user.setFont(f2);
		user.setBounds(430,70,300,20);
		
		t1=new JTextField();
		t1.setBounds(430,95,300,30);
		t1.setFont(f3);
		t1.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text1=t1.getText();
				System.out.println(text1);
			}
			
		});
		
		tpass=new JLabel("Password:");
		tpass.setFont(f2);
		tpass.setBounds(430,125,300,20);
		
		t2=new JPasswordField();
		t2.setBounds(430,150,300,30);
		t2.setFont(f3);
		t2.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text2=t2.getText();
				System.out.println(text2);
			}
			
		});
		
		
		SignIn=new JButton("SIGN IN");
		SignIn.setForeground(Color.white);
		SignIn.setBackground(Color.pink);
		SignIn.setFont(f2);
		SignIn.setBounds(430,231,120,40);
		SignIn.setCursor(cur);
		
		SignIn.addActionListener(new ActionListener() {//this is for adding action listener to signin

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
				
				
				String com=t1.getText()+","+t2.getText();

				
				if(t1.getText()!=null && t2.getText()!=null) {
				

					File myfile=new File("LogInFile.txt");      // reading from file
				try {
						
						Scanner myreader=new Scanner(myfile);
						
						while(myreader.hasNext()) {
							String data=myreader.nextLine();
							System.out.println(data);		//taking data from file
							if(!data.equals(com)) {
								
								t1.setText("");
								t2.setText("");
								
								}
							
							else {
								flag=0;
								Canteen window = new Canteen();
								window.frame_2.setVisible(true);
								
								}
							}
						if(flag!=0) {
							JOptionPane.showMessageDialog(null, "Please enter correct\n username & password");
						}
					} catch (FileNotFoundException d) {
						// TODO Auto-generated catch block
						System.out.println(d);
					}	
					}
				

			}
			
		});
		

		
		SignUp=new JButton("SIGN UP");
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				signUp window = new signUp();
				window.frame_signUp.setVisible(true);
				ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
				window.frame_signUp.setIconImage(img2.getImage());
			}
		});
		SignUp.setForeground(Color.white);
		SignUp.setBackground(Color.pink);
		SignUp.setFont(f2);
		SignUp.setBounds(610,231,120,40);
		SignUp.setCursor(cur);
		
		
	    c.add(imglabel);
		c.add(l);
		c.add(user);
		c.add(t1);
		c.add(tpass);
		c.add(t2);
		c.add(SignIn);
		c.add(SignUp);
		
		
		}
	
	public Swing() {
		
		interfacee();
		
	}
	
	public static void main(String[]args) {
		Swing frame=new Swing();
		frame.setTitle("ABC CANTEEN");
		frame.setVisible(true);
		frame.setBounds(100,50,750,600);
		
	}
	

}
