package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener, MouseListener
{
 
public static FlappyBird flappyBird;

public final int WIDTH = 1000, HEIGHT = 800;

public Render render;

public Rectangle bird;

public int ticks, yMotion, score;

public ArrayList<Rectangle> columns;

public Random rand;

public boolean gameOver, started;

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
	jframe.addMouseListener(this);
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
	  columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 150, width, height));
	  columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space ));  
  }
  
 }


//creating the columns
public void paintColumn(Graphics g, Rectangle column)
{
	g.setColor(Color.green.darker());
	g.fillRect(column.x, column.y, column.width, column.height);
}  

  //Setting the game's logic
@Override
public void actionPerformed(ActionEvent e) 
 {
 if (started)
 {
		
	//moving the columns towards the left;
	int speed = 8;
	   
   for(int i = 0; i< columns.size(); i++)
   {
	  Rectangle column = columns.get(i);
	  column.x -= speed;
    }
     // handle for columns with zero height
   for(int i = 0; i< columns.size(); i++)
   {
	  Rectangle column = columns.get(i);
	  
	  // remove the pair with zero height
	  if (column.x + column.width < 0)
	  {
		  columns.remove(column);
		  
		  //remove the top column and add another
		  if(column.y == 0)
		  {
			  addColumn(false);
		  }
	  }
    }
   
   //creating the bird's motion
   ticks++;
   if(ticks % 2 == 0 && yMotion < 15)
   {
	 yMotion += 2;
   }
	bird.y += yMotion;
	
	
	for (Rectangle column : columns)
	{   
		//Calculating the score
		if (column.y == 0 && bird.x + bird.width / 2 > column.x +column.width / 2 - 5 && bird.x + bird.width / 2 < column.x +column.width / 2 + 5)
		{
			score++;
		}
			//Conditions for ending the game
		if (column.intersects(bird))
		{
			gameOver = true;
			
			//column sweeps the bird away
			bird.x = column.x - bird.width;
		}
	}
	
	if(bird.y > HEIGHT - 150 || bird.y < 0)
	{
		gameOver = true;
	}
	
	//positioning the bird after it falls over
	if (bird.y + yMotion >= HEIGHT - 120)
	{
		bird.y = HEIGHT - 120 -bird.height;
	}
	
  }
	
    render.repaint(); 
  }

 // All the game Graphics
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
	
	for(Rectangle column : columns)
	{
		paintColumn(g, column);
	}
	
	g.setColor(Color.white);
	g.setFont(new Font("Arial", 1, 100));
	
	//to start the game
	if (!started)
	{
	  g.drawString("Click to Start!", 75, HEIGHT/2 -50);
	}
	
	//when its game over
	if (gameOver)
	{
	  g.drawString("Game Over!", 75, HEIGHT/2 -50);
	}
	//showing scores on the window
	if (!gameOver && !started)
	{
		g.drawString(String.valueOf(score), WIDTH/ 2 - 25, 100);
	}
  }
  
   //instantiating bird objects
  public static void main(String[] args)
  {
	flappyBird = new FlappyBird();
  }
  
  public void jump()
  {
	  if(gameOver)
	  {
		  bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			
			columns.clear();
			yMotion = 0;
			score = 0;
			
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
		  gameOver = false;
	  }
	  
	  if(!started)
	  {
		  started = true;
	  }
	  else if (!gameOver)
	  {
		  if (yMotion > 0)
		  {
			  yMotion = 0;
		  }
		  
		  yMotion -= 10;
	  }
  }

@Override
public void mouseClicked(MouseEvent e) {
	jump();
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

	
	
}
