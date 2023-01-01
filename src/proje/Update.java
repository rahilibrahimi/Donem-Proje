package proje;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public void refreshtable() {

		try {
			String sql = "SELECT * FROM kayitlar";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			//modelim.addRow(satirlar);
			try {
				while(rs.next())
				{
					satirlar[0] = rs.getString("adsoy");
					satirlar[1] = rs.getString("tc");
					satirlar[2] = rs.getString("telno");
					satirlar[3] = rs.getString("sınıf");
					satirlar[4] = rs.getString("no"); 
					satirlar[5] = rs.getString("adres");
					satirlar[6] = rs.getString("veli");
					satirlar[7] = rs.getString("velitel");
					modelim.addRow(satirlar);
				}
				//pst.execute();				
				//pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e2);
			}
			 
			table.setModel(modelim);
		 	
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	} 
	
	
	
	/**
	 * Launch the application.
	 */
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"Ad-Soyad", "TC", "Tel", "Sınıf", "No", "Adres", "Veli", "Veli Tel"};
	Object[] satirlar = new Object[8];
	public static void main(String[] args) {		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	Connection connection = null;
	private JTextField adsoytxt;
	private JTextField tctxt;
	private JTextField teltxt;
	private JTextField snftxt;
	private JTextField notxt;
	private JTextField adrestxt;
	private JTextField velitxt;
	private JTextField veliteltxt;
	public Update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update.class.getResource("/proje/update64.png")));
		setTitle("KAYIT GÜNCELLEME");
		connection= DB_connector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 850, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 81, 548, 281);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("GÜNCELLE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String sql = "UPDATE kayitlar set no='"+ notxt.getText() +"', adsoy='"+adsoytxt.getText()+"', tc='"+tctxt.getText()+"', telno='"+ teltxt.getText() +"', sınıf='"+ snftxt.getText()+"', adres='"+adrestxt.getText()+"', veli='"+ velitxt.getText() +"', velitel='"+ veliteltxt.getText()+"' where no='"+notxt.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(sql);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated"); 
					pst.close();
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				} 
				refreshtable();
			}
		});
		btnNewButton.setBounds(140, 373, 105, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblKaytGncelleme = new JLabel("KAYIT GÜNCELLEME");
		lblKaytGncelleme.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblKaytGncelleme.setBounds(271, 27, 238, 28);
		contentPane.add(lblKaytGncelleme);
		
		adsoytxt = new JTextField();
		adsoytxt.setForeground(Color.BLACK);
		adsoytxt.setColumns(10);
		adsoytxt.setBackground(new Color(211, 211, 211));
		adsoytxt.setBounds(109, 81, 152, 20);
		contentPane.add(adsoytxt);
		
		tctxt = new JTextField();
		tctxt.setForeground(Color.BLACK);
		tctxt.setColumns(10);
		tctxt.setBackground(new Color(211, 211, 211));
		tctxt.setBounds(109, 112, 152, 20);
		contentPane.add(tctxt);
		
		teltxt = new JTextField();
		teltxt.setForeground(Color.BLACK);
		teltxt.setColumns(10);
		teltxt.setBackground(new Color(211, 211, 211));
		teltxt.setBounds(109, 139, 152, 20);
		contentPane.add(teltxt);
		
		snftxt = new JTextField();
		snftxt.setColumns(10);
		snftxt.setBackground(new Color(211, 211, 211));
		snftxt.setBounds(109, 168, 152, 20);
		contentPane.add(snftxt);
		
		notxt = new JTextField();
		notxt.setColumns(10);
		notxt.setBackground(new Color(211, 211, 211));
		notxt.setBounds(109, 199, 152, 20);
		contentPane.add(notxt);
		
		adrestxt = new JTextField();
		adrestxt.setColumns(10);
		adrestxt.setBackground(new Color(211, 211, 211));
		adrestxt.setBounds(109, 230, 152, 20);
		contentPane.add(adrestxt); 
		
		velitxt = new JTextField();
		velitxt.setColumns(10);
		velitxt.setBackground(new Color(211, 211, 211));
		velitxt.setBounds(114, 293, 124, 20);
		contentPane.add(velitxt);
		
		veliteltxt = new JTextField();
		veliteltxt.setColumns(10);
		veliteltxt.setBackground(new Color(211, 211, 211));
		veliteltxt.setBounds(114, 324, 124, 20);
		contentPane.add(veliteltxt);
		
		JLabel lblNewLabel_1 = new JLabel("AD-SOYAD");
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(25, 82, 74, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC");
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(25, 115, 74, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TEL NO");
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(25, 142, 74, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SINIF");
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(25, 169, 74, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NO");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(25, 200, 74, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ADRES");
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(25, 231, 74, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("VELİ");
		lblNewLabel_7.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(25, 294, 74, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("VELİ TEL");
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(25, 325, 74, 20);
		contentPane.add(lblNewLabel_8);
		
		JButton btnGeriDn = new JButton("GERİ DÖN");
		btnGeriDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGeriDn.setBackground(new Color(211, 211, 211)); 
		btnGeriDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				YonlendirmePage yonlendir = new YonlendirmePage();
				yonlendir.setVisible(true);
				dispose();
			}
		});
		btnGeriDn.setBounds(36, 373, 94, 23); 
		contentPane.add(btnGeriDn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Update.class.getResource("/proje/loginpagebg.jpg")));
		lblNewLabel.setBounds(0, 0, 834, 460);
		contentPane.add(lblNewLabel);
		
		refreshtable();
	}
}
