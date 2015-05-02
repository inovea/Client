package panel;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class pnlMain extends JPanel{
	//Attribut
          
	GridLayout grid = new GridLayout() ;
	
	public pnlMain() {
		super();
		configureGrid();
	}
	 public void configureGrid() {
			grid.setColumns(2);
			grid.setRows(4);
			grid.setHgap(15);
			grid.setVgap(14);
			this.setLayout(grid);
		}
}
