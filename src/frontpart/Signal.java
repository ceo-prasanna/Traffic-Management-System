package frontpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SignalPackage.Density_Signal;
import SignalPackage.ManualSignal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signal frame = new Signal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void manual(final java.awt.event.ActionEvent evt)
	{ ManualSignal obj =new ManualSignal();
	  obj.setVisible(true);
	  this.dispose();
	}
	private void automatic(final java.awt.event.ActionEvent evt)
	{ Density_Signal obj=new Density_Signal();
	  obj.setVisible(true);
	  this.dispose();
	}
	private void getback(ActionEvent arg0)
	{ Home obj =new Home();
	  obj.setVisible(true);
	  this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public Signal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(101, 44, 608, 647);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SIGNAL MANAGEMENT");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(92, 98, 422, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CHOOSE ONE OF FOLLOWING OPERATIONS");
		lblNewLabel_1.setFont(new Font("Dialog", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(77, 186, 411, 43);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("MANUAL ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				manual(evt);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(92, 286, 232, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AUTOMATIC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				 automatic(evt);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(92, 394, 232, 43);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getback(arg0);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setBounds(23, 30, 117, 25);
		panel.add(btnNewButton_2);
	}
}
