package mp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	public JFrame frame_signUp;
	public JTextField txtsignupid;
	public JTextField txtsignuppassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp window = new signUp();
					window.frame_signUp.setVisible(true);
					ImageIcon img2=new ImageIcon(getClass().getResource("icon.png"));//to set icon
					window.frame_signUp.setIconImage(img2.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	File myfile=new File("LogInFile.txt");
	
	protected void initialize() {
		frame_signUp = new JFrame();
		frame_signUp.setBounds(100, 100, 450, 300);
		frame_signUp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame_signUp.getContentPane().setLayout(null);
		
		
		
		JLabel signup = new JLabel("Create New ID");
		signup.setForeground(Color.BLUE);
		signup.setFont(new Font("Tahoma", Font.BOLD, 20));
		signup.setBounds(132, 10, 170, 26);
		frame_signUp.getContentPane().add(signup);
		
		JLabel lblNewLabel = new JLabel("Enter User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(20, 77, 163, 26);
		frame_signUp.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(Color.BLUE);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterPassword.setBounds(20, 123, 145, 26);
		frame_signUp.getContentPane().add(lblEnterPassword);
		
		txtsignupid = new JTextField();
		txtsignupid.setBounds(210, 77, 157, 26);
		frame_signUp.getContentPane().add(txtsignupid);
		txtsignupid.setColumns(10);
		
		txtsignuppassword = new JTextField();
		txtsignuppassword.setColumns(10);
		txtsignuppassword.setBounds(210, 123, 157, 26);
		frame_signUp.getContentPane().add(txtsignuppassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String com=txtsignupid.getText()+","+txtsignuppassword.getText();
				
				try {
					if(myfile.createNewFile()) {
						System.out.println("File created and file name is : "+myfile.getName());
					}
					else {
					
						System.out.println("The file already exist");
					}
				
				}catch(Exception e1) {
					System.out.println("An error occured");
				}
				

				if(myfile.exists()) {
					
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("LogInFile.txt",true));
						writer.newLine();
						writer.write(com);
						writer.close();
						System.out.println("Value successfully added to file");
						txtsignupid.setText("");
						txtsignuppassword.setText("");
						JOptionPane.showMessageDialog(null, "User Id Successfully Created");
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(271, 178, 107, 26);
		frame_signUp.getContentPane().add(btnNewButton);
	}
}
