package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panel.pnlConnexion;
import frame.frmMain;
public class CallFrmMain implements ActionListener{
	//Attribut
	pnlConnexion panel = new pnlConnexion();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==panel.getConnexion()){
			new frmMain();	
		}
		
	}
	public CallFrmMain(pnlConnexion panel) {
		super();
		this.panel = panel;
	}

}
