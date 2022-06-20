package labs;
import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * A DieComponent draws an outline of a die, 
 * then draws a face depending based on the int roll.
 * The face is drawn by creating a 2d array containing
 * the dots as coordinate pairs with relative x and y offsets.
 * The rolled value is swiched on to determine which dots should
 * be drawn and to dynamically resize the array. The dots are then stored in an Ellipse2D array and drawn. 
 * The reroll() method creates a new face which depends on the DiePanel
 * class to re-draw it in the panel. 
 */

public class DieComponent extends JComponent {
    private static final long serialVersionUID = 1L;
    private Ellipse2D[] pattern;
    private double left;
    private double right;
    private double upper;
    private double lower;
    private double middleX;
    private double middleY;
    private int size = 100;
    private int myXPos;
    private int myYPos;
    private int upperAndLeftOffset = 20;
    private int middleOffset = 45;
    private int lowerAndRightOffset = 70;
    private int dotDiameter = 10;
    public int roll;

    public DieComponent(int xPos, int yPos) {
        myXPos = xPos;
        myYPos = yPos;
        left = myXPos + upperAndLeftOffset;
        right = myXPos + lowerAndRightOffset;
        middleX = myXPos + middleOffset;
        middleY = myYPos + middleOffset;
        upper = myYPos + upperAndLeftOffset;
        lower = myYPos + lowerAndRightOffset;

        calculatePattern();
    }

    public void calculatePattern() {
        Random r = new Random();
        roll = r.nextInt(6) +  1;
        pattern = new Ellipse2D[roll];
        double[][] dotPositions = new double[roll][2];
        double[] middleDot = {middleX, middleY};
        double[] upperLeftDot = {left, upper};
        double[] middleLeftDot = {left, middleY};
        double[] lowerLeftDot = {left, lower};
        double[] upperRightDot = {right, upper};
        double[] middleRightDot = {right, middleY};
        double[] lowerRightDot = {right, lower};

        switch (roll) {
            case 1 : 
                dotPositions[0] = middleDot;
                break;
            case 2 : 
                dotPositions[0] = lowerLeftDot;
                dotPositions[1] = upperRightDot;
                break;
            case 3 :
                dotPositions[0] = lowerLeftDot;
                dotPositions[1] = middleDot;
                dotPositions[2] = upperRightDot;
                break;
            case 4 :
                dotPositions[0] = upperLeftDot;
                dotPositions[1] = lowerLeftDot;
                dotPositions[2] = upperRightDot;
                dotPositions[3] = lowerRightDot;
                break;
            case 5 :
                dotPositions[0] = upperLeftDot;
                dotPositions[1] = lowerLeftDot;
                dotPositions[2] = upperRightDot;
                dotPositions[3] = lowerRightDot;
                dotPositions[4] = middleDot;
                break;
            case 6 : 
                dotPositions[0] = upperLeftDot;
                dotPositions[1] = lowerLeftDot;
                dotPositions[2] = upperRightDot;
                dotPositions[3] = lowerRightDot;
                dotPositions[4] = middleLeftDot;
                dotPositions[5] = middleRightDot;
                break;
        }

        for (int i = 0; i < roll; i++) {
            Ellipse2D.Double dot 
            = new Ellipse2D.Double(dotPositions[i][0], dotPositions[i][1], dotDiameter, dotDiameter);
            pattern[i] = dot;
        }
    }

    public void draw(Graphics2D g2){
        Rectangle2D.Double outline = new Rectangle2D.Double(myXPos, myYPos, size, size);
        g2.draw(outline);

        for (Ellipse2D dot : pattern) {
            g2.fill(dot);
        }
    }
}