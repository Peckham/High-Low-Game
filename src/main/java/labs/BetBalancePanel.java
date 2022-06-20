package labs;

/**
 * Created by Tavish Peckham 
 * The BetBalance Panel creates a JPanel with a JLabel balanceLabel containing the 
 * user's balance and a JComboBox betList containing bet options. betList is populated
 * by a String[] betOptions, and is listened to by the ButtonPanel. The int method 
 * getBetAmount() returns the currently selected bet amount to be interpreted by 
 * the ButtonPanel. setBalance() is used to update balanceLabel. 
 */

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class BetBalancePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int SUBPANEL_WIDTH = 100;
    private static final int SUBPANEL_HEIGHT = 100;
    private String[] betOptions = {"£1", "£5", "£10"};
    private String startingBalance = "Balance = £50";
    private JLabel balanceLabel;
    private JComboBox<String> betList;
    
    public BetBalancePanel(ActionListener eavesdropper) {
        setPreferredSize(new Dimension(SUBPANEL_WIDTH, SUBPANEL_HEIGHT));
        balanceLabel = new JLabel(startingBalance);
        betList = new JComboBox<>(betOptions);

        betList.addActionListener(eavesdropper);
        add(balanceLabel);
        add(betList);
    }

    public int getBetAmount() {
        return Integer.parseInt(((String)betList.getSelectedItem()).substring(1));
    }

    public void setBalance(String newBalance){
        balanceLabel.setText("Balance = £" + newBalance);
    }
}