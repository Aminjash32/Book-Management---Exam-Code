// Code Copyright Amin Jash February 2023.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookShop {

	private JFrame frmBookEntry;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShop window = new BookShop();
					window.frmBookEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookEntry = new JFrame();
		frmBookEntry.setTitle("Book Entry - Java");
		frmBookEntry.setResizable(false);
		frmBookEntry.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmBookEntry.setBounds(100, 100, 465, 458);
		frmBookEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookEntry.getContentPane().setLayout(null);
		
		T1 = new JTextField();
		T1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char b = e.getKeyChar();
				
				if((!(Character.isAlphabetic(b))) &&(!(Character.isSpaceChar(b))) && (b != KeyEvent.VK_SPACE) && (b != KeyEvent.VK_BACK_SPACE))
				{
					JOptionPane.showMessageDialog(null,"Invalid Character for Book Name!");
				}
			}
		});
		T1.setToolTipText("Enter Book Name");
		T1.setForeground(SystemColor.desktop);
		T1.setHorizontalAlignment(SwingConstants.RIGHT);
		T1.setBackground(SystemColor.controlHighlight);
		T1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		T1.setBounds(166, 94, 181, 31);
		frmBookEntry.getContentPane().add(T1);
		T1.setColumns(10);
		
		JLabel L1 = new JLabel("Book Name");
		L1.setFont(new Font("Tahoma", Font.BOLD, 15));
		L1.setHorizontalAlignment(SwingConstants.CENTER);
		L1.setBounds(60, 94, 96, 31);
		frmBookEntry.getContentPane().add(L1);
		
		JLabel L2 = new JLabel("Author Name");
		L2.setHorizontalAlignment(SwingConstants.CENTER);
		L2.setFont(new Font("Tahoma", Font.BOLD, 15));
		L2.setBounds(39, 154, 117, 31);
		frmBookEntry.getContentPane().add(L2);
		
		T2 = new JTextField();
		T2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				
				if((!(Character.isAlphabetic(a))) &&(!(Character.isSpaceChar(a))) && (a != KeyEvent.VK_SPACE) && (a != KeyEvent.VK_BACK_SPACE))
				{
					JOptionPane.showMessageDialog(null,"Invalid Character for Book Name!");
				}
			}
		});
		T2.setToolTipText("Enter Author Name");
		T2.setForeground(SystemColor.desktop);
		T2.setHorizontalAlignment(SwingConstants.RIGHT);
		T2.setBackground(SystemColor.controlHighlight);
		T2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		T2.setColumns(10);
		T2.setBounds(166, 154, 181, 31);
		frmBookEntry.getContentPane().add(T2);
		
		JLabel L3 = new JLabel("Price");
		L3.setHorizontalAlignment(SwingConstants.CENTER);
		L3.setFont(new Font("Tahoma", Font.BOLD, 15));
		L3.setBounds(60, 279, 96, 31);
		frmBookEntry.getContentPane().add(L3);
		
		T3 = new JTextField();
		T3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int p = e.getKeyChar();
				
				if((!(Character.isDigit(p))) &&(!(Character.isSpaceChar(p))) && (p != KeyEvent.VK_SPACE) && (p != KeyEvent.VK_BACK_SPACE))
				{
					JOptionPane.showMessageDialog(null,"Invalid Character for Book Name!");
				}
			}
		});
		T3.setToolTipText("Enter Price");
		T3.setForeground(SystemColor.desktop);
		T3.setHorizontalAlignment(SwingConstants.RIGHT);
		T3.setBackground(SystemColor.controlHighlight);
		T3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		T3.setColumns(10);
		T3.setBounds(166, 279, 181, 31);
		frmBookEntry.getContentPane().add(T3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		comboBox.setToolTipText("Dropdown Menu");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Thriller\t", "Horror", "Romance", "Self-Help", "Other"}));
		comboBox.setMaximumRowCount(5);
		comboBox.setBackground(SystemColor.controlHighlight);
		comboBox.setBounds(166, 222, 181, 31);
		frmBookEntry.getContentPane().add(comboBox);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGenre.setBounds(60, 222, 96, 31);
		frmBookEntry.getContentPane().add(lblGenre);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(T1.getText().isBlank() || T2.getText().isBlank() || T3.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null,"Please Fill All Fields!");
				}
				else
				{
					String Bname = T1.getText();
					String Aname = T2.getText();
					int c = Integer.parseInt(T3.getText());
					Object d = comboBox.getSelectedItem();
					double price = c + c * 8.5 /100;
					
					JOptionPane.showMessageDialog(null,"Book Name : " + Bname +"\nAuthor's Name : " + Aname +"\nGenre : " + d +"\nPrice with 8.5% Gst : " + price);
					
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textInactiveText);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(166, 333, 85, 39);
		frmBookEntry.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				T1.setText(null);
				T2.setText(null);
				T3.setText(null);
				comboBox.setSelectedIndex(0);
			
			}
			
		});
		btnReset.setForeground(SystemColor.text);
		btnReset.setBackground(SystemColor.textInactiveText);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.setBounds(262, 333, 85, 39);
		frmBookEntry.getContentPane().add(btnReset);
		
		JLabel lblNewLabel = new JLabel("Book Entry System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 23, 181, 39);
		frmBookEntry.getContentPane().add(lblNewLabel);
	}
}

