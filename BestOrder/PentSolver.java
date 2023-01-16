import java.util.*;
import java.math.*;
import java.util.concurrent.TimeUnit;

public class PentSolver{
	public static int horizontalGridSize = 12;
    public static int verticalGridSize = 5;
    
    public static char[] input = {'X','I','L','F','W','P','T', 'Y','Z','U','N','V'};

    // Static UI class to display the board
    public static UI ui = new UI( verticalGridSize,horizontalGridSize, 50);

    private static int characterToID(char character) {
    	int pentID = -1;
    	if (character == 'X') {
    		pentID = 0;
    	} else if (character == 'I') {
    		pentID = 1;
    	} else if (character == 'Z') {
    		pentID = 2;
    	} else if (character == 'T') {
    		pentID = 3;
    	} else if (character == 'U') {
    		pentID = 4;
     	} else if (character == 'V') {
     		pentID = 5;
     	} else if (character == 'W') {
     		pentID = 6;
     	} else if (character == 'Y') {
     		pentID = 7;
    	} else if (character == 'L') {
    		pentID = 8;
    	} else if (character == 'P') {
    		pentID = 9;
    	} else if (character == 'N') {
    		pentID = 10;
    	} else if (character == 'F') {
    		pentID = 11;
    	}
    	return pentID;
    }

    private static char pentIDToCharacter(int pentID){
    	char character = 'A';
    	if (pentID == 0) {
    		character = 'X';
    	} else if (pentID == 1) {
    		character = 'I';
    	} else if (pentID == 2) {
    		character = 'Z';
    	} else if (pentID == 3) {
    		character = 'T';
    	} else if (pentID == 4) {
    		character = 'U';
     	} else if (pentID == 5) {
     		character = 'V';
     	} else if (pentID == 6) {
     		character = 'W';
     	} else if (pentID == 7) {
     		character = 'Y';
    	} else if (pentID == 8) {
    		character = 'L';
    	} else if (pentID == 9) {
    		character = 'P';
    	} else if (pentID == 10) {
    		character = 'N';
    	} else if (pentID == 11) {
    		character = 'F';
    	}
    	return character;
    }

    private static void search(){
    	// Create the grid.
    	int[][] grid = new int[verticalGridSize][horizontalGridSize];
    	int[] pentID = new int[input.length];
    	for(int i=0;i<verticalGridSize;i++){
    		for (int j=0;j<horizontalGridSize;j++){
    			// fill in the grid with -1.
    			grid[i][j]=-1;
    		}
    	}
    	for(int i=0;i<input.length;i++){
    		// Put the pentID instead of the character.
    		pentID[i]=characterToID(input[i]);
    	}
    	searchBestSpot(grid, pentID, 0);
  	}
    
    /** Check if the pentomino fits.
    *  if the pentominoes fits, pain them on the UI.
    *  else, make a mutation and research if the new organization of the pentominoes fits.
    */
  	private static void searchBestSpot(int[][] grid, int[] pentID, int x){
  		if(area(grid)){ 
  			// If all the pentominoes aren't used, chack if it fits in the grid.
  			if (x!=pentID.length){
				for(int p=0; p< PentominoDatabase.data[pentID[x]].length;p++){
					int[][] curr_pent = PentominoDatabase.data[pentID[x]][p];
					for(int i=0;i<=verticalGridSize;i++){
						for(int j=0;j<=horizontalGridSize;j++){
							if(checkIfItFits(grid, curr_pent,j, i)){
								// Add the pentomino to the grid and search for the next pentomino.
								searchBestSpot(addPiece(grid, curr_pent,pentID[x], j, i),pentID, x+1);
							}
						}
					}
				}
			}
			// When all the pentominoes are placed, set the UI.
  			else{
  				ui.setState(grid);
  				someSolutions(transpose(grid));
  			}
  		}
  	}
  	/** Transpose a matrix
  	*	@param grid : grid with all the pentominoes fitting in it.
  	*	@return the transposed array.
  	*/
  	public static int[][] transpose (int[][] grid){
  		int[][] grid1 = new int[grid[0].length][grid.length];
  		for (int m=0; m<grid1.length; m++){
  			for (int n=0; n<grid1[m].length; n++){
  				grid1[m][n] = grid[n][m];
  			}
  		}
  		return grid1;
  	}

  	/** Look at the best solution and print them. 
  	*	If it found a solution with the I pentominoin a vertical position.
  	*	@param grid : grid with all the pentominoes fitting in it.
  	*/
  	public static void someSolutions (int[][]grid){
  		// Copy the grid array.
  		int[][] grid1 = new int[grid.length][grid[0].length];
  		for (int i=0; i<grid1.length; i++){
  			for (int j=0; j<grid1[i].length; j++){
  				grid1[i][j] = grid[i][j];
  			}
  		}
  		// Search for a solution feasible with a tetris game.
  		int[] sol = solution(grid);
  		// If there is no -1 in the solution.
		if (minus(sol)){
			// print the pentID in the best order.
  			for (int b=0; b<sol.length; b++){
				System.out.print(sol[b] + " ");
	  		}
	  		// If there is a solution with a vertical I.
        	if(bestPoint(grid1)){
        		// Print the solution (the letters) and stop the program for a certain time before to close it.
        		System.out.println("");
        		System.out.println("Here is the order with the best point: ");
        		for(int r=0; r<sol.length; r++){
        			System.out.print(pentIDToCharacter(sol[r]) + " ");
            	}
            	try {
            		Thread.sleep(120000);
            	} catch (InterruptedException e) {
              		e.printStackTrace();
            	}
            	System.exit(0);
          	}
          	else{
          		// Print the letters.
          		System.out.println(" ");
			for(int c=0; c<sol.length; c++){
				System.out.print(pentIDToCharacter(sol[c]) + " ");
			}
  			System.out.println("");
    		System.out.println("");
          	}
		}	
	}	

	/** Search if the solution is feasible by playing tetris.
	*	@param grid : the grid with all the pentominoes fitting in.
	*	@return the order with whitch we can play tetris and get the best order.	  				
	*/
   	public static int[] solution(int[][] grid){
   		int[] solArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
   		int pentID = -1;
   		int x=0;
   		// Search for a pentID.
   		for (int i=0; i<grid.length; i++){
   			for(int j=0; j<grid[i].length; j++){
   				if (grid[i][j] != -1){
   					// If it finds a number different from 0, make it equal to the pentID.
   					pentID = grid[i][j];
   					int count = 0;
   					// If the place in the array is equal to the pentID, replace it by -1 and check if there is not a -1 above in the grid.
   					for (int k=0; k<grid.length; k++){
   						for(int l=0; l<grid[k].length; l++){
   							if(grid[k][l] == pentID){
   								grid[k][l] = -1;
   								if (nothingAbove(grid,l,k)){
   									count++;
	   								// If the method replaced the five ID and that there is nothing above, add pentID to the list of solution.
	   								if (count == 5){
	   									solArray[x] = pentID;
	   									x++;
	   									count = 0;
	   								}
	   							}else{
	   								break;
	   							}
   							}
   						}
   					}
   				}
   			}
   		}
   		return solArray;
   	}

    /** Ensure that there are no overlaps or getting out of the grid
   	*	@param grid: the field containing the pentomino's already placed
    *	@param pento : the current pentomino that we are trying to put in
    *	@param posX posY: the coordinates of the pentamino
    *	@return boolean true if it can fit at that position, false otherwise
    */
    public static boolean checkIfItFits(int[][] grid, int[][] pento, int posX, int posY){
    	// Check if it fits in the grid.
    	if(posY+pento.length>grid.length||posX+pento[0].length>grid[0].length||posX<0||posY<0){
    		return false;
    	}
    	// If it fits check if there isn't any overlapping pentominoes.
    	for(int i=0;i<pento.length;i++){
    		for(int j=0;j<pento[0].length;j++){
    			if(pento[i][j]==1){
    				if(grid[posY+i][posX+j]!=-1){
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    /** Adds a pentomino to the position on the field and return a new grid
    *   @param field : field in which the pentomino is going to be placed.
    *   @param piece : pentomino that is going to be placed.
    *   @param pieceID : Idnetification number of the pentomino.
    *   @param x, y : top left coordinates of the location of the petomino.
    *   @return the array wih the pentomino added to it. 
    */
    public static int[][] addPiece(int[][] field, int[][] piece, int pieceID, int x, int y){
       int[][] res = Arrays.stream(field).map(int[]::clone).toArray(int[][]::new);
    	for(int i = 0; i < piece.length; i++){ // loop over x position of pentomino
            for (int j = 0; j < piece[i].length; j++){ // loop over y position of pentomino
                if (piece[i][j] == 1){
                    // Add the ID of the pentomino to the board if the pentomino occupies this square
                    res[y + i][x + j] = pieceID;
                }
            }
        }return res;
    }
	
	/**	count the number of block constituing the different area of
	*	the grid to see if it is divisible by 5.
	*	@param grid : the field containing pentominoes.
	*	@return a boolean if 
	*/
	public static boolean area(int[][] grid){
		boolean[][] checked = new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]!=-1){
					checked[i][j]=true;
				}else{
					checked[i][j]=false;
				}
			}
		}
		for(int k=0; k<checked.length; k++){
			for(int l=0; l<checked[0].length; l++){
				if(!checked[k][l]){
					if(count(checked, k, l)%5!=0){
						return false;
					}
				}
			}
		}return true;
	}
	
	/** Count the number of empty blocks.
	*   @param checked : boolean array.
	*	@param x,y : position to be checked.
	*/
	public static int count(boolean[][] checked, int y, int x){
		if(y>=0&&y<checked.length&&x>=0&&x<checked[0].length){
			if(!checked[y][x]){
				checked[y][x]=true;
				return 1 + count(checked, y-1, x) + count(checked, y, x+1) + count(checked, y+1,x) + count(checked, y,x-1);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	
	/* Check if there is a -1 above a certain place in the grid.
	   @param grid : expect the game grid.
	   @param x : expect the x position of a place int the grid
	   @param y : expect the y position of a place in the grid
	   @return if there is a -1 above the place or not.
	*/
    public static boolean nothingAbove (int[][] grid, int x, int y){
    	// If there is a -1, return false.
    	for(int i=y+1; i<grid.length;i++){
   			if(grid[i][x] == -1){
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean minus (int[] sol){
    	for(int i=0; i<sol.length; i++){
    		if (sol[i] == -1){
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean bestPoint (int[][] grid){
      	int pentIDI = 1;
      	for(int i=0; i<grid.length-1; i++){
        	for(int j=0; j<grid[i].length; j++){
        		if (grid[i][j] == pentIDI){
            		if (grid[i+1][j] == pentIDI){
             	 		return true;
            		}
          		}
        	}
      	}
      	return false;
    }

    // Main function. Needs to be executed to start the algorithm
    public static void main(String[] args){
    	search();
    }
}