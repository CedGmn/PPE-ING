package fr.cedric.programme;
import java.awt.BorderLayout;
import fr.cedric.programme.SelectionListener;
import fr.cedric.programme.FileNode;
import fr.cedric.programme.CreateChildNodes;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class FileBrowser implements Runnable {

    static DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;

    private JTree tree;
    
    static File fileRoot;
    
   
    

    @Override
    
    public void run() {
    	
    	
        JFrame frame = new JFrame("File Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(2,2,20,20) );	
        frame.add( createToolBar(),BorderLayout.NORTH);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        

        fileRoot = new File("C:/BD_ING");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new SelectionListener());
        
        
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.add(scrollPane);
        frame.setVisible(true);
       

        CreateChildNodes ccn = 
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
    }
    
    private JToolBar createToolBar() {
    	
        JToolBar toolBar = new JToolBar	();
        JButton b =new JButton("Ouvrir");
        b.setPreferredSize(new Dimension(200, 50));
        toolBar.add(b);
        JTextField textfield = new JTextField("rechecher");
        textfield.setPreferredSize(new Dimension (10, 10));
        toolBar.add(textfield);    
        
        return toolBar;
    }
    
    
  
    
    

}