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

public class Transportation {
	private int transportationId; 
	private String transportationType; // - Sea, Air, Land
	private int capacity; 
	
	public Transportation() {
		
	}
	
	public Transportation(String transportationType, int capacity) {
		this.transportationId = Main.generateId();
		this.transportationType = transportationType;
		this.capacity = capacity;
	}
	
	public Transportation(int transportationId) {
		this.transportationId = transportationId;
		
		File transportationFile = new File("C:\\Users\\oumar\\Desktop\\cargo_data\\transportations.txt");
		String transportationLine = null;
		try {
			BufferedReader transportationFileReader = new BufferedReader(new FileReader(transportationFile));
			transportationLine = transportationFileReader.readLine();
			
			// find transportation data from text file based on transportationId
			while((transportationLine = transportationFileReader.readLine()) != null) {
				String[] fields = transportationLine.split(" "); // example ["231", "Land", "30"]
				int id = Integer.parseInt(fields[0]);
				if(id == transportationId) {
					this.transportationType = fields[1];
					this.capacity = Integer.parseInt(fields[2]);
					break;
				}
			}
			transportationFileReader.close();
				
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public int getTransportationId() {
		return transportationId;
	}

	public void setTransportationId(int transportationId) {
		this.transportationId = transportationId;
	}
	
	public String getTransportationType() {
		return transportationType;
	}
	
	public void setTransportationType(String transportationType) {
		this.transportationType = transportationType;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	// calculate if the transport's capacity is less than total weight 
	public boolean transportationCanCarry(int weight) {
		int totalWeight = weight;
		File cargoesFile = new File("C:\\Users\\oumar\\Desktop\\cargo_data\\cargoes.txt");
		String cargoesLine = null;
		try {
			BufferedReader cargoesFileReader = new BufferedReader(new FileReader(cargoesFile));
			cargoesLine = cargoesFileReader.readLine();
			
			// calculate total weight for cargoes that have "this" transportationId 
			while(cargoesLine != null) {
				String[] fields = cargoesLine.split(" ");
				int transportationId = Integer.parseInt(fields[4]);
				if(transportationId == this.getTransportationId()) {
					int cargoWeight = Integer.parseInt(fields[1]);
					totalWeight = totalWeight + cargoWeight;
				}
				cargoesLine = cargoesFileReader.readLine();
			}
			cargoesFileReader.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return totalWeight <= this.getCapacity();
	}
	
	private static void saveTransportation() {
		String transportationTypeValue = (String)transportationTypeField.getSelectedItem();
		int capacityValue = Integer.parseInt(capacityField.getText());
		Transportation newTransportation = new Transportation(transportationTypeValue, capacityValue);
		
		// saving information of new transportation to a new text file.
		try {
  			FileWriter transportationsFile = new FileWriter("C:\\Users\\oumar\\Desktop\\cargo_data\\transportations.txt", true);
			PrintWriter printer = new PrintWriter(transportationsFile );
			transportationsFile.write(newTransportation.getTransportationId() + " ");
			transportationsFile.write(newTransportation.getTransportationType() + " ");
			transportationsFile.write(newTransportation.getCapacity() + " ");
			
			printer.println();
			transportationsFile.close();
			printer.close();
		}
		catch(Exception f){
			f.printStackTrace();
		}
		
		addTransportationFrame.dispose();
		Main.showMainFrame();
	}
	
	static JFrame addTransportationFrame;
	static JTextField capacityField;
	static JComboBox transportationTypeField;	

	public static void showNewForm() {
		// initializing the main frame for adding customers.
		addTransportationFrame = new JFrame("Add Transportation");

		// initializing the major box to be added in the main frame and its sub-boxes.
		Box base = Box.createVerticalBox();
		Box row1 = Box.createHorizontalBox();
		Box row2 = Box.createHorizontalBox();
		Box row3 = Box.createHorizontalBox();

		row1.add(Box.createHorizontalStrut(3));
		row1.add(new JLabel("Capacity:"));
		capacityField = new JTextField();
		row1.add(capacityField);
		
		row2.add(Box.createHorizontalStrut(3));
		row2.add(new JLabel("Transportation type:"));
		transportationTypeField = new JComboBox(new String[] { "Air", "Sea", "Land" });
		row2.add(transportationTypeField);
		

		JButton cancel = new JButton("CANCEL");
		row3.add(Box.createHorizontalStrut(5));
		row3.add(cancel);
		row3.add(Box.createHorizontalStrut(100));
		JButton addCustomer = new JButton("SAVE");
		row3.add(addCustomer);

		// adding what to do when the 'addCustomer' button is pressed.
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTransportation();
			}			
		});

		// adding what to do when the 'cancel' button is pressed.
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTransportationFrame.dispose();
				Main.showMainFrame();
			}
		});

		base.add(row1);
		base.add(row2);
		base.add(row3);
		
		addTransportationFrame.add(base);
		addTransportationFrame.setBackground(Color.pink);
		addTransportationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addTransportationFrame.setBounds(500, 200, 700, 500);
		addTransportationFrame.setVisible(true);
	}
}