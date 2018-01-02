package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel{
	
	String text;
	float width;
	float height;
	
	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		this.width = w;
		this.height = h;
		this.text = text;
		
		// TODO Auto-generated constructor stub
	}

	public void updateString1(String string) {
		;
	}
	
	public void updateString2(String string) {
		;
	}

	public void setIconColor(Color color) {
		;
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.BLACK);
		g.drawString(text, width, height);
	}
}
