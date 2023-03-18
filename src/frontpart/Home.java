package frontpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	private void signal(final java.awt.event.ActionEvent evt)
	{ Signal obj =new Signal();
	  obj.setVisible(true);
	  this.dispose();
	}
	private void challan(final java.awt.event.ActionEvent evt)
	{ Challan obj=new Challan();
	  obj.setVisible(true);
	  this.dispose();
	}
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 709);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 44, 666, 584);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label = new Label("WELCOME TO RTMS");
		label.setFont(new Font("DialogInput", Font.BOLD, 18));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLUE);
		label.setAlignment(Label.CENTER);
		label.setBounds(197, 34, 307, 52);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("CHOOSE THE OPERATION");
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 131, 217, 42);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Signal Management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				signal(evt);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.ITALIC, 15));
		btnNewButton.setBounds(85, 195, 279, 52);
		panel.add(btnNewButton);
		
		JButton btnChallanManagement = new JButton("Challan management");
		btnChallanManagement.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				challan(evt);
			}
		});
		btnChallanManagement.setFont(new Font("Dialog", Font.ITALIC, 15));
		btnChallanManagement.setBounds(85, 320, 279, 52);
		panel.add(btnChallanManagement);
	}
}
