package proje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField txtkulad;
	private JPasswordField ps;
	private JCheckBox cbsifregoster;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
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
	public Loginpage() {
		setForeground(new Color(0, 0, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ceyda\\Desktop\\userlogin.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtkulad = new JTextField();
		txtkulad.setBackground(new Color(255, 255, 255));  
		txtkulad.setBounds(217, 181, 163, 20);
		contentPane.add(txtkulad); 
		txtkulad.setColumns(10);
		
		ps = new JPasswordField();
		ps.setEchoChar('*');
		ps.setBackground(new Color(255, 255, 255));
		ps.setBounds(217, 245, 163, 20);
		contentPane.add(ps);
		
		JLabel lblNewLabel = new JLabel("KULLANICI ADI");
		lblNewLabel.setForeground(new Color(224, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(242, 156, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("ŞİFRE");
		lblPassword.setForeground(new Color(224, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(262, 220, 80, 14);
		contentPane.add(lblPassword);
		
		JButton girisbtn = new JButton("");
		girisbtn.setIcon(new ImageIcon(Loginpage.class.getResource("/proje/accept-icon.png")));
		girisbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		girisbtn.setBackground(new Color(0, 0, 128));
		girisbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(ps.getPassword());
				String ad = "admin";
				String password = "admin"; 
				
				
				if(ad.equals(txtkulad.getText())) 
				{
					if(password.equals(pass))
					{
						YonlendirmePage yonlendirme = new YonlendirmePage(); //yonlendirmePage adlı bir nesne oluşturdu
						yonlendirme.setVisible(true); //ve nesnenin görünürlüğünün açtık
						dispose(); //loginPage sayfasını kapatır
						
					}
						
					else
						{
							 String msj = "ŞİFRE HATALI";
							 JOptionPane.showMessageDialog(null, msj, "Sonuç" , JOptionPane.ERROR_MESSAGE);}	

					}
				
					else
				{
						String msj2 = "KULLANICI ADI YA DA ŞİFRE HATALI";
						JOptionPane.showMessageDialog(null, msj2, "Sonuç" , JOptionPane.ERROR_MESSAGE);
				}
		}
	});
		girisbtn.setBounds(396, 285, 40, 41);
		contentPane.add(girisbtn);
		
		cbsifregoster = new JCheckBox("şifreyi göster");
		cbsifregoster.setForeground(new Color(255, 255, 255));
		cbsifregoster.setBackground(new Color(0, 0, 51));
		cbsifregoster.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if(cbsifregoster.isSelected())
				{
					ps.setEchoChar((char)0);
				}
				
				else
				{
					ps.setEchoChar('*'); 
				}
			
			}
		});
		cbsifregoster.setBounds(386, 244, 100, 23);
		contentPane.add(cbsifregoster); 
		
		JButton btnk = new JButton(""); 
		btnk.setIcon(new ImageIcon(Loginpage.class.getResource("/proje/Close-icon.png")));
		btnk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			} 
		});
		btnk.setBackground(new Color(0, 0, 128));
		btnk.setBounds(446, 285, 40, 41);
		contentPane.add(btnk);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Loginpage.class.getResource("/proje/96pxl.png")));
		lblNewLabel_1.setBounds(238, 23, 120, 122);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Loginpage.class.getResource("/proje/background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 634, 405);
		contentPane.add(lblNewLabel_2);
	}
}
