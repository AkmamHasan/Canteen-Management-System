package mp;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.Window;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

public class Inventory  {
	
	private JLabel Ibclock;

	public JFrame frame3;

	private JLabel imglabel;
	private JTabbedPane tabbedPane;
	private JTextField txtnewcustomer;
	private JTextField txtamountofnewcustomer;
	private JTextField txtamountforrecharge;
	private JTextField txtidofexistingcustomer;
	private JTextField txtemployeename;
	private JTextField txtemployeeid;
	private JTextField txtemployeeaddress;
	private JTextField txtemployeesalary;
	private JTextField txtproductname;
	private JTextField txtproductquantity;
	private JTextField txtamount;
	private JTextField txtvouchername;
	
	private ImageIcon imageemp=null;
	String filename =null;
	byte[] person_image =null;
	
	String sname, nid, namount;
	int sum = 0,sum1=0,empsalary=0,Id_checker,eid,esalary;
	boolean f=false,e=false,p=false,flag=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();
					window.frame3.setVisible(true);
					ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
					window.frame3.setIconImage(img2.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/* 
	 * auto update
	 */
	
	public void jrecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("registered");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
			System.out.println("connected");
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select sum(sell) from selll");
			
			System.out.println("done");
			while(res.next()) {
				sum=res.getInt(1);
				
			}
			res.close();
			ResultSet res1=stmt.executeQuery("Select sum(Price) from purchase");
			while(res1.next()) {
				
				sum1=res1.getInt(1);
			}

			
			stmt.close();
			Statement stm=con.createStatement();
			ResultSet ress=stm.executeQuery("Select sum(salary) from employee");
			while (ress.next()) {
				empsalary=ress.getInt(1);
				System.out.println("salary:"+empsalary);
			}
			con.close();
			stm.close();
			ress.close();
			
			}catch(Exception e) {
				System.out.println(e);
			}

	}
	
	
	
	public void clock() {
		
		Thread clock = new Thread() {
			
			public void run() {
				
				try {
					for(;;) {
						
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					Ibclock.setText(" "+hour+":"+minute+":"+second+" || "+day+"/"+month+"/"+year);
					
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		
		clock.start(); // without this cant start the thread.  
		
	}
	
	
	
	public Inventory() {
		initialize();
		clock(); // declare clock method
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(170, 100, 1100, 600);
		frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 250, 553);
		panel.setBackground(Color.PINK);
		frame3.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		Ibclock = new JLabel("clock");
		Ibclock.setVerticalAlignment(SwingConstants.TOP);
		Ibclock.setBounds(0, 56, 250, 62);
		panel.add(Ibclock);
		Ibclock.setForeground(new Color(255, 255, 255));
		Ibclock.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblInventoryManagement = new JLabel(" Inventory Management");
		lblInventoryManagement.setVerticalAlignment(SwingConstants.TOP);
		lblInventoryManagement.setForeground(Color.WHITE);
		lblInventoryManagement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInventoryManagement.setBounds(0, 10, 250, 62);
		panel.add(lblInventoryManagement);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(263, 10, 813, 553);
		frame3.getContentPane().add(tabbedPane);
		
		JPanel panel_customerInformation = new JPanel();
		panel_customerInformation.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Customer Information", null, panel_customerInformation, null);
		panel_customerInformation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Customer");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(85, 29, 250, 39);
		panel_customerInformation.add(lblNewLabel);
		
		JLabel lblRechargeBalance = new JLabel("Recharge Balance\r\n");
		lblRechargeBalance.setForeground(SystemColor.textHighlight);
		lblRechargeBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRechargeBalance.setBounds(493, 29, 250, 39);
		panel_customerInformation.add(lblRechargeBalance);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.PINK);
		separator.setBackground(Color.PINK);
		separator.setBounds(388, 10, 7, 506);
		panel_customerInformation.add(separator);
		
		JLabel cname=new JLabel("Enter Name");
		cname.setBounds(10,122,142,39);
		cname.setFont(new Font("Tahoma",Font.BOLD,18));
		cname.setForeground(SystemColor.textHighlight);
		panel_customerInformation.add(cname);
		
		JLabel lblId = new JLabel("Enter Id");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(10, 182, 142, 39);
		panel_customerInformation.add(lblId);
		
		JLabel lblAmount = new JLabel("Enter Amount");
		lblAmount.setForeground(SystemColor.textHighlight);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmount.setBounds(10,242, 142, 39);
		panel_customerInformation.add(lblAmount);
		
	
		JTextField tname=new JTextField();
		tname.setBounds(184,122,177,39);
		tname.setColumns(10);
		panel_customerInformation.add(tname);
		
		
		txtnewcustomer = new JTextField();
		txtnewcustomer.setBounds(184, 182, 177, 39);
		panel_customerInformation.add(txtnewcustomer);
		txtnewcustomer.setColumns(10);
		
		txtamountofnewcustomer = new JTextField();
		txtamountofnewcustomer.setColumns(10);
		txtamountofnewcustomer.setBounds(184, 242, 177, 39);
		panel_customerInformation.add(txtamountofnewcustomer);
		
		JButton btncreatevustomer = new JButton("Create");
		btncreatevustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncreatevustomer.setForeground(SystemColor.textHighlight);
		btncreatevustomer.setBounds(250, 325, 111, 39);
		panel_customerInformation.add(btncreatevustomer);
		
		//working on create button
		//it will used to create new account
		//will be connected to database & file both
		
		btncreatevustomer.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					sname=tname.getText();
				nid=txtnewcustomer.getText();
				namount=txtamountofnewcustomer.getText();
				
				try{
					int ount= Integer.parseInt(namount);
					int op=Integer.parseInt(nid);
					flag=true;
				}catch(Exception q) {
					
				}
				if(flag) {
				File myfile=new File(nid+".txt");
				try {
					myfile.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					FileWriter mywriter=new FileWriter(nid+".txt");
					mywriter.write(namount);					//creating new cutomer file & adding amount
					mywriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Input correct information");
				}
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("registered");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
					System.out.println("connected");
					PreparedStatement stmt=con.prepareStatement("insert into customer(name,id) values(?,?)");  //database to keep information
					System.out.println("done");
			
					stmt.setString(1, sname);
					stmt.setString(2, nid);
					stmt.executeUpdate();
					System.out.println("invoked");
					JOptionPane.showMessageDialog(null, "Account created");//     worked for create new user account
					
					
					con.close();
					stmt.close();
					tname.setText("");
					txtnewcustomer.setText("");
					txtamountofnewcustomer.setText("");
					

				} 
				catch (Exception e2) {
					System.out.println(e2);
				}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Input correct information");
					txtnewcustomer.setText("");
					txtamountofnewcustomer.setText("");
					tname.setText("");
				}
			}
			
		});
		
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(SystemColor.textHighlight);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId_1.setBounds(421, 122, 142, 39);
		panel_customerInformation.add(lblId_1);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setForeground(SystemColor.textHighlight);
		lblAmount_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmount_1.setBounds(421, 182, 142, 39);
		panel_customerInformation.add(lblAmount_1);
		
		
		txtamountforrecharge = new JTextField();
		txtamountforrecharge.setColumns(10);
		txtamountforrecharge.setBounds(595, 182, 177, 39);
		panel_customerInformation.add(txtamountforrecharge);
		
		txtidofexistingcustomer = new JTextField();
		txtidofexistingcustomer.setColumns(10);
		txtidofexistingcustomer.setBounds(595, 122, 177, 39);
		panel_customerInformation.add(txtidofexistingcustomer);
		
		JButton btnrechargecustomer = new JButton("Recharge");
		btnrechargecustomer.setForeground(SystemColor.textHighlight);
		btnrechargecustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnrechargecustomer.setBounds(651, 265, 132, 39);
		panel_customerInformation.add(btnrechargecustomer);
		
		// working here for recharge
		btnrechargecustomer.addActionListener(new ActionListener() {//    working here for recharge

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("registered");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
					System.out.println("connected");
					Statement stmt=con.createStatement();
					ResultSet res=stmt.executeQuery("select id from customer");
					int change=Integer.parseInt(txtidofexistingcustomer.getText());
					System.out.println("done");
					while(res.next()) {
						Id_checker=res.getInt(1);
						if(change==Id_checker) {
							int q=Integer.parseInt(txtamountforrecharge.getText());
							f=true;
					}
					}
					res.close();
				}catch(Exception e10) {
					
				} 
				if(f) {
				// TODO Auto-generated method stub
				namount=txtamountforrecharge.getText();
				nid=txtidofexistingcustomer.getText();
				
				File myfile=new File(nid+".txt");
				try {
					Scanner myreader=new Scanner(myfile);
						String data = null;
						while(myreader.hasNext()) {
							 data=myreader.nextLine();
						}
						//current value
						double amo=Double.parseDouble(data);
						double namo=Double.parseDouble(namount);
						double to=amo+namo;
						
					BufferedWriter apen=new BufferedWriter(new FileWriter(nid+".txt",true));
					apen.newLine();
					apen.write(""+to);					//recharging customer account
					apen.close();
					
					JOptionPane.showMessageDialog(null, "Recharge successfull");
					txtamountforrecharge.setText("");
					txtidofexistingcustomer.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Enter correct information");
				txtamountforrecharge.setText("");
				txtidofexistingcustomer.setText("");
			}
			}
		});
		
		JPanel panel_employeeInformation = new JPanel();
		panel_employeeInformation.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Employee Information", null, panel_employeeInformation, null);
		panel_employeeInformation.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(SystemColor.textHighlight);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(10, 31, 142, 39);
		panel_employeeInformation.add(lblName);
		
		txtemployeename = new JTextField();
		txtemployeename.setColumns(10);
		txtemployeename.setBounds(184, 29, 177, 39);
		panel_employeeInformation.add(txtemployeename);
		
		txtemployeeid = new JTextField();
		txtemployeeid.setColumns(10);
		txtemployeeid.setBounds(184, 91, 177, 39);
		panel_employeeInformation.add(txtemployeeid);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(SystemColor.textHighlight);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployeeId.setBounds(10, 91, 142, 39);
		panel_employeeInformation.add(lblEmployeeId);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(SystemColor.textHighlight);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(10, 153, 142, 39);
		panel_employeeInformation.add(lblAddress);
		
		txtemployeeaddress = new JTextField();
		txtemployeeaddress.setColumns(10);
		txtemployeeaddress.setBounds(184, 153, 177, 39);
		panel_employeeInformation.add(txtemployeeaddress);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setForeground(SystemColor.textHighlight);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalary.setBounds(10, 218, 142, 39);
		panel_employeeInformation.add(lblSalary);
		
		txtemployeesalary = new JTextField();
		txtemployeesalary.setColumns(10);
		txtemployeesalary.setBounds(184, 218, 177, 39);
		panel_employeeInformation.add(txtemployeesalary);
		
		JTextArea textArea_employee = new JTextArea();
		textArea_employee.setBounds(384, 31, 414, 453);
		panel_employeeInformation.add(textArea_employee);
		textArea_employee.setFont(new Font("verdana",Font.BOLD,20));
		textArea_employee.setForeground(Color.cyan);
		//working here for creating database for employee
		//data will stored in database
		//lets make it

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(53, 279, 275, 164);
		panel_employeeInformation.add(desktopPane_1);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setBackground(Color.BLACK);
		imagelabel.setBounds(10, 10, 255, 144);
		desktopPane_1.add(imagelabel);
		
		JButton btnemployeeadd = new JButton("Attach");
		btnemployeeadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				
				filename=f.getAbsolutePath();
				ImageIcon imageIcoon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(imagelabel.getWidth() ,imagelabel.getHeight(),Image.SCALE_DEFAULT));
				imagelabel.setIcon(imageIcoon);
				try {
					File imageemp=new File(filename);
					FileInputStream fix=new FileInputStream(imageemp);
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
					for(int i;(i=fix.read(buf))!= -1; ) {
						bos.write(buf,0,i);
					}
					person_image=bos.toByteArray();
					
					
				}catch(Exception e1) {
					
				}
				
				
			}
		});
		btnemployeeadd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnemployeeadd.setBackground(new Color(240, 240, 240));
		btnemployeeadd.setForeground(SystemColor.textHighlight);
		btnemployeeadd.setBounds(245, 453, 116, 31);
		panel_employeeInformation.add(btnemployeeadd);
		
		JButton addbtn = new JButton("Add");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//txtemployeename  txtemployeeid txtemployeeaddress txtemployeesalary
				String ename=txtemployeename.getText();
				String sid=txtemployeeid.getText();
				
				String eadress=txtemployeeaddress.getText();
				String ssalary=txtemployeesalary.getText();
				try {
					eid=Integer.parseInt(sid);
					esalary=Integer.parseInt(ssalary);
					f=true;
					}catch(Exception i) {
						
					}
				if(f) {
					
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection coon=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
					PreparedStatement pst3=coon.prepareStatement("Insert into employee(name,id,adress,salary,image)values(?,?,?,?,?)");
					pst3.setString(1, ename);
					pst3.setInt(2, eid);
					pst3.setString(3, eadress);
					pst3.setInt(4, esalary);
					pst3.setBytes(5, person_image);
					pst3.executeUpdate();
					
					pst3.close();
					coon.close();
					textArea_employee.append(" Congraculation,"+ename+".\nYour are the newest member."+ "\nWelcome to ABC CANTEEN");
					JOptionPane.showMessageDialog(null, "done");
					txtemployeename.setText("");
					txtemployeeid.setText("");
					txtemployeeaddress.setText("");
					txtemployeesalary.setText("");
					imagelabel.setIcon(null);
					textArea_employee.setText("");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(null, "Enter correct Information");
					txtemployeename.setText("");
					txtemployeeid.setText("");
					txtemployeeaddress.setText("");
					txtemployeesalary.setText("");
					imagelabel.setIcon(null);
					textArea_employee.setText("");
					
				}
				}
		});
		addbtn.setBounds(63, 453, 116, 31);
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		addbtn.setBackground(new Color(240, 240, 240));
		addbtn.setForeground(SystemColor.textHighlight);
	    panel_employeeInformation.add(addbtn);
		
		
		JPanel panel_purchase = new JPanel();
		panel_purchase.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Purchase Request", null, panel_purchase, null);
		panel_purchase.setLayout(null);
		
		JTextArea textArea_purchase = new JTextArea();
		
		Font font = new Font("Segoe Script", Font.BOLD, 20);
        textArea_purchase.setFont(font);
        JScrollPane scroll=new JScrollPane(textArea_purchase);
        scroll.setBounds(354, 10, 444, 457);
        textArea_purchase.setForeground(Color.BLUE);
		panel_purchase.add(scroll);
		
		
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(SystemColor.textHighlight);
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProductName.setBounds(10, 28, 142, 39);
		panel_purchase.add(lblProductName);
		
		txtproductname = new JTextField();
		txtproductname.setColumns(10);
		txtproductname.setBounds(184, 26, 160, 39);
		panel_purchase.add(txtproductname);
		
		txtproductquantity = new JTextField();
		txtproductquantity.setColumns(10);
		txtproductquantity.setBounds(184, 88, 160, 39);
		panel_purchase.add(txtproductquantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(SystemColor.textHighlight);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(10, 88, 142, 39);
		panel_purchase.add(lblQuantity);
		
		JLabel lblAmountofpurchase = new JLabel("Amount/Unit");
		lblAmountofpurchase.setForeground(SystemColor.textHighlight);
		lblAmountofpurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmountofpurchase.setBounds(10, 150, 142, 39);
		panel_purchase.add(lblAmountofpurchase);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(184, 150, 160, 39);
		panel_purchase.add(txtamount);
		
		
		//working here for request product
		//wil also connected to database
		//name,cost,date
		JButton btnpurchaserequest = new JButton("Request");
		btnpurchaserequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double dam,q = 0,to = 0;
				String pname,pQuan,pcost;
				pname=txtproductname.getText();
				pcost=txtamount.getText();
				pQuan=txtproductquantity.getText();
				try {
				dam=Double.parseDouble(pcost);
				q=Double.parseDouble(pQuan);
				to=dam*q;
				p=true;
				}catch(Exception w) {
					System.out.println(w);
				}
				if(p) {
				textArea_purchase.append("Product Name      : "+pname+"\nProduct Quantity :  "+pQuan+"\nProduct Price      :  "+to+"\n\n");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("registered");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
					System.out.println("connected");
					PreparedStatement stmt=con.prepareStatement("insert into purchase(Product,Quantity,Price,Date) values(?,?,?,curdate())");  
					System.out.println("done");
			
					stmt.setString(1, pname);
					stmt.setDouble(2, q);
					stmt.setDouble(3, to);
					
					stmt.executeUpdate();
					System.out.println("invoked");
					
					
					con.close();
					stmt.close();
					txtproductname.setText("");
					txtamount.setText("");
					txtproductquantity.setText("");
					}
				
				catch (Exception e2) {
					System.out.println(e2);
				}
				}else {
					JOptionPane.showMessageDialog(null, "Enter correct information");
					txtproductname.setText("");
					txtamount.setText("");
					txtproductquantity.setText("");
					
				}
				}
		});
		btnpurchaserequest.setForeground(SystemColor.textHighlight);
		btnpurchaserequest.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnpurchaserequest.setBackground(SystemColor.menu);
		btnpurchaserequest.setBounds(228, 237, 116, 31);
		panel_purchase.add(btnpurchaserequest);
		
		JPanel panel_voucher = new JPanel();
		panel_voucher.setBackground(UIManager.getColor("inactiveCaption"));
		tabbedPane.addTab("Voucher", null, panel_voucher, null);
		panel_voucher.setLayout(null);
		
		txtvouchername = new JTextField();
		txtvouchername.setColumns(10);
		txtvouchername.setBounds(271, 22, 326, 39);
		panel_voucher.add(txtvouchername);
		
		JLabel lblQuantity_1 = new JLabel("Voucher Name");
		lblQuantity_1.setForeground(SystemColor.textHighlight);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity_1.setBounds(96, 19, 143, 39);
		panel_voucher.add(lblQuantity_1);
		
		JTextArea textArea_voucher = new JTextArea();
		textArea_voucher.setBounds(30, 97, 744, 387);
		Font font2 = new Font("Segoe Script", Font.BOLD, 20);
        textArea_voucher.setFont(font2);
        textArea_voucher.setForeground(Color.BLUE);
		panel_voucher.add(textArea_voucher);
		
		JButton btnaddvoucher = new JButton("Add");
		btnaddvoucher.setForeground(SystemColor.textHighlight);
		btnaddvoucher.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnaddvoucher.setBounds(632, 22, 95, 36);
		panel_voucher.add(btnaddvoucher);
		
		//working here for vocher
		//it will added in file
		
		btnaddvoucher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num=txtvouchername.getText();
				textArea_voucher.append("Voucher:\n");
				textArea_voucher.append(num+"\n");
				try {
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
				File myfile=new File("voucher.txt");
				try {
					if(myfile.createNewFile()) {
						System.out.println("created");			//voucher file created
					}
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				String data=null;
				Scanner myreader;
				try {
					myreader = new Scanner(myfile);
					
					while(myreader.hasNext()) {
						data=myreader.nextLine();
						textArea_voucher.append(data+"\n");
						
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				try {
				BufferedWriter apen=new BufferedWriter(new FileWriter("voucher.txt",true));
				apen.newLine();
				apen.write(num);
				apen.close();
				txtvouchername.setText("");
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});
		
		JPanel panel_records = new JPanel();
		panel_records.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Records", null, panel_records, null);
		panel_records.setLayout(null);
		
		JTextArea textArea_records = new JTextArea();
		textArea_records.setBounds(121, 69, 652, 425);
		textArea_records.setFont(font2);
        textArea_records.setForeground(Color.BLUE);
		panel_records.add(textArea_records);
		
		Thread update = new Thread() {
		
		public void run() {
			
			try {
				for(;;) {
					jrecords();
					textArea_records.setText("");
					textArea_records.append("Revenue                     :"+sum);
					textArea_records.append("\n\nTotal expense              :"+sum1);
					textArea_records.append("\nEmployee salary          :"+empsalary);
					textArea_records.append("\n\n---------------------------------");
					
					if(sum>(sum1+empsalary)){
						textArea_records.append("\n\nProfit                        :"+(sum-(sum1+empsalary)));
					}
					else {
						textArea_records.append("\n\nLoss                          :"+(sum1+empsalary-sum));
					}
					
					sleep(1000);// records will change 
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};
	
	update.start(); // without this cant start the thread.  
	

	}
}
