package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener
{
 
public static FlappyBird flappyBird;

public final int WIDTH = 700, HEIGHT = 700;

public Render render;

public Rectangle bird;

public int ticks, yMotion;

public ArrayList<Rectangle> columns;

public Random rand;

// class constructor
  public FlappyBird()
  {
	JFrame jframe = new JFrame();
	Timer timer = new Timer(20, this);
	
	render = new Render();
	rand = new Random();
	
	jframe.add(render);
	jframe.setTitle("FlappyBird");
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setSize(WIDTH, HEIGHT);
	jframe.setResizable(false);
	jframe.setVisible(true); 
	
	bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
	columns = new ArrayList<Rectangle>();
	
	addColumn(true);
	addColumn(true);
	addColumn(true);
	addColumn(true);
	addColumn(true);
	
	timer.start();
   } 
	
  //adding the columns of random height to screen
public void addColumn(boolean start)
{
 int space = 300;
 int width = 100;
 int height = 50 + rand.nextInt(300);
 
  if (start)
  {  
 columns.add(new Rectangle(WIDTH  + width + columns.size() * 300, HEIGHT - height - 150, width, height));
 columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space ));
  }
  else
  {
	  columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
	  columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space ));  
  }
  
 }


//creating the columns
public void paintColumn(Graphics g, Rectangle column)
{
	g.setColor(Color.green.darker());
	g.fillRect(column.x, column.y, column.width, column.height);
}  
  
@Override
public void actionPerformed(ActionEvent e) 
 {
	//creating the bird's motion
   if(ticks % 2 == 0 && yMotion < 15)
   {
	 yMotion += 2;
   }
	bird.y = yMotion;
	
   render.repaint(); 
  }

 public void repaint(Graphics g)
  {
	  //background paint components
	g.setColor(Color.cyan);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	  //ground paint components
	g.setColor(Color.ORANGE);
	g.fillRect(0, HEIGHT-150, WIDTH, 150);
	
	  //grass 
	g.setColor(Color.green);
	g.fillRect(0, HEIGHT-150, WIDTH, 20);
	
	  //bird paint components
	g.setColor(Color.red);
	g.fillRect(bird.x, bird.y, bird.width, bird.height);
  }
  
   //instantiating bird objects
  public static void main(String[] args)
  {
	flappyBird = new FlappyBird();
  }

	
	
}
