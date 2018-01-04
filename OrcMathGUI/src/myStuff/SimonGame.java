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
	private Button start;
	private Button restart;
	private TextArea scoreBoard;
	private TextArea title;
	private TextArea devs;
	private int round;
	private int score;
	
	public SimonGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		moves = new ArrayList<Integer>();
		playerMoves = new ArrayList<Integer>();
		blue = new Button(200,250,200,200,"",Color.BLUE,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(0);
				buttonBlink(0,200);
				checkMoves();
			}

		});
		viewObjects.add(blue);
		
		red = new Button(400,250,200,200,"",Color.RED,new Action() {
			
			@Override
			public void act() {
				playerMoves.add(1);
				buttonBlink(1,200);
				checkMoves();
			}

		});
		viewObjects.add(red);
		
		yellow = new Button(200,450,200,200,"",new Color(175,175,0),new Action() {
			
			@Override
			public void act() {
				playerMoves.add(2);
				buttonBlink(2,200);
				checkMoves();
			}

		});
		viewObjects.add(yellow);
		
		green = new Button(400,450,200,200,"",new Color(0,120,0),new Action() {
			
			@Override
			public void act() {
				playerMoves.add(3);
				buttonBlink(3,200);
				checkMoves();
			}

		});
		viewObjects.add(green);
		
		start = new Button(500,185,100,50,"Start Game",new Action() {
			
			@Override
			public void act() {
				round = 0;
				start.setVisible(false);
				SimonTurn();
			}
		});
		viewObjects.add(start);
		
		restart = new Button(350,350,100,50,"Play Again?",new Action() {
			
			public void act() {
				restart.setVisible(false);
				round = 0;
				moves.clear();
				playerMoves.clear();
				scoreBoard.clear();
				scoreBoard.setText("ROUND : "+(round)+"                                                HIGHSCORE : "+(score)+"\nSEQUENCE LENGTH : "+(round)+"\nWAITING FOR GAME TO START...");
				scoreBoard.setSize(16);
				blue.setVisible(true);
				red.setVisible(true);
				yellow.setVisible(true);
				green.setVisible(true);
				start.setVisible(true);
				blue.setEnabled(false);
				red.setEnabled(false);
				yellow.setEnabled(false);
				green.setEnabled(false);
			}
		});
		viewObjects.add(restart);
		restart.setVisible(false);
		
		scoreBoard = new TextArea(200,150,400,150,"ROUND : "+(round)+"                                                HIGHSCORE : "+(score)+"\nSEQUENCE LENGTH : "+(round)+"\nWAITING FOR GAME TO START...");
		scoreBoard.setSize(16);
		viewObjects.add(scoreBoard);
		
		title = new TextArea(200,100,400,70,"                            SIMON");
		title.setSize(20);
		viewObjects.add(title);
		
		devs = new TextArea(200,675,400,50,"CREATED BY MARK PARKS AND WILLIAM WU");
		devs.setSize(18);
		viewObjects.add(devs);
		
		blue.setEnabled(false);
		red.setEnabled(false);
		yellow.setEnabled(false);
		green.setEnabled(false);
	}

	public void checkMoves() {
		for(int i = 0; i < playerMoves.size(); i++) {
			if(moves.get(i) != playerMoves.get(i)) {
				scoreBoard.clear();
				blue.setVisible(false);
				red.setVisible(false);
				yellow.setVisible(false);
				green.setVisible(false);
				scoreBoard.setText("ROUND : "+round+"                                                HIGHSCORE : "+(score)+"\nSEQUENCE LENGTH : "+(round+2)+"\nGAME OVER ");
				scoreBoard.setSize(16);
				restart.setVisible(true);
				return;
			}
		}
		if(playerMoves.size() == moves.size()) {
			if(score < round+2)
				score = round + 2;
			SimonTurn();
		}
	}

	public void generateMove(int round) {
		if(round == 0) {
			moves.add((int)(Math.random()*4));
			moves.add((int)(Math.random()*4));
			while(moves.get(0) == moves.get(1)){
				moves.remove(1);
				moves.add((int)(Math.random()*4));
			}
			moves.add((int)(Math.random()*4));
			while(moves.get(1) == moves.get(2)){
				moves.remove(2);
				moves.add((int)(Math.random()*4));
			}
		}else {
			moves.add((int)(Math.random()*4));
			while(moves.get(round+1) == moves.get(round+2)){
				moves.remove(round+2);
				moves.add((int)(Math.random()*4));
			}
		}
	}
	
	protected void SimonTurn() {
		Thread simon = new Thread(new Runnable() {
			
			public void run() {
				blue.setEnabled(false);
				red.setEnabled(false);
				yellow.setEnabled(false);
				green.setEnabled(false);
				scoreBoard.setText("ROUND : "+(round+1)+"                                                HIGHSCORE : "+(score)+"\nSEQUENCE LENGTH : "+(round+3)+"\nSIMON'S TURN");
				playerMoves.clear();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				generateMove(round);
				int time = 1000-(round*75);
				if(time < 100)
					time = 100;
				for(int i = 0; i < moves.size(); i++) {
					if(moves.get(i) == 0) {
						blue.setBackground(new Color(0,125,255));
						blue.setForeground(new Color(0,125,255));
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						blue.setBackground(Color.BLUE);
						blue.setForeground(Color.BLUE);
					}else if(moves.get(i) == 1) {
						red.setBackground(new Color(255,95,125));
						red.setForeground(new Color(255,95,125));
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						red.setBackground(Color.RED);
						red.setForeground(Color.RED);
					}else if(moves.get(i) == 2) {
						yellow.setBackground(new Color(255,255,0));
						yellow.setForeground(new Color(255,255,0));
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						yellow.setBackground(new Color(175,175,0));
						yellow.setForeground(new Color(175,175,0));
					}else if(moves.get(i) == 3) {
						green.setBackground(new Color(0,255,100));
						green.setForeground(new Color(0,255,100));
						try {
							Thread.sleep(time);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						green.setBackground(new Color(0,125,0));
						green.setForeground(new Color(0,125,0));
					}	
				}	
				round++;
				blue.setEnabled(true);
				red.setEnabled(true);
				yellow.setEnabled(true);
				green.setEnabled(true);
				scoreBoard.setText("ROUND : "+(round)+"                                                HIGHSCORE : "+(score)+"\nSEQUENCE LENGTH : "+(round+2)+"\nYOUR TURN");
			}
		});
		simon.start();
	}
	
	public void buttonBlink(int b, int t) {
		Thread blink = new Thread(new Runnable() {
			
			public void run() {
				if(b == 0) {
					blue.setBackground(new Color(0,125,255));
					blue.setForeground(new Color(0,125,255));
					blue.setInactiveBorderColor(Color.ORANGE);
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					blue.setBackground(Color.BLUE);
					blue.setForeground(Color.BLUE);
					blue.setInactiveBorderColor(Color.BLACK);
				}else if(b == 1) {
					red.setBackground(new Color(255,95,125));
					red.setForeground(new Color(255,95,125));
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					red.setBackground(Color.RED);
					red.setForeground(Color.RED);
				}else if(b == 2) {
					yellow.setBackground(new Color(255,255,0));
					yellow.setForeground(new Color(255,255,0));
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					yellow.setBackground(new Color(175,175,0));
					yellow.setForeground(new Color(175,175,0));
				}else if(b == 3) {
					green.setBackground(new Color(0,255,100));
					green.setForeground(new Color(0,255,100));
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					green.setBackground(new Color(0,125,0));
					green.setForeground(new Color(0,125,0));
				}	
			}
		});
		blink.start();
	}
	
}