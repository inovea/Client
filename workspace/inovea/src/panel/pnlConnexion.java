package panel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class pnlConnexion extends JPanel{
	//Attribut
    BufferedImage image;       
	 
	JTextArea username = new JTextArea();
	JTextArea password = new JTextArea();
	JLabel lblImage = new JLabel(new ImageIcon("C:/Users/Lyes Atek/Desktop/logo3.png")); 
	JLabel lblUsername = new JLabel("Nom de compte");
	JLabel lblPassword = new JLabel("Mot de pass");
	JLabel lblForget = new JLabel("Mot de pass oublié");
	JLabel lblSpace = new JLabel();
	JButton connexion = new JButton("Valider");
	GridLayout grid = new GridLayout() ;
	
	public pnlConnexion() {
		configureGrid();
		initializeAttribut();
		password.setBounds(0, 0, 20, 20);
		this.add(lblImage);
		this.add(lblSpace);
		this.add(lblUsername);
		this.add(username);
		this.add(lblPassword);
		this.add(password);
		this.add(connexion);
		
		

		
	}
	 public GridLayout getGrid() {
		return grid;
	}
	public void initializeAttribut() {
		
			lblPassword.setForeground(Color.black);
			lblUsername.setForeground(Color.black);
			lblForget.setForeground(Color.black);
			
		}
	 public void configureGrid() {
			
			grid.setColumns(2);
			grid.setRows(4);
			grid.setHgap(15);
			grid.setVgap(14);
			this.setLayout(grid);
		}
	
	public JButton getConnexion() {
		return connexion;
	}
	public JTextArea getUsername() {
		return username;
	}
	public JTextArea getPassword() {
		return password;
	}

	

}
