package myStuff;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField titleField;
	private TextField compField;
	private TextField yearField;
	private Button add;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		titleField = new TextField(40,40,200,30,"Title goes here , ","Title of Game");
		compField = new TextField(260,40,200,30,"Company Name goes here , ","Company who made Game");
		yearField = new TextField(480,40,200,30,"Year goes here , ","Year it was made");
		StyledComponent.setButtonOutline(true);
		add = new Button(260, 100, 100, 50, "Add",new Action() {
			
			@Override
			public void act() {
				titleField.setText(" You clicked the button.");
			}
		});
		add.setInactiveBorderColor(Color.blue);
		viewObjects.add(titleField);
		viewObjects.add(compField);
		viewObjects.add(yearField);
		viewObjects.add(add);
	}

}
