package labs;

/**
 * Created by Tavish Peckham 
 * Creates three subpanels: radioButtonPanel, betBalancePanel, rollResultPanel.
 * The rollResultPanel's roll button is activated by the validateRoll() helper method.
 * 1. radioButtonPanel contains a group of three radio buttons that keep track of the user's
 *    gamble category: low, sevens, or high. When a radio button is pressed, we set the 
 *    int gambleCategory to 0, 1, or 2 representing low, sevens, or high. If the user
 *    has selected sevens, the bet multiplier is changed to 4. Finally call validateRoll()
 *    to make sure all selections are valid. 
 * 2. betBalancePanel contains a JLabel displaying the user's balance and a JComboBox
 *    containing bets of 1, 5, or 10. Set int betAmount to the panel's getBetAmount() method.
 *    Then validate the selection by calling validateRoll().
 * 3. rollResultPanel contains the roll button and displays the result of the last round.
 *    First switch on diePanel.roll(), which returns a new roll from the DiePanel class.
 *    Depending on the category, a rollCategory of 0, 1, 2 for low, sevens, and high
 *    respectively. If rollCategory == gambleCategory the user has won the game: adjust
 *    balance by the balanceChange, and set the result string passed to this panel. 
 * 4. validateRoll() sets the int balanceChange to betAmount * betMultiplier, then checks
 *    three conditions: is balanceChange > balance, is balance > 100, and is there a 
 *    radioButton selected in the radioButtonPanel. If any condition is false, disable
 *    the roll button. Otherwise, enable it.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel{
    private RadioButtonPanel radioButtonPanel;
    private BetBalancePanel betBalancePanel;
    private RollResultPanel rollResultPanel;
    private String resultString;
    private static final long serialVersionUID = 1L;
    private static final int PANEL_HEIGHT = 100;
    private static final int PANEL_WIDTH = 400;
    private static final int LOWROLL = 0;
    private static final int SEVENROLL = 1;
    private static final int HIGHROLL = 2;
    private int balanceChange; 
    private int betAmount = 1;
    private int balance = 50;
    private int betMultiplier;
    private int gambleCategory;
    private int rollCategory;
    
     public ButtonPanel(final DiePanel diePanel) {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        radioButtonPanel = new RadioButtonPanel(new ActionListener() {
            public void actionPerformed(ActionEvent e){ 
                gambleCategory = Integer.parseInt(e.getActionCommand());
                betMultiplier = (gambleCategory == SEVENROLL) ? 4 : 1;
                validateRoll();
            }
        });

        betBalancePanel = new BetBalancePanel(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                betAmount = betBalancePanel.getBetAmount();
                validateRoll();
            }
        });

        rollResultPanel = new RollResultPanel(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                switch(diePanel.roll()) {
                    case 2: case 3: case 4: case 5: case 6: 
                        rollCategory = LOWROLL; break;
                    case 8: case 9: case 10: case 11: case 12: 
                        rollCategory = HIGHROLL; break;
                    default: rollCategory = SEVENROLL;
                }

                if(rollCategory == gambleCategory) {
                    resultString = "You Win!";
                    balance += balanceChange;
                } else {
                    resultString = "You Lose!";
                    balance -= balanceChange; 
                }

                rollResultPanel.setResult(resultString);
                betBalancePanel.setBalance(Integer.toString(balance));
                validateRoll();
            }
        });

        add(radioButtonPanel);
        add(betBalancePanel);
        add(rollResultPanel);
    } 

    public void validateRoll() {
        balanceChange = betAmount * betMultiplier;
        if (balanceChange > balance || balance >= 100 || !radioButtonPanel.hasSelection()) {
            rollResultPanel.disableRollButton();
        } else {
            rollResultPanel.enableRollButton();
        }
    }
}