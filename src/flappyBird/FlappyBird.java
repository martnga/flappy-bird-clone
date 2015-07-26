package flappyBird;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener
{
 
public static FlappyBird flappyBird;

public final int WIDTH = 600, HEIGHT = 600;
public Render render;

// class constructor
  public FlappyBird()
  {
	JFrame jframe = new JFrame();
	Timer timer = new Timer(20, this);
	
	render = new Render();
	
	jframe.add(render);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);
	jframe.setVisible(true);
   }
	
@Override
public void actionPerformed(ActionEvent e) 
 {
  
  	
  }

  public void repaint(Graphics g)
  {
		
		
  }
  
  public static void main(String[] args)
  {
	flappyBird = new FlappyBird();
  }

	
	
}
