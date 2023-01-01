package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Select extends JFrame {

	Connection connection = null; 
	private JPanel contentPane;
	private JTable table;

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
					Select frame = new Select();
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
	public Select() {
		setTitle("TUM KAYITLAR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Select.class.getResource("/proje/Files-icon.png")));
		connection= DB_connector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 603, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);
		
		JButton btnrenciListesiniGster = new JButton("ÖĞRENCİ LİSTESİNİ\r\n GÖSTER");
		btnrenciListesiniGster.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnrenciListesiniGster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//scrollPane.removeAll();
				
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
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
					 
					table.setModel(modelim);
				 	 
				} catch (Exception e2) {
					
				}
				
				
			}
		});
		btnrenciListesiniGster.setBounds(418, 284, 195, 31);
		contentPane.add(btnrenciListesiniGster);
		
		JButton btnNewButton = new JButton("GERİ DÖN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonlendirmePage yonlendir = new YonlendirmePage();
				yonlendir.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(524, 326, 89, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Select.class.getResource("/proje/loginpagebg.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 361);
		contentPane.add(lblNewLabel);
	}
}
