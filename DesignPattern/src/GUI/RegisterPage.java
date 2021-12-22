package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.Naming;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JPasswordField ConfirmpasswordField;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		
		Button button_1 = new Button("Si vous avez déja un compte ,Se Connecter");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage();
			}
		});
		button_1.setForeground(SystemColor.windowText);
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBounds(395, 391, 283, 36);
		contentPane.add(button_1);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            RegisterPage.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(0, 0, 346, 437);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon("D:\\ApplicationRMI\\images\\register1.jpg"));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("....We got you....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(111, 343, 141, 27);
		panel.add(lblWeGotYou);
		
		Button button = new Button("S'inscrire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/applicationrmi","root","");
					Statement st = (Statement) con.createStatement();
					String name = textName.getText();
					String email = textEmail.getText();
					String pass = passwordField.getText();
					String confirmpass =ConfirmpasswordField.getText();
					if(name.isEmpty()||email.isEmpty()||pass.isEmpty()||confirmpass.isEmpty()||!pass.equals(confirmpass)) {
						JOptionPane.showMessageDialog(null,"Remplir tous les champs","error",JOptionPane.ERROR_MESSAGE);
					}else {
						if(pass.equals(confirmpass)) {
							jdbcInterface db=(jdbcInterface) Naming.lookup("rmi://localhost:2011/db");
							String r = db.InsertUser(name, email, pass);
							new ParkingPage();
						}else{
							JOptionPane.showMessageDialog(null,"Verifier le mot de passe","error",JOptionPane.ERROR_MESSAGE);
						}
				
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex,"error",JOptionPane.ERROR_MESSAGE);
				}
				*/
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 102, 204));
		button.setBounds(395, 346, 283, 36);
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(button);
		
		textName = new JTextField();
		textName.setBounds(395, 83, 283, 36);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Nom d'utilisateur :");
		lblUsername.setBounds(395, 58, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(395, 132, 54, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(395, 157, 283, 36);
		contentPane.add(textEmail);
		
		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(395, 204, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("Confirmation du mot de passe :");
		lblRepeatPassword.setBounds(395, 275, 205, 14);
		contentPane.add(lblRepeatPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 229, 283, 36);
		contentPane.add(passwordField);
		
		ConfirmpasswordField = new JPasswordField();
		ConfirmpasswordField.setBounds(395, 293, 283, 36);
		contentPane.add(ConfirmpasswordField);
		
		
		setVisible(true);

	}
}
