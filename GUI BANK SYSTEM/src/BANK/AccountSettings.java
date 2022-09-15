package BANK;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.mysql.cj.protocol.ResultsetRow;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccountSettings extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldpinPassfield;
	private JPasswordField newpinPassfield;
	private JPasswordField confirmpinPassfield;
	private JButton changepinButt , logoutButt;
	private JButton confirmButt;
	private JButton backButt;
	private JButton truebackButt;
	private JLabel BG;
	private String ownaccountnum;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSettings frame = new AccountSettings();
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
	public AccountSettings() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel oldpinLabel = new JLabel(" Old Pin :");
		oldpinLabel.setVisible(false);
		oldpinLabel.setForeground(Color.WHITE);
		oldpinLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		oldpinLabel.setBounds(10, 67, 108, 14);
		contentPane.add(oldpinLabel);
		
		JLabel newpinLabel = new JLabel("New Pin :");
		newpinLabel.setVisible(false);
		newpinLabel.setForeground(Color.WHITE);
		newpinLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		newpinLabel.setBounds(10, 118, 108, 14);
		contentPane.add(newpinLabel);
		
		JLabel confirmpinLabel = new JLabel("Confirm Pin :");
		confirmpinLabel.setVisible(false);
		confirmpinLabel.setForeground(Color.WHITE);
		confirmpinLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		confirmpinLabel.setBounds(10, 167, 108, 14);
		contentPane.add(confirmpinLabel);
		
		oldpinPassfield = new JPasswordField();
		oldpinPassfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				oldpinPassfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				
	            if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    oldpinPassfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					oldpinPassfield.setEditable(true);
					
				}else {
					
					oldpinPassfield.setEditable(false);
					
				}
			}
			}});
		oldpinPassfield.setForeground(Color.BLACK);
		oldpinPassfield.setBackground(Color.WHITE);
		oldpinPassfield.setVisible(false);
		oldpinPassfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		oldpinPassfield.setBounds(106, 65, 118, 20);
		oldpinPassfield.setDocument(new Limiter(6));
		contentPane.add(oldpinPassfield);
		
		newpinPassfield = new JPasswordField();
		newpinPassfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				newpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
				confirmpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
				
	               if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                   newpinPassfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					newpinPassfield.setEditable(true);
					
				}else {
					
					newpinPassfield.setEditable(false);
					
				}
			}
			}});
		newpinPassfield.setVisible(false);
		newpinPassfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		newpinPassfield.setBounds(106, 116, 118, 20);
		newpinPassfield.setDocument(new Limiter(6));
		contentPane.add(newpinPassfield);
		
		confirmpinPassfield = new JPasswordField();
		confirmpinPassfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				newpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
				confirmpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
				
				
				 
	            if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    confirmpinPassfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					confirmpinPassfield.setEditable(true);
					
				}else {
					
					confirmpinPassfield.setEditable(false);
					
				}
			}
			}});
		confirmpinPassfield.setVisible(false);
		confirmpinPassfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		confirmpinPassfield.setBounds(106, 165, 118, 20);
		confirmpinPassfield.setDocument(new Limiter(6));
		contentPane.add(confirmpinPassfield);
		
	    changepinButt = new JButton("CHANGE PIN");
	    changepinButt.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		changepinButt.setContentAreaFilled(true);
	    		changepinButt.setBackground(Color.white);
	    		changepinButt.setForeground(Color.black);
	    		
	    	} 
	    
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		changepinButt.setContentAreaFilled(false);
	    		changepinButt.setForeground(Color.white);
	    		
	    	}
	    });
	    changepinButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changepinButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// IF THE USER CLICK BUTTON THE FIELD AND LABELS WILL APPEAR.
				oldpinLabel.setVisible(true);
				newpinLabel.setVisible(true);
				confirmpinLabel.setVisible(true);
				oldpinPassfield.setVisible(true);
				newpinPassfield.setVisible(true);
				confirmpinPassfield.setVisible(true);
				confirmButt.setVisible(true);
				backButt.setVisible(true);
				
				
				//IF THE USER ALREADY CLICK THE BUTTON THE CHANGEPINBUTT AND LOGOUTBUTT WILL GONE.
				changepinButt.setVisible(false);
				logoutButt.setVisible(false);
				truebackButt.setVisible(false);
			
				
				
			}
		});
		changepinButt.setFocusPainted(false);
		changepinButt.setOpaque(false);
		changepinButt.setContentAreaFilled(false);
		changepinButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		changepinButt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		changepinButt.setForeground(Color.WHITE);
		changepinButt.setBounds(73, 114, 133, 23);
		contentPane.add(changepinButt);
		
		JLabel settingsIcon = new JLabel("");
		settingsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		settingsIcon.setIcon(new ImageIcon("E:\\Downloads\\icons8-settings-28.png"));
		settingsIcon.setBounds(116, 11, 46, 25);
		contentPane.add(settingsIcon);
		
	    logoutButt = new JButton("LOGOUT");
	    logoutButt.setFocusPainted(false);
	    logoutButt.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		logoutButt.setContentAreaFilled(true);
	    		logoutButt.setBackground(Color.white);
	    		logoutButt.setForeground(Color.black);
	    	    logoutButt.setIcon(new ImageIcon("E:\\Downloads\\blacklogout.png"));
	    		
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		logoutButt.setContentAreaFilled(false);
	    		logoutButt.setForeground(Color.white);
	    	    logoutButt.setIcon(new ImageIcon("E:\\Downloads\\icons8-logout-20.png"));
	    		
	    		
	    		
	    	}
	    });
	    logoutButt.setIcon(new ImageIcon("E:\\Downloads\\icons8-logout-20.png"));
	    logoutButt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	  int response = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO LOG OUT?","LOGOUT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if(response == JOptionPane.YES_OPTION) {
	        	
	        	Main main = new Main();
	  
	        	dispose();
	            getFrame().dispose();
	        	main.setLocationRelativeTo(null);
	        	main.setVisible(true);

	        } 
	        	
	        
	    	
	    	}});
	    logoutButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutButt.setForeground(Color.WHITE);
		logoutButt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		logoutButt.setContentAreaFilled(false);
		logoutButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		logoutButt.setBounds(73, 145, 133, 23);
		contentPane.add(logoutButt);
		
		JLabel lblNewLabel = new JLabel("https://www.facebook.com/albrtsuperduper/");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 277, 266, 14);
		contentPane.add(lblNewLabel);
		
		confirmButt = new JButton("CONFIRM");
		confirmButt.setFocusPainted(false);
		confirmButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Homepage hp = new Homepage();
			
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfos","root","tuto123");
					PreparedStatement ps = con.prepareStatement("update infosbs SET Pin=? where AccountNumber=?");
					Statement state = con.createStatement();
					
					  String oldpin = oldpinPassfield.getText();
					  String newpin = newpinPassfield.getText();
					  String confirmpin = confirmpinPassfield.getText();
				  
				
				     
					ResultSet rs = state.executeQuery("select * from infosbs where AccountNumber='"+ownaccountnum+"' and Pin='"+oldpin+"'");
				
				
				     
					  if(rs.next()) {
	
							if(newpin.equals(confirmpin) && !oldpin.equals(confirmpin) )  {
								
								ps.setString(1, confirmpin);
								ps.setString(2, ownaccountnum);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY","CHANGE PIN", JOptionPane.INFORMATION_MESSAGE);
							    dispose();
							    getFrame().dispose();
								Main main = new Main();
								main.setLocationRelativeTo(null);
								main.setVisible(true);
								
							}else {
								
								if(oldpin.equals(confirmpin)) {
								    confirmpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
								    oldpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
								    newpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
									JOptionPane.showMessageDialog(null, "PLEASE CREATE NEW PASSWORD","WARNING", JOptionPane.WARNING_MESSAGE);
									
								}else {
									
							        newpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
						            confirmpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
						    
						  
								}
					
								
							}
			
							
						}else {
							
							oldpinPassfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color (255,0,0)));
							
							
						}
	
					
					
					  } catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		confirmButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confirmButt.setContentAreaFilled(true);
				confirmButt.setBackground(Color.WHITE);
				confirmButt.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confirmButt.setContentAreaFilled(false);
				confirmButt.setForeground(Color.white);
				
			}
		});
		confirmButt.setVisible(false);
		confirmButt.setContentAreaFilled(false);
		confirmButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		confirmButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmButt.setForeground(Color.WHITE);
		confirmButt.setFont(new Font("SansSerif", Font.PLAIN, 13));
		confirmButt.setBounds(38, 192, 206, 23);
		contentPane.add(confirmButt);
		
		backButt = new JButton("BACK");
		backButt.setFocusPainted(false);
		backButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButt.setContentAreaFilled(true);
				backButt.setBackground(Color.white);
				backButt.setForeground(Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButt.setContentAreaFilled(false);
				backButt.setForeground(Color.white);
				
			}
		});
		backButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// IF THE USER CLICK BUTTON THE FIELD AND LABELS WILL DISAPPEAR.
				oldpinLabel.setVisible(false);
				newpinLabel.setVisible(false);
				confirmpinLabel.setVisible(false);
				oldpinPassfield.setVisible(false);
				newpinPassfield.setVisible(false);
				confirmpinPassfield.setVisible(false);
				confirmButt.setVisible(false);
				backButt.setVisible(false);
				oldpinPassfield.setText("");
				newpinPassfield.setText("");
				confirmpinPassfield.setText("");
				
		
				
				
				//IF THE USER ALREADY CLICK THE BUTTON THE CHANGEPINBUTT AND LOGOUTBUTT WILL APPEAR.
				changepinButt.setVisible(true);
				logoutButt.setVisible(true);
				truebackButt.setVisible(true);
				
				
				
			}
		});
		backButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButt.setVisible(false);
		backButt.setContentAreaFilled(false);
		backButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		backButt.setForeground(Color.WHITE);
		backButt.setFont(new Font("SansSerif", Font.PLAIN, 13));
		backButt.setBounds(38, 219, 206, 23);
		contentPane.add(backButt);
		
		truebackButt = new JButton("BACK");
		truebackButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		truebackButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				truebackButt.setContentAreaFilled(true);
				truebackButt.setForeground(Color.BLACK);
				truebackButt.setBackground(Color.white);
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				truebackButt.setContentAreaFilled(false);
				truebackButt.setForeground(Color.white);
				
				
			}
		});
		truebackButt.setFocusPainted(false);
		truebackButt.setForeground(Color.WHITE);
		truebackButt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		truebackButt.setContentAreaFilled(false);
		truebackButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		truebackButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		truebackButt.setBounds(73, 84, 133, 23);
		contentPane.add(truebackButt);
		
		BG = new JLabel("");
		BG.setBounds(0, 0, 286, 302);
		contentPane.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
	
	
	} public void setAccountnum(String accountnum) {
		this.ownaccountnum = accountnum;

	} public String getAccountnum() {
	    return ownaccountnum;
		
	}  public JFrame getFrame() {
		
		return frame;
		
		
	} public void setFrame(JFrame frame) {
		
		this.frame = frame;
		
		
	}
	
	
	
	
}
