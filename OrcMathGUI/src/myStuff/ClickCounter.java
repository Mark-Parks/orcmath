package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ClickCounter extends FullFunctionScreen{

	private int score;
	private int time;
	TextArea scoreBox;
	TextArea timerBox;
	TextArea promptBox;
	Button clicker;
	
	public ClickCounter(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		score = 0;
		time = 5;
		
		scoreBox = new TextArea(200, 50, 100, 30, "Score : "+score);
		viewObjects.add(scoreBox);
		
		promptBox = new TextArea(200,100,75,30,"");
		viewObjects.add(promptBox);
		
		timerBox = new TextArea(275,50,100,30,"Time : "+time);
		viewObjects.add(timerBox);
		
		clicker = new Button(200,150,75,45,"Ready", new Action() {
			
			@Override
			public void act() {
				Thread c = new Thread(new Runnable() {
					public void run() {
						clicker.setEnabled(false);
						promptBox.setText("3...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						promptBox.setText("2...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						promptBox.setText("1...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						promptBox.setText("Go!");
						clicker.setAction(new Action() {
							
							@Override
							public void act() {
								score++;
								scoreBox.setText("Score : "+score);
							}
						});
						clicker.setEnabled(true);
						clicker.setText("Click Me!");
						for(int i = 5; i > 0; i--) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							time--;
							timerBox.setText("Time :"+time);
						}
						clicker.setText("Done");
						clicker.setEnabled(false);
					}
				});
				c.start();
			}
		});
		viewObjects.add(clicker);
	}

}
