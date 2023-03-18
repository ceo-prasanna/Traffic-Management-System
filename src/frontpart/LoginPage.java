package frontpart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	private void home(final java.awt.event.ActionEvent evt)
	{ Home obj = new Home();
	  obj.setVisible(true);
	  this.dispose();
	}
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 70, 656, 601);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN FOR RTMS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 64, 361, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("   USERNAME");
		lblNewLabel_1.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(99, 193, 145, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("    PASSWORD");
		lblNewLabel_2.setFont(new Font("Dialog", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(112, 272, 115, 45);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(353, 198, 206, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(355, 278, 204, 39);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed( java.awt.event.ActionEvent evt) {
				String us = textField.getText();
				String p = passwordField.getText();
			    if(us.trim().equals("abc") && p.trim().equals("123") ) {
				home(evt);	}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(275, 423, 126, 53);
		panel.add(btnNewButton);
	}
}
