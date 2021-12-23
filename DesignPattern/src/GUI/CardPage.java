package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import DBPart.DBMethode;
import Model.Membre;
import Model.Membre.MemberBuilder;
import net.connectcode.Code128Auto;

import javax.swing.JScrollPane;

public class CardPage extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	int xx,xy;
	private JTextField ID;
	private JTextField Name;
	private JTextField Filiere;
	private JTextField telephone;
	private JTextField Adresse;
	private JTextField date_debut;
	private JTextField date_fin;
	private JTextField age;
	String s;
	JLabel image;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardPage frame = new CardPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	 public ImageIcon ResizeImage(String imgPath){
	        ImageIcon MyImage = new ImageIcon(imgPath);
	        Image img = MyImage.getImage();
	        Image newImage = img.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImage);
	        return image;
	    }


	/**
	 * Create the frame.
	 */
	public CardPage() {

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(361, 0, 352, 194);
		contentPane.add(panel);
		panel.setBackground(new Color(51, 102, 102));
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 126, 127);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel im = new JLabel("New label");
		im.setBounds(0, 0, 126, 127);
		panel_3.add(im);
		
		JLabel nom = new JLabel("New label");
		nom.setBounds(146, 36, 46, 14);
		panel.add(nom);
		
		JLabel filiere = new JLabel("New label");
		filiere.setBounds(146, 58, 46, 14);
		panel.add(filiere);
		
		JLabel adr = new JLabel("New label");
		adr.setBounds(146, 80, 46, 14);
		panel.add(adr);
		
		JLabel mobile = new JLabel("New label");
		mobile.setBounds(146, 105, 46, 14);
		panel.add(mobile);
		
		JLabel matricule = new JLabel("New label");
		matricule.setBounds(10, 145, 46, 14);
		panel.add(matricule);
		
		JLabel db = new JLabel("New label");
		db.setBounds(10, 169, 46, 14);
		panel.add(db);
		
		JLabel df = new JLabel("New label");
		df.setBounds(88, 169, 46, 14);
		panel.add(df);
		
		JLabel barecode = new JLabel("");
		barecode.setBounds(236, 137, 116, 46);
		panel.add(barecode);
		
		JLabel ag = new JLabel("New label");
		ag.setBounds(146, 130, 46, 14);
		panel.add(ag);
		
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
		Filiere.setBounds(10, 215, 176, 31);
		panel1.add(Filiere);
		Filiere.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(10, 331, 192, 31);
		panel1.add(telephone);
		telephone.setColumns(10);
		
		Adresse = new JTextField();
		Adresse.setBounds(10, 276, 275, 31);
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
				Code128Auto code128 = new Code128Auto();
				String barreCode = code128.encode(ID.getText());
				barecode.setText(barreCode);
				barecode.setFont(new java.awt.Font("CCode128_S3_Trial", java.awt.Font.PLAIN, 24));
//				 try {
//					 EAN13Writer barcodeWriter = new EAN13Writer();
//					    BitMatrix bitMatrix = barcodeWriter.encode(ID.getText(), BarcodeFormat.EAN_13, 300, 150);
//
//					    MatrixToImageWriter.toBufferedImage(bitMatrix);
//
//				 }catch(Exception ex) {
//					 System.out.println(ex);
//				 }

			}
		});
		btnNewButton.setBackground(new Color(51, 102, 102));
		btnNewButton.setBounds(196, 56, 32, 31);
		panel1.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Ajouter Les coordonn\u00E9es");
		lblNewLabel_8.setBounds(94, 23, 129, 14);
		panel1.add(lblNewLabel_8);
		
		age = new JTextField();
		age.setBounds(10, 173, 141, 31);
		panel1.add(age);
		age.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(361, 192, 352, 245);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		        try {
		       	 InputStream is = new FileInputStream(new File(s));
			        Membre member = new Membre.MemberBuilder(ID.getText(), Name.getText(), Filiere.getText(), date_debut.getText(), date_fin.getText())
			        		.age(Integer.parseInt(age.getText())).phone(telephone.getText()).address(Adresse.getText()).fileImage(is).build();
			     
			        DBMethode memberDB = new DBMethode();
			  
			        // add
					memberDB.ajouter(member.getID(), member.getNomComplet(),
							member.getSpecialite(), member.getAge(), member.getPhone(), member.getAddresse(), 
							member.getDateDebut(), member.getDateFin(), member.getFileImage());
					ResultSet result = memberDB.getMembre(ID.getText());
					if(result.next())
					{
						nom.setText(result.getString("nomComplet"));
						filiere.setText(result.getString("specialite"));
						ag.setText(result.getString("age"));
						mobile.setText(result.getString("phone"));
						adr.setText(result.getString("addresse"));
						db.setText(result.getString("dateDebut"));
						df.setText(result.getString("dateFin"));
						im.setIcon(ResizeImage(result.getString("image")));

					//	``, `age`, `phone`, `addresse`, `dateDebut`, `dateFin`, `image`	
					}
					JOptionPane.showMessageDialog(null, "ok","success",JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(51, 102, 102));
		btnNewButton_1.setBounds(202, 126, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Imprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBackground(new Color(51, 102, 102));
		btnNewButton_2.setBounds(202, 172, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 30, 158, 171);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		image = new JLabel("New label");
		image.setBounds(0, 0, 158, 171);
		panel_2.add(image);
		
		JButton Browse = new JButton("Parcourir");
		Browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser fileChooser = new JFileChooser();
			         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
			         fileChooser.addChoosableFileFilter(filter);
			         int result = fileChooser.showSaveDialog(null);
			         if(result == JFileChooser.APPROVE_OPTION){
			             File selectedFile = fileChooser.getSelectedFile();
			             String path = selectedFile.getAbsolutePath();
			             image.setIcon(ResizeImage(path));
			             s = path;
			              }
			         else if(result == JFileChooser.CANCEL_OPTION){
			             System.out.println("No Data");
			         }
			}
		});
		Browse.setBackground(new Color(51, 102, 102));
		Browse.setBounds(202, 94, 89, 23);
		panel_1.add(Browse);
		
		setVisible(true);

	}
	
	
}

