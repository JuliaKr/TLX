/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Julia
 */
public class TLXButtonGroup {
    
    JButton button1;
    JButton button2;
    boolean button1Selected;
    boolean button2Selected;
    Color unselctedColor;
    Color unselctedFontColor;
    
    public TLXButtonGroup(JButton button1, JButton button2){
        this.button1 = button1;
        this.button2 = button2;
        button1Selected = false;
        button2Selected = false;
        unselctedColor = button1.getBackground();
        unselctedFontColor = button1.getForeground();
    }
    
    public boolean groupContainsButton(JButton button){
        if(button == button1){
            return true;
        }else if(button == button2){
            return true;
        }else{
            return false;
        }
    }
    
    public int getButtonNr(JButton button){
       if(button == button1){
            return 1;
        }else if(button == button2){
            return 2;
        }else{
            return 0;
        }
    }
    
    public boolean isSelectionChange(int newSelectedButtonNr){
        /*
        true: before the other button was selected
        false: there wasn't any selection before
        */
        //TODO: hier liegt irgendwo ein Logikfehler
        switch(newSelectedButtonNr){
            case 1:
                //the newSelectedButtonNr -> button1
                if(button2Selected){
                    return true;
                }
            case 2:
                //the newSelectedButtonNr -> button2
                if(button1Selected){
                    return true;
                }else{
                    return false;
                }
        }
        return false;
    }
    
    public void selectButton(int buttonNr){
        switch (buttonNr){
            case 1: 
                setStyle(button1, button2);
                button1Selected = true;
                button2Selected = false;
                break;
            case 2:
                setStyle(button2, button1);
                button1Selected = false;
                button2Selected = true;
                break;
        }
    }
    
    private void setStyle(JButton selectedButton, JButton notSelectedButton){
        selectedButton.setBackground(Color.DARK_GRAY);
        selectedButton.setForeground(Color.LIGHT_GRAY);
        notSelectedButton.setBackground(unselctedColor);
        notSelectedButton.setForeground(unselctedFontColor);
        
    }
    
    public JButton getUnselectedButton(int selectedButtonNr){
        switch (selectedButtonNr){
            case 1: 
                return button2;
            case 2:
                return button1;
        }
        return null;
    }
    
    public boolean isSelected(JButton button){
        switch(getButtonNr(button)){
            case 1:
                if(!button1Selected){
                  return true;
                }
                break;
            case 2:
                if(!button2Selected){
                    return true;
                }
                break;
        }
        return false;
    }
}
