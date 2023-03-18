package frontpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dbconnections.Challandb;
import models.ChallanDatamodel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History("AP314569");
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
	public History(String vehiclename) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Challandb cdb = new Challandb();
		
		JLabel lblName = new JLabel(vehiclename);
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName.setBounds(314, 33, 189, 22);
		contentPane.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 236, 697, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Object[] column = {"date","Driver name","Offense","Fine"};
        DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(column);
        scrollPane.setViewportView(table);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		backtrack(arg0);
        	}
        });
        btnBack.setBounds(70, 33, 117, 44);
        contentPane.add(btnBack);
        final Object[] row = new Object[4];
        ArrayList<ChallanDatamodel> cdmlist = new ArrayList<ChallanDatamodel>();
        cdmlist = cdb.getoffensersHistory(vehiclename);
        for (int i = 0; i < cdmlist.size(); i++) {
        	row[0] = cdmlist.get(i).getDate();
    		row[1] = cdmlist.get(i).getName();
    		row[2] = cdmlist.get(i).getOffense();
    		row[3] = cdmlist.get(i).getFine();
    	
    		model.addRow(row);
			
		}
        
	}

	protected void backtrack(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Challan c =new Challan();
		c.setVisible(true);
		this.dispose();
	}
}
