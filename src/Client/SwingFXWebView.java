package Client;


import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

  
/** 
 * SwingFXWebView 
 */  
public class SwingFXWebView extends JPanel {  
     
    private Stage stage;  
    private WebView browser;  
    private JFXPanel jfxPanel;  
    private JButton swingButton;  
    private JButton btnAjout;
    private WebEngine webEngine;  

    public SwingFXWebView(){  
        initComponents();  
      }  

    public JFXPanel getJfxPanel() {
        return jfxPanel;
    }
  
   
     
    private void initComponents(){  
         
        jfxPanel = new JFXPanel();
      
        createScene();  
         
       // setLayout(new BorderLayout());  
        add(jfxPanel, BorderLayout.CENTER); 
    
       
    }     
     
    /** 
     * createScene 
     * 
     * Note: Key is that Scene needs to be created and run on "FX user thread" 
     *       NOT on the AWT-EventQueue Thread 
     * 
     */  
 
     
     
    private void createScene() {  
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                 
                stage = new Stage();  
                 
                stage.setTitle("Hello Java FX");  
               
               
                stage.setResizable(true);  
   
                Group root = new Group(); 
                int i =JFrame.MAXIMIZED_HORIZ;
                int  j=JFrame.MAXIMIZED_VERT;
                
               Scene  scene = new Scene(root);
             
                stage.setScene(scene);  
                // System.out.println(scene.getHeight() + " "+ scene.getWidth()  );
                // Set up the embedded browser:
                browser = new WebView();
                webEngine = browser.getEngine();
                
                final URL urlGoogleMaps = getClass().getResource("../googleMap/googlemaps.html");
                System.out.println(urlGoogleMaps); 
                webEngine.load(urlGoogleMaps.toExternalForm());
                
                
                ObservableList<Node> children = root.getChildren();
                children.add(browser);                     
                 
                jfxPanel.setScene(scene);  
            }  
        });  
    }
    
}
 