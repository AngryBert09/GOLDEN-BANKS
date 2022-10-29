package BANK;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class SignUp {

	JFrame frame;
	private JTextField FnameField;
	private JTextField LnameField;
	private JTextField ageField;
	private JTextField anskeyField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private static 	JLabel c1, c2, c3, c4, c5, c6, c7, c8,c9;
	private JLabel checkLabel;
	private JDateChooser dateChooser;
    private JLabel accountRandomGenLabel;
    private String account;
    private int mouseX,mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();			
			        window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();			
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);				
			}
		});
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 929, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Kalinga", Font.PLAIN, 11));
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(152, 70, 627, 456);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	    JLabel FirstnameLabel = new JLabel("First Name :");
		FirstnameLabel.setForeground(Color.DARK_GRAY);
		FirstnameLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		FirstnameLabel.setBounds(10, 11, 86, 20);
		panel.add(FirstnameLabel);
		
		JLabel LastnameLabel = new JLabel("Last Name :");
		LastnameLabel.setForeground(Color.DARK_GRAY);
		LastnameLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		LastnameLabel.setBounds(10, 59, 94, 14);
		panel.add(LastnameLabel);
		
		JLabel AgeLabel = new JLabel("Age :");
		AgeLabel.setForeground(Color.DARK_GRAY);
		AgeLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		AgeLabel.setBounds(10, 93, 67, 20);
		panel.add(AgeLabel);
		
		JLabel GenderLabel = new JLabel("Gender : ");
		GenderLabel.setForeground(Color.DARK_GRAY);
		GenderLabel.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 13));
		GenderLabel.setBounds(10, 141, 67, 14);
		panel.add(GenderLabel);
		
		JLabel BdayLabel = new JLabel("Birthday : ");
		BdayLabel.setForeground(Color.DARK_GRAY);
		BdayLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		BdayLabel.setBounds(10, 186, 86, 14);
		panel.add(BdayLabel);
		
		JLabel EmailLabel = new JLabel("Email : ");
		EmailLabel.setForeground(Color.DARK_GRAY);
		EmailLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		EmailLabel.setBounds(10, 232, 46, 14);
		panel.add(EmailLabel);
		
		JLabel AccountNumLabel = new JLabel("Your Account #:");
		AccountNumLabel.setForeground(Color.DARK_GRAY);
		AccountNumLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		AccountNumLabel.setBounds(10, 277, 139, 14);
		panel.add(AccountNumLabel);
		
		JLabel PinLabel = new JLabel("Pin # :");
		PinLabel.setForeground(Color.DARK_GRAY);
		PinLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		PinLabel.setBounds(10, 322, 46, 14);
		panel.add(PinLabel);
		
		JLabel AnswerKeyLabel = new JLabel("Security Question :");
		AnswerKeyLabel.setForeground(Color.DARK_GRAY);
		AnswerKeyLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		AnswerKeyLabel.setBounds(10, 366, 118, 14);
		panel.add(AnswerKeyLabel);
		
		FnameField = new JTextField();
		FnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		        e.getKeyCode();
				FnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));			
			}
		});
		FnameField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		FnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FnameField.setBounds(10, 28, 211, 20);
		panel.add(FnameField);
		FnameField.setColumns(10);
		
		LnameField = new JTextField();
		LnameField.setBackground(Color.WHITE);
		LnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.getKeyCode();
				LnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));	
			}
		});
		LnameField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		LnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		LnameField.setBounds(10, 75, 211, 20);
		panel.add(LnameField);
		LnameField.setColumns(10);
		
		ageField = new JTextField();
		ageField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.getKeyCode();
				ageField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));	
			}
		});
		ageField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		ageField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		ageField.setBounds(10, 114, 46, 20);
		panel.add(ageField);
		ageField.setColumns(10);
		
		JRadioButton MaleButton = new JRadioButton("Male");
		MaleButton.setHorizontalAlignment(SwingConstants.CENTER);
		MaleButton.setContentAreaFilled(false);
		MaleButton.setBackground(Color.WHITE);
		MaleButton.setFont(new Font("SansSerif", Font.BOLD, 11));
		MaleButton.setBorder(new LineBorder(Color.BLACK));
		MaleButton.setBounds(10, 156, 52, 23);
		panel.add(MaleButton);
		
		JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setHorizontalAlignment(SwingConstants.CENTER);
		femaleButton.setBackground(Color.WHITE);
		femaleButton.setFont(new Font("SansSerif", Font.BOLD, 11));
		femaleButton.setBorder(new LineBorder(Color.BLACK));
		femaleButton.setBounds(62, 156, 67, 23);
		panel.add(femaleButton);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(MaleButton);
		gender.add(femaleButton);
		
	
		String[] questions = {"Who is your longtime crush?", "How many friends do you have?", "Favorite superhero?","Favorite sports? pick one","Favorite Local artist"};
		JComboBox questionaires = new JComboBox(questions);
		questionaires.setBackground(Color.LIGHT_GRAY);
		questionaires.setFont(new Font("SansSerif", Font.PLAIN, 10));
		questionaires.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		questionaires.setBounds(127, 363, 162, 22);
		panel.add(questionaires);
		
		JLabel AnswerLabel = new JLabel("Answer Key :");
		AnswerLabel.setForeground(Color.DARK_GRAY);
		AnswerLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		AnswerLabel.setBounds(10, 395, 86, 14);
		panel.add(AnswerLabel);
		
		anskeyField = new JTextField();
		anskeyField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.getKeyCode();
				anskeyField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));	
			}
		});
		anskeyField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		anskeyField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		anskeyField.setBounds(92, 393, 142, 20);
		panel.add(anskeyField);
		anskeyField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.getKeyCode();
				passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));	
				
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    passwordField.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					passwordField.setEditable(true);
					
				}else {
					
					passwordField.setEditable(false);
					
				}
			}
		}});
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(10, 335, 142, 20);
		panel.add(passwordField);
		passwordField.setDocument(new Limiter(6));
	  
		emailField = new JTextField();
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.getKeyCode();
				emailField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));	
			}
		});
		emailField.setFont(new Font("SansSerif", Font.PLAIN, 11));
		emailField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		emailField.setBounds(10, 246, 142, 20);
		panel.add(emailField);
		emailField.setColumns(10);
		
        dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 11));
		dateChooser.setBorder(new LineBorder(Color.DARK_GRAY));
		dateChooser.getCalendarButton().setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser.setForeground(Color.WHITE);
		dateChooser.setBackground(Color.BLACK);
		dateChooser.setBounds(10, 201, 142, 20);
		panel.add(dateChooser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(329, 0, 311, 456);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel panelBG = new JLabel("");
		panelBG.setBounds(0, 0, 301, 456);
		panel_1.add(panelBG);
		ImageIcon img  = new ImageIcon(getClass().getResource("drawing ideas.jpg"));
		Image image = (img).getImage().getScaledInstance(	panelBG.getWidth(), 	panelBG.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		panelBG.setIcon(img);
		
		JButton doneButt = new JButton("Register");
		doneButt.setFocusPainted(false);
		doneButt.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
					String query = "insert into userinfos values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					
					//CHECK IF TEXTFIELD ARE EMPTY 
			        if(FnameField.getText().isEmpty()) {
			        	
			        	
			        	FnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			        }else if( LnameField.getText().isEmpty()) {
			        	
			        	LnameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			        	
			        }else if( ageField.getText().isEmpty()) {
			        	

			        	ageField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			        	
			        	
			        } else if( MaleButton.getText().isEmpty() || femaleButton.getText().isEmpty()) {
			        	
			        	MaleButton.setBorderPainted(true);
			        	femaleButton.setBorderPainted(true);
			        	MaleButton.setBorder(new LineBorder(Color.RED));
			        	femaleButton.setBorder(new LineBorder(Color.RED));
			        
			        	doneButt.disable();
			        	
			        }else if( dateChooser.getDate().toString().isEmpty()) {
			        	
			        	dateChooser.getCalendarButton().setBorder(new LineBorder(new Color(255, 0, 0)));
			        	doneButt.disable();
			        	
			        }else if( emailField.getText().isEmpty()) {
			        	
			        	emailField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			        	
			        	
			        }else if( passwordField.getText().isEmpty()) {
			        	
			        	passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			        	
			        	
			        }else if( anskeyField.getText().isEmpty()) {
			        	
			        	anskeyField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
			        	doneButt.disable();
			        	
			      
			        }else {
			        	
			        	//IF THE USER FULLFILLED ALL THE REQUIREMENTS THE INSERTED INFO WILL GO TO THE DATABASE
			        	
			        	int balance = 0;
			        	
			        	ps.setString(1, FnameField.getText());
			        	ps.setString(2, LnameField.getText());
			        	ps.setString(3, ageField.getText());
			            if(MaleButton.isSelected()) {
			            	ps.setString(4, MaleButton.getText());
			            } else {
			            	ps.setString(4,femaleButton.getText());
			            }
			        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        	String bday = sdf.format(dateChooser.getDate());
			        	ps.setString(5, bday);
			            ps.setString(6, emailField.getText());
			            ps.setString(7, account);
			            ps.setString(8, passwordField.getText());
			            ps.setString(9, (String) questionaires.getSelectedItem());
			            ps.setString(10, anskeyField.getText());
			            ps.setLong(11, balance);
			           
			            ps.executeUpdate();
			            ps.close();
			            con.close();
			           
			            frame.dispose();
			            Main main = new Main();
			            main.setLocationRelativeTo(null);
			            main.setVisible(true);
			            
			          
			    	
			        	
			        }
						
					
					
				} catch (ClassNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
			
	
				
					
			}
		});
		doneButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				doneButt.setForeground(Color.blue);
				doneButt.setFont(new Font("Arial", Font.BOLD, 14));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				doneButt.setForeground(Color.black);
				doneButt.setFont(new Font("Arial", Font.BOLD, 10));
			}
		});
		doneButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		doneButt.setContentAreaFilled(false);
		doneButt.setFont(new Font("Arial", Font.BOLD, 12));
		doneButt.setBackground(Color.WHITE);
		doneButt.setBorderPainted(false);
		doneButt.setBounds(229, 411, 103, 34);
		panel.add(doneButt);
		
		JLabel label = new JLabel("New label");
		label.setBounds(231, 34, -203, 396);
		panel.add(label);
		
		JLabel noteLabel = new JLabel("NOTE : Do not share your asnwer key!!!");
		noteLabel.setForeground(Color.BLUE);
		noteLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		noteLabel.setBounds(10, 421, 198, 14);
		panel.add(noteLabel);
		
		
		// THIS PART THE COMPUTER WILL GENERATE A 9DIGIT DIFFERENT NUMBER IT WILL USE TO SIGN IN
		
		Random rand = new Random();
		int random  =  rand.nextInt(999999999);
	    account = String.valueOf(random);
		
		
		JLabel accountRandomGenLabel = new JLabel(account);
		accountRandomGenLabel.setBounds(10, 297, 103, 14);
		panel.add(accountRandomGenLabel);
		
		JLabel lblNewLabel = new JLabel("NOTE : Do not share your account number!!!");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(80, 297, 209, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter a 6DIGIT PIN CODE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(162, 338, 127, 14);
		panel.add(lblNewLabel_1);
		
		JButton exitButt = new JButton("X");
		exitButt.setFocusPainted(false);
		exitButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButt.setFont(new Font("Tahoma", Font.BOLD, 20));
			}
			@Override
			public void mouseExited(MouseEvent e) {
	
				exitButt.setFont(new Font("Tahoma", Font.BOLD, 13));
			}
		});
		exitButt.setOpaque(false);
		exitButt.setBorderPainted(false);
		exitButt.setBorder(null);
		exitButt.setContentAreaFilled(false);
		exitButt.setForeground(Color.WHITE);
		exitButt.setFont(new Font("Tahoma", Font.BOLD, 13));
		exitButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButt.setBounds(880, 0, 49, 38);
		frame.getContentPane().add(exitButt);
		
		JLabel userIcon = new JLabel("");
		userIcon.setBounds(456, 11, 46, 48);
		frame.getContentPane().add(userIcon);
		ImageIcon img2  = new ImageIcon(getClass().getResource("maleuser.png"));
		Image image2 = (img2).getImage().getScaledInstance(	userIcon.getWidth(), 	userIcon.getHeight(), Image.SCALE_SMOOTH);
		img2 = new ImageIcon(image2);
		userIcon.setIcon(img2);
		
		JLabel logoIcon = new JLabel("GOLDEN BANK");
		logoIcon.setFont(new Font("SansSerif", Font.PLAIN, 11));
		logoIcon.setForeground(Color.WHITE);
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setBounds(0, 0, 218, 99);
		frame.getContentPane().add(logoIcon);
		ImageIcon img3  = new ImageIcon(getClass().getResource("logo.png"));
		Image image3 = (img3).getImage().getScaledInstance(	logoIcon.getWidth(), 	logoIcon.getHeight(), Image.SCALE_SMOOTH);
		img2 = new ImageIcon(image3);
		logoIcon.setIcon(img3);
		
		JLabel BG = new JLabel("");
		BG.setBounds(0, 0, 929, 594);
		frame.getContentPane().add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
	
	}
	}


