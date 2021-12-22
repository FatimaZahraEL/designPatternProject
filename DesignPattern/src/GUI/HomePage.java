package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		JLabel background;
		setSize(1200,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img= new ImageIcon("D:\\ApplicationRMI\\images\\background.jpg");
		getContentPane().setLayout(null);
		
		JLabel TextBienvenue = new JLabel("<html> Bienvenue Chez Le <br>"
                + " Parking En Ligne. <br>" +"");
		TextBienvenue.setFont(new Font("Times New Roman", Font.BOLD, 99));
		TextBienvenue.setForeground(new Color(0, 102, 204));
		TextBienvenue.setBounds(214, 71, 864, 347);
		getContentPane().add(TextBienvenue);
	
		
		JButton Login = new JButton("Login\r\n");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    new LoginPage();
			    dispose();
			}
		});
		Login.setBackground(new Color(59, 89, 182));
		Login.setForeground(Color.WHITE);
		Login.setFocusPainted(false);
		Login.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Login.setBounds(292, 452, 242, 43);
		getContentPane().add(Login);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
				dispose();
			}
		});
		Register.setBackground(new Color(59, 89, 182));
		Register.setForeground(Color.WHITE);
		Register.setFocusPainted(false);
		Register.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Register.setBounds(681, 452, 242, 43);
		getContentPane().add(Register);
		
		
		background= new JLabel("",img,JLabel.CENTER);
		background.setBounds(0, 0, 1184, 661);
		getContentPane().add(background);
		setVisible(true);
	}
}
