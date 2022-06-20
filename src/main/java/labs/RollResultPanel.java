package labs;

/**
 * Created by Tavish Peckham 
 * The RollResultPanel creates a panel with a JLabel result and a JButton roll. 
 * result is set to the results of the last round via setResult().
 * rollButton starts out disabled, and must be enabled by calling enableRollButton. 
 */

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class RollResultPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int SUBPANEL_WIDTH = 75;
    private static final int SUBPANEL_HEIGHT = 100;
    private JButton rollButton;
    private JLabel result;
    
    public RollResultPanel(ActionListener eavesdropper) {
        result = new JLabel();
        setPreferredSize(new Dimension(SUBPANEL_WIDTH, SUBPANEL_HEIGHT));
        rollButton = new JButton("Roll");

        rollButton.setEnabled(false);
        rollButton.addActionListener(eavesdropper);
        add(rollButton);
        add(result);
    }

    public void enableRollButton() {
        rollButton.setEnabled(true);
    }
    
    public void disableRollButton() {
        rollButton.setEnabled(false);
    }

    public void setResult(String resultString) {
            result.setText(resultString);
    }
}