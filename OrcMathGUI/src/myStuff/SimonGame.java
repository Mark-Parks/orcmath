package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SimonGame extends FullFunctionScreen{
	
	private ArrayList<Integer> moves;
	private ArrayList<Integer> playerMoves;
	private Button blue;
	private Button red;
	private Button yellow;
	private Button green;
	private TextArea scoreBoard; 
	private int round;
	
	public SimonGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		blue = new Button(150,250,200,200,"",Color.BLUE,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(0);
				buttonBlink(1000-(round*50));
				checkGame();
			}

		});
		viewObjects.add(blue);
		
		red = new Button(350,250,200,200,"",Color.red,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(1);
				checkGame();
			}

		});
		viewObjects.add(red);
		
		yellow = new Button(150,450,200,200,"",Color.YELLOW,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(2);
				checkGame();
			}

		});
		viewObjects.add(yellow);
		
		green = new Button(350,450,200,200,"",Color.GREEN,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(3);
				checkGame();
			}

		});
		viewObjects.add(green);
		
		scoreBoard = new TextArea(150,100,400,100,"ROUND : "+round+"\nSEQUENCE LENGTH : "+(round+3));
		viewObjects.add(scoreBoard);
	}

	protected void checkGame() {
		for(int i = 0; i < moves.size(); i++) {
			if(moves.get(i) != playerMoves.get(i)) {
				//Buttons not visable TextFeild says game over
			}
		}
	}

	public void generateMove(int round) {
		moves.add((int)(Math.random()*4));
		while(moves.get(round-2) == moves.get(round-1)){
			moves.remove(round-1);
			moves.add((int)(Math.random()*4));
		}
	}
	

	private void buttonBlink(int i) {
		;
	}
}
