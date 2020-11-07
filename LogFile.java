package mp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LogFile implements Myfiles{

	 public boolean cashlessRead(String id,double total2) {
		File myfile=new File(id);
	
		
		try {
			Scanner myreader=new Scanner(myfile);					
			String data = null;
			while(myreader.hasNext()) {
				 data=myreader.nextLine();						//fetching data from customer account
				System.out.println(data);
			}
			double balance=Double.parseDouble(data);			//account value
			double new_balance=balance-total2;
			if(balance!=0 && balance>total2) {
				JOptionPane.showMessageDialog(null, "Your balance is:"+balance);
			cashlessWrite(id,new_balance);					//used to insert new value after cashless trasection 
		
			}else {
				JOptionPane.showMessageDialog(null, "Insufficient Balance"+"\n  Balance:"+balance);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

	

	@Override
	public void cashlessWrite(String file,double r) {
		// TODO Auto-generated method stub
		
		File myfile=new File(file);
	
		try {
			BufferedWriter apen=new BufferedWriter(new FileWriter(file,true));
			apen.newLine();
			apen.write(""+r);						//using for adding value in file
			apen.close();
			JOptionPane.showMessageDialog(null, "Cashless transection successfull.\nCurrent balance:"+r);
		}catch(Exception e) {
			
		}
		
		
	}
}
	
