/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Julia
 */
public class ComparButtonListener implements ActionListener{

    private List<TLXButtonGroup> buttonGroups;
    /*--- Singelton --------------------------*/
    private static ComparButtonListener instance;
    
    public static ComparButtonListener getInstance (List<TLXButtonGroup> buttonGroups) {
        if (ComparButtonListener.instance == null) {
          ComparButtonListener.instance = new ComparButtonListener(buttonGroups);
        }
        return ComparButtonListener.instance;
    }
    private ComparButtonListener(List<TLXButtonGroup> buttonGroups){  
        this.buttonGroups = buttonGroups;

    }
    /*-----------------------------------------*/

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        for(TLXButtonGroup buttonGroup : buttonGroups){
            if(buttonGroup.groupContainsButton(button)){
                    int buttonNr = buttonGroup.getButtonNr(button);
                    buttonGroup.selectButton(buttonNr);
                    break;
            }
        }
    }
}
