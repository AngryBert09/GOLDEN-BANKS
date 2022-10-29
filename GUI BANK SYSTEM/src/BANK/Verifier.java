package BANK;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import java.awt.Panel;

public class Verifier extends JFrame {

	private JPanel contentPane;
	private JTextField accountTextfield;
	private JTextField anskeyTextfield;
	private JLabel show;
    private String accountnum;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verifier frame = new Verifier();				
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
	public Verifier() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AccountLabel = new JLabel("Account # :");
		AccountLabel.setForeground(Color.WHITE);
		AccountLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		AccountLabel.setBounds(131, 81, 109, 14);
		contentPane.add(AccountLabel);
		
		accountTextfield = new JTextField();
		accountTextfield.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		accountTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.black));
				
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    accountTextfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					accountTextfield.setEditable(true);
					
				}else {
					
					accountTextfield.setEditable(false);
					
				}
			}
			}});
		accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64)));
		accountTextfield.setBounds(131, 98, 176, 20);
		contentPane.add(accountTextfield);
		accountTextfield.setColumns(10);
		accountTextfield.setDocument(new Limiter(9));
		
		JButton exitButt = new JButton("X");
		exitButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButt.setOpaque(false);
		exitButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButt.setFont(new Font("Tahoma", Font.BOLD, 20));
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButt.setFont(new Font("Tahoma", Font.BOLD, 17));
				
				
			}
		});
		exitButt.setFont(new Font("Tahoma", Font.BOLD, 17));
		exitButt.setForeground(Color.WHITE);
		exitButt.setHorizontalTextPosition(SwingConstants.CENTER);
		exitButt.setContentAreaFilled(false);
		exitButt.setBorderPainted(false);
		exitButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButt.setBounds(390, 0, 60, 40);
		contentPane.add(exitButt);
		
		
		JLabel bdayLabel = new JLabel("Birthday");
		bdayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		bdayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		bdayLabel.setForeground(Color.WHITE);
		bdayLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		bdayLabel.setBounds(130, 129, 67, 20);
		contentPane.add(bdayLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dateChooser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			}
		});
		dateChooser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dateChooser.setBounds(181, 129, 126, 20);
		contentPane.add(dateChooser);
		
		JLabel anskeyLabel = new JLabel("Answer Key : ");
		anskeyLabel.setForeground(Color.WHITE);
		anskeyLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		anskeyLabel.setBounds(131, 184, 78, 20);
		contentPane.add(anskeyLabel);
		
		anskeyTextfield = new JTextField();
		anskeyTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				anskeyTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(65, 65, 65)));
			
			}
		});
		anskeyTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64)));
		anskeyTextfield.setBounds(206, 187, 101, 20);
		contentPane.add(anskeyTextfield);
		anskeyTextfield.setColumns(10);
		
		JLabel logoIcon = new JLabel("GOLDEN BANK");
		logoIcon.setBounds(10, 11, 48, 40);
		contentPane.add(logoIcon);
		ImageIcon img3  = new ImageIcon(getClass().getResource("logo.png"));
		Image image3 = (img3).getImage().getScaledInstance(	logoIcon.getWidth(), 	logoIcon.getHeight(), Image.SCALE_SMOOTH);
		img3 = new ImageIcon(image3);
		logoIcon.setIcon(img3);
		
		JLabel lblNewLabel = new JLabel("GOLDEN BANK");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(68, 24, 129, 14);
		contentPane.add(lblNewLabel);
		
		JLabel confirmLabel = new JLabel("CONFIRM");
		confirmLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			//ESTABLISHING CONNECTION TO THE DATABSE
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
					
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    String date = sdf.format(dateChooser.getDate());
				    
				    accountnum = accountTextfield.getText();
				    String anskey = anskeyTextfield.getText();
				    
				    Statement state = con.createStatement();
				    String sql = "select * from userinfos where AccountNumber='"+accountnum+"' and  Birthday ='"+date+"' and AnswerKey = '"+anskey+"'";
					ResultSet rs = state.executeQuery(sql);
					
					// IN THIS PART THE PROGRAM WILL ASK THE 3 INFORMATION CAME FROM THE USER AND IT WILL VALIDATE 
				
					if(rs.next()) {
						ResetInfo reset = new ResetInfo();
						reset.setLocationRelativeTo(null);
						reset.setVisible(true);
						dispose();		
						reset.setAccs(accountnum);
									
						if(anskeyTextfield.getText().isEmpty() || dateChooser.toString().isEmpty()) {
							
							anskeyTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
							dateChooser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
							
						}	
						
					} else {
						anskeyTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
						dateChooser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
						
					}
					
						 
								
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				confirmLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confirmLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				
			}
		});
		confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		confirmLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		confirmLabel.setForeground(Color.RED);
		confirmLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmLabel.setBounds(171, 220, 89, 27);
		contentPane.add(confirmLabel);
		
	 show = new JLabel("");
	 show.setHorizontalTextPosition(SwingConstants.LEFT);
	 show.setHorizontalAlignment(SwingConstants.LEFT);
	 show.setFont(new Font("SansSerif", Font.PLAIN, 11));
	 show.setForeground(Color.WHITE);
		show.setBounds(230, 159, 176, 17);
		contentPane.add(show);
		
		JLabel SecretQLabel = new JLabel("Secret Question :");
		SecretQLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		SecretQLabel.setForeground(Color.WHITE);
		SecretQLabel.setBounds(131, 159, 98, 14);
		contentPane.add(SecretQLabel);
		
		JLabel verifyLabel = new JLabel("VERIFY");
		verifyLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				verifyLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {			 
				
				// ESTABLISH A CONNECTION TO THE SQL DATABASE
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
					 Statement statement = con1.createStatement();
				     accountnum = accountTextfield.getText();
					 String see = "select * from userinfos where AccountNumber='"+accountnum+"'";
					ResultSet res = statement.executeQuery(see);
		
					// IN THIS PART THE PROGRAM WILL CHECK IF THE ACCOUNTNUMBER THAT THE USER INPUT IS VALID
					if(res.next()) {
						
						String secretque = res.getString(9);
						accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
						show.setText(secretque);
					
						
					} else {
						
						accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();		
				}
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				verifyLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
			}
		});
		verifyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verifyLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		verifyLabel.setForeground(Color.GREEN);
		verifyLabel.setBounds(315, 103, 78, 14);
		contentPane.add(verifyLabel);
		
		JLabel BG = new JLabel("");
		BG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BG.setBounds(0, 0, 450, 300);
		contentPane.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
	}
	
	
	}
	
		
	
	

	

	
		
	

	
	

