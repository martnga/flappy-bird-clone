package flappyBird;

import java.awt.Graphics;
import javax.swing.JFrame;

public class FlappyBird {
 
public static FlappyBird flappyBird;

public final int WIDTH = 600, HEIGHT = 600;
public Render render;

// class constructor
  public FlappyBird()
  {
	JFrame jframe = new JFrame();
	
	render = new Render();
	
	jframe.add(render);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);
	jframe.setVisible(true);
   }
		
  public void repaint(Graphics g)
  {
		
		
  }
  
  public static void main(String[] args)
  {
	flappyBird = new FlappyBird();
  }

	
	
}
