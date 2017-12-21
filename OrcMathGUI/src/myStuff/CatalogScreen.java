package myStuff;

import java.awt.Color;
import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.VideoGame;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField titleField;
	private TextField compField;
	private TextField yearField;
	private Button add;
	private CatalogMaker Catalog;
	private TextArea textarea;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Catalog = new CatalogMaker();
		StyledComponent.setTextColor(Color.BLUE);
		textarea = new TextArea(310,300,200,30,"");
		titleField = new TextField(40,40,200,30,"Title goes here , ","Title of Game");
		compField = new TextField(260,40,200,30,"Company Name goes here , ","Company who made Game");
		yearField = new TextField(480,40,200,30,"Year goes here , ","Year it was made");
		yearField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		StyledComponent.setButtonOutline(true);
		add = new Button(310, 100, 100, 50, "Add",new Action() {
			
			@Override
			public void act() {
				addButtonClicked();
			}
		});
		Button open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Switch",new Action() {
			 @Override
		 	public void act() {
				 CatalogMakerGUI.catalog.setScreen(CatalogMakerGUI.s2);
		 	}
		});
		viewObjects.add(open);
		viewObjects.add(titleField);
		viewObjects.add(compField);
		viewObjects.add(yearField);
		viewObjects.add(add);
		viewObjects.add(textarea);
	}

	protected void addButtonClicked() {
		VideoGame a = new VideoGame(titleField.getText(),compField.getText(),yearField.getText());
		String s = textarea.getText()+a+"\n";
		textarea.setText(s);
		Catalog.addNewGame(a);
		titleField.setText("");
		compField.setText("");
		yearField.setText("");
	}

}
