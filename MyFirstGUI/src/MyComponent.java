import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JComponent;

public class MyComponent extends JComponent{

	private static int counter = 0;
	
	private Car theCar = new Car(0,0,Color.RED, 1, 5);
	
	private static final int LANE_HEIGHT = 40;
	
	private boolean reachedRightEdge(Car c) {
		return c.getxPos() + c.getWidth() >= this.getWidth();
	}
	
	private boolean reachedEdge(Car c) {
		return reachedLeftEdge(c) || reachedRightEdge(c);
	}
	
	private boolean reachedLeftEdge(Car c) {
		return theCar.getxPos() <= 0;
	}

	public void paintComponent(Graphics g) {
		
		int deltax = theCar.getSpeed() * theCar.getDirection();
		theCar.move(deltax, 0);
		if (reachedEdge(theCar)) {
			theCar.setDirection(-theCar.getDirection());
		}
		theCar.draw(g);
		
		counter++;
		System.out.println("paintComponent called " + counter + " times.");
	}
	
}
