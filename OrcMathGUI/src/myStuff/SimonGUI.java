package myStuff;

import guiTeacher.GUIApplication;

public class SimonGUI extends GUIApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7548071104587737267L;

	public SimonGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args){
		SimonGUI game = new SimonGUI(800, 800);
		Thread runner = new Thread(game);
		runner.start();
	}

	@Override
	public void initScreen() {
		SimonGame screen = new SimonGame(getWidth(), getHeight());
		setScreen(screen);
	}
}
