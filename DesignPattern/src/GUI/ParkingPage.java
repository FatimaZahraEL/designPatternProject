package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ParkingPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	int xx,xy;
	private String[] column = {"Numero R\u00E9servation", "Numero de place", "Nom du client", "Date de reservation"};
	private JTextField ID;
	private JTextField Name;
	private JTextField Filiere;
	private JTextField telephone;
	private JTextField Adresse;
	private JTextField date_debut;
	private JTextField date_fin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingPage frame = new ParkingPage();
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
	public ParkingPage() {

		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		
		JPanel panel = new JPanel();
		panel.setBounds(361, 0, 352, 194);
		contentPane.add(panel);
		panel.setBackground(new Color(51, 102, 102));
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 126, 127);
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(146, 36, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(146, 58, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(146, 80, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(146, 105, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 145, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(10, 169, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(88, 169, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(276, 169, 46, 14);
		panel.add(lblNewLabel_7);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 359, 437);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		ID = new JTextField();
		ID.setBounds(10, 56, 176, 31);
		panel1.add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(10, 116, 176, 31);
		panel1.add(Name);
		Name.setColumns(10);
		
		Filiere = new JTextField();
		Filiere.setBounds(10, 180, 176, 31);
		panel1.add(Filiere);
		Filiere.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(10, 331, 192, 31);
		panel1.add(telephone);
		telephone.setColumns(10);
		
		Adresse = new JTextField();
		Adresse.setBounds(10, 258, 275, 31);
		panel1.add(Adresse);
		Adresse.setColumns(10);
		
		date_debut = new JTextField();
		date_debut.setBounds(10, 395, 141, 31);
		panel1.add(date_debut);
		date_debut.setColumns(10);
		
		date_fin = new JTextField();
		date_fin.setBounds(188, 395, 148, 31);
		panel1.add(date_fin);
		date_fin.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBackground(new Color(51, 102, 102));
		btnNewButton.setBounds(196, 56, 32, 31);
		panel1.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Ajouter Les coordonn\u00E9es");
		lblNewLabel_8.setBounds(94, 23, 129, 14);
		panel1.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(361, 192, 352, 245);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBackground(new Color(51, 102, 102));
		btnNewButton_1.setBounds(202, 126, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Imprimer");
		btnNewButton_2.setBackground(new Color(51, 102, 102));
		btnNewButton_2.setBounds(202, 172, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 30, 158, 171);
		panel_1.add(panel_2);
		
	
		setVisible(true);

	}
}

