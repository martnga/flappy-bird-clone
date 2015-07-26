package flappyBird;

import javax.swing.JFrame;

public class FlappyBird {
     
	public static FlappyBird flappyBird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	
	// class constructor
	public FlappyBird(){
		JFrame jframe = new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
		
	public static void main(String[] args){
		flappyBird = new FlappyBird();
	}
	
}
