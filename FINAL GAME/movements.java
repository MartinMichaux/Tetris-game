package e;

public class movements {
	
	// Check if the row under is empty. done by Martin
	public static boolean downEmpty(int [][] field, int [][] pento,int y) {
		if(y>=15) {
			return false;
		}
		int pentID = 0;
		boolean stop = false;		
		for(int i=0;!stop&&i<pento.length;++i) {
			for(int j = 0;!stop&&j<pento[0].length;++j) {
				if(pento[i][j] != -1) {
					pentID = pento[i][j];
					stop = true;
				}
			}
		}		
		for(int i = y; i<=y+4;++i){			
			for(int j = 0; j<field[0].length;++j){
				if(field[i][j] == pentID && field[i+1][j] != -1 && field[i+1][j] != pentID){
					return false;
				}
			}		
		}
		for(int j = 0; j<field[0].length;++j) {
			if(field[y+4][j] == pentID && field[y+5][j] == pentID){
				return false;
			}
		}
		return true;
		
	}	
	
	
	// Make the pentomino go down. done by Martin
	public static int[][] goDown(int [][] field, int [][] pento, int y) {
		int pentID = 0;
		boolean stop = false;		
		for(int i=0;!stop&&i<pento.length;++i) {
			for(int j = 0;!stop&&j<pento[0].length;++j) {
				if(pento[i][j] != -1) {
					pentID = pento[i][j];
					stop = true;
				}
			}
		}
		for(int i=y;i<=y+4;++i) {
			for(int j=0;j<field[0].length;++j) {
				if(field[i][j] == pentID) {
					field[i][j] = -1;
				}
			}
		}
		y=y+1;
		int row = 0;
		for(int i=y;i<y+pento.length;++i) {
			for(int j=0;j<pento[0].length;++j) {
				if(pento[row][j] == pentID) {
					field[i][j] = pento[row][j];
				}				
			}
			row++;
		}
		return field;
	}
	
	
	//condition to go left. done by Martin
	public static boolean toLeft(int [][] field,int [][] pento,int y,int pentID) {			
		for(int i = y; i<=y+4;++i){			
			for(int j = 1; j<field[0].length;j++){
				if(field[i][j] == pentID && field[i][j-1] != -1 && field[i][j-1] != pentID){
					return false;
				}
			}		
		}
		for(int i = y; i<=y+4;++i){			
			for(int j = 0; j<field[0].length;j++){
				if(field[i][j] == pentID && j-1<0){
					return false;
				}
			}		
		}
		
		return true;
	}
	//condition to go right.done by Martin
	public static boolean toRight(int [][]field,int [][] pento,int y,int pentID) {
		
		for(int i = y; i<=y+4;++i){			
			for(int j = 0; j<field[0].length-1;++j){
				if(field[i][j] == pentID && field[i][j+1] != -1 && field[i][j+1] != pentID){
					return false;
				}
			}		
		}
		for(int i = y; i<=y+4;++i){			
			for(int j = 0; j<field[0].length;++j){
				if(field[i][j] == pentID && j+1>4){
					return false;
				}
			}		
		}
		return true;
	}	
	//move the pentomino to the left done by Martin
	public static int [][] MoveToLeft(int [][] field,int [][] pentomino,int y) {
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
		int [][] reField = new int [field.length][field[0].length];
		for(int i = 0; i<field.length;++i) {
			for(int j = 0; j<field[0].length;++j) {
				reField[i][j]=field[i][j];
			}
		}
		
		//To left
		if(toLeft(field,pentomino,y,pentID)) {
			
			int counter1 = 0;
		    for(int i=y;i<=y+4;++i) {
				for(int j=0;j<field[0].length;++j) {
					if(field[i][j] == -1) {
						counter1++;
					}
				}
			}
			
			for(int i=y;i<=y+4;++i) {
				for(int j=0;j<field[0].length;++j) {
					if(field[i][j] == pentID) {
						field[i][j] = -1;
					}
				}
			}
			int row = 0;
			for(int i=y;i<=y+4;++i) {
				for(int j=0;j<pentomino[0].length-1;++j) {
					if(pentomino[row][j+1] == pentID) {
						field[i][j] = pentomino[row][j+1];
					}				
				}
				row++;
			}
			int counter2 = 0;
		    for(int i=y;i<=y+4;++i) {
				for(int j=0;j<field[0].length;++j) {
					if(field[i][j] == -1) {
						counter2++;
					}
				}
			}
		    if(counter1==counter2) {
		    	return field;
		    }else {
		    	return reField;
		    }
		}
		return reField;
	}
	//move pentomino to the right done by Martin
	public static int [][] MoveToRight(int [][] field,int [][] pentomino,int y) {
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
		int [][] reField = new int [field.length][field[0].length];
		int counter1 = 0;
	    for(int i=y;i<=y+4;++i) {
			for(int j=0;j<field[0].length;++j) {
				if(field[i][j] != -1) {
					counter1++;
				}
			}
		}
		for(int i = 0; i<field.length;++i) {
			for(int j = 0; j<field[0].length;++j) {
				reField[i][j]=field[i][j];
			}
		}
		
		if(toRight(field,pentomino,y,pentID)) {
			for(int i=y;i<=y+4;++i) {
				for(int j=0;j<field[0].length;++j) {
					if(field[i][j] == pentID) {
						field[i][j] = -1;
					}
				}
			}
			int row = 0;
			for(int i=y;i<=y+4;++i) {
				for(int j=1;j<pentomino[0].length;++j) {
					if(pentomino[row][j-1] == pentID) {
						field[i][j] = pentomino[row][j-1];
					}				
				}
				row++;
			}			
			int counter2 = 0;
		    for(int i=y;i<=y+4;++i) {
				for(int j=0;j<field[0].length;++j) {
					if(field[i][j] != -1) {
						counter2++;
					}
				}
			}
		    if(counter1==counter2) {
		    	return field;
		    }else {
		    	return reField;
		    }
		}
		return reField;
	}
	
	//Method to rotate done by Martin
	public static int[][] rotate(int [][] field,int[][] pentomino,int y) {
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
		
		if(pentID == 0) {
			int row = 0;
			for(int i=y;i<y+pentomino.length;++i) {
				for(int j=0;j<pentomino[0].length;++j) {
					if(pentomino[row][j] == pentID) {
						field[i][j] = pentomino[row][j];
					}				
				}
				row++;
			}			
			return field;
		}
		int [][] reField = new int [field.length][field[0].length];
		for(int i = 0; i<field.length;++i) {
			for(int j = 0; j<field[0].length;++j) {
				reField[i][j] = field [i][j];
			}
		}
		int count1 = 0;
	    for(int i=y;i<=y+4;++i) {
			for(int j=0;j<field[0].length;++j) {
				if(field[i][j] == -1) {
					count1++;
				}
			}
		}
		
	    //delete the empty row
		int counter1 = 0;
		int counter2 = 0;
		for(int i = 0; i<pentomino.length;++i) {
			if(pentomino[i][4]==-1) {
				counter1++;
				counter2++;
			}
			if(pentomino[i][3]==-1) {
				counter2++;
			}
			
		}
		if(counter1==5&&counter2!=10) {		
		for(int i=0;i<pentomino.length;++i) {
			for( int j=pentomino.length-2; j >= 0 ; j--){
	            pentomino[i][j+1] = pentomino [i][j];
	        }
		}
		for(int i = 0; i<5;++i) {
			if(pentomino[i][0]==pentID) {
				   pentomino[i][0] = -1;
				}
		}
		}
		if(counter2==10) {			
			for(int i=0;i<pentomino.length;++i) {
				for( int j=pentomino.length-3; j >= 0 ; j--){
		            pentomino[i][j+2] = pentomino [i][j];
		        }
			}
			for(int i = 0; i<5;++i) {
				for(int j = 0;j<=1;j++) {
					if(pentomino[i][j]==pentID) {
						   pentomino[i][j] = -1;
					}					
				}
			}
		}
		
		//rotate the pentomino
		int length = pentomino.length-1;
		   
		  for (int i = 0; i <= (length)/2; i++) {
		      for (int j = i; j < length-i; j++) {
		        
		       //Coordinate 1
		       int p1 = pentomino[i][j];
		        
		       //Coordinate 2
		       int p2 = pentomino[j][length-i];
		        
		       //Coordinate 3
		       int p3 = pentomino[length-i][length-j];
		        
		       //Coordinate 4
		       int p4 = pentomino[length-j][i];
		        
		       //Swap values of 4 coordinates.
		       pentomino[j][length-i] = p1;
		       pentomino[length-i][length-j] = p2;
		       pentomino[length-j][i] = p3;
		       pentomino[i][j] = p4;
		      }
		  }
			
		    int row1 = 0;
			for(int i=y;i<y+pentomino.length;++i) {
				for(int j=0;j<pentomino[0].length;++j) {
					if(pentomino[row1][j] == pentID) {
						field[i][j] = pentomino[row1][j];
					}				
				}
				row1++;
			}

		int count2 = 0;
	    for(int i=y;i<=y+4;++i) {
			for(int j=0;j<field[0].length;++j) {
				if(field[i][j] == -1) {
					count2++;
				}
			}
		}
		
		if(count1==count2) {
			return field;
		}		
		
		return reField;	
	}
}

