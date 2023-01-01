package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Search extends JFrame {

	Connection connection = null; 
	private JPanel contentPane;
	private JTextField notxt;

	/**
	 * Launch the application.
	 */
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"Ad-Soyad", "TC", "Tel", "Sınıf", "No", "Adres", "Veli", "Veli Tel"};
	Object[] satirlar = new Object[8];
	private JTextField adsoytxt;
	private JTextField tctxt;
	private JTextField teltxt;
	private JTextField okulnotxt;
	private JTextField adrestxt;
	private JTextField velitxt;
	private JTextField veliteltxt;
	private JTextField snftxt;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setTitle("KAYIT ARA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Search.class.getResource("/proje/search64.png")));
		connection= DB_connector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelim.setColumnIdentifiers(kolonlar);
		modelim.setColumnIdentifiers(kolonlar);
		
		notxt = new JTextField();
		notxt.addKeyListener(new KeyAdapter() {
		});
		notxt.setBounds(104, 72, 126, 20);
		contentPane.add(notxt);
		notxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ARA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "SELECT * FROM kayitlar where no ="+notxt.getText(); //kayitlar tablosundaki no satırındaki notxt textfieldında yazan veriyi aratır
					PreparedStatement pst = connection.prepareStatement(sql);
					
					//pst.execute();
					 
					ResultSet rs = pst.executeQuery();
					rs.next();
					
					adsoytxt.setText(rs.getString("adsoy")); // aratılan numaraya sahip kaydın ad ve soyad bilgilerini adsoytxt inin içine yazar
					tctxt.setText(rs.getString("tc"));  // aratılan numaraya sahip kaydın tc bilgisini tctxt inin içine yazar
					teltxt.setText(rs.getString("telno")); // aratılan numaraya sahip kaydın telefon numarası bilgisini teltxt inin içine yazar
					snftxt.setText(rs.getString("sınıf")); // aratılan numaraya sahip kaydın sınıf bilgisini snftxt inin içine yazar
					okulnotxt.setText(rs.getString("no")); // aratılan numaraya sahip kaydın okul numarası bilgisini okulnotxt inin içine yazar
					adrestxt.setText(rs.getString("adres")); // aratılan numaraya sahip kaydın adres bilgisini adrestxt inin içine yazar
					velitxt.setText(rs.getString("veli")); // aratılan numaraya sahip kaydın veli bilgisini velitxt inin içine yazar
					veliteltxt.setText(rs.getString("velitel")); // aratılan numaraya sahip kaydın veli telefon numarası bilgisini veliteltxt inin içine yazar
					
					pst.close(); //statement'i kapatır
					 
	
					
				} catch (Exception e2) {
					// TODO: handle exception
					 System.out.println(e2);
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(189, 141, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("OKUL NO");
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(104, 56, 53, 20);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1_1 = new JButton("TEMİZLE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notxt.setText(null);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(189, 171, 100, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("GERİ DÖN");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonlendirmePage yonlendir = new YonlendirmePage();
				yonlendir.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(189, 198, 100, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblKaytArama = new JLabel("KAYIT ARAMA");
		lblKaytArama.setForeground(new Color(0, 0, 102));
		lblKaytArama.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblKaytArama.setBounds(240, 11, 157, 28);
		contentPane.add(lblKaytArama);
		
		adsoytxt = new JTextField();
		adsoytxt.setEditable(false);
		adsoytxt.setForeground(Color.BLACK);
		adsoytxt.setColumns(10);
		adsoytxt.setBackground(Color.WHITE);
		adsoytxt.setBounds(429, 55, 157, 20);
		contentPane.add(adsoytxt);
		
		tctxt = new JTextField();
		tctxt.setEditable(false);
		tctxt.setForeground(Color.BLACK);
		tctxt.setColumns(10);
		tctxt.setBackground(Color.WHITE);
		tctxt.setBounds(429, 83, 157, 20);
		contentPane.add(tctxt);
		
		teltxt = new JTextField();
		teltxt.setEditable(false);
		teltxt.setForeground(Color.BLACK);
		teltxt.setColumns(10);
		teltxt.setBackground(Color.WHITE);
		teltxt.setBounds(429, 110, 157, 20);
		contentPane.add(teltxt);
		
		okulnotxt = new JTextField();
		okulnotxt.setEditable(false);
		okulnotxt.setForeground(Color.BLACK);
		okulnotxt.setColumns(10);
		okulnotxt.setBackground(Color.WHITE);
		okulnotxt.setBounds(429, 170, 157, 20);
		contentPane.add(okulnotxt);
		
		adrestxt = new JTextField();
		adrestxt.setEditable(false);
		adrestxt.setForeground(Color.BLACK);
		adrestxt.setColumns(10);
		adrestxt.setBackground(Color.WHITE);
		adrestxt.setBounds(429, 201, 157, 20);
		contentPane.add(adrestxt);
		
		velitxt = new JTextField();
		velitxt.setEditable(false);
		velitxt.setForeground(Color.BLACK);
		velitxt.setColumns(10);
		velitxt.setBackground(Color.WHITE);
		velitxt.setBounds(429, 277, 157, 20);
		contentPane.add(velitxt);
		
		veliteltxt = new JTextField();
		veliteltxt.setEditable(false);
		veliteltxt.setForeground(Color.BLACK);
		veliteltxt.setColumns(10);
		veliteltxt.setBackground(Color.WHITE);
		veliteltxt.setBounds(429, 308, 157, 20);
		contentPane.add(veliteltxt);
		
		JLabel lblNewLabel_1 = new JLabel("AD-SOYAD");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(355, 56, 74, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(355, 84, 74, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TEL NO");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(355, 111, 74, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SINIF");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(355, 140, 74, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("NO");
		lblNewLabel_5_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_5_1.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(355, 171, 74, 20);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("ADRES");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(355, 202, 74, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("VELİ");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(355, 278, 74, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("VELİ TEL");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(355, 309, 74, 20);
		contentPane.add(lblNewLabel_8);
		
		snftxt = new JTextField();
		snftxt.setEditable(false);
		snftxt.setForeground(Color.BLACK);
		snftxt.setColumns(10);
		snftxt.setBackground(Color.WHITE);
		snftxt.setBounds(429, 141, 157, 20);
		contentPane.add(snftxt);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Search.class.getResource("/proje/Vector-Abstract-Background.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 361);
		contentPane.add(lblNewLabel);
	}
} 
