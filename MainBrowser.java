package fr.cedric.programme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;

import fr.cedric.programme.SelectionListener;;



public class MainBrowser extends SelectionListener implements ActionListener{

	private String sItem ;
	
	
	

	public String getsItem() {
		return sItem;
	}

	public void setsItem(String sItem) {
		this.sItem = sItem;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	 String name = getNamePath();
		
	}


	
	
	
}
