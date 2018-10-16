import javax.swing.JFrame;

public class Main {

	public static Display f = new Display(); //gets the things inside display class
	public static int w = 800; //width
	public static int h = 600; //height
	public static void main(String[] args){
		f.setSize(w, h);  //sets the size of the frame
		f.setResizable(false); //the window cannot be resized
		f.setVisible(true); //makes the window visible
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops program when closed
		f.setTitle("Bet you can't reach level 20"); //sets the title of the window
		f.setLocationRelativeTo(null); //centers the window on startup
	}
	

	

}
