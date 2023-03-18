package frontpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dbconnections.Challandb;
import dbconnections.Getfine;
import models.ChallanDatamodel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Challan extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JTextField drivername;
	private JTextField vehiclenumber;
	private JTextField phonenumber;
	private JTextField searchfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Challan frame = new Challan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void home(ActionEvent arg0)
	{ Home obj =new Home();
	  obj.setVisible(true);
	  this.dispose();
	}
	public Challan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 883);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Getfine obj = new Getfine();
		Challandb cdb = new Challandb();
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 12, 789, 798);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Challan management");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(197, 44, 234, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("select the offense committed");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(87, 96, 257, 40);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Driver Name");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
        lblNewLabel_2.setBounds(410, 144, 118, 47);
        panel.add(lblNewLabel_2);
        
        drivername = new JTextField();
        drivername.setBounds(602, 148, 160, 40);
        panel.add(drivername);
        drivername.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Vehicle number");
        lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
        lblNewLabel_3.setBounds(410, 215, 141, 40);
        panel.add(lblNewLabel_3);
        
        vehiclenumber = new JTextField();
        vehiclenumber.setBounds(602, 226, 160, 39);
        panel.add(vehiclenumber);
        vehiclenumber.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Enter driver details");
        lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
        lblNewLabel_4.setBounds(400, 95, 274, 41);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_3_1 = new JLabel("Phone number");
        lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 15));
        lblNewLabel_3_1.setBounds(410, 282, 141, 40);
        panel.add(lblNewLabel_3_1);
        
        phonenumber = new JTextField();
        phonenumber.setColumns(10);
        phonenumber.setBounds(602, 293, 160, 39);
        panel.add(phonenumber);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(93, 206, 213, 59);
		panel.add(comboBox);
		ArrayList<String> strlist = new ArrayList<String>();
        strlist = obj.getrules();
        comboBox.addItem("Select the offense");
        
        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 464, 724, 322);
        panel.add(scrollPane);
        
        table = new JTable();
        Object[] column = {"Vehicle number","Offense","Driver name","Phone number","Fine","date"};
        model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(column);
        scrollPane.setViewportView(table);
         Object[] row = new Object[6];
        
        ArrayList<ChallanDatamodel> cdmlist = new ArrayList<ChallanDatamodel>();
        cdmlist = cdb.getoffensers();
        for (int i = 0; i < cdmlist.size(); i++) {
        	row[0] = cdmlist.get(i).getVehiclename();
    		row[1] = cdmlist.get(i).getOffense();
    		row[2] = cdmlist.get(i).getName();
    		row[3] = cdmlist.get(i).getPhonenumber();
    		row[4] = cdmlist.get(i).getFine();
    		row[5] = cdmlist.get(i).getDate();
    		model.addRow(row);
			
		}
       
        
        for(int i= 0;i<strlist.size();i++)
        {
            comboBox.addItem(strlist.get(i).toString());
        }
        
        JButton addbtn = new JButton("proceed");
        addbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ChallanDatamodel cdm = new ChallanDatamodel();
        		
        		String name=drivername.getText();
        		String vehiclename=vehiclenumber.getText();
        		String phone=phonenumber.getText();
        		String offense=comboBox.getSelectedItem().toString();
        		double fine = obj.fine(offense);
        		
        		cdm.setName(name);
        		cdm.setVehiclename(vehiclename);
        		cdm.setPhonenumber(phone);
        		cdm.setOffense(offense);
        		cdm.setFine(fine);
        		
        		cdb.setchallan(cdm);
        		
        		drivername.setText("");
        		vehiclenumber.setText("");
        		phonenumber.setText("");
        		comboBox.setSelectedIndex(0);
        		 ArrayList<ChallanDatamodel> cdmlist = new ArrayList<ChallanDatamodel>();
        	        cdmlist = cdb.getoffensers();
        	        	row[0] = cdmlist.get(cdmlist.size()-1).getVehiclename();
        	    		row[1] = cdmlist.get(cdmlist.size()-1).getOffense();
        	    		row[2] = cdmlist.get(cdmlist.size()-1).getName();
        	    		row[3] = cdmlist.get(cdmlist.size()-1).getPhonenumber();
        	    		row[4] = cdmlist.get(cdmlist.size()-1).getFine();
        	    		row[5] = cdmlist.get(cdmlist.size()-1).getDate();
        	    		model.addRow(row);
        				
        		
        	}
        });
        addbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        addbtn.setBounds(311, 396, 117, 25);
        panel.add(addbtn);
        
        searchfield = new JTextField();
        searchfield.setColumns(10);
        searchfield.setBounds(449, 21, 160, 40);
        panel.add(searchfield);
        
        JButton searchbtn = new JButton("search history");
        searchbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String vehicleno = searchfield.getText();
        		btnonclick(e,vehicleno);
        	}
        });
        searchbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
        searchbtn.setBounds(621, 28, 156, 25);
        panel.add(searchbtn);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		home(arg0);
        	}
        });
        btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
        btnNewButton.setBounds(41, 28, 117, 25);
        panel.add(btnNewButton);
	}

	private void btnonclick(ActionEvent e, String vehicleno) {
		// TODO Auto-generated method stub
		History history = new History(vehicleno);
		history.setVisible(true);
		this.dispose();
		
	}
}
