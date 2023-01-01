package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class DeletePage extends JFrame {

	
	Connection connection = null; 
	private JPanel contentPane;
	private JTable table;
	private JTextField okulnotxt;

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
					DeletePage frame = new DeletePage();
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
	public DeletePage() {
		setTitle("KAYIT SIL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeletePage.class.getResource("/proje/delete264.png")));
		connection= DB_connector.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 420); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				okulnotxt.setText(modelim.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString());
				
			} 
		});
		scrollPane.setBounds(195, 78, 422, 259);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				okulnotxt.setText(modelim.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString());
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(true);
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);
		
		okulnotxt = new JTextField();
		okulnotxt.setEditable(false);
		okulnotxt.setBackground(new Color(255, 250, 250));
		okulnotxt.setBounds(73, 131, 112, 20);
		contentPane.add(okulnotxt);
		okulnotxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("OKUL NO");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 13)); 
		lblNewLabel_5.setBounds(10, 132, 53, 20); 
		contentPane.add(lblNewLabel_5);
		 
		JButton btnNewButton = new JButton("SİL");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(okulnotxt.getText() == null) {
					JOptionPane.showMessageDialog(null, "Lütfen bir değer giriniz.");
					
				}
				
				else
				{
					String sql = "DELETE FROM kayitlar where no='"+okulnotxt.getText()+"'";
					try {
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "data deleted");
						pst.close();
					} catch (SQLException e1) { 
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
			}
		});
		btnNewButton.setBounds(88, 234, 97, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ÖĞRENCİ LİSTESİ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		});
		btnNewButton_1.setBounds(335, 347, 149, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GERİ DÖN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YonlendirmePage yonlendir = new YonlendirmePage();
				yonlendir.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(88, 305, 97, 32);
		contentPane.add(btnNewButton_2);
		
		JLabel lblKaytSilme = new JLabel("KAYIT SILME");
		lblKaytSilme.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblKaytSilme.setBounds(225, 25, 157, 28);
		contentPane.add(lblKaytSilme);
		
		JButton btnNewButton_3 = new JButton("TEMİZLE");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okulnotxt.setText(null);
			}
		});
		btnNewButton_3.setBounds(88, 270, 97, 32);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeletePage.class.getResource("/proje/loginpagebg.jpg")));
		lblNewLabel.setBounds(0, 0, 634, 381);
		contentPane.add(lblNewLabel);
	}
}
