package e;


public class fieldBuilder {
	public static int score;
    public static int rowdeleted;
    public static int [][] field = new int [20][5];
    
	
	// Create the different pentominoes into one big array.done by martin
	public static int[][][] basicDatabase = {
	            {
	            	// pentomino representation X
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,1,1,1,-1},
	            	{-1,-1,1,-1,-1}

	            },
	            {
	            	// pentomino representation I
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1}

	            },
	            {
	            	// pentomino representation Z
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},  
	            	{-1,-1,1,1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,1,1,-1,-1}

	            },
	            {
	            	// pentomino representation T
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,1,1,1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1}

	            },
	            {
	            	// pentomino representation U
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,1,-1,-1,-1},
	            	{-1,1,1,-1,-1}
	            },
	            {
	            	// pentomino representation V
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,1,1,1,-1},
	            	{-1,1,-1,-1,-1},
	            	{-1,1,-1,-1,-1}
	            },
	            {
	            	// pentomino representation W
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,1,-1},
	            	{-1,1,1,1,-1},
	            	{-1,1,-1,-1,-1}
	            },
	            {
	            	// pentomino representation Y
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,1,-1},
	            	{-1,-1,1,-1,-1}
	            },
	            {
	            	// pentomino representation L
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,1,-1}
	            },
	            {
	            	// pentomino representation P
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,1,-1},
	            	{-1,-1,1,1,-1},
	            	{-1,-1,1,-1,-1}
	            },
	            {
	            	// pentomino representation N
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,-1,1,1,1}
	            },
	            {
	            	// pentomino representation F
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,-1,1,-1,-1}
	            },
	            {
	            //mirror pentomino L
	                {-1,-1,-1,-1,-1},
            	    {-1,-1,1,-1,-1},
            	    {-1,-1,1,-1,-1},
            	    {-1,-1,1,-1,-1},
            	    {-1,1,1,-1,-1}
	            },
	            //mirror pentomino F
	            {
	                {-1,-1,-1,-1,-1},
            	    {-1,-1,-1,-1,-1},
                 	{-1,1,1,-1,-1},
               	    {-1,-1,1,1,-1},
                	{-1,-1,1,-1,-1}
	            },
	            //mirror pentomoino P
	            {
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,-1,1,-1,-1}
	            },
	            //mirror pentomino Y
	            {
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,1,1,-1,-1},
	            	{-1,-1,1,-1,-1}
	            },
	            //mirror pentomino Z
	            {
	            	{-1,-1,-1,-1,-1},
	            	{-1,-1,-1,-1,-1},  
	            	{-1,1,1,-1,-1},
	            	{-1,-1,1,-1,-1},
	            	{-1,-1,1,1,-1}
	            },
	    };
	

	
	// Return randomly a pentomino.done by martin
	public static int [][] randomPento(int randomNumber) {	
		int [][] randomPento = basicDatabase[randomNumber];	// With the random number take the pentomino corresponding to the random number.		
		for(int i = 0; i<randomPento.length;++i) {
			for(int j = 0; j<randomPento[0].length;++j) {
				if(randomPento[i][j] == 1){
					randomPento[i][j] = randomNumber;           //change the 1 of the pentomino into his pentID
				}
			}
		}
		return randomPento;			// Return the random Pentomino.
	}
	//gameover method done by martin
	public static boolean gameOver(int [][] field) {
		for(int i = 0; i<field[0].length;++i) {
			if(field[4][i] != -1) {
				return true;
			}
		}
		return false;
	}
	
	//method to delete full rown done by rein, collin and martin
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
			if(counter == 5) {
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
		rowdeleted+=rowdel;
		score = calculateScore(rowdel);
		if(ok==true) {
			return removedRow;
		}else {
			return field;
		}
	}	

    //collins stuff still has some placeholder names that need to be changed
    public static int calculateScore(int numberOfCompletedRows)
    //Made by collins
	{
		
		if(numberOfCompletedRows == 1)
		{
			score += 40;
		}
		else if(numberOfCompletedRows == 2 )
		{
			score += 100;
		}
		else if(numberOfCompletedRows == 3 )
		{
			score += 300;
		}
		else if(numberOfCompletedRows == 4)
		{
			score += 1200;
		}
		else if(numberOfCompletedRows == 5)
		{
			score += 3000;
		}
		
		return score;
    }
    
    
    
    
    
    static int[] rowfil = {-1,-1,-1,-1,-1};
    int length =field.length;
    public static  int Score(){
        int addedscore;
        //check the rows (might be optimized based on the last coordinates of the pentomino as the only possibility fill 
        //a row if the pentomino ends up putting blocks in that area)

        addedscore = calculateScore1(checkAllRows(field));
        
        for(int i = 0 ; i<field.length; i++){
        	moveRow(i);
        }
        return addedscore;
        //it's possible for the pentominoes to form another full row after removing multiple rows, we should discuss how
        //we can implement that in an efficient way
        
    }
    public static boolean fullRow(int row){
    	int counter = 0;
        int length = field[row].length;
        for(int i = 0; i<length;i++){
            if(field[row][i]== -1){
                counter++; 
            }
        }
        if(counter==5) {
        	return true;
        }
        return false;
    }
    public static void moveRow(int row){
        for(int h = 0; h<field[0].length;h++){
            field[row][h]=-1;
        }
        for(int i = row; (i>=0)&&(emptyRow(i)==false);i--){
            for(int j=0; j<field[i].length;j++){
                for(int k = i; k < field.length;k++){
                    field[i][j] = field [k][j];
            }
        }
    }
    }
    public static boolean emptyRow(int row){
        int counter = 0;
        int length = field[row].length;
        for(int i = 0; i<length;i++){
            if(field[row][i]!= -1){
                counter++;
            }
        }
        if(counter==5) {
        	return true;
        }
        return false;
    }
    //collins stuff still has some placeholder names that need to be changed
    public static int checkAllRows(int[][] field)
    //Made by Collin
	{
		int numberOfCompletedRows = 0;
		for(int i = (field.length-1); (i >= 0)&&(emptyRow(i)); i--)
		{
			if( fullRow(i) )
			{   
                rowfil[numberOfCompletedRows] = i;
                numberOfCompletedRows++;

            }

		}
		return numberOfCompletedRows;
	}
    public static int calculateScore1(int numberOfCompletedRows)
    //Made by collins
	{
		
		if(numberOfCompletedRows == 1)
		{
			score += 40;
		}
		else if(numberOfCompletedRows == 2 )
		{
			score += 100;
		}
		else if(numberOfCompletedRows == 3 )
		{
			score += 300;
		}
		else if(numberOfCompletedRows == 4)
		{
			score += 1200;
		}
		else if(numberOfCompletedRows == 5)
		{
			score += 3000;
		}
		
		return score;
    }
}
