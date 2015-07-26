package flappyBird;

import javax.swing.JFrame;

public class FlappyBird {
     
	public static FlappyBird flappyBird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	
	// class constructor
	public FlappyBird(){
		JFrame jframe = new JFrame();
		
		jframe.setSize(WIDTH, HEIGHT);
	}
		
	public static void main(String[] args){
		flappyBird = new FlappyBird();
	}
	
}
