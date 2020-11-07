

package mp;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Canteen extends LogFile {
	
	LogFile fil=new LogFile();

	public JFrame frame_2;
	private JTextField tfchickenburger;
	private JTextField tfbeefburger;
	private JTextField tfshwarma;
	private JTextField tficetea;
	private JTextField tfsandwich;
	private JTextField tfclubsandwich;
	private JTextField tfcocacola;
	private JTextField tffanta;
	private JTextField tfchickenfry;
	private JTextField tfchickenkabab;
	private JTextField tfbeefkabab;
	private JTextArea textArea;
	private JCheckBox chckbxchickenburger,chckbxbeefburger,chckbxshwarma,chckbxicetea,chckbxsandwich,chckbxclubsandwich,chckbxcocacola,chckbxfanta,chckbxchickenfry,chckbxchickenkabab,chckbxbeefkabab
	;
	

	/**
	 * Launch the application.
	 */
	
	
	double total2;
	private int cBurger,bBurger,shwarma,IceTea,Sandwich,cSandwich,Cocacola,Fanta,ChickenFry,cKabab,bkabab;
	double t1,t2;
	private double total;//=cBurger + bBurger + shwarma + IceTea + Sandwich + cSandwich + Cocacola + Fanta + ChickenFry + cKabab + bkabab;
	boolean f=false;
	int Id_checker;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Canteen window = new Canteen();
					window.frame_2.setVisible(true);
					ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
					window.frame_2.setIconImage(img2.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//reciept();
	}
	

	/**
	 * Create the application.
	 */
	
	
	public Canteen() {
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_2 = new JFrame("Canteen");
		frame_2.setBounds(0, 0, 1368, 689);
		frame_2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame_2.getContentPane().setLayout(null);
		
		//ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(255, 175, 175)));
		panel1.setBounds(10, 98, 442, 554);
		frame_2.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblBasicMenu = new JLabel("****Basic Menu****");
		lblBasicMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblBasicMenu.setBounds(95, 10, 333, 30);
		panel1.add(lblBasicMenu);
		
		
		
			JRadioButton rdbtnchickenburger = new JRadioButton("Chicken Burger");
			rdbtnchickenburger.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnchickenburger.setBounds(33, 61, 150, 30);
			panel1.add(rdbtnchickenburger);
			
			JRadioButton rdbtnbeefburger = new JRadioButton("Beef Burger");
			rdbtnbeefburger.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnbeefburger.setBounds(33, 105, 150, 30);
			panel1.add(rdbtnbeefburger);
			
			JRadioButton rdbtnshwarma = new JRadioButton("Shwarma");
			rdbtnshwarma.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnshwarma.setBounds(33, 151, 150, 30);
			panel1.add(rdbtnshwarma);
			
			JRadioButton rdbtnicetea = new JRadioButton("Ice Tea");
			rdbtnicetea.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnicetea.setBounds(33, 205, 150, 30);
			panel1.add(rdbtnicetea);
			
			JRadioButton rdbtnsandwich = new JRadioButton("Sandwich");
			rdbtnsandwich.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnsandwich.setBounds(33, 261, 150, 30);
			panel1.add(rdbtnsandwich);
			
			JRadioButton rdbtnclubsandwich = new JRadioButton("Club Sandwich");
			rdbtnclubsandwich.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnclubsandwich.setBounds(33, 317, 150, 30);
			panel1.add(rdbtnclubsandwich);
			
			JRadioButton rdbtncocacola = new JRadioButton("Coca Cola");
			rdbtncocacola.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtncocacola.setBounds(234, 61, 150, 30);
			panel1.add(rdbtncocacola);
			
			JRadioButton rdbtnfanta = new JRadioButton("Fanta");
			rdbtnfanta.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnfanta.setBounds(234, 112, 150, 30);
			panel1.add(rdbtnfanta);
			
			JRadioButton rdbtnchickenfry = new JRadioButton("Chicken Fry");
			rdbtnchickenfry.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnchickenfry.setBounds(234, 158, 150, 30);
			panel1.add(rdbtnchickenfry);
			
			JRadioButton rdbtnchickenkabab = new JRadioButton("Chicken Kabab");
			rdbtnchickenkabab.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnchickenkabab.setBounds(234, 212, 150, 30);
			panel1.add(rdbtnchickenkabab);
			
			JRadioButton rdbtnbeefkabab = new JRadioButton("Beef Kabab");
			rdbtnbeefkabab.setFont(new Font("Tahoma", Font.BOLD, 14));
			rdbtnbeefkabab.setBounds(234, 261, 150, 30);
			panel1.add(rdbtnbeefkabab);
		
		
		
		
	
	
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.PINK));
		panel2.setBounds(455, 10, 455, 461);
		frame_2.getContentPane().add(panel2);
		panel2.setLayout(null);
		
				
		
		
		
		
		JLabel labelLiveMenu = new JLabel("****Live Menu****");
		labelLiveMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelLiveMenu.setBounds(112, 10, 333, 30);
		panel2.add(labelLiveMenu);
		
		
			
			JCheckBox chckbxchickenburger = new JCheckBox("Chicken Burger");
			chckbxchickenburger.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxchickenburger.setBounds(28, 68, 141, 21);
			panel2.add(chckbxchickenburger);
			chckbxchickenburger.setVisible(false);
			chckbxchickenburger.setToolTipText("0");
			
			//chckbxbeefburger,chckbxshwarma,chckbxicetea,chckbxsandwich,chckbxclubsandwich,chckbxcocacola,chckbxfanta,chckbxchickenfry,chckbxchickenkabab,chckbxbeefkabab
			
			JCheckBox chckbxbeefburger = new JCheckBox("Beef Burger");
			chckbxbeefburger.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxbeefburger.setBounds(28, 101, 141, 21);
			panel2.add(chckbxbeefburger);
			chckbxbeefburger.setVisible(false);
			
			JCheckBox chckbxshwarma = new JCheckBox("Shwarma");
			chckbxshwarma.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxshwarma.setBounds(28, 134, 141, 21);
			panel2.add(chckbxshwarma);
			chckbxshwarma.setVisible(false);
			
			JCheckBox chckbxicetea = new JCheckBox("Ice Tea");
			chckbxicetea.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxicetea.setBounds(28, 170, 141, 21);
			panel2.add(chckbxicetea);
			chckbxicetea.setVisible(false);
			
			JCheckBox chckbxsandwich = new JCheckBox("Sandwich");
			chckbxsandwich.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxsandwich.setBounds(28, 205, 141, 21);
			panel2.add(chckbxsandwich);
			chckbxsandwich.setVisible(false);
			
			JCheckBox chckbxclubsandwich = new JCheckBox("Club Sandwich");
			chckbxclubsandwich.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxclubsandwich.setBounds(28, 241, 141, 21);
			panel2.add(chckbxclubsandwich);
			chckbxclubsandwich.setVisible(false);
			
			JCheckBox chckbxcocacola = new JCheckBox("Coca Cola");
			chckbxcocacola.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxcocacola.setBounds(28, 277, 141, 21);
			panel2.add(chckbxcocacola);
			chckbxcocacola.setVisible(false);
			
			JCheckBox chckbxfanta = new JCheckBox("Fanta");
			chckbxfanta.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxfanta.setBounds(28, 315, 141, 21);
			panel2.add(chckbxfanta);
			chckbxfanta.setVisible(false);
			
			JCheckBox chckbxchickenfry = new JCheckBox("Chicken Fry");
			chckbxchickenfry.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxchickenfry.setBounds(28, 347, 141, 21);
			panel2.add(chckbxchickenfry);
			chckbxchickenfry.setVisible(false);
			
			JCheckBox chckbxchickenkabab = new JCheckBox("Chicken Kabab");
			chckbxchickenkabab.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxchickenkabab.setBounds(28, 382, 141, 21);
			panel2.add(chckbxchickenkabab);
			chckbxchickenkabab.setVisible(false);
			
			JCheckBox chckbxbeefkabab = new JCheckBox("Beef Kabab");
			chckbxbeefkabab.setFont(new Font("Tahoma", Font.BOLD, 14));
			chckbxbeefkabab.setBounds(28, 415, 141, 21);
			panel2.add(chckbxbeefkabab);
		
				tfchickenburger = new JTextField();
				tfchickenburger.setBounds(175, 70, 96, 19);
				panel2.add(tfchickenburger);
				tfchickenburger.setColumns(10);
				tfchickenburger.setVisible(false);
				
				
				
				tfbeefburger = new JTextField();
				tfbeefburger.setColumns(10);
				tfbeefburger.setBounds(175, 102, 96, 19);
				panel2.add(tfbeefburger);
				tfbeefburger.setVisible(false);
				
				tfshwarma = new JTextField();
				tfshwarma.setColumns(10);
				tfshwarma.setBounds(175, 136, 96, 19);
				panel2.add(tfshwarma);
				tfshwarma.setVisible(false);
				
				tficetea = new JTextField();
				tficetea.setColumns(10);
				tficetea.setBounds(175, 172, 96, 19);
				panel2.add(tficetea);
				tficetea.setVisible(false);
				
				tfsandwich = new JTextField();
				tfsandwich.setColumns(10);
				tfsandwich.setBounds(175, 207, 96, 19);
				panel2.add(tfsandwich);
				tfsandwich.setVisible(false);
				
				tfclubsandwich = new JTextField();
				tfclubsandwich.setColumns(10);
				tfclubsandwich.setBounds(175, 243, 96, 19);
				panel2.add(tfclubsandwich);
				tfclubsandwich.setVisible(false);
				
				tfcocacola = new JTextField();
				tfcocacola.setColumns(10);
				tfcocacola.setBounds(175, 279, 96, 19);
				panel2.add(tfcocacola);
				tfcocacola.setVisible(false);
				
				tffanta = new JTextField();
				tffanta.setColumns(10);
				tffanta.setBounds(175, 317, 96, 19);
				panel2.add(tffanta);
				tffanta.setVisible(false);
				
				tfchickenfry = new JTextField();
				tfchickenfry.setColumns(10);
				tfchickenfry.setBounds(175, 349, 96, 19);
				panel2.add(tfchickenfry);
				tfchickenfry.setVisible(false);
				
				tfchickenkabab = new JTextField();
				tfchickenkabab.setColumns(10);
				tfchickenkabab.setBounds(175, 384, 96, 19);
				panel2.add(tfchickenkabab);
				tfchickenkabab.setVisible(false);
				
				tfbeefkabab = new JTextField();
				tfbeefkabab.setColumns(10);
				tfbeefkabab.setBounds(175, 417, 96, 19);
				tfbeefkabab.setToolTipText("");
				panel2.add(tfbeefkabab);
				
				
				//i am working
				//workinglllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll
				//llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll
				
				
				
				JButton btnTotal = new JButton("Total");
				btnTotal.setForeground(Color.WHITE);
				btnTotal.setBackground(new Color(250, 128, 114));
				btnTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnTotal.setBounds(301, 400, 132, 36);
				panel2.add(btnTotal);
				
				JLabel lblqty = new JLabel("Qty");
				lblqty.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblqty.setBounds(311, 71, 67, 19);
				panel2.add(lblqty);
				chckbxbeefkabab.setVisible(false);
				tfbeefkabab.setVisible(false);
		
		
				JButton btnadd = new JButton("Add");
				btnadd.setBackground(new Color(250, 128, 114));
				btnadd.setForeground(Color.WHITE);
				btnadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(rdbtnchickenburger.isSelected()) {
							chckbxchickenburger.setVisible(true);
							tfchickenburger.setVisible(true);
						}
						
						if(rdbtnbeefburger.isSelected()) {
							chckbxbeefburger.setVisible(true);
							tfbeefburger.setVisible(true);
						}
						
						if(rdbtnshwarma.isSelected()) {
							chckbxshwarma.setVisible(true);
							tfshwarma.setVisible(true);
						}
						
						if(rdbtnicetea.isSelected()) {
							chckbxicetea.setVisible(true);
							tficetea.setVisible(true);
						}
						
						if(rdbtnsandwich.isSelected()) {
							chckbxsandwich.setVisible(true);
							tfsandwich.setVisible(true);
						}
						
						if(rdbtnclubsandwich.isSelected()) {
							chckbxclubsandwich.setVisible(true);
							tfclubsandwich.setVisible(true);

						}
						
						if(rdbtncocacola.isSelected()) {
							chckbxcocacola.setVisible(true);
							tfcocacola.setVisible(true);
						}
						
						if(rdbtnfanta.isSelected()) {
							chckbxfanta.setVisible(true);
							tffanta.setVisible(true);
						}
						
						if(rdbtnchickenkabab.isSelected()) {
							chckbxchickenkabab.setVisible(true);
							tfchickenkabab.setVisible(true);
						}
						
						if(rdbtnchickenfry.isSelected()) {
							chckbxchickenfry.setVisible(true);
							tfchickenfry.setVisible(true);
						}
						
						if(rdbtnbeefkabab.isSelected()) {
							chckbxbeefkabab.setVisible(true);
							tfbeefkabab.setVisible(true);
						}
						
					}
				});
				btnadd.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnadd.setBounds(10, 453, 132, 36);
				panel1.add(btnadd);
				
				JButton btnremove = new JButton("Remove");
				btnremove.setForeground(Color.WHITE);
				btnremove.setBackground(new Color(250, 128, 114));
				btnremove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(rdbtnchickenburger.isSelected()) {
							chckbxchickenburger.setVisible(false);
							tfchickenburger.setVisible(false);
						}
						
						if(rdbtnbeefburger.isSelected()) {
							chckbxbeefburger.setVisible(false);
							tfbeefburger.setVisible(false);
						}
						
						if(rdbtnshwarma.isSelected()) {
							chckbxshwarma.setVisible(false);
							tfshwarma.setVisible(false);
						}
						
						if(rdbtnicetea.isSelected()) {
							chckbxicetea.setVisible(false);
							tficetea.setVisible(false);
						}
						
						if(rdbtnsandwich.isSelected()) {
							chckbxsandwich.setVisible(false);
							tfsandwich.setVisible(false);
						}
						
						if(rdbtnclubsandwich.isSelected()) {
							chckbxclubsandwich.setVisible(false);
							tfclubsandwich.setVisible(false);
						}
						
						if(rdbtncocacola.isSelected()) {
							chckbxcocacola.setVisible(false);
							tfcocacola.setVisible(false);
						}
						
						if(rdbtnfanta.isSelected()) {
							chckbxfanta.setVisible(false);
							tffanta.setVisible(false);
						}
						
						if(rdbtnchickenkabab.isSelected()) {
							chckbxchickenkabab.setVisible(false);
							tfchickenkabab.setVisible(false);
						}
						
						if(rdbtnchickenfry.isSelected()) {
							chckbxchickenfry.setVisible(false);
							tfchickenfry.setVisible(false);
						}
						
						if(rdbtnbeefkabab.isSelected()) {
							chckbxbeefkabab.setVisible(false);
							tfbeefkabab.setVisible(false);
						}
						
					}
				});
				btnremove.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnremove.setBounds(298, 453, 132, 36);
				panel1.add(btnremove);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setForeground(Color.WHITE);
				btnReset.setBackground(new Color(250, 128, 114));
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						rdbtnchickenburger.setSelected(false);
						rdbtnbeefburger.setSelected(false);
						rdbtnshwarma.setSelected(false);
						rdbtnicetea.setSelected(false);
						rdbtnsandwich.setSelected(false);
						rdbtnclubsandwich.setSelected(false);
						rdbtncocacola.setSelected(false);
						rdbtnfanta.setSelected(false);
						rdbtnchickenfry.setSelected(false);
						rdbtnchickenkabab.setSelected(false);
						rdbtnbeefkabab.setSelected(false);
					}
				});
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnReset.setBounds(162, 453, 115, 36);
				panel1.add(btnReset);
				
				
				JButton buttobtnlogout = new JButton("Logout");
								buttobtnlogout.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										
										JFrame frmLoginSystem = new JFrame("Logout");
										if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to logout","Canteen",
												JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
											System.exit(0);
											}
										}
										
									});
								
								buttobtnlogout.setForeground(Color.WHITE);
								buttobtnlogout.setFont(new Font("Tahoma", Font.BOLD, 20));
								buttobtnlogout.setBackground(new Color(250, 128, 114));
								buttobtnlogout.setBounds(145, 498, 145, 36);
								panel1.add(buttobtnlogout);
		
		
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new LineBorder(Color.DARK_GRAY));
		panel4.setBounds(912, 10, 442, 535);
		frame_2.getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JLabel labelReceipt = new JLabel("****Receipt****");
		labelReceipt.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelReceipt.setBounds(142, 10, 232, 30);
		panel4.add(labelReceipt);
		
		//started for reciept
		

		
		Font rF=new Font(Font.SERIF, Font.PLAIN,  18);    //this is used for reciept
		
		textArea = new JTextArea();
		textArea.setBounds(10, 85, 422, 393);
		
	    textArea.setText("\t\t----------RECEPIT ----------\n\n" +
	    					"===============================================================\n\n"+
	                       
	    					"DESCRIPTION\t\t"+"QUANTITY\t\t"+"PRICE\n\n");
		panel4.add(textArea);                                         
	/*
		heading =new JTextArea( "", 36, 36);
		heading.setBounds(25,100,400,15);
		heading.setEditable( true);
		//heading.setFont(rF);
		heading.setText("Description"+"      "+"Quantity"+"    "+"Price");
		*/
		 //heading = new JTextArea( "", 36, 36);
		 //heading.setEditable( true);
		
		btnTotal.addActionListener(new ActionListener() {
			

			
	
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chckbxchickenburger.isSelected()) {
              
					String inp1=(tfchickenburger.getText());
					cBurger=Integer.parseInt(inp1)*90;
String cb="Chicken Burger\t\t"+tfchickenburger.getText()+"\t\t"+cBurger+"\n";
					textArea.append(cb);
					
				}
				
				 if (chckbxshwarma.isSelected()) {
	                
						String inp2=(tfshwarma.getText());
						 shwarma=Integer.parseInt(inp2)*70;
	String sh="Shwarma\t\t"+tfshwarma.getText()+"\t\t"+shwarma+"\n";
						textArea.append(sh);
						
					}
				 if (chckbxbeefkabab.isSelected()) {
					String inp55=(tfbeefkabab.getText());
					bkabab=Integer.parseInt(inp55)*40;
String bk="Beef Kabab\t\t"+tfbeefkabab.getText()+"\t\t"+bkabab+"\n";
					textArea.append(bk);
					
				}
				 if (chckbxbeefburger.isSelected()) {
						String inp3=(tfbeefburger.getText());
						 bBurger=Integer.parseInt(inp3)*110;
	String bb="Beef Burger\t\t"+tfbeefburger.getText()+"\t\t"+bBurger+"\n";
						textArea.append(bb);
						
					}
				 if (chckbxicetea.isSelected()) {
						String inp4=(tficetea.getText());
						IceTea=Integer.parseInt(inp4)*25;
	String it="Ice Tea\t\t"+tficetea.getText()+"\t\t"+IceTea+"\n";
						textArea.append(it);
						
					}
				 if (chckbxsandwich.isSelected()) {
						String inp5=(tfsandwich.getText());
						Sandwich=Integer.parseInt(inp5)*60;
	String ss="Sandwich\t\t"+tfsandwich.getText()+"\t\t"+Sandwich+"\n";
						textArea.append(ss);
						
					}
				 if (chckbxclubsandwich.isSelected()) {
						String inp6=(tfclubsandwich.getText());
						cSandwich=Integer.parseInt(inp6)*70;
	String cs="Club Sandwich\t\t"+tfclubsandwich.getText()+"\t\t"+cSandwich+"\n";
						textArea.append(cs);
						
					}
				 if (chckbxcocacola.isSelected()) {
						String inp7=(tfcocacola.getText());
						Cocacola=Integer.parseInt(inp7)*20;
	String coc="Cocacola\t\t"+tfcocacola.getText()+"\t\t"+Cocacola+"\n";
						textArea.append(coc);
						
					}
				 if (chckbxchickenfry.isSelected()) {
						String inp8=(tfchickenfry.getText());
						ChickenFry=Integer.parseInt(inp8)*100;
	String cf="Chicken Fry\t\t"+tfchickenfry.getText()+"\t\t"+ChickenFry+"\n";
						textArea.append(cf);
						
					}
				 if (chckbxchickenkabab.isSelected()) {
						String inp10=(tfchickenkabab.getText());
						cKabab=Integer.parseInt(inp10)*25;
	String ck="Chicken Kabab\t\t"+tfchickenkabab.getText()+"\t\t"+cKabab+"\n";
						textArea.append(ck);
						
					}
				 if (chckbxfanta.isSelected()) {
		                
						String inp20=(tffanta.getText());
						 Fanta=Integer.parseInt(inp20)*20;
	String sh="Fanta\t\t"+tffanta.getText()+"\t\t"+Fanta+"\n";
						textArea.append(sh);
						
					}
				 
				 
				 
				total = cBurger + bBurger + shwarma + IceTea + Sandwich + cSandwich + Cocacola + Fanta + ChickenFry + cKabab + bkabab;
				 t1=total;
									 textArea.append("-----------------------------------------------------------------------------------------------------\n"+
						 "Total Amount:\t\t\t\t"+total);
				 
				
			}		
		});

		    
		  
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.PINK));
		panel3.setBounds(455, 473, 455, 179);
		frame_2.getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JLabel lblcashlessTransaction = new JLabel("*****Cashless Transaction & Vouchers*****");
		lblcashlessTransaction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcashlessTransaction.setBounds(17, 10, 428, 30);
		panel3.add(lblcashlessTransaction);
		
		JLabel id=new JLabel("Id               :");
		id.setBounds(20,50,150,20);
		id.setFont(new Font("Verdana",Font.BOLD,18));
		panel3.add(id);
		
		JTextField idd=new JTextField();
		idd.setBounds(178,45,180,25);
		panel3.add(idd);
		
		
		JLabel pword=new JLabel("Voucher     :");
		pword.setBounds(20,90,150,20);
		pword.setFont(new Font("Verdana",Font.BOLD,18));
		panel3.add(pword);
		
		JTextField tpword=new JTextField();
		tpword.setBounds(178,90,180,25);
		panel3.add(tpword);
		
		
		
		
		JButton proceed=new JButton("Proceed");
		proceed.setForeground(Color.WHITE);
		proceed.setBackground(new Color(250, 128, 114));
		proceed.setBounds(320,130,120,39);
		proceed.setFont(new Font("Verdana", Font.BOLD, 18));
		proceed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag=1;
				String data;
				String idc=idd.getText();
				String vou=tpword.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("registered");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
					System.out.println("connected");
					Statement stmt=con.createStatement();
					ResultSet res=stmt.executeQuery("select id from customer");
					int change=Integer.parseInt(idd.getText());
					System.out.println("done");
					while(res.next()) {
						Id_checker=res.getInt(1);
						if(change==Id_checker) {
							f=true;
					}
					}
					res.close();
				}catch(Exception e10) {
					
				} 
				if(f){
				
				
				
				File myfile=new File("voucher.txt");
				
				try {
					Scanner myreader=new Scanner(myfile);
					double total3=total-(total*.05);
					
					while(myreader.hasNext()) {
					 data=myreader.nextLine();
						if (tpword.getText().equals(data)) {
								flag=0;
								System.out.println("Flag:"+flag);
						}
						
						
						System.out.println(data);
					}
					if(flag==0) {
						t2=total3;
					}
					else {
						t2=total;
						JOptionPane.showMessageDialog(null, "Voucher is not working");
					}
					
				
					String tot="\n"+"Pay:\t\t\t\t"+t2;
					textArea.append(tot);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String iddf=idc+".txt";
				
				if(cashlessRead(iddf,t2)) {
					textArea.append("\n\n\nCashless transa"
							+ "ction successfully completed.");
				}
				
			}
				 else {
					JOptionPane.showMessageDialog(null, "Please correct enter id");
			}

			}
			
		});
		
		panel3.add(proceed);
		
		JLabel lblCanteenName = new JLabel("ABC Canteen Management System");
		lblCanteenName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblCanteenName.setForeground(Color.BLACK);
		lblCanteenName.setBounds(10, 10, 435, 78);
		frame_2.getContentPane().add(lblCanteenName);
		
		JButton btnrefreash = new JButton("Refresh");
		btnrefreash.setForeground(Color.WHITE);
		btnrefreash.setBackground(new Color(250, 128, 114));
		btnrefreash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chckbxchickenburger.setSelected(false);
				chckbxbeefburger.setSelected(false);
				chckbxshwarma.setSelected(false);
				chckbxicetea.setSelected(false);
				chckbxsandwich.setSelected(false);
				chckbxclubsandwich.setSelected(false);
				chckbxcocacola.setSelected(false);
				chckbxfanta.setSelected(false);
			    chckbxchickenfry.setSelected(false);
				chckbxchickenkabab.setSelected(false);
				chckbxbeefkabab.setSelected(false);
			
				total = 0;
				cBurger=0;
				bBurger=0;
				shwarma=0;
				IceTea=0;
				Sandwich=0;
				cSandwich=0;
				Cocacola=0;
				Fanta=0;
				ChickenFry=0;
				cKabab=0;
				bkabab=0;
			
				tfchickenburger.setText("");
				tfbeefburger.setText("");
				tfshwarma.setText("");
				tficetea.setText("");
				tfsandwich.setText("");
				tfclubsandwich.setText("");
				tfcocacola.setText("");
				tffanta.setText("");
				tfchickenfry.setText("");
				tfchickenkabab.setText("");
			    tfbeefkabab.setText("");
			    idd.setText(null);
			    tpword.setText(null);
				textArea.setText("");
				textArea.setText("\t\t----------RECEPIT ----------\n\n" +
	    					"===============================================================\n\n"+
	                       
	    					"DESCRIPTION\t\t"+"QUANTITY\t\t"+"PRICE\n\n");
				
			
			}
		});
		btnrefreash.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnrefreash.setBounds(920, 576, 136, 34);
		frame_2.getContentPane().add(btnrefreash);
		
		
		//worked for printing
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(new Color(250, 128, 114));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.append("\n\n\nReceipt Printed");
				textArea.append("\n\n                                       ----------Thank You ----------");
				if(t2==0) {
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
						System.out.println("connected");
						PreparedStatement stmt=con.prepareStatement("insert into selll(sell) values(?)");  
						System.out.println("done");
				
						stmt.setDouble(1, t1);
						
						
						stmt.executeUpdate();
						System.out.println("invoked");
						
						
						con.close();
						stmt.close();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(t2!=0) {
					
					try {
						Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC", "root", "");
						System.out.println("connected");
						PreparedStatement stmt=con2.prepareStatement("insert into selll(sell) values(?)");  
						System.out.println("done");
				
						stmt.setDouble(1, t2);
						
						
						stmt.executeUpdate();
						System.out.println("invoked");
						
						
						con2.close();
						stmt.close();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				JOptionPane.showMessageDialog(null,"Done");
			
				Boolean ppt;
					try {
						ppt = textArea.print();
						
						if(ppt) {
							
							}
						else {
							JOptionPane.showMessageDialog(null,"Printing");
						}
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						System.out.println("You aborted printing");
					}
					
				
				
			}
				
			}); 
		
		
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPrint.setBounds(1066, 576, 136, 34);
		frame_2.getContentPane().add(btnPrint);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setForeground(Color.WHITE);
		btnInventory.setBackground(new Color(250, 128, 114));
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inventory window = new Inventory();
				window.frame3.setVisible(true);
				
			}
		});
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInventory.setBounds(1212, 576, 136, 34);
		frame_2.getContentPane().add(btnInventory);
	}
}

