import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PentominoBuilder {

    //All basic pentominoes that will be rotated and inverted
    private static int[][][] basicDatabase = {
            {
            	// pentomino representation X --> 0.
                    {0,1,0},
                    {1,1,1},
                    {0,1,0}
            },
            {
            	// pentomino representation I --> 1.
                    {1},
                    {1},
                    {1},
                    {1},
                    {1}
            },
            {
            	// pentomino representation Z --> 2.
                    {0,1,1},
                    {0,1,0},
                    {1,1,0}
            },
            {
            	// pentomino representation T --> 3.
                    {1,1,1},
                    {0,1,0},
                    {0,1,0}
            },
            {
            	// pentomino representation U --> 4.
                    {1,1},
                    {1,0},
                    {1,1}
            },
            {
            	// pentomino representation V --> 5.
                    {1,1,1},
                    {1,0,0},
                    {1,0,0}
            },
            {
            	// pentomino representation W --> 6.
                    {0,0,1},
                    {0,1,1},
                    {1,1,0}
            },
            {
            	// pentomino representation Y --> 7.
                    {1,0},
                    {1,1},
                    {1,0},
                    {1,0}
            },
            {
            	// pentomino representation L --> 8.
                    {1,0},
                    {1,0},
                    {1,0},
                    {1,1}
            },
            {
                // pentomino representation P --> 9.        		
        		{1,1},
                {1,1},
                {1,0}
            },
            {
                // pentomino representation N --> 10.
        		{1,1,0,0},
                {0,1,1,1}
            },
            {
                // pentomino representation F --> 11.
        	    {0,1,1},
                {1,1,0},
                {0,1,0}
            }
    };
}