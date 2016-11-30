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
                if(buttonGroup.isSelected(button)){
                    int buttonNr = buttonGroup.getButtonNr(button);
                    buttonGroup.selectButton(buttonNr);
                    if(buttonGroup.isSelectionChange(buttonNr)){
                        JButton b = buttonGroup.getUnselectedButton(buttonNr);
                        changeTLXElementCounter(button.getText(), b.getText());
                    }else{
                        this.setTLXElementCounter(button.getText());
                    }
                    break;
                }
            }
        }
    }
    
    private void setTLXElementCounter(String name){
        /*
         set the counter at the TLXElement-Class
         that's important for the analyse
        */
        name = name.toLowerCase();
        for(TLXElement tlxElement : tlxElements){
            //System.out.println(tlxElement.getName()+ " == "+ name);
            if(tlxElement.getName().equals(name)){
                tlxElement.addCounter();
                break;
            }
        }
    }
    
    private void changeTLXElementCounter(String selectedButtonName, String unselectedButtonName){
        /*
         change the counter at two TLXElement-Objects
            sub the counter of the unselected Button
            add the counter of the selected Button
         that's important for the analyse
        */
        selectedButtonName = selectedButtonName.toLowerCase();
        unselectedButtonName = unselectedButtonName.toLowerCase();
        for(TLXElement tlxElement : tlxElements){
            if(tlxElement.getName().equals(unselectedButtonName)){
                tlxElement.subCounter();
            }else if(tlxElement.getName().equals(selectedButtonName)){
                tlxElement.addCounter();
            }
        }
    }
  
}
