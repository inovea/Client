package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import event.CallFrmMain;



import javax.swing.JFrame;

import event.CallFrmMain;
import panel.pnlConnexion;;


public class frmConnexion extends JFrame{
	// Attribut
	pnlConnexion panel;
	
	public frmConnexion() {
		// Creation de la fenetre
		this.setTitle("Connexion");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(15,94,30));
		
		panel = new pnlConnexion();
		panel.getConnexion().addActionListener(new  CallFrmMain(panel));
		this.add(panel);
		this.setVisible(true);
	}

	
	
}
