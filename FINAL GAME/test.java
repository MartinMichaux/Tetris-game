package e;

import java.awt.Color;

import java.awt.event.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class test{	
	public static int y = 0;
	public static int [][] field = new int [20][5];
	public static int [][] pentomino = new int [5][5];
	public static UI ui = new UI(20,5);
	public static UI ui1 = new UI(5,5);
	public static int [] twoPentos = new int [2];
	public static long timeInterval = 650;
	
	public static void main(final String[] args) {
		UI ui = new UI(20,5);
		UI ui1 = new UI(5,5);
		
		for (int i = 0; i < field.length; ++i) {
			for (int j = 0; j < field[0].length; ++j) {
				field[i][j] = -1;
			}
		}
		twoPentos[1] = (int)(Math.random() * 17);
		ui1.setState(fieldBuilder.randomPento(twoPentos[1]));
		
		//Timer done by Rein
		// run in a millisecond
		final Runnable runnable = new Runnable() {
			public void run() {
				int first = 0;
				//all the methods implemented inside the timer done by Martin
				while(!fieldBuilder.gameOver(field)) {
					if(first == 0) {
						twoPentos[0] = (int)(Math.random() * 17);// Give to the variable a value between 0 and 16
						//to avoid an error
						while(twoPentos[0]==twoPentos[1]) {
							twoPentos[0] = (int)(Math.random() * 17);
						}
					}else{
						twoPentos[0] = twoPentos[1];
						twoPentos[1] = (int)(Math.random() * 17);// Give to the variable a value between 0 and 16
						//no to have the 2 same pentominos in a raw (rule)
						while(twoPentos[1]==twoPentos[0]) {
							twoPentos[1] = (int)(Math.random() * 17);
						}						
					}											
					pentomino = fieldBuilder.randomPento(twoPentos[0]);
					ui1.setState(fieldBuilder.randomPento(twoPentos[1]));
					y = 0;
	                //Timer
					while (movements.downEmpty(field, pentomino,y)) {
						//Keylistener by Bert and Martin
				  		JFrame frame = (JFrame)UI.frame;
				  		JPanel panel = new JPanel();
				  		frame.getContentPane().add(panel);
				  		panel.addKeyListener(new KeyListener(){
				  				public void keyTyped(KeyEvent e){							
				  				}
				  				public void keyPressed(KeyEvent e) {
				  					if(e.getKeyCode()==KeyEvent.VK_UP){
				  						field = movements.rotate(field, pentomino, y);
				  					}
				  					if(e.getKeyCode()==KeyEvent.VK_RIGHT){											
				  							//Get pentID
				  							int pentID = 0;
				  							boolean stop = false;		
				  							for(int i=0;!stop&&i<pentomino.length;++i) {
				  								for(int j = 0;!stop&&j<pentomino[0].length;++j) {
				  									if(pentomino[i][j] != -1) {
				  										pentID = pentomino[i][j];
				  										stop = true;
				  									}
				  								}
				  							}
				  							if(movements.toRight(field,pentomino,y,pentID)) {
				  								field = movements.MoveToRight(field, pentomino, y);												
				  								for(int i=0;i<pentomino.length;++i) {
				  									for( int j=pentomino.length-2; j >= 0 ; j-- ){
				  							            pentomino[i][j+1] = pentomino [i][j];
				  							        }
				  								}
				  								for(int i = 0; i<5;++i) {
				  									if(pentomino[i][0]==pentID) {
				  										   pentomino[i][0] = -1;
				  										}
				  								}
				  								
				  							}											
				  					}
				  					if(e.getKeyCode()==KeyEvent.VK_LEFT){													
				  							//Get pentID
				  							int pentID = 0;
				  							boolean stop = false;		
				  							for(int i=0;!stop&&i<pentomino.length;++i) {
				  								for(int j = 0;!stop&&j<pentomino[0].length;++j) {
				  									if(pentomino[i][j] != -1) {
				  										pentID = pentomino[i][j];
				  										stop = true;
				  									}
				  								}
				  							}
				  							if(movements.toLeft(field,pentomino,y,pentID)) {
				  								field = movements.MoveToLeft(field, pentomino, y);
				  								for(int i=0;i<pentomino.length;++i) {
				  									for(int j=0;j<pentomino[0].length-1;++j) {													
				  									    pentomino[i][j] = pentomino[i][j+1];																	
				  									}
				  								}
				  								for(int i = 0; i<5;++i) {
				  									if(pentomino[i][4]==pentID) {
				  									   pentomino[i][4] = -1;
				  									}
				  								}
					  							
				  							}											
				  					}
				  					if(e.getKeyCode()==KeyEvent.VK_DOWN){
										  timeInterval = 100;
									}

									if(e.getKeyCode()==KeyEvent.VK_SPACE) {
										while(movements.downEmpty(field, pentomino, y)) {
											 field = movements.goDown(field, pentomino, y);
											y++;
										}
									}
									
				  				}
				  				public void keyReleased(KeyEvent e) {
				  					if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				  						timeInterval = 650;
				  					}
				  				}
				  			});		
				  		panel.setFocusable(true);
				        panel.requestFocusInWindow();
		                field = movements.goDown(field, pentomino, y);
						ui.setState(field);
						y++;

						//we use the timer to update the score realtime - Bert
						ui.xLabel1.setText("Score: " + fieldBuilder.score);

						try {
							Thread.sleep(timeInterval);
						} catch (final InterruptedException e) {
							e.printStackTrace();
						}
					}
					fieldBuilder.Score();

					if(fieldBuilder.gameOver(field)) {
						//restart functions by Bert
						JButton restart = new JButton("Restart");
						restart.setPreferredSize(new Dimension(120, 70));
						restart.addActionListener(new ActionListener()
						{
							//starting the main method again, replacing the other instance of it.
							public void actionPerformed(ActionEvent e)
							{
								//restartClicked = true;
								test.main(new String[0]);
							}
						});

						JFrame gameOver = new JFrame("GAME OVER");
						JPanel gameOPnale = new JPanel();
						JLabel gameOverTxt = new JLabel("GAME OVER !!! YOU LOST");
						JLabel gameOverScore = new JLabel("Score: " + fieldBuilder.score);
						JLabel gameOverRow = new JLabel("Deleted Rows: " + fieldBuilder.rowdeleted);
						gameOPnale.add(gameOverTxt);
						gameOPnale.add(gameOverScore);
						gameOPnale.add(gameOverRow);
						gameOver.add(gameOPnale);
						gameOver.setSize(350,150);
						gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						gameOver.add(restart);
						gameOver.setLayout(new FlowLayout());
						gameOver.setVisible(true);
					}
					field = fieldBuilder.removeRow(field);
					first++;
				}
			}
		};
		final Thread thread = new Thread(runnable);
		thread.start();
	}
}