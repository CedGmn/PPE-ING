package fr.cedric.programme;

import java.io.File;


import javax.swing.tree.DefaultMutableTreeNode;

import fr.cedric.programme.FileBrowser;


    public  class CreateChildNodes implements Runnable {

    	
    	private File fileRoot;
    	private DefaultMutableTreeNode root;
    	private File[] files;
        
		
		public static File getfile(File fileRoot) {
			return fileRoot;
		}
        public CreateChildNodes(File fileRoot, 
                DefaultMutableTreeNode root) {
        	this.fileRoot =  FileBrowser.fileRoot ;
        	 this.root = FileBrowser.root ;
        }

        public CreateChildNodes() {
			// TODO Auto-generated constructor stub
		}
		@Override
        public void run() {
            createChildren(fileRoot, root);
        }

        public void createChildren(File fileRoot, 
                DefaultMutableTreeNode node) {
             files = fileRoot.listFiles();
            if (files == null) return;

            for (File file : files) {
                DefaultMutableTreeNode childNode = 
                        new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                    
                    
                }
            }
        }

            
       

    }

