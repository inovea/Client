package frame;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import panel.pnlConnexion;
import panel.pnlMain;
public class frmMain extends JFrame implements ActionListener{
	//Attribut
	pnlMain pnlMain ;


	public frmMain() throws HeadlessException {
		super();
		this.setTitle("Main");
		this.setSize(500, 500);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(15,94,30));
		pnlMain = new pnlMain();
		
		this.add(pnlMain);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}
