package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Ekle extends JFrame {

	private JPanel contentPane;
	private JTextField adsoytxt;
	private JTextField tctxt;
	private JTextField teltxt;
	private JTextField notxt;
	private JTextField adrestxt;
	private JTextField velitxt;
	private JTextField veliteltxt;

	
	 
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ekle frame = new Ekle();
					frame.setVisible(true);
				} catch (Exception e) {
					 
				}
			}
		}); 
	}

	/**
	 * Create the frame.
	 */
	Connection connection = null; 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JButton btnNewButton_1;
	private JButton TEMİZLE;
	private JTextField snftxt;
	
	public Ekle() {
		setTitle("YENI KAYIT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ekle.class.getResource("/proje/Save-icon.png")));
		
		connection= DB_connector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 609, 400);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("inactiveCaption"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adsoytxt = new JTextField();
		adsoytxt.setForeground(new Color(0, 0, 0)); 
		adsoytxt.setBackground(new Color(255, 255, 255));
		adsoytxt.setBounds(151, 64, 157, 20);
		contentPane.add(adsoytxt);
		adsoytxt.setColumns(10);
		
		tctxt = new JTextField();
		tctxt.setBackground(new Color(255, 255, 255));
		tctxt.setForeground(new Color(0, 0, 0));
		tctxt.setBounds(151, 92, 157, 20);
		contentPane.add(tctxt);
		tctxt.setColumns(10);
		
		teltxt = new JTextField();
		teltxt.setForeground(new Color(0, 0, 0));
		teltxt.setBackground(new Color(255, 255, 255));
		teltxt.setBounds(151, 119, 157, 20);
		contentPane.add(teltxt);
		teltxt.setColumns(10);
		
		notxt = new JTextField();
		notxt.setForeground(new Color(0, 0, 0));
		notxt.setBackground(new Color(255, 255, 255));
		notxt.setBounds(151, 179, 157, 20);
		contentPane.add(notxt);
		notxt.setColumns(10);
		
		adrestxt = new JTextField();
		adrestxt.setForeground(new Color(0, 0, 0));
		adrestxt.setBackground(new Color(255, 255, 255));
		adrestxt.setBounds(151, 210, 157, 20);
		contentPane.add(adrestxt);
		adrestxt.setColumns(10);
		
		velitxt = new JTextField();
		velitxt.setForeground(new Color(0, 0, 0));
		velitxt.setBackground(new Color(255, 255, 255));
		velitxt.setBounds(151, 286, 157, 20);
		contentPane.add(velitxt);
		velitxt.setColumns(10);
		
		veliteltxt = new JTextField();
		veliteltxt.setForeground(new Color(0, 0, 0));
		veliteltxt.setBackground(new Color(255, 255, 255));
		veliteltxt.setBounds(151, 317, 157, 20);
		contentPane.add(veliteltxt);
		veliteltxt.setColumns(10);
		
		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 102));
		btnNewButton.setBackground(new Color(204, 255, 255));
		 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO kayitlar(adsoy,tc,telno,sınıf,no,adres,veli,velitel) VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(sql);
					pst.setString(1, adsoytxt.getText());
					pst.setString(2, tctxt.getText());
					pst.setString(3, teltxt.getText());
					pst.setString(4, snftxt.getText());
					pst.setString(5, notxt.getText());
					pst.setString(6, adrestxt.getText());
					pst.setString(7, velitxt.getText());
					pst.setString(8, veliteltxt.getText());
					 
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "data saved");					 
					pst.close();
					
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2); 
				}
				
			} 
		});
		btnNewButton.setBounds(473, 206, 94, 28);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("YENI KAYIT");
		lblNewLabel.setForeground(new Color(204, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblNewLabel.setBounds(253, 25, 157, 28);
		contentPane.add(lblNewLabel); 
		
		lblNewLabel_1 = new JLabel("AD-SOYAD");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(204, 255, 255));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(77, 65, 74, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("TC");
		lblNewLabel_2.setForeground(new Color(204, 255, 255));
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(77, 93, 74, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("TEL NO");
		lblNewLabel_3.setForeground(new Color(204, 255, 255));
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(77, 120, 74, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("SINIF");
		lblNewLabel_4.setForeground(new Color(204, 255, 255));
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(77, 149, 74, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("NO");
		lblNewLabel_5.setForeground(new Color(204, 255, 255));
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(77, 180, 74, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("ADRES");
		lblNewLabel_6.setForeground(new Color(204, 255, 255));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(77, 211, 74, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("VELİ");
		lblNewLabel_7.setForeground(new Color(204, 255, 255));
		lblNewLabel_7.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(77, 287, 74, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("VELİ TEL");
		lblNewLabel_8.setForeground(new Color(204, 255, 255));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(77, 318, 74, 20);
		contentPane.add(lblNewLabel_8);
		 
		btnNewButton_1 = new JButton("GERİ DÖN");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(new Color(0, 0, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonlendirmePage yonlendir = new YonlendirmePage();
				yonlendir.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setBounds(473, 282, 94, 28);
		contentPane.add(btnNewButton_1);
		
		TEMİZLE = new JButton("TEMİZLE");
		TEMİZLE.setFont(new Font("Tahoma", Font.BOLD, 13));
		TEMİZLE.setForeground(new Color(0, 0, 153));
		TEMİZLE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adsoytxt.setText(null); 
				tctxt.setText(null); 
				teltxt.setText(null); 
				snftxt.setText(null); 
				notxt.setText(null); 
				adrestxt.setText(null); 
				velitxt.setText(null); 
				veliteltxt.setText(null); 
			}
		});
		TEMİZLE.setBackground(new Color(204, 255, 255));
		TEMİZLE.setBounds(473, 243, 94, 28);
		contentPane.add(TEMİZLE);
		
		snftxt = new JTextField();
		snftxt.setForeground(new Color(0, 0, 0));
		snftxt.setColumns(10);
		snftxt.setBackground(new Color(255, 255, 255));
		snftxt.setBounds(151, 150, 157, 20);
		contentPane.add(snftxt);
		 
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBackground(new Color(204, 255, 255));
		lblNewLabel_9.setIcon(new ImageIcon(Ekle.class.getResource("/proje/istockphoto-1189542390-612x612.jpg")));
		lblNewLabel_9.setBounds(0, 0, 593, 361);
		contentPane.add(lblNewLabel_9);
	}
}
