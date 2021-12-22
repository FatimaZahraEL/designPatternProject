package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.Naming;
import java.sql.DriverManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JPasswordField passwordField;
	
	int xx,xy;

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
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public LoginPage() {
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
		panel.setBounds(0, 0, 346, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 346, 437);
		panel.add(label);
		
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
	            LoginPage.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon("D:\\ApplicationRMI\\images\\login2.jpg"));
		
		Button button = new Button("Connexion");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					/*try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/applicationrmi","root","");
					Statement st = (Statement) con.createStatement();
					String name = textName.getText();
					String pass = passwordField.getText();
					if(name.isEmpty()||pass.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Remplir tous les champs","error",JOptionPane.ERROR_MESSAGE);
					}else {
						
							jdbcInterface db=(jdbcInterface) Naming.lookup("rmi://localhost:2011/db");
							Boolean r = db.getLogin(name, pass);
							if(r==false) {
								JOptionPane.showMessageDialog(null,"User Doesn't exist","success",JOptionPane.ERROR_MESSAGE);
							}else if(r==true) {
								new ParkingPage();
								
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
		button.setBounds(395, 308, 283, 36);
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(button);
		
		textName = new JTextField();
		textName.setBounds(395, 136, 283, 36);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Nom d'utilisateur :");
		lblUsername.setBounds(395, 111, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(395, 204, 96, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 229, 283, 36);
		contentPane.add(passwordField);
		
		Button button_1 = new Button("Si vous n'avez pas de compte , S'inscrire");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
			}
		});
		button_1.setForeground(SystemColor.windowText);
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBounds(395, 362, 283, 36);
		contentPane.add(button_1);
		
		
		setVisible(true);

	}
}
