package e;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// This class takes care of all the graphics to display a certain state
public class UI extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[][] state;
    public int size = 38;
    public static JFrame frame = new JFrame();
    public static boolean restartClicked = false;
    public JLabel xLabel1; //declare the labels here, so we can access them outside the method as well.
    public JLabel xLabel2;

    // Constructor: sets everything up
    public UI(int x, int y)
    {
        //Creating the Frame
        final int FRAME_WIDTH = 550;
        final int FRAME_HEIGHT = 800;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Pentis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Create the panel which is gonna welcome the game.

        JPanel gameBoard = new JPanel();
        gameBoard.setPreferredSize(new Dimension(250, 600));
   
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setPreferredSize(new Dimension(250, 600));
        panel.setBackground(new Color(150, 150, 255));       // Light blue.

        //BUTTON
        JButton restart = new JButton("Restart");
        restart.setPreferredSize(new Dimension(250, 100));
        restart.addActionListener(new ActionListener()
        {
            //starting the main method again, replacing the other instance of it.
            public void actionPerformed(ActionEvent e)
            {
                //restartClicked = true;
                test.main(new String[0]);
            }
        });
        
///////////button commented for now, not always stable.
       // panel.add(restart);

        // Create the place for the score.
        xLabel1 = new JLabel("Score: " + fieldBuilder.score);
        xLabel1.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(xLabel1);

        /*// Create the place for the deleted rows.
        JLabel xLabel2 = new JLabel("Deleted rows: " + fieldBuilder.rowdeleted);
        xLabel2.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(xLabel2);*/

        JLabel upAr = new JLabel("Up: rotation");
        upAr.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(upAr);
        
        JLabel rightAr = new JLabel("Right: to right");
        rightAr.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(rightAr);
        
        JLabel leftAr = new JLabel("Left: to left");
        leftAr.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(leftAr);
        
        JLabel downAr = new JLabel("Down: go faster");
        downAr.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(downAr);
        
        JLabel spaceBar = new JLabel("Space: place directly");
        spaceBar.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(spaceBar);
        
        JLabel nextPento = new JLabel("Next pentomino :");
        nextPento.setFont(new Font("Serif", Font.PLAIN, 30));
        panel.add(nextPento);

         

        //Adding Components to the frame.
        
        if(x*y == 100) {
    	    setPreferredSize(new Dimension(y * size, x * size));
    	    gameBoard.add(this);
            frame.add(gameBoard); 
            state = new int[x][y];
            for (int i = 0; i < state.length; i++)
            {
                for (int j = 0; j < state[i].length; j++)
                {
                    state[i][j] = -1;
                }
            }
        }
        
        if(x*y == 25) {
            setPreferredSize(new Dimension(5 * size, 5 * size));
            panel.add(this);
            frame.add(panel);
            state = new int[x][y]; 
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    state[i][j] = -1;
                }
            }
        }
 
        frame.add(BorderLayout.EAST, gameBoard);
        frame.getContentPane().add(BorderLayout.WEST, panel); 

        frame.setVisible(true);
    }

    // Paint function, called by the system if required for a new frame, uses the state stored by the UI class
    public void paintComponent(Graphics g)
    {
        Graphics2D localGraphics2D = (Graphics2D) g;

        localGraphics2D.setColor(Color.LIGHT_GRAY);
        localGraphics2D.fill(getVisibleRect());

        // draw lines
        localGraphics2D.setColor(Color.GRAY);
        for (int i = 0; i <= state.length; i++)
        {
            localGraphics2D.drawLine(i * size, 0, i * size, state.length * size);
        }
        for (int i = 0; i <= state.length; i++)
        {
            localGraphics2D.drawLine(0, i * size, state.length * size, i * size);
        }

        // draw blocks
        for (int i = 0; i < state.length; i++)
        {
            for (int j = 0; j < state[0].length; j++)
            {
                localGraphics2D.setColor(GetColorOfID(state[i][j]));
                localGraphics2D.fill(new Rectangle2D.Double(j * size + 1, i * size + 1, size - 1, size - 1));
            }
        }
    }

    // Decodes the ID of a pentomino into a color
    public Color GetColorOfID(int i)
    {
        
        if(i==0) {return Color.BLUE;}
        else if(i==1) {return Color.ORANGE;}
        else if(i==2) {return Color.CYAN;}
        else if(i==3) {return Color.GREEN;}
        else if(i==4) {return Color.MAGENTA;}
        else if(i==5) {return Color.PINK;}
        else if(i==6) {return Color.RED;}
        else if(i==7) {return Color.YELLOW;}
        else if(i==8) {return new Color(102,0,153);}
        else if(i==9) {return new Color(0,150,0);}
        else if(i==10) {return new Color(100, 0,0);}
        else if(i==11) {return new Color(0, 100, 0);}
        else if(i==12) {return new Color(100, 50, 0);}
        else if(i==13) {return new Color(0, 100, 0);}
        else if(i==14) {return new Color(0, 0, 100);}
        else if(i==15) {return Color.YELLOW;}
        else if(i==16) {return Color.CYAN;}        
        else {return Color.LIGHT_GRAY;}
        
    }

    // This function should be called to update the displayed state (Makes a copy)
    public void setState(int[][] _state)
    {
        for (int i =0; i < state.length; i++)
        {
            for (int j = 0; j < state[i].length; j++)
            {
                state[i][j] = _state[i][j];
            }
        }

        // Tells the system a frame update is required
        repaint();
    }

}