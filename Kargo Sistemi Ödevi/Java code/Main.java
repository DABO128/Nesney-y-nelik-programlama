  package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static JFrame frame = new JFrame("Bitlis Cargo Management System");

	public static int generateId() {
	    return (int) ((Math.random() * 900) + 100); // generate a number from 100 to 1000
	}

	public static void showMainFrame() {
		Box base = Box.createVerticalBox();
		Box row1 = Box.createHorizontalBox();
		Box row2 = Box.createHorizontalBox();
		Box row3 = Box.createHorizontalBox();
		Box row4 = Box.createHorizontalBox();
		
        JLabel label = new JLabel("Homepage");
        row1.add(label);
        
        JButton button1 = new JButton();  
        button1.setText("Add Customer");
        button1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
                // show customer form
        		frame.dispose();
        		Customer.showNewForm();
        	}
        });
        row2.add(button1);

        
        JButton button2 = new JButton(); 
        button2.setText("Add Transportation");
        button2.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
                // show transportation form
        		frame.dispose();
        		Transportation.showNewForm();
            }  
        });
        row3.add(button2);
        
        JButton button3 = new JButton();  
        button3.setText("Add Cargo");
        button3.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
                // show cargo form
        		frame.dispose();
        		Cargo.showNewForm();
            }  
        });
        row4.add(button3);

        base.add(row1);
        base.add(row2);
        base.add(row3);
        base.add(row4);
        frame.add(base);
        frame.setBounds(500, 200, 700, 500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		showMainFrame();
	}
}
