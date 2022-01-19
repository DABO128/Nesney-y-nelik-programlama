package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Customer {
	private String customerType;
	private String name;
	private String surname;
	private String telefonNo;
	private String address;

	public Customer() {

	}

	public Customer(String customerType, String name, String surname, String telefonNo, String address) {
		this.customerType = customerType;
		this.name = name;
		this.surname = surname;
		this.telefonNo = telefonNo;
		this.address = address;
	}
	
	public Customer(String customerName) {
		this.name = customerName;
		
		File customersFile = new File("C:\\Users\\oumar\\Desktop\\cargo_data\\customers.txt");
		String customerLine = null;
		try {
			BufferedReader customerFileReader = new BufferedReader(new FileReader(customersFile));
			customerLine = customerFileReader.readLine();
			
			// find customer data from text file based on customerName
			while(customerLine != null) {
				String[] fields = customerLine.split(" "); // example ["CIP", "Hamza", "Sani", "5521873895", "Avcilar", "3423"]
				String name = fields[1];
				if(name.equals(customerName)) {
					this.customerType = fields[0];
					this.surname = fields[2]; 
					this.telefonNo = fields[3];
					this.address = fields[4];
					System.out.println(this.customerType);
					break;
				}
				customerLine = customerFileReader.readLine();
			}
			customerFileReader.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String Number) {
		this.telefonNo = Number;
	}

	public String getAddress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	private static void saveCustomer() {
		Customer newCustomer = new Customer();
		String customerType = (String) customerTypeField.getSelectedItem();
		switch (customerType) {
		case "Normal":
			newCustomer = new Customer("Normal", nameField.getText(), surnameField.getText(), telefonNoField.getText(),
					addressField.getText());
			break;
		case "CIP":
			newCustomer = new CIPCustomer("CIP", nameField.getText(), surnameField.getText(), telefonNoField.getText(),
				addressField.getText(), membershipNoField.getText());
			break;
		case "VIP":
			newCustomer = new VIPCustomer("VIP", nameField.getText(), surnameField.getText(), telefonNoField.getText(),
					addressField.getText(), membershipNoField.getText());
			break;
		default:
			break;
		}
		
		// saving information of new customer to a new text file.
		try{
  			FileWriter customersFile = new FileWriter("C:\\Users\\oumar\\Desktop\\cargo_data\\customers.txt", true);
			PrintWriter printer = new PrintWriter(customersFile);
			customersFile.write(customerType + " ");
			customersFile.write(newCustomer.getName() + " ");
			customersFile.write(newCustomer.getSurname() + " ");
			customersFile.write(newCustomer.getTelefonNo() + " ");
			customersFile.write(newCustomer.getAddress() + " ");
			if (customerType == "CIP") {
				customersFile.write(((CIPCustomer) newCustomer).getMembershipNo() + " ");				
			}
			else if(customerType == "VIP") {
				customersFile.write(((VIPCustomer) newCustomer).getMembershipNo() + " ");
			}
			printer.println();
			customersFile.close();
			printer.close();
		}
		catch(Exception f){
			f.printStackTrace();
		}
		
		addCustomerFrame.dispose();
		Main.showMainFrame();
	}

	static JFrame addCustomerFrame;
	static JTextField nameField;
	static JTextField surnameField;
	static JTextField telefonNoField;
	static JTextField addressField;
	static JComboBox customerTypeField;
	static JTextField membershipNoField;

	public static void showNewForm() {
		// initializing the main frame for adding customers.
		addCustomerFrame = new JFrame("Add Customer");

		// initializing the major box to be added in the main frame and its sub-boxes.
		Box base = Box.createVerticalBox();
		Box row1 = Box.createHorizontalBox();
		Box row2 = Box.createHorizontalBox();
		Box row3 = Box.createHorizontalBox();
		Box row4 = Box.createHorizontalBox();
		Box row5 = Box.createHorizontalBox();
		Box row6 = Box.createHorizontalBox();
		Box row7 = Box.createHorizontalBox();

		// initializing all the fields to input information of new employee and setting
		// their alignments.
		row1.add(Box.createHorizontalStrut(3));
		row1.add(new JLabel("First Name:"));
		nameField = new JTextField();
		row1.add(nameField);

		row2.add(Box.createHorizontalStrut(3));
		row2.add(new JLabel("Surname:"));
		surnameField = new JTextField();
		row2.add(surnameField);

		row3.add(Box.createHorizontalStrut(3));
		row3.add(new JLabel("Phone Number:"));
		telefonNoField = new JTextField();
		row3.add(telefonNoField);

		row4.add(Box.createHorizontalStrut(3));
		row4.add(new JLabel("Address:"));
		addressField = new JTextField();
		row4.add(addressField);

		row5.add(Box.createHorizontalStrut(3));
		row5.add(new JLabel("Customer Type:"));
		customerTypeField = new JComboBox(new String[] { "Normal", "CIP", "VIP" });
		row5.add(customerTypeField);
		
		row6.add(Box.createHorizontalStrut(3));
		row6.add(new JLabel("Membership Number:"));
		membershipNoField = new JTextField();
		row6.add(membershipNoField);

		JButton cancel = new JButton("CANCEL");
		row7.add(Box.createHorizontalStrut(5));
		row7.add(cancel);
		row7.add(Box.createHorizontalStrut(100));
		JButton addCustomer = new JButton("SAVE");
		row7.add(addCustomer);

		// adding what to do when the 'addCustomer' button is pressed.
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCustomer();
			}
		});

		// adding what to do when the 'cancel' button is pressed.
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerFrame.dispose();
				Main.showMainFrame();
			}
		});

		base.add(row1);
		base.add(row2);
		base.add(row3);
		base.add(row4);
		base.add(row5);
		base.add(row6);
		base.add(row7);
		addCustomerFrame.add(base);
		addCustomerFrame.setBackground(Color.pink);
		addCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addCustomerFrame.setBounds(500, 200, 700, 500);
		addCustomerFrame.setVisible(true);
	}
}
