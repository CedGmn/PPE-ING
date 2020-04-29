package fr.cedric.programme;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;

import fr.cedric.programme.CreateChildNodes;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class SelectionListener implements TreeSelectionListener {
//	private File fileRoot; 
	private String selectedNodeName;
	private File selectedFile;


	private String namePath;
	@Override
	public String toString() {
	return toString();
	}
	


	

	public void valueChanged(TreeSelectionEvent se) {
		
	    JTree tree = (JTree) se.getSource();
	    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
	        .getLastSelectedPathComponent();
	    
	     selectedNodeName = selectedNode.toString();	      
	   
//	    FileBrowser.root = selectedNode ;
	     selectedFile = new File(selectedNodeName);
	    
		 setNamePath(selectedFile.getName());
		 selectedFile = new File (selectedNodeName);
	    if (selectedNode.isLeaf()) {	    	

		      System.out.println(selectedNodeName);
		    		       		        		         		     	      
	      Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	      System.out.println(desktop);
          try {
        	  desktop.open(selectedFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	  }

	public String getNamePath() {
		return namePath;
	}

	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}
	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}
	public void setSelectedNodeName(String selectedNodeName) {
		this.selectedNodeName = selectedNodeName;
	}
	public String getSelectedNodeName() {
		return selectedNodeName;
	}
    
	
}
