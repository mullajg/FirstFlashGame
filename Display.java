import javax.swing.*;
import java.awt.*;

//this class has access to JFrame "extends" it to where it is called
public class Display extends JFrame {
	public JPanel gp = (JPanel) getGlassPane(); //used for invisible panel on top of JFrame
	public Images i;
	public Keying k;

	
	public Display(){     //this handles the display
		i = new Images();
		gp.setVisible(true);
		k = new Keying(this, i); //takes itself and images as inputs
		i.loadImages();
		
		
		gp.setLayout(new GridLayout(1, 1, 0, 0));
		this.setLayout(new GridLayout(1, 1, 0, 0));
		
		gp.add(k); //adds keying to the glasspane
		this.add(i); //adds images to display
	}
}
