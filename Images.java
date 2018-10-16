import javax.swing.*;

import java.awt.*;


public class Images extends JPanel { //where the images are stored
	
	public boolean imagesLoaded = false;
    public Image bg;
    public Image frog;
    
    
	
	public void loadImages(){
		bg = new ImageIcon("C:/CIS111B/newbackground.png").getImage();
		frog = new ImageIcon("C:/CIS111B/frog.png").getImage();
		
		imagesLoaded = true;
	}
	
	

	
}
