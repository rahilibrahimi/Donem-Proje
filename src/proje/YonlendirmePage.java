package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class YonlendirmePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YonlendirmePage frame = new YonlendirmePage();
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
	public YonlendirmePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(YonlendirmePage.class.getResource("/proje/page-swap-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 518, 393);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YAPMAK ISTEDIGINIZ ISLEMI SECINIZ");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblNewLabel.setBounds(77, 43, 351, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ekle ekle = new Ekle();
				ekle.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/save64.png"))); 
		btnNewButton.setBounds(131, 103, 56, 51);
		contentPane.add(btnNewButton);
		
		JButton btnKiiSilme = new JButton("");
		btnKiiSilme.setBackground(new Color(0, 0, 0));
		btnKiiSilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				DeletePage sil = new DeletePage();
				sil.setVisible(true);
				dispose();
			}
		});
		btnKiiSilme.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/delete264.png")));
		btnKiiSilme.setBounds(301, 103, 56, 51);
		contentPane.add(btnKiiSilme);
		
		JButton btnKaytGncelleme = new JButton("");
		btnKaytGncelleme.setBackground(new Color(0, 0, 0));
		btnKaytGncelleme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Update update = new Update();
				update.setVisible(true);
				dispose();
			}
		});
		btnKaytGncelleme.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/update64.png")));
		btnKaytGncelleme.setBounds(131, 165, 56, 51);
		contentPane.add(btnKaytGncelleme);
		
		JButton btnKaytArama = new JButton("");
		btnKaytArama.setBackground(new Color(0, 0, 0));
		btnKaytArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search ara = new Search();
				ara.setVisible(true);
				dispose();
				
			}
		});
		btnKaytArama.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/Start-Menu-Search-icon (1).png")));
		btnKaytArama.setBounds(301, 165, 56, 51);
		contentPane.add(btnKaytArama);
		
		JButton btnTmKaytlar = new JButton("");
		btnTmKaytlar.setBackground(new Color(0, 0, 0));
		btnTmKaytlar.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/Files-icon.png")));
		btnTmKaytlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Select tumkayitlar = new Select();
				tumkayitlar.setVisible(true);
				dispose(); 
			}
		});
		btnTmKaytlar.setBounds(131, 227, 56, 51);
		contentPane.add(btnTmKaytlar);
		
		JButton btnkYap = new JButton("");
		btnkYap.setForeground(new Color(0, 0, 0));
		btnkYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnkYap.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/Close-2-icon.png")));
		btnkYap.setBackground(new Color(0, 0, 0));
		btnkYap.setBounds(301, 227, 56, 51);
		contentPane.add(btnkYap);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Wingdings 2", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(YonlendirmePage.class.getResource("/proje/3928563151cd0d9d3f8a5bd350d5dfb7.jpg")));
		lblNewLabel_1.setBounds(0, -2, 502, 356);
		contentPane.add(lblNewLabel_1);
	}
}
