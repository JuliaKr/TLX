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
public class ButtonListener implements ActionListener{

    private List<TLXButtonGroup> buttonGroups;
    private List<TLXElement> tlxElements;
    /*--- Singelton --------------------------*/
    private static ButtonListener instance;
    
    public static ButtonListener getInstance (List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements) {
        if (ButtonListener.instance == null) {
          ButtonListener.instance = new ButtonListener(buttonGroups, tlxElements);
        }
        return ButtonListener.instance;
    }
    private ButtonListener(List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements){  
        this.buttonGroups = buttonGroups;
        this.tlxElements = tlxElements;

    }
    /*-----------------------------------------*/

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        for(TLXButtonGroup buttonGroup : buttonGroups){
            if(buttonGroup.groupContainsButton(button)){
                if(buttonGroup.isNotSelected(button)){
                    int buttonNr = buttonGroup.getButtonNr(button);
                    buttonGroup.selectButton(buttonNr);
                    break;
                }
            }
        }
    }
}
