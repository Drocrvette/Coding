import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	
	//Objects that need to be drawn on the JFrame in the paint method.
	Tree tree1 = new Tree();
	Duck bird = new Duck();
	Ground grass = new Ground();
	Dog d = new Dog();

	Music bang1 = new Music("bang 1.wav",false);
	Music bang2 = new Music("bang 2.wav", false);
	Music thud = new Music("thud 1.wav",false);
	Music welcome = new Music ("welcome.wav", false);
	Music missed = new Music("missed.wav", false);
	Music start = new Music("start.wav", false);
	
	public int numMissed = 0;
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		
		bird.paint(g);
		
		

		grass.paint(g);
		
		tree1.paint(g);
		
		if (numMissed == 3) {
			d.paint(g);
			numMissed = 0;
		}
		
	}
	
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
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
		int mouseX = arg0.getX();
		int mouseY = arg0.getY();
		 int birdX = bird.getDuckX();
		 int birdY = bird.getDuckY();
		
		System.out.println(birdX);
		System.out.println(birdY);
		birdX +=50;
		birdY+=100;
		int newBirdX = birdX + 150;
		int newBirdY = birdY + 80;
		
		if ((mouseX > birdX && mouseY > birdY) && (mouseX < newBirdX && mouseY < newBirdY)) {
			System.out.println("hit");
			bang1.play();
			bird.setVX(0);
			bird.setVY(30);
		}else {
			System.out.println("miss");
			numMissed++;
			bang2.play();

		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
