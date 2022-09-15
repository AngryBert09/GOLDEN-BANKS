package BANK;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
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

import javax.swing.JTextField;

public class CASHIN extends JFrame {

	private JPanel contentPane;
	private JTextField amountTextfield;
	private JLabel partnersLabel, insertamountLabel, backLabel;
    private JButton insertButt, backButt;
    private String ownaccountnum;
    private JFrame homepage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CASHIN frame = new CASHIN();
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
	public CASHIN() {
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton partner1 = new JButton("GCash");
		partner1.setFocusPainted(false);
		partner1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				partner1.setContentAreaFilled(true);
				partner1.setBackground(Color.white);
				partner1.setIcon(new ImageIcon("E:\\Downloads\\icons8-gcash-45.png"));
				partner1.setText("");
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				partner1.setContentAreaFilled(false);
				partner1.setText("GCash");
				
				
			}
		});
		partner1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner1.setForeground(Color.WHITE);
		partner1.setContentAreaFilled(false);
		partner1.setIconTextGap(0);
		partner1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		partner1.setHorizontalTextPosition(SwingConstants.CENTER);
		partner1.setVerticalTextPosition(SwingConstants.BOTTOM);
		partner1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "FOLLOW THE STEPS: \nStep 1 : Go to Send Money\nStep 2 : Select 'BANK TRANSFER' search 'GOLDENBANK' \nStep 3 : Enter your AccName and Account#" ,"GCash", JOptionPane.INFORMATION_MESSAGE);
				
				
				
			}
		});
		partner1.setIcon(new ImageIcon("E:\\Downloads\\icons8-gcash-45.png"));
		partner1.setBackground(new Color(255, 250, 250));
		partner1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		partner1.setBounds(69, 98, 94, 66);
		contentPane.add(partner1);
		
		JButton partner2 = new JButton("7Eleven");
		partner2.setFocusPainted(false);
		partner2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "FOLLOW STEPS: \nStep 1 : Select Bills Payment\nStep 2 : Search for 'GOLDENBANK'\nStep 3 : Enter your Acc#", "7Eleven", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		partner2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				partner2.setContentAreaFilled(true);
				partner2.setBackground(Color.white);
				partner2.setIcon(new ImageIcon("E:\\Downloads\\icons8-7-eleven-is-your-go-to-convenience-store-for-food,-snacks,-hot-and-cold-beverages-34.png"));
				partner2.setText("");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				partner2.setContentAreaFilled(false);
				partner2.setText("7Eleven");
				
				
			}
		});
		partner2.setIconTextGap(6);
		partner2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner2.setForeground(Color.WHITE);
		partner2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		partner2.setHorizontalTextPosition(SwingConstants.CENTER);
		partner2.setVerticalTextPosition(SwingConstants.BOTTOM);
		partner2.setIcon(new ImageIcon("E:\\Downloads\\icons8-7-eleven-is-your-go-to-convenience-store-for-food,-snacks,-hot-and-cold-beverages-34.png"));
		partner2.setContentAreaFilled(false);
		partner2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		partner2.setBounds(173, 98, 94, 66);
		contentPane.add(partner2);
		
		JButton partner3 = new JButton("Paypal");
		partner3.setFocusPainted(false);
		partner3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "CURRENTLY UNAVAILABLE","Paypal",JOptionPane.ERROR_MESSAGE);
			}
		});
		partner3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				partner3.setContentAreaFilled(true);
				partner3.setText("");
				partner3.setBackground(Color.white);
				partner3.setIcon(new ImageIcon("E:\\Downloads\\icons8-paypal-42.png"));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				partner3.setContentAreaFilled(false);
				partner3.setText("Paypal");
				
				
			}
		});
		partner3.setIconTextGap(1);
		partner3.setHorizontalTextPosition(SwingConstants.CENTER);
		partner3.setVerticalTextPosition(SwingConstants.BOTTOM);
		partner3.setIcon(new ImageIcon("E:\\Downloads\\icons8-paypal-42.png"));
		partner3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner3.setForeground(Color.WHITE);
		partner3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		partner3.setContentAreaFilled(false);
		partner3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		partner3.setBounds(278, 98, 94, 66);
		contentPane.add(partner3);
		
		JButton partner4 = new JButton("Amazon");
		partner4.setFocusPainted(false);
		partner4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UNDER MAINTENANCE","Amazon",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		partner4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				partner4.setContentAreaFilled(true);
				partner4.setText("");
				partner4.setBackground(Color.white);
				partner4.setIcon(new ImageIcon("E:\\Downloads\\icons8-amazon-42.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				partner4.setContentAreaFilled(false);
				partner4.setText("Amazon");
				
			}
		});
		partner4.setIcon(new ImageIcon("E:\\Downloads\\icons8-amazon-42.png"));
		partner4.setHorizontalTextPosition(SwingConstants.CENTER);
		partner4.setVerticalTextPosition(SwingConstants.BOTTOM);
		partner4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner4.setForeground(Color.WHITE);
		partner4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		partner4.setContentAreaFilled(false);
		partner4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		partner4.setBounds(173, 175, 94, 66);
		contentPane.add(partner4);
		
		JButton partner5 = new JButton("Citi Bank");
		partner5.setFocusPainted(false);
		partner5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UNDER MAINTENANCE","Citi Bank", JOptionPane.WARNING_MESSAGE);
				
			}
		});
		partner5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				partner5.setContentAreaFilled(true);
				partner5.setText("");
				partner5.setBackground(Color.white);
				partner5.setIcon(new ImageIcon("E:\\Downloads\\icons8-citibank-42.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				partner5.setContentAreaFilled(false);
				partner5.setText("Citi Bank");
				
				
			}
		});
		partner5.setHorizontalTextPosition(SwingConstants.CENTER);
		partner5.setVerticalTextPosition(SwingConstants.BOTTOM);
		partner5.setIcon(new ImageIcon("E:\\Downloads\\icons8-citibank-42.png"));
		partner5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner5.setForeground(Color.WHITE);
		partner5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		partner5.setContentAreaFilled(false);
		partner5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		partner5.setBounds(69, 175, 94, 66);
		contentPane.add(partner5);
		
		JButton partner6 = new JButton("Play Money");
		partner6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partner1.setVisible(false);
				partner2.setVisible(false);
				partner3.setVisible(false);
				partner4.setVisible(false);
				partner5.setVisible(false);
				partner6.setVisible(false);
				partnersLabel.setVisible(false);
				backLabel.setVisible(false);
			
				
				
				//THEN THE INSERTAMOUNT LABEL AND TEXTFIELD WILL APPEAR
				amountTextfield.setVisible(true);
				insertamountLabel.setVisible(true);
				insertButt.setVisible(true);
				backButt.setVisible(true);
				
				
				
				
				
			}
		});
		partner6.setFocusPainted(false);
		partner6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		partner6.setForeground(Color.WHITE);
		partner6.setFont(new Font("SansSerif", Font.PLAIN, 11));
		partner6.setContentAreaFilled(false);
		partner6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		partner6.setBounds(278, 175, 94, 66);
		contentPane.add(partner6);
		
		JLabel tittleLavel = new JLabel("CASH IN");
		tittleLavel.setForeground(Color.WHITE);
		tittleLavel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		tittleLavel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLavel.setHorizontalTextPosition(SwingConstants.CENTER);
		tittleLavel.setBounds(123, 11, 196, 43);
		contentPane.add(tittleLavel);
		
	    partnersLabel = new JLabel("Our partners :");
		partnersLabel.setForeground(Color.WHITE);
		partnersLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		partnersLabel.setBounds(69, 79, 120, 14);
		contentPane.add(partnersLabel);
		
	    backLabel = new JLabel("back");
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	          
				dispose();
				
			}
		});
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backLabel.setForeground(Color.WHITE);
		backLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		backLabel.setBounds(198, 275, 46, 14);
		contentPane.add(backLabel);
		
	    insertamountLabel = new JLabel("INSERT AMOUNT :");
		insertamountLabel.setVisible(false);
		insertamountLabel.setForeground(Color.WHITE);
		insertamountLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		insertamountLabel.setBounds(87, 123, 120, 14);
		contentPane.add(insertamountLabel);
		
		amountTextfield = new JTextField();
		amountTextfield.setVisible(false);
		amountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		amountTextfield.setBounds(205, 121, 152, 20);
		contentPane.add(amountTextfield);
		amountTextfield.setColumns(10);
		amountTextfield.setDocument(new Limiter(6));
	
		
	    insertButt = new JButton("INSERT");
	    insertButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    insertButt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    
	    		
	    		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfos","root","tuto123");
					PreparedStatement ps = con.prepareStatement("update infosbs set balance = (balance + ?) where AccountNumber=?");
				
					
					String insert = amountTextfield.getText();
					
			
					if(amountTextfield.getText().isEmpty()){
						
						amountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(255,0,0)));
						
						
						
					} else {
					
					ps.setString(1, insert);
					ps.setString(2, ownaccountnum);
					ps.executeUpdate();
					ps.close();
					con.close();
					JOptionPane.showMessageDialog(null, "INSERTED");
			         
					
					dispose();
					
					
					
					}
					
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	}
	    });
	    insertButt.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		
	    		insertButt.setContentAreaFilled(true);
	    		insertButt.setBackground(Color.white);
	    		insertButt.setForeground(Color.black);
	    		
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		insertButt.setContentAreaFilled(false);
	    		insertButt.setForeground(Color.white);
	    	}
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		Homepage hp = new Homepage();
	    		
	    		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfos","root","tuto123");
					Statement state = con.createStatement();
					ResultSet rs = state.executeQuery("select * from infosbs where AccountNumber='"+ownaccountnum+"'");
					
					rs.next();
					
				
				    hp.getFrame().setLocationRelativeTo(null);
				    hp.getFrame().setVisible(true);
					hp.setAccountnum(ownaccountnum);
				    getFrame().dispose();
					hp.setBal(rs.getDouble(11));
					hp.setFirst(rs.getString(1));
				    
		
					 
				
				
					
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	}
	    });
		insertButt.setVisible(false);
		insertButt.setForeground(Color.WHITE);
		insertButt.setFont(new Font("SansSerif", Font.PLAIN, 11));
		insertButt.setContentAreaFilled(false);
		insertButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		insertButt.setFocusPainted(false);
		insertButt.setBounds(137, 159, 89, 23);
		contentPane.add(insertButt);
		
	    backButt = new JButton("BACK");
	    backButt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
	    		partner1.setVisible(true);
				partner2.setVisible(true);
				partner3.setVisible(true);
				partner4.setVisible(true);
				partner5.setVisible(true);
				partner6.setVisible(true);
				partnersLabel.setVisible(true);
				backLabel.setVisible(true);
			
				
				
				//THEN THE INSERTAMOUNT LABEL AND TEXTFIELD WILL APPEAR
				amountTextfield.setVisible(false);
				insertamountLabel.setVisible(false);
				insertButt.setVisible(false);
				backButt.setVisible(false);
				
	    		
	    		
	    	}
	    });
		backButt.setVisible(false);
		backButt.setForeground(Color.WHITE);
		backButt.setFont(new Font("SansSerif", Font.PLAIN, 11));
		backButt.setContentAreaFilled(false);
		backButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		backButt.setFocusPainted(false);
		backButt.setBounds(230, 159, 89, 23);
		contentPane.add(backButt);
		
		JLabel BG = new JLabel("");
		BG.setBounds(0, 0, 450, 300);
		contentPane.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);

	}
	public void setAccountnum(String accountnum) {
		this.ownaccountnum = accountnum;
		
		
		
	}public void setFrame(JFrame frame) {
		
		this.homepage = frame;
		
	} public JFrame getFrame() {
		return homepage;
		
		
		
	}
}
