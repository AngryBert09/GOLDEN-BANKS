package BANK;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.desktop.*;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main extends JFrame {
	private static JTextField accountTextfield;
	private static JPasswordField pinPassField;
	private static JButton signInButt;
	private static JLabel exitIcon;
	private static JLabel retrieveLabel;
    private static 	JLabel accountLabel;
    private static JLabel pinLabel;
    private static JButton signupButt;
    private static JLabel fbIcon;
    private static JLabel twitterIcon;
    private String Firstname;
    private String Lastname;
    private String accountnum;
    private String pin;
    private String show;
    private final JLabel logoIcon, BG,orLabel,userIcon;
    private Double bal;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected Object frame;

	/**
	 * Create the frame.
	 */
	public Main() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
	    accountLabel = new JLabel("ACCOUNT #:");
		accountLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(130, 61, 88, 32);
		getContentPane().add(accountLabel);
		
	    pinLabel = new JLabel("PIN #:");
		pinLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		pinLabel.setForeground(Color.WHITE);
		pinLabel.setBounds(130, 104, 54, 32);
		getContentPane().add(pinLabel);
		
		accountTextfield = new JTextField();
		accountTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				accountTextfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
				
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
		accountTextfield.setCaretColor(Color.WHITE);
		accountTextfield.setForeground(Color.WHITE);
		accountTextfield.setOpaque(false);
		accountTextfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		accountTextfield.setBounds(130, 86, 133, 20);
		getContentPane().add(accountTextfield);
		accountTextfield.setColumns(10);
		accountTextfield.setDocument(new Limiter(9));
	
		
		signInButt = new JButton("Sign In");
		signInButt.setFocusPainted(false);
		signInButt.setOpaque(false);
		signInButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signInButt.setContentAreaFilled(false);
		signInButt.setBackground(Color.WHITE);
		signInButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signInButt.setContentAreaFilled(rootPaneCheckingEnabled);
				signInButt.setBackground(Color.white);            
			  
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signInButt.setContentAreaFilled(false);
				signInButt.setForeground(Color.WHITE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				signInButt.setContentAreaFilled(rootPaneCheckingEnabled);
				signInButt.setForeground(Color.BLACK);
			}
			
		});
		
		signInButt.setFont(new Font("Arial Nova", Font.PLAIN, 13));
		signInButt.setBorder(new LineBorder(Color.WHITE));
		signInButt.setForeground(Color.WHITE);
		signInButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		
				
				try {
					 // WE ESTABLISH A CONNECTION HERE TO THE DATABASE
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
						
				       accountnum = accountTextfield.getText();
					   pin = pinPassField.getText();
					
						Statement state = con.createStatement();
						String sql = "select * from userinfos where AccountNumber='"+accountnum+"' and  Pin ='"+pin+"'";
					     ResultSet rs = state.executeQuery(sql);
				
						
				    // IN THIS PART THE PROGRAM WILL CHECK IF BOTH TEXTFIELDS ARE EMPTY
					     
					     if(accountTextfield.getText().isEmpty()) {
					    	 
					 		accountTextfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
					 		     if(pinPassField.getText().isEmpty()){
					 		    	 
					 			pinPassField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));	 
					 		     }
					 		    	 
					 		    					 		    	 
					     }else {
					    	 
					    // IF THE USER INPUTS ALL THE CORRECT DETAILS THE PROGRAM WILL GO TO THE HOMEPAGE
					    	 if(rs.next()) {
					    		 
					    		 // WE GET THE THE DETAILS OF FIRSTNAME AND THE BALANCE
					    		 String show = rs.getString(1);
					    		 Double bal = rs.getDouble(11);
					             	
					    		 // WE INITIALIZE THE HOMEPAGE FRAME HERE WE USE SETTERS TO SHOW THE INFOS OF THE USER TO THE HOMEPAGE
					    		 Homepage homepage = new Homepage();
					    		 homepage.getFrame().setLocationRelativeTo(null);
					    		 homepage.getFrame().setVisible(true);
					    		 dispose();
					    		 homepage.setFirst(show);
					    		 homepage.setBal(bal);
					    		 homepage.setAccountnum(accountnum);
					    		 setBal(bal);
					    		 setShow(show);
					    		
					    		
					    	
					    	 }
					    	 else {
					    		 
					    		 // IF THE USER PUT A WRONG DETAILS THE BORDERFIELDS WILL TURN INTO RED JUST TO INDICATE THAT THEY INPUT A WRONG INFORMATION
					    			accountTextfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
					    			pinPassField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));	 
					    			
					    	 }
					    	
					     }
	
						
				
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
	
			}
		});
		signInButt.setBounds(111, 199, 89, 23);
		getContentPane().add(signInButt);
		
		pinPassField = new JPasswordField();
		
		// IN THIS PART WE ADD A SECURITY MEASURES TO ENSURE THAT ONLY NUMBERS WILL INPUT AND PREVENT THE SQL INJECTION
		
		pinPassField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				pinPassField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
	
				
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    pinPassField.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					pinPassField.setEditable(true);
					
				}else {
					
					pinPassField.setEditable(false);
					
				}
			}
			}});
		pinPassField.setCaretColor(Color.WHITE);
		pinPassField.setForeground(Color.WHITE);
		pinPassField.setOpaque(false);
		pinPassField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		pinPassField.setBounds(130, 128, 88, 20);
		getContentPane().add(pinPassField);
		pinPassField.setDocument(new Limiter(6));
		
	    signupButt = new JButton("Sign up");
	    signupButt.setFocusPainted(false);
		signupButt.setOpaque(false);
		signupButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signupButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		    SignUp sign = new SignUp();
		    sign.frame.setLocationRelativeTo(null);
		    sign.frame.setVisible(true);   
		    dispose();
		
				
			}
		});
		signupButt.setBackground(Color.WHITE);
		signupButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signupButt.setContentAreaFilled(rootPaneCheckingEnabled);
				signupButt.setBackground(Color.white);
						
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButt.setContentAreaFilled(rootPaneCheckingEnabled);
				signupButt.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				signupButt.setContentAreaFilled(false);
				signupButt.setForeground(Color.WHITE);
			}
		});
		signupButt.setFont(new Font("Arial Nova", Font.PLAIN, 13));
		signupButt.setBorder(new LineBorder(Color.WHITE));
		signupButt.setContentAreaFilled(false);
		signupButt.setForeground(Color.WHITE);
		signupButt.setBounds(244, 199, 89, 23);
		getContentPane().add(signupButt);

	    orLabel = new JLabel("or");
		orLabel.setForeground(Color.WHITE);
		orLabel.setBounds(215, 204, 30, 14);
		getContentPane().add(orLabel);

        userIcon = new JLabel("");
		userIcon.setBounds(205, 11, 40, 39);
		getContentPane().add(userIcon);
		ImageIcon img2  = new ImageIcon(getClass().getResource("user.png"));
		Image image2 = (img2).getImage().getScaledInstance(	userIcon.getWidth(), 	userIcon.getHeight(), Image.SCALE_SMOOTH);
		img2 = new ImageIcon(image2);
		userIcon.setIcon(img2);
		
	    retrieveLabel = new JLabel("Retrieve");
		retrieveLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		retrieveLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				retrieveLabel.setForeground(Color.red);
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				retrieveLabel.setForeground(Color.white);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Verifier veri = new Verifier();
				veri.setLocationRelativeTo(null);
				veri.setVisible(true);
				dispose();
				
				
				
			}
		});
		retrieveLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		retrieveLabel.setForeground(Color.WHITE);
		retrieveLabel.setBounds(230, 156, 46, 14);
		getContentPane().add(retrieveLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Forgot details?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(159, 156, 76, 14);
		getContentPane().add(lblNewLabel_3);
		
		exitIcon =new JLabel("");
		exitIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			exitIcon.setBounds(420, 11, 30, 40);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitIcon.setBounds(415, 11, 30, 39);
			}
		});
		exitIcon.setForeground(Color.WHITE);
		exitIcon.setBounds(415, 11, 30, 39);
		getContentPane().add(exitIcon);
		ImageIcon img  = new ImageIcon(getClass().getResource("whitexit.png"));
		Image image = (img).getImage().getScaledInstance(	exitIcon.getWidth(), 	exitIcon.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		exitIcon.setIcon(img);
		
	    fbIcon = new JLabel("");
		fbIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// WE ESTABLISH A CONNECTION TO THE BROWSER. IF THE USER CLICK EITHER FBICON OR TWITTERICON IT WILL BE DIRECT TO THE CERTAIN URL
				
				Desktop desk =  Desktop.getDesktop();
				try {
				desk.browse(new URI("https://www.facebook.com/albrtsuperduper/"));
				}
				catch(IOException err ) {
					
					
				}
				catch(URISyntaxException err ) {
				
				}
				
		         dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				fbIcon.setBounds(10, 243, 30, 46);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				fbIcon.setBounds(10, 257, 30, 32);
			}
		});
		fbIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fbIcon.setBounds(10, 257, 30, 32);
		getContentPane().add(fbIcon);
		ImageIcon img5  = new ImageIcon(getClass().getResource("fb.png"));
		Image image5 = (img5).getImage().getScaledInstance(	fbIcon.getWidth(), fbIcon.getHeight(), Image.SCALE_SMOOTH);
		img5 = new ImageIcon(image5);
		fbIcon.setIcon(img5);
		
	    twitterIcon = new JLabel("");
		twitterIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desk =  Desktop.getDesktop();
				try {
				desk.browse(new URI("https://twitter.com/JohnAlbertYans1"));
				}
				catch(IOException err ) {
					
					
				}
				catch(URISyntaxException err ) {
				
				}
				
		         dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				twitterIcon.setBounds(42, 243, 30, 46);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			    twitterIcon.setBounds(42, 257, 30, 32);
			}
		});
		twitterIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		twitterIcon.setBounds(42, 257, 30, 32);
		getContentPane().add(twitterIcon);
		ImageIcon img6  = new ImageIcon(getClass().getResource("twitter.png"));
		Image image6 = (img6).getImage().getScaledInstance(	twitterIcon.getWidth(), 	twitterIcon.getHeight(), Image.SCALE_SMOOTH);
		img6 = new ImageIcon(image6);
		twitterIcon.setIcon(img6);
		
	    logoIcon = new JLabel("New label");
		logoIcon.setBounds(10, 11, 40, 39);
		getContentPane().add(logoIcon);
		ImageIcon img4  = new ImageIcon(getClass().getResource("logo.png"));
		Image image4 = (img4).getImage().getScaledInstance(	logoIcon.getWidth(), 	logoIcon.getHeight(), Image.SCALE_SMOOTH);
		img4 = new ImageIcon(image4);
		logoIcon.setIcon(img4);
		
	    BG = new JLabel("");
		BG.setBounds(0, 0, 450, 300);
		getContentPane().add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);

	}
	
public String getAccountnum() {
	return accountnum;
	
} public String getShow() {
	return show;

}public void setBal(Double bal) {
	this.bal = bal;
	
}public void setShow(String show){
   this.show = show;
   
}public Double getBal() {
	return bal;
}
		
		
	}

