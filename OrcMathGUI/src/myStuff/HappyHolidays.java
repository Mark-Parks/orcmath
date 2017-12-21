package myStuff;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HappyHolidays extends FullFunctionScreen {

	public HappyHolidays(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
	
		Graphic level = new Graphic(75, 100, "resources/christmas.png");
		Graphic text = new Graphic(300, 100, 200, 200, "resources/merry.png");
		Graphic text2 = new Graphic(300, 300, .3, "resources/dab.png");
		
		viewObjects.add(level);
		viewObjects.add(text);
		viewObjects.add(text2);
		Button open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Switch",new Action() {
			 @Override
		 	public void act() {
				 CatalogMakerGUI.catalog.setScreen(CatalogMakerGUI.s1);
		 	}
		});
		viewObjects.add(open);
		
	}


}
