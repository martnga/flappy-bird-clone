package flappyBird;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Render extends JPanel 
{

	
  private static final long serialVersionUID = -8171341062077512766L;
	
  @Override
  protected void paintComponent(Graphics g) 
  {
		
  super.paintComponent(g);
		
  FlappyBird.flappyBird.repaint(g);
  
  }

}
