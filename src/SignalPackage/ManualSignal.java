package SignalPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import frontpart.Home;
import frontpart.Signal;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.concurrent.TimeUnit;

public class ManualSignal extends JFrame {

    private JPanel contentPane;
    JButton Lane_1btn = new JButton("");
    JButton Lane_2btn = new JButton("");
    JButton Lane_3btn = new JButton("");
    JButton Lane_4btn = new JButton("");
    
    /**
     * Launch the application.
     */
    private void signal(ActionEvent arg0)
	{ Signal obj =new Signal();
	  obj.setVisible(true);
	  this.dispose();
	}
    
    public static void main(String[] args) {
       
        new ManualSignal();
    }
    public ManualSignal() {
    	 try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
         } catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 1066, 737);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 0));
        panel.setBounds(0, 0, 373, 235);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		signal(arg0);
        	}
        });
        btnBack.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
        btnBack.setBounds(23, 24, 93, 25);
        panel.add(btnBack);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 0));
        panel_1.setBounds(0, 480, 373, 235);
        contentPane.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0, 128, 0));
        panel_2.setBounds(692, 0, 373, 235);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("MANUAL SIGNALS");
        lblNewLabel.setForeground(new Color(240, 255, 240));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(43, 20, 318, 56);
        panel_2.add(lblNewLabel);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(0, 128, 0));
        panel_3.setBounds(692, 480, 373, 235);
        contentPane.add(panel_3);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(520, 42, 10, 89);
        contentPane.add(panel_4);


        Lane_1btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Lane_1btn.setBackground(Color.GREEN);
                Lane_2btn.setBackground(Color.RED);
                Lane_3btn.setBackground(Color.RED);
                Lane_4btn.setBackground(Color.RED);
            }
        });
        Lane_1btn.setBackground(Color.RED);
        Lane_1btn.setBounds(481, 174, 93, 89);
        contentPane.add(Lane_1btn);


        Lane_2btn.setBackground(Color.RED);
        Lane_2btn.setBounds(319, 316, 93, 89);
        Lane_2btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Lane_2btn.setBackground(Color.GREEN);
                Lane_1btn.setBackground(Color.RED);
                Lane_3btn.setBackground(Color.RED);
                Lane_4btn.setBackground(Color.RED);
            }
        });

        contentPane.add(Lane_2btn);


        Lane_3btn.setBackground(Color.RED);
        Lane_3btn.setBounds(481, 462, 93, 89);
        Lane_3btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Lane_3btn.setBackground(Color.GREEN);
                Lane_1btn.setBackground(Color.RED);
                Lane_2btn.setBackground(Color.RED);
                Lane_4btn.setBackground(Color.RED);
            }
        });
        contentPane.add(Lane_3btn);


        Lane_4btn.setBackground(Color.RED);
        Lane_4btn.setBounds(635, 316, 93, 89);
        Lane_4btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Lane_4btn.setBackground(Color.GREEN);
                Lane_1btn.setBackground(Color.RED);
                Lane_2btn.setBackground(Color.RED);
                Lane_3btn.setBackground(Color.RED);
            }
        });
        contentPane.add(Lane_4btn);


        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBounds(520, 616, 10, 89);
        contentPane.add(panel_4_1);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(10, 355, 93, 10);
        contentPane.add(panel_5);

        JPanel panel_5_1 = new JPanel();
        panel_5_1.setBounds(152, 355, 93, 10);
        contentPane.add(panel_5_1);

        JPanel panel_5_2 = new JPanel();
        panel_5_2.setBounds(802, 355, 93, 10);
        contentPane.add(panel_5_2);

        JPanel panel_5_3 = new JPanel();
        panel_5_3.setBounds(962, 355, 93, 10);
        contentPane.add(panel_5_3);
        
        JLabel lblNewLabel_1 = new JLabel("North Lane");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(466, 141, 125, 22);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("South Lane");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblNewLabel_1_1.setBounds(466, 560, 125, 22);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("West Lane");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblNewLabel_1_2.setBounds(152, 323, 125, 22);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("East Lane");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        lblNewLabel_1_3.setBounds(780, 323, 125, 22);
        contentPane.add(lblNewLabel_1_3);
        this.setVisible(true);
    }
}