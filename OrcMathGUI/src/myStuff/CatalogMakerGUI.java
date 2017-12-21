package myStuff;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {
	
	public static CatalogMakerGUI catalog;
	public static CatalogScreen s1;
	public static HappyHolidays s2;	

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		catalog = new  CatalogMakerGUI(800, 550);
		Thread go = new Thread(catalog);
		go.start();
	}
	
	@Override
	public void initScreen() {
		s1 = new CatalogScreen(getWidth(),getHeight());
		s2 = new HappyHolidays(getWidth(),getHeight());
		setScreen(s1);
	}

}
