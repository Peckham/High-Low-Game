package labs;

/**
 * Created by Tavish Peckham 
 * The RadioButtonPanel class creates a JPanel with three JRadioButtons signifying the
 * the user's gamble selection. For each radiobutton in buttonArray, it assigns a 
 * string from the buttonStrings array, adds an action listener, sets an action command
 * equal to the string of its index, and adds the button to the panel. Important to note,
 * setting each button's action command equal to its index is equivalent to assigning
 * the buttons's respective gambleCategory in the ButtonPanel class. This makes getting
 * the button's gambleCategory in ButtonPanel much simpler.
 * The boolean method hasSelection() loops through the buttons, and returns true if a button
 * has been selected.
 */

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.event.*;


public class RadioButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int SUBPANEL_WIDTH = 75;
    private static final int SUBPANEL_HEIGHT = 100;
    private String[] buttonStrings = {"low", "seven", "high"};
    public JRadioButton lowButton, sevenButton, highButton;
    public JRadioButton[] buttonArray = {lowButton, sevenButton, highButton};

    public RadioButtonPanel(ActionListener actionListener) {
        setPreferredSize(new Dimension(SUBPANEL_WIDTH, SUBPANEL_HEIGHT));
        ButtonGroup radioGroup = new ButtonGroup();

        for(int i = 0; i < 3; i++) {
            buttonArray[i] = new JRadioButton(buttonStrings[i]);
            buttonArray[i].addActionListener(actionListener);
            buttonArray[i].setActionCommand(Integer.toString(i));
            radioGroup.add(buttonArray[i]);
            add(buttonArray[i]);
        }
    }

    public boolean hasSelection() {
        for (JRadioButton button : buttonArray) {
            if (button.isSelected()) {return true;}
        }
        return false;
    }
}