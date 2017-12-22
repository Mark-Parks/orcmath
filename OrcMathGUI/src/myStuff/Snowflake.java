package myStuff;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class Snowflake extends MovingComponent {

	private BufferedImage img;
	private int topToBottom;
	private int leftToRight;
	private double sizeSpeed;
	
	public Snowflake(int w, int h) {
		super((int)(Math.random()*w), (int)(Math.random()*h), 30, 30);
		topToBottom = h;
		leftToRight = w;
		sizeSpeed = Math.sqrt(h*w);
		img = new Graphic(0, 0,(int) (2 + Math.random() * 3),(int) (2 + Math.random() * 3), "resources/snow.png").getImage();
		setVy(sizeSpeed);
		update();
		Thread t = new Thread(this);
		
		t.start();
		setY((int)(Math.random()*h));
	}
	
	public void run(){
		try {
			Thread.sleep((int)(100 + Math.random()*10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}

	public void startFalling() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void drawImage(Graphics2D g) {
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
	public void checkBehaviors() {
		if(getY()-getHeight()>topToBottom){
			setY(0);
			setVy(1.05);
			setX((int)(Math.random()*leftToRight));
		}
	}

}