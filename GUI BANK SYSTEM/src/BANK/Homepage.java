package BANK;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class Homepage {

	private JFrame frame;
	private  JButton cashinButt, sendmoneyButt,transactHistoryButt,accsettingsButt;
    private String Firstname;
	private String Lastname;
    private JLabel clientnameLabel , showbalanceLabel, exitLabel;
    private String account;
 
   
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
				
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setUndecorated(true);
		getFrame().setBounds(100, 100, 800, 517);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
	
		
		JLabel welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 17));
		welcomeLabel.setBounds(51, 110, 136, 14);
		getFrame().getContentPane().add(welcomeLabel);
		
	    clientnameLabel = new JLabel();
	    clientnameLabel.setLabelFor(frame);
		clientnameLabel.setForeground(Color.WHITE);
		clientnameLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		clientnameLabel.setBounds(133, 103, 178, 29);
		getFrame().getContentPane().add(clientnameLabel);
	


		
	    accsettingsButt = new JButton("Account Settings");
	    accsettingsButt.setFocusPainted(false);
	    accsettingsButt.setIconTextGap(6);
	    accsettingsButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-settings-28.png"));
		accsettingsButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				accsettingsButt.setContentAreaFilled(true);
				accsettingsButt.setBackground(Color.white);
				accsettingsButt.setForeground(Color.black);
				accsettingsButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\settingsblack.png"));
				accsettingsButt.setText("");
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				accsettingsButt.setContentAreaFilled(false);
				accsettingsButt.setForeground(Color.white);
				accsettingsButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-settings-28.png"));
				accsettingsButt.setText("Account Settings");
			}
		});
		accsettingsButt.setForeground(Color.WHITE);
		accsettingsButt.setContentAreaFilled(false);
		accsettingsButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		accsettingsButt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		accsettingsButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accsettingsButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AccountSettings as = new AccountSettings();
			    as.setFrame(getFrame());
				as.setAccountnum(account);
				as.setLocationRelativeTo(null);
				as.setFrame(getFrame());
				as.setVisible(true);
				as.setAccountnum(getAccount());
				
				
				
				
			}
		});
		accsettingsButt.setBounds(326, 371, 216, 71);
		getFrame().getContentPane().add(accsettingsButt);
		
	    sendmoneyButt = new JButton("Send Money");
	    sendmoneyButt.setOpaque(false);
	    sendmoneyButt.setFocusPainted(false);
	    sendmoneyButt.setBackground(Color.WHITE);
	    sendmoneyButt.setIconTextGap(7);
	    sendmoneyButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-money-transfer-25.png"));
		sendmoneyButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sendmoneyButt.setContentAreaFilled(true);
				sendmoneyButt.setBackground(Color.WHITE);
				sendmoneyButt.setForeground(Color.BLACK);
			    sendmoneyButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\sendmoneyblack.png"));
			    sendmoneyButt.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sendmoneyButt.setContentAreaFilled(false);
			    sendmoneyButt.setForeground(Color.white);
			    sendmoneyButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-money-transfer-25.png"));
			    sendmoneyButt.setText("Send Money");
			}
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				sendmoneyButt.setContentAreaFilled(true);
				sendmoneyButt.setBackground(Color.white);
				
				
				
				
			}
		});
		sendmoneyButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		sendmoneyButt.setForeground(Color.WHITE);
		sendmoneyButt.setContentAreaFilled(false);
		sendmoneyButt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		sendmoneyButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendmoneyButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				sendMoney send = new sendMoney();
				send.setVisible(true); 
				send.setFrame(getFrame());
				send.setLocationRelativeTo(null);
				send.setVisible(true); 
				send.setAccountnum(account);
				setAccountnum(send.getAccountnum());
		    
				
			}
		});
		sendmoneyButt.setBounds(326, 289, 216, 71);
		getFrame().getContentPane().add(sendmoneyButt);
		
	    transactHistoryButt = new JButton("Transaction History");
	    transactHistoryButt.setFocusPainted(false);
	    transactHistoryButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-scroll-25.png"));
		transactHistoryButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 transactHistoryButt.setContentAreaFilled(true);
				 transactHistoryButt.setForeground(Color.black);
				 transactHistoryButt.setBackground(Color.white);
				 transactHistoryButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\historyblack.png"));
				 transactHistoryButt.setText(null);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				transactHistoryButt.setContentAreaFilled(false);
				transactHistoryButt.setForeground(Color.white);
			    transactHistoryButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\icons8-scroll-25.png"));
			    transactHistoryButt.setText("Transaction History");
			}
		});
		transactHistoryButt.setContentAreaFilled(false);
		transactHistoryButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		transactHistoryButt.setForeground(Color.WHITE);
		transactHistoryButt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		transactHistoryButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		transactHistoryButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "THIS PAGE IS UNDER DEVELOPMENT PLS BARE WITH US \nIF YOU THINK SOMETHINGS WRONG CONTACT THE FACEBOOK PAGE ","NOTICE",JOptionPane.WARNING_MESSAGE);
			
		
			}
		});
		transactHistoryButt.setBounds(552, 371, 216, 71);
		getFrame().getContentPane().add(transactHistoryButt);
		
	    cashinButt = new JButton("Cash In");
	    cashinButt.setFocusPainted(false);
	    cashinButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\Cashin (2).png"));
		cashinButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
		     cashinButt.setContentAreaFilled(true);
		     cashinButt.setBackground(Color.white);
		     cashinButt.setForeground(Color.black);
		     cashinButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\cashinblack.png"));
		     cashinButt.setText("");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cashinButt.setContentAreaFilled(false);
				cashinButt.setForeground(Color.white);
			   cashinButt.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\Cashin (2).png"));
				cashinButt.setText("Cash In");
			}
		});
		cashinButt.setForeground(Color.WHITE);
		cashinButt.setContentAreaFilled(false);
		cashinButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		cashinButt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cashinButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cashinButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CASHIN cash = new CASHIN();
				cash.setFrame(getFrame());
				cash.setLocationRelativeTo(null);
				cash.setAccountnum(account);
				cash.setVisible(true);
				
				
				
				
			}
		});
		cashinButt.setBounds(552, 289, 216, 71);
		getFrame().getContentPane().add(cashinButt);
		
		JLabel balanceLabel = new JLabel(" AVAILABLE BALANCE :");
		balanceLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		balanceLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setForeground(Color.WHITE);
		balanceLabel.setBounds(312, 155, 222, 50);
		getFrame().getContentPane().add(balanceLabel);
		
	    showbalanceLabel = new JLabel("");
		showbalanceLabel.setForeground(Color.WHITE);
		showbalanceLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		showbalanceLabel.setBounds(574, 165, 194, 29);
		getFrame().getContentPane().add(showbalanceLabel);
		
		JLabel logoIcon = new JLabel("");
		logoIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		logoIcon.setVerticalAlignment(SwingConstants.TOP);
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setForeground(Color.WHITE);
		logoIcon.setFont(new Font("SansSerif", Font.PLAIN, 11));
		logoIcon.setBounds(10, 11, 53, 50);
		getFrame().getContentPane().add(logoIcon);
		ImageIcon img3  = new ImageIcon(getClass().getResource("logo.png"));
		Image image3 = (img3).getImage().getScaledInstance(	logoIcon.getWidth(), 	logoIcon.getHeight(), Image.SCALE_SMOOTH);
		img3 = new ImageIcon(image3);
		logoIcon.setIcon(img3);
		
		JLabel tittleLabel = new JLabel("GOLDEN BANK");
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tittleLabel.setBounds(73, 24, 166, 29);
		getFrame().getContentPane().add(tittleLabel);
		
		JLabel phplabel = new JLabel("PHP");
		phplabel.setForeground(Color.WHITE);
		phplabel.setFont(new Font("SansSerif", Font.PLAIN, 9));
		phplabel.setBounds(547, 165, 46, 14);
		getFrame().getContentPane().add(phplabel);
		
		JLabel chooseLabel = new JLabel("Choose your operation");
		chooseLabel.setForeground(Color.WHITE);
		chooseLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		chooseLabel.setBounds(326, 247, 275, 31);
		frame.getContentPane().add(chooseLabel);
		
		JLabel userIcon = new JLabel("");
		userIcon.setBounds(10, 93, 31, 31);
		frame.getContentPane().add(userIcon);
		ImageIcon img4  = new ImageIcon(getClass().getResource("userHome.png"));
		Image image4 = (img4).getImage().getScaledInstance(	userIcon.getWidth(), 	userIcon.getHeight(), Image.SCALE_SMOOTH);
		img4 = new ImageIcon(image4);
		userIcon.setIcon(img4);
		
		JLabel datetodayLabel = new JLabel("New label");
		datetodayLabel.setForeground(Color.WHITE);
		datetodayLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		datetodayLabel.setBounds(10, 492, 113, 14);
		frame.getContentPane().add(datetodayLabel);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
		datetodayLabel.setText(dtf.format(now));
		
		JLabel BG = new JLabel("");
		BG.setBounds(0, 0, 800, 517);
		frame.getContentPane().add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
	
		
	
	}
	public void setFirst(String Firstname) {
		this.clientnameLabel.setText(Firstname);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	public void setBal(Double bal) {
        String bala = String.valueOf(bal);
		this.showbalanceLabel.setText(bala);
	}
	
	public void setAccountnum(String accountnum) {
		this.account = accountnum; 
	}
	public String getAccount() {
		return account;
	}
	}
	
	
	
	

