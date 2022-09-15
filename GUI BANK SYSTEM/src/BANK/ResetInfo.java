package BANK;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import BANK.Verifier;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ResetInfo extends JFrame {

	private JPanel contentPane;
	private JPasswordField newpinField;
	private JPasswordField confirmpinField;
    private JLabel showupper, hideupper, showbelow,hidebelow;
    private JLabel userIcon;
    private JLabel BG2;
    private JButton CONFIRM;
    private JLabel BG;
    private String accs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetInfo frame = new ResetInfo();			
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
	public ResetInfo() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(300, 0, 353, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel newpinLabel = new JLabel("New Pin :");
		newpinLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		newpinLabel.setForeground(Color.WHITE);
		newpinLabel.setBounds(36, 133, 83, 20);
		panel.add(newpinLabel);
		
		JLabel confirmpinLabel = new JLabel("Confirm Pin : ");
		confirmpinLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		confirmpinLabel.setForeground(Color.WHITE);
		confirmpinLabel.setBounds(36, 199, 83, 14);
		panel.add(confirmpinLabel);
		
		JLabel exitLabel = new JLabel("X");
		exitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				
			}
		});
		exitLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exitLabel.setForeground(Color.WHITE);
		exitLabel.setBounds(299, 0, 54, 37);
		panel.add(exitLabel);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER 6 DIGIT");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(170, 120, 90, 14);
		panel.add(lblNewLabel_3);
		
		newpinField = new JPasswordField();
		newpinField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				newpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    newpinField.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
				    newpinField.setEditable(true);
					
				}else {
	
					newpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
					newpinField.setEditable(false);
					JOptionPane.showMessageDialog(null, "ENTER NUMBERS ONLY","WARNING", JOptionPane.WARNING_MESSAGE);
					
				}}
			}
		});
		newpinField.setEchoChar('*');
		newpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		newpinField.setBounds(139, 133, 141, 20);
		panel.add(newpinField);
		newpinField.setDocument(new Limiter(6));
		
		confirmpinField = new JPasswordField();
		confirmpinField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				confirmpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    confirmpinField.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					confirmpinField.setEditable(true);
					
				}else {
					
					confirmpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
					confirmpinField.setEditable(false);
					JOptionPane.showMessageDialog(null, "ENTER NUMBERS ONLY","WARNING", JOptionPane.WARNING_MESSAGE);
					
				}}
			}
		});
		confirmpinField.setEchoChar('*');
		confirmpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		confirmpinField.setBounds(139, 196, 141, 20);
		panel.add(confirmpinField);
		confirmpinField.setDocument(new Limiter(6));
		
	    showbelow = new JLabel("show");
		showbelow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showbelow.setVisible(false);
				hidebelow.setVisible(true);
				confirmpinField.setEchoChar((char)0);
				
			}
		});
		showbelow.setFont(new Font("Tahoma", Font.PLAIN, 10));
		showbelow.setForeground(Color.WHITE);
		showbelow.setBounds(290, 200, 46, 14);
		panel.add(showbelow);
		
	    showupper = new JLabel("show");
	    showupper.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		showupper.setVisible(false);
	    		hideupper.setVisible(true);
	            newpinField.setEchoChar((char)0);		
	    	}
	    });
		showupper.setFont(new Font("Tahoma", Font.PLAIN, 10));
		showupper.setForeground(Color.WHITE);
		showupper.setBounds(290, 137, 46, 14);
		panel.add(showupper);
		
	    hidebelow = new JLabel("hide");
		hidebelow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			hidebelow.setVisible(false);
			showbelow.setVisible(true);
			confirmpinField.setEchoChar(('*'));
			
			}
		});
		hidebelow.setForeground(Color.WHITE);
		hidebelow.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hidebelow.setBounds(290, 200, 46, 14);
		panel.add(hidebelow);
		hidebelow.setVisible(false);
		
	    hideupper = new JLabel("hide");
	    hideupper.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		hideupper.setVisible(false);
				showupper.setVisible(true);
				newpinField.setEchoChar(('*'));		
	    	}
	    });
		hideupper.setForeground(Color.WHITE);
		hideupper.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hideupper.setBounds(290, 137, 46, 14);
		panel.add(hideupper);
		hideupper.setVisible(false);
		
		userIcon = new JLabel("");
		userIcon.setBounds(159, 27, 54, 48);
		panel.add(userIcon);
		ImageIcon img2  = new ImageIcon(getClass().getResource("maleuser.png"));
		Image image2 = (img2).getImage().getScaledInstance(	userIcon.getWidth(), 	userIcon.getHeight(), Image.SCALE_SMOOTH);
		img2 = new ImageIcon(image2);
		userIcon.setIcon(img2);

		
		CONFIRM = new JButton("CONFIRM");
		CONFIRM.setFocusPainted(false);
		CONFIRM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CONFIRM.setFont(new Font("SansSerif", Font.PLAIN, 12));
		CONFIRM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CONFIRM.setFont(new Font("SansSerif", Font.PLAIN, 14));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CONFIRM.setFont(new Font("SansSerif", Font.PLAIN, 12));
				
				
			}
		});
		CONFIRM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ESTABLISHING CONNECTION TO THE SQL DATABASE
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfos","root","tuto123");
					 
			        String newpin = newpinField.getText();
			        String confirmpin = confirmpinField.getText();
				    
				    String sql = "UPDATE infosbs SET Pin=? where AccountNumber=?";
				    PreparedStatement ps = con.prepareStatement(sql);
				    
				    // THE PROGRAM WILL REVIEW IF THE NEWPIN AND CONFIRMPIN ARE SAME 
				    if(newpin.equals(confirmpin)) {
				    
				    ps.setString(1, confirmpin);
				    ps.setString(2, accs);
				   
				    ps.executeUpdate();
				    ps.close();
				    con.close();
				    
				    JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED");
				    dispose();
				    Main main = new Main();
				    main.setLocationRelativeTo(null);
				    main.setVisible(true);
				  
				    }	else {
				    	JOptionPane.showMessageDialog(null, "INPUT DOES NOT MATCH","WARNING!",JOptionPane.WARNING_MESSAGE);
						confirmpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
						newpinField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
				    	
				    	
				    }
				    				
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		CONFIRM.setForeground(Color.RED);
		CONFIRM.setContentAreaFilled(false);
		CONFIRM.setBorderPainted(false);
		CONFIRM.setBounds(139, 216, 141, 37);
		panel.add(CONFIRM);
		
		BG = new JLabel("");
		BG.setBounds(0, 0, 353, 418);
		panel.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
		
		BG2 = new JLabel("New label");
		BG2.setBounds(0, 0, 309, 418);
		contentPane.add(BG2);
		ImageIcon img  = new ImageIcon(getClass().getResource("bg1.jpg"));
		Image image = (img).getImage().getScaledInstance(	BG2.getWidth(), 	BG2.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		BG2.setIcon(img);
		
		
	}
	public void setAccs(String accs) {
		
		this.accs = accs;
	}
	
	
}
