package e;
import java.util.*;
import javax.swing.*;

public class myAIToo
{
	public static int pentID;
	public static int Score;
	public static UI ui = new UI(20,5);
	public static int[][] currentfield = new int[20][5];
	public static JFrame frame = new JFrame("Score viewer");
	public static ArrayList<int[][]> allPossiblePlays = new ArrayList<int[][]>();
	public static ArrayList<Integer> scores = new ArrayList<Integer>(); 
	public static ArrayList<int[][]> pentoRotations = new ArrayList<int[][]>(); 
	public static int[][][][] basicDatabase =
		{
			{
				//pent F
				{
					//F rot 1
					{0,1,1},
					{1,1,0},
					{0,1,0}
				},
				{
					//F rot 2
					{0,1,0},
					{1,1,1},
					{0,0,1}
				},
				{
					//F rot 3
					{0,1,0},
					{0,1,1},
					{1,1,0}
				},
				{
					//F rot 4
					{1,0,0},
					{1,1,1},
					{0,1,0}
				}
				
			},
			{
				//pent I
				{
					//I rot 1
					{1},
					{1},
					{1},
					{1},
					{1}
				},
				{
					//I rot 2
					{1,1,1,1,1}
				},
				{
					//I rot 3
					{1},
					{1},
					{1},
					{1},
					{1}
				},
				{
					//I rot 4
					{1,1,1,1,1}
				}
				
			},
			{
				//pent L
				{
					//L rot 1
					{1,0},
					{1,0},
					{1,0},
					{1,1}
				},
				{
					//L rot 2
					{0,0,0,1},
					{1,1,1,1}
				},
				{
					//L rot 3
					{1,1},
					{0,1},
					{0,1},
					{0,1}
				},
				{
					//L rot 4
					{1,1,1,1,0},
					{1,0,0,0,0},
				}
			},
			{
				//pent N
				{
					//N rot 1
					{0,1},
					{1,1},
					{1,0},
					{1,0}
				},
				{
					// N rot 2
					{1,1,0,0},
					{0,1,1,1}
				},
				{
					//N rot 3
					{0,1},
					{0,1},
					{1,1},
					{1,0}
				},
				{
					//N rot 4
					{1,1,1,0},
					{0,0,1,1}
				}
			},
			{
				//pent P
				{
					//P rot 1
					{1,1},
					{1,1},
					{0,1}
				},
				{
					//P rot 2
					{1,1,0},
					{1,1,1}
				},
				{
					//P rot 3
					{0,1},
					{1,1},
					{1,1}
				},
				{
					//P rot 4
					{1,1,1},
					{0,1,1}
				}
				
			},
			{
				//pent T
				{
					//T rot 1
					{1,1,1},
					{0,1,0},
					{0,1,0}
				},
				{
					//T rot 2
					{1,0,0},
					{1,1,1},
					{1,0,0}
				},
				{
					//T rot 3
					{0,1,0},
					{0,1,0},
					{1,1,1}
				},
				{
					//T rot 4
					{0,0,1},
					{1,1,1},
					{0,0,1}
				}
			},
			{
				//pent U
				{
					//U rot 1
					{1,0,1},
					{1,1,1}
				},
				{
					//U rot 2
					{1,1},
					{0,1},
					{1,1}
				},
				{
					//U rot 3
					{1,1,1},
					{1,0,1}
				},
				{
					//U rot 4
					{1,1},
					{1,0},
					{1,1}
				}
			},
			{
				//pent V
				{
					//V rot 1
					{1,0,0},
					{1,0,0},
					{1,1,1}
				},
				{
					//V rot 2
					{0,0,1},
					{0,0,1},
					{1,1,1}
				},
				{
					//V rot 3
					{1,1,1},
					{0,0,1},
					{0,0,1}
				},
				{
					//V rot 4
					{1,1,1},
					{1,0,0},
					{1,0,0},
				}
			},
			{
				//pent W
				{
					//W rot 1
					{1,0,0},
					{1,1,0},
					{0,1,1}
				},
				{
					//W rot 2
					{0,0,1},
					{0,1,1},
					{1,1,0},
				},
				{
					//W rot 3
					{1,1,0},
					{0,1,1},
					{0,0,1}
				},
				{
					//W rot 4
					{0,1,1},
					{1,1,0},
					{1,0,0}
				}
			},
			{
				//pent X
				{
					//X rot 1
					{0,1,0},
					{1,1,1},
					{0,1,0}
				},
				{
					//X rot 2
					{0,1,0},
					{1,1,1},
					{0,1,0}
				},
				{
					//X rot 3
					{0,1,0},
					{1,1,1},
					{0,1,0}
				},
				{
					//X rot 4
					{0,1,0},
					{1,1,1},
					{0,1,0}
				}
			},
			{
				//pent Y
				{
					//Y rot 1
					{0,1},
					{1,1},
					{0,1},
					{0,1}
				},
				{
					//Y rot 2
					{1,1,1,1},
					{0,1,0,0}
				},
				{
					//Y rot 3
					{1,0},
					{1,0},
					{1,1},
					{1,0}
				},
				{
					//Y rot 4
					{0,0,1,0},
					{1,1,1,1}
				}
			},
			{
				//pent Z
				{
					//Z rot 1
					{1,1},
					{0,1},
					{1,1}
				},
				{
					//Z rot 2
					{0,0,0,1},
					{0,1,1,1},
					{0,1,0,0}
				},
				{
					//Z rot 3
					{1,1,0},
					{0,1,0},
					{0,1,1}
				},
				{
					//Z rot 4
					{0,0,1},
					{1,1,1},
					{1,0,0}
				}
			}
		};
	
	
	public static void main(String[] args)
	{
		emptyField(currentfield);
		while(!gameOver(currentfield))
		{
			chooseRandomPentoAndTurnZerosIntoMinusOnes();
			treatRotations();
			getBestPlayFromAll();
			displayfield();
			allPossiblePlays.clear();
			scores.clear();
			pentoRotations.clear();
			currentfield = removeRow(currentfield);
			displayfield();
		}
		displayScore();
	}
////////MAIN////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	public static void emptyField(int[][] currentField)
	{
		for(int i = 0; i<currentField.length; i++)
		{
			for(int j = 0; j<currentField[0].length; j++)
			{
				currentField[i][j] = -1;
			}
		}
	}
	
	public static void chooseRandomPentoAndTurnZerosIntoMinusOnes()
	{
		Random rand = new Random();
		
		int randomPentomino = rand.nextInt(basicDatabase.length);
		pentID = randomPentomino;
		
		for(int rotation = 0; rotation < 4; rotation++)
		{
			int[][] randomPento = basicDatabase[randomPentomino][rotation];
			
			for(int k = 0; k<randomPento.length; k++)
			{
				for(int l = 0; l<randomPento[k].length; l++)
				{
					if(randomPento[k][l] == 0)
					{
						randomPento[k][l] = -1;
					}
					else if(randomPento[k][l] == 1)
					{
						randomPento[k][l] = randomPentomino;
					}	
				}
			}
			pentoRotations.add(randomPento);
		}
	}
	public static void treatRotations()
	{
		int[][] currentPento;
		for(int i = 0; i < 4; i++)
		{
			currentPento = pentoRotations.get(i);
			getAllPossiblePlays(currentPento);
		}
		scanAllPossibleFields();
		
	}
	
	public static void getAllPossiblePlays(int[][] pento)
	{
		for( int yOfPentomino = 0; yOfPentomino < currentfield.length - pento.length + 1; yOfPentomino++ )
		{
			for( int xOfPentomino = 0; xOfPentomino < currentfield[yOfPentomino].length - pento[0].length + 1; xOfPentomino++)
			{
				if(legalAction(pento, yOfPentomino, xOfPentomino))
				{
					int[][] newField = new int[currentfield.length][currentfield[0].length];
					for( int i = 0; i < newField.length ; i++ )
					{
						for( int j = 0; j < newField[i].length; j++)
						{
							newField[i][j] = currentfield[i][j];
						}
					}
					pentoInField(newField, pento, yOfPentomino, xOfPentomino);
					allPossiblePlays.add(newField);
					ui.setState(newField);
					try
					{
						Thread.sleep(0);
					}
					catch(InterruptedException e)
					{
					}
				}
			}
		}
	}
	
	public static boolean legalAction(int[][] pento, int yOfPentomino,int xOfPentomino)
	{
		for( int i = 0; i < pento.length ; i++ )
		{
			for( int j = 0; j < pento[i].length; j++)
			{
				if(pento[i][j] == pentID && currentfield[i + yOfPentomino][j + xOfPentomino] != -1)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void pentoInField(int[][] field, int[][] pento, int yOfPentomino, int xOfPentomino)
	{
		for( int i = 0; i <  pento.length ; i++ )
		{
			for( int j = 0; j <  pento[i].length; j++)
			{
				if(pento[i][j] == pentID)
				{
					field[i + yOfPentomino][j + xOfPentomino] = pento[i][j];
			
				}
			}
		}
	}
	
////////// Rein's code
	public static void scanAllPossibleFields()
	{
		for(int i = 0; i < allPossiblePlays.size(); i++)
		{
			scores.add(determinefitness(allPossiblePlays.get(i)));
		}
	}
	
	public static int determinefitness(int[][] field)
	{
        int score = 0;
        for(int i = 0;i<field.length;i++)
        {
            for(int j = 0;j<field[i].length;j++)
            {
                if(field[i][j]!= -1)
                {
                    score = score + i;
                }
            }
        }
        return score;
    }
    
    public static void getBestPlayFromAll()
    {
		if(scores.size() != 0)
		{
			int indexOfBestPlay = scores.indexOf(Collections.max(scores));
			currentfield = allPossiblePlays.get(indexOfBestPlay);
    	}
    }
///////// end of Rein's code

    public static void displayfield()
    {
    	ui.setState(currentfield);
    	try
    	{
    		Thread.sleep(500);
    	}
    	catch(InterruptedException e)
    	{
    	}
    }
   
    public static boolean gameOver(int [][] field) 
    {
		for(int i = 0; i<field[0].length;++i)
		{
			if(field[0][i] != -1) 
			{
				return true;
			}
		}
		return false;
	}
	/////////////////// from fuildbuilder
	public static int [][] removeRow(int [][] field){	
		int rowdel = 0;
		int [][] removedRow = new int [field.length][field[0].length];
		for(int i = 0; i<field.length;i++) {
			for(int j = 0; j<field[0].length;j++) {
				removedRow [i][j] = field[i][j];
			}
		}
		boolean ok = false;
		int counter = 0;
		for(int i =0; i<field.length;++i) {
			counter = 0;
			for(int j = 0;j<field[0].length;++j) {
				if(field[i][j]!=-1) {
					counter++;
				}
			}
			if(counter == currentfield[0].length) {
				rowdel++;				
				for(int k = 1; k<=i;++k) {
					for(int j = 0; j<field[0].length;++j) {
						removedRow[k][j] = field[k-1][j];
						}
				}
				for(int j = 0; j<field[0].length;++j) {
					removedRow[0][j] = -1;
				}
				for(int k = i+1; k<field.length;++k) {
					for(int j = 0; j<field[0].length;++j) {
						removedRow[k][j] = field[k][j];
					}
				}
				
				ok=true;
				
			}
			for(int k = 0; k<field.length;k++) {
				for(int j = 0; j<field[0].length;j++) {
					field [k][j] = removedRow[k][j];
				}
			}
		}
		int rowdeleted = 0;
		rowdeleted+=rowdel;
		calculateScore(rowdel);
		if(ok==true) {
			return removedRow;
		}else {
			return field;
		}
	}
	
	public static void calculateScore(int numberOfCompletedRows)
	{
		
		if(numberOfCompletedRows == 1)
		{
			Score += 40;
		}
		else if(numberOfCompletedRows == 2 )
		{
			Score += 100;
		}
		else if(numberOfCompletedRows == 3 )
		{
			Score += 300;
		}
		else if(numberOfCompletedRows == 4)
		{
			Score += 1200;
		}
		else if(numberOfCompletedRows == 5)
		{
			Score += 3000;
		}
    }
	///////////////////////////////////////////////
	
	public static void displayScore()
	{
		JOptionPane.showMessageDialog(frame, "Your Score : "+ Score);
	}
}