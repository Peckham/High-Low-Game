package labs;

/**
 * Created by Tavish Peckham on 10.21.19
 * A simple JFrame that sets the frame's dimensions, title,
 * default close operation, resizibility, and visibility.
 */

import javax.swing.JFrame;
import java.awt.Dimension;

 public class DiceGameFrame extends JFrame{
     
    private static final long serialVersionUID = 1L;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;

    public DiceGameFrame() {
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("High - Low Game");
        setVisible(true);
     }
 }