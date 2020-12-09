import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = 300,y = 200;
	private int vx = (int)(Math.random()*8)-4;
	private int vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private boolean dead = false;
	
	public Duck() {
		img = getImage("BIRD.png"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
	}
	
	public void paint(Graphics g) {
		vy = -2;
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		x=x + vx;
		y=y + vy;
		tx.setToTranslation(x, y);
		if (x >= 750 || x <= -100) {
			vx*=-1;
			x=x + vx;

			tx.setToTranslation(x, y);
		} 
		if (y <= -350) {
			x = 300;
			y = 400;
		}
	}
	public int getDuckX() {
		return x;
	}
	public int getDuckY() {
		return y;
	}
	public void setVX(int newVX) {
		vx = newVX;
	}
	public void setVY(int newVY) {
		vy += newVY;
	}
	
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ouch");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
