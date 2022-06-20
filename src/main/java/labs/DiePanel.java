package labs;


/**
 * The DiePanel class creates two DieComponents and places them
 * into the panel. The roll() method rolls each die, repaints
 * them to the panel, and returns the roll result as an int.
 */

import javax.swing.JPanel;
import java.awt.*;

public class DiePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int PANEL_WIDTH = 200;
    private static final int PANEL_HEIGHT = 160;
    private DieComponent die1;
    private DieComponent die2;
    public int dieYTop = 50;
    private int die1XLeft = 50;
    private int die2XLeft = 250;

    public DiePanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        die1 = new DieComponent(die1XLeft, dieYTop);
        die2 = new DieComponent(die2XLeft, dieYTop);
    }
    
    public int roll() {
        die1.calculatePattern();
        die2.calculatePattern();
        repaint();
        return die1.roll + die2.roll;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        die1.draw(g2);
        die2.draw(g2);
    }
}