import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> myBalls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        myBalls = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        for(int i = 0; i < nBolas; i++){
            BouncingBall ball = new BouncingBall(50 +(20 * i), 50, 16, Color.BLUE, ground, myCanvas);
            myBalls.add(ball); 
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < nBolas; i++){
                myBalls.get(i).move();

                if(myBalls.get(i).getXPosition() >= 550 || myBalls.get(i).getXPosition() >= 550) {
                finished = true;
            }
            }
             
            // stop once ball has travelled a certain distance on x axis
            
        }
    }
}
