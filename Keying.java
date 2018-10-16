import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keying extends JPanel {
	
	public Rectangle character;                                                      //movable character
	public Rectangle topDetect, lane1Detect, lane2Detect, lane3Detect, lane4Detect;  //car respawn detection areas
	public Rectangle car1, car2, car3, car4;										 //cars
	
	
	public int levelNum = 1;  //level number
	public int numLives = 10; //number of lives
	
	public boolean right = false; 
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	public boolean carMove = true;
	
	
	public Keying(Display f, Images i){
		
	    
		
		
		character = new Rectangle(375, 525, 10, 10);     //sets location and size of character
		
		
		topDetect = new Rectangle(0, 0, 800, 50);        //parameters of pond collision detector
		lane1Detect = new Rectangle(800, 95, 500, 50);   //parameters of respawn collision detectors
		lane2Detect = new Rectangle(-576, 210, 500, 50);
		lane3Detect = new Rectangle(800, 325, 500, 50);
		lane4Detect = new Rectangle(-576, 440, 500, 50);
		
		car1 = new Rectangle(-50, 95, 75, 50);      //parameters of cars
		car2 = new Rectangle(850, 210, 75, 50);
		car3 = new Rectangle(-100, 325, 75, 50);
		car4 = new Rectangle(950, 440, 75, 50);
		
		f.addKeyListener(new KeyAdapter(){           //"listens" for keys
			public void keyPressed(KeyEvent e){      //do this when a key is pressed 
				if(e.getKeyCode()== KeyEvent.VK_D){  //if "D" is pressed do this
					right = true;           //if d is pressed add 1 to x coordinate
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					left = true;            //if a is pressed subtract 1 from x coordinate
				}
				if(e.getKeyCode() == KeyEvent.VK_W){
					up = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					down = true;
				}
			}
				public void keyReleased(KeyEvent e){
					if(e.getKeyCode() == KeyEvent.VK_D){
						right = false;
					}
					if(e.getKeyCode()== KeyEvent.VK_A){
						left = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_W){
						up = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_S){
						down = false;
					}
				}
			
		});
		
	}
	
	public void paintComponent(Graphics g){ 
		
	if(Main.f.i.imagesLoaded = true){
		super.paintComponent(g);
			
		g.setColor(Color.WHITE);
		g.drawImage(Main.f.i.bg, 0, 0, 800, 600, null);//draws background
		g.drawString("Level: " + levelNum, 700, 40); 							 //level tracker
		g.drawString("Lives: " + numLives, 35, 40);
		g.fillRect(character.x, character.y, character.width, character.height); //fills the character
		g.fillRect(car1.x, car1.y, car1.width, car1.height);	                 //fills the cars
		g.fillRect(car2.x, car2.y, car2.width, car2.height);
		g.fillRect(car3.x, car3.y, car3.width, car3.height);
		g.fillRect(car4.x, car4.y, car4.width, car4.height);
		
		if (right){           //if right is true move it right
			character.x += 1; 
		}
		if(left){             //if left is true move it left
			character.x -= 1;
		}
		if(up){				  
			character.y -= 1;
		}
		if(down){
			character.y += 1;
		}
		
		
		if(topDetect.contains(character)){  //if the frog reaches the pond
			 	character.x = 375;				//set its x value back to 375,
				character.y = 525;				//its y value back to 525, and
				levelNum += 1;	                //increase the level by 1
				numLives += 1;					//decrease number of lives
			}
			else if(car1.contains(character)){  //if the frog hits a car do this stuff
				character.x = 375;
				character.y = 550;
				numLives -= 1;
			}
			else if(car2.contains(character)){
				character.x = 375;
				character.y = 550;
				numLives -= 1;
			}
			else if(car3.contains(character)){
				character.x = 375;
				character.y = 550;
				numLives -= 1;
			}
			else if(car4.contains(character)){
				character.x = 375;
				character.y = 550;
				numLives -= 1;
			}
			
		
		
		
		if(lane1Detect.contains(car1)){
			car1.x = -50;
		}
			if(lane2Detect.contains(car2)){
				car2.x = 850;
			}
			if(lane3Detect.contains(car3)){
				car3.x = -50;
			}
			if(lane4Detect.contains(car4)){
				car4.x = 850;
			}
		
		if(carMove){
			car1.x += levelNum;
			car2.x -= levelNum;
			car3.x += levelNum;
			car4.x -= levelNum;
		}
		
		if(numLives == 0){
			System.exit(0);
		}
		

		
		
		
		repaint();
		
	  }
	
	}
	
}
