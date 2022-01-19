package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cargo { 
	private int weight; 
    private int cargoID;
    private String itemName; 
    private String customerName; 
    private int transportId; // - bycicle, car, motorcyclu
    private String status;
    private int price;
    private String destinationAddress;
    
    public Cargo()
    {
   	 
    }
    
    public Cargo(int weight, String itemName, String customerName, int transportId, String destinationAddress)
    {
    	this.weight = weight;
    	this.cargoID = Main.generateId();
    	this.itemName = itemName;
    	this.customerName = customerName;
    	this.status = "waiting";  
    	this.transportId = transportId;
    	this.price = calculatePrice(transportId, weight, customerName);
    	this.destinationAddress = destinationAddress;
    }

	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getCargoID() {
		return cargoID;
	}
	
	public void setCargoID(int cargoID) {
		this.cargoID = cargoID;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String sender) {
		this.customerName = sender;
	}

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    private int calculatePrice(int transportId, int cargoWeight, String customerName) {
    	Transportation transportation = new Transportation(transportId);
    	int price = 0;
    	switch (transportation.getTransportationType()) {
		case "Sea":
			price = cargoWeight * 10;
			break;
		case "Land":
			price = cargoWeight * 15;
			break;
		case "Air":
			price = cargoWeight * 20;
			break;
		default:
			break;
		}
    	
    	Customer customer = new Customer(customerName);
    	switch (customer.getCustomerType()) {
		case "CIP":
			price = price + (int)((CIPCustomer.discountPercent/100) * price);
			break;
		case "VIP":
			price = price + (int)((VIPCustomer.discountPercent/100) * price);
			break;
		default:
			break;
		}
    	
    	return price;
    }
    
    public void cancelCargo() {
    	
    }
    
    public static String getCargoStatus(int cargoId) {
    	// return the status of the cargo based on cargoId
    	return "";
    }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	private static void saveCargo() {
		int weightValue = Integer.parseInt(weightField.getText());
		String itemNameValue = itemNameField.getText();
		String customerNameValue = customerNameField.getText();
		int transportationIdValue = Integer.parseInt(transportIdField.getText());
		String destinationAddressValue = destinationAddressField.getText();
		Cargo newCargo = new Cargo(weightValue, itemNameValue, customerNameValue, transportationIdValue, destinationAddressValue);
		
		Transportation transportation = new Transportation(transportationIdValue);
		Boolean totalWeightIsLessThanCapacity = transportation.transportationCanCarry(weightValue);
		if(!totalWeightIsLessThanCapacity) {
			JOptionPane.showMessageDialog(addCargoFrame, "Total weight is greater than capapcity.", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// saving information of new customer to a new text file.
		try{
  			FileWriter cargoesFile = new FileWriter("C:\\Users\\oumar\\Desktop\\cargo_data\\cargoes.txt", true);
			PrintWriter printer = new PrintWriter(cargoesFile);
			cargoesFile.write(newCargo.getCargoID() + " ");
			cargoesFile.write(newCargo.getWeight() + " ");
			cargoesFile.write(newCargo.getItemName() + " ");
			cargoesFile.write(newCargo.getCustomerName() + " ");
			cargoesFile.write(newCargo.getTransportId() + " ");
			cargoesFile.write(newCargo.getStatus() + " ");
			cargoesFile.write(String.valueOf(newCargo.getPrice()) + " ");
			cargoesFile.write(newCargo.getDestinationAddress());
			
			printer.println();
			cargoesFile.close();
			printer.close();
		}
		catch(Exception f){
			f.printStackTrace();
		}
		
		addCargoFrame.dispose();
		Main.showMainFrame();
	}

	static JFrame addCargoFrame;
	static JTextField weightField;
	static JTextField itemNameField;
	static JTextField customerNameField;
	static JTextField transportIdField;
	static JTextField destinationAddressField;

	public static void showNewForm() {
		// initializing the main frame for adding customers.
		addCargoFrame = new JFrame("Add Cargo");

		// initializing the major box to be added in the main frame and its sub-boxes.
		Box base = Box.createVerticalBox();
		Box row1 = Box.createHorizontalBox();
		Box row2 = Box.createHorizontalBox();
		Box row3 = Box.createHorizontalBox();
		Box row4 = Box.createHorizontalBox();
		Box row5 = Box.createHorizontalBox();
		Box row6 = Box.createHorizontalBox();

		// their alignments.
		row1.add(Box.createHorizontalStrut(3));
		row1.add(new JLabel("Weight:"));
		weightField = new JTextField();
		row1.add(weightField);

		row2.add(Box.createHorizontalStrut(3));
		row2.add(new JLabel("ItemName:"));
		itemNameField = new JTextField();
		row2.add(itemNameField);

		row3.add(Box.createHorizontalStrut(3));
		row3.add(new JLabel("Customer name:"));
		customerNameField = new JTextField();
		row3.add(customerNameField);

		row4.add(Box.createHorizontalStrut(3));
		row4.add(new JLabel("Transpotation Id:"));
		transportIdField = new JTextField();
		row4.add(transportIdField);

		row5.add(Box.createHorizontalStrut(3));
		row5.add(new JLabel("Destination Address:"));
		destinationAddressField = new JTextField();
		row5.add(destinationAddressField);

		JButton cancel = new JButton("CANCEL");
		row6.add(Box.createHorizontalStrut(5));
		row6.add(cancel);
		row6.add(Box.createHorizontalStrut(100));
		JButton addCargo = new JButton("SAVE");
		row6.add(addCargo);

		// adding what to do when the 'addCustomer' button is pressed.
		addCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCargo();
			}			
		});

		// adding what to do when the 'cancel' button is pressed.
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCargoFrame.dispose();
				Main.showMainFrame();
			}
		});

		base.add(row1);
		base.add(row2);
		base.add(row3);
		base.add(row4);
		base.add(row5);
		base.add(row6);
		addCargoFrame.add(base);
		addCargoFrame.setBackground(Color.pink);
		addCargoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addCargoFrame.setBounds(500, 200, 700, 500);
		addCargoFrame.setVisible(true);
	}
}