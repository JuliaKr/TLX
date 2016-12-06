/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import tlx.TLXElement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Julia
 */
public class AnalyseButtonListener implements ActionListener{

    private List<TLXButtonGroup> buttonGroups;
    private List<TLXElement> tlxElements;
    private TLXForm form;
    
    public AnalyseButtonListener(TLXForm form, List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements){  
        this.buttonGroups = buttonGroups;
        this.tlxElements = tlxElements;
        this.form = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //1. check if all groups have a selected Button
        JButton button = (JButton)e.getSource();
        if(comparPanalComplet()){
            //TODO: 2. check if the user has used the slider-panal
            form.setAttentionLabelText("");
            setCounter();
            displayCounter();
            button.setEnabled(false);
            form.setAnalysePanelButtons(true);
        }else{
            form.setAttentionLabelText("VERGLEICH: es wurden nicht alle Paare vergleichen");
        }
        
    }
    
    private boolean comparPanalComplet(){
        for(TLXButtonGroup group : buttonGroups){
            if(!group.hasSelectedButton()){
                return false;
            }
        }
        return true;
    }
    
    private void setCounter(){
        /*
         set all TLXElement counter
        */
        for(TLXButtonGroup group : buttonGroups){
            String name = group.getSelectedButton().getText();
            for(TLXElement element : tlxElements){
                if(element.getName().equalsIgnoreCase(name)){
                    element.addCounter();
                    break;
                }
                //TODO: Set Slider value
            }
        }
    }
    
    private void displayCounter(){
        for(TLXElement element : tlxElements){
            System.out.println(element.getName() + " " + element.getCounter());
        }
    }
}
