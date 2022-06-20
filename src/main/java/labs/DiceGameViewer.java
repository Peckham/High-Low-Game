package labs;
/**
 * Created by Tavish Peckham 
 * A simple Die Game Viewer. 
 * Creates a JFrame to set basic frame info.
 * Creates a JPanel diePanel to create and manipulate two DieComponents.
 * Creates a JPanel buttonPanel to keep track of the users's gamble choice
 * and roll the dice. 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

class DiceGameViewer {
    public static void main(String[] args) {
        JFrame diceGameFrame = new DiceGameFrame();
        DiePanel diePanel = new DiePanel();
        JPanel buttonPanel = new ButtonPanel(diePanel);

        diceGameFrame.add(diePanel, BorderLayout.NORTH);
        diceGameFrame.add(buttonPanel, BorderLayout.SOUTH);
        diceGameFrame.pack();
    }
}