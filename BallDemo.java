import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
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
        Random aleatorio = new Random();

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i = 0; i < nBolas; i++){
            int radio = aleatorio.nextInt(30) + 5;
            int r = aleatorio.nextInt(256);
            int g = aleatorio.nextInt(256);
            int b = aleatorio.nextInt(256);
            Color color = new Color(r, g, b);
            int posX = aleatorio.nextInt(300);
            BouncingBall ball = new BouncingBall(posX, 50, radio, color, ground, myCanvas);
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
