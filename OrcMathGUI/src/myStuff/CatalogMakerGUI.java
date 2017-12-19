package myStuff;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		CatalogMakerGUI sample = new  CatalogMakerGUI(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}
	
	@Override
	public void initScreen() {
		CatalogScreen s = new CatalogScreen(getWidth(),getHeight());
		setScreen(s);
	}

}
