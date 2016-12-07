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
import java.util.*;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTable;

/**
 *
 * @author Julia
 */
public class AnalyseButtonListener implements ActionListener{

    private List<TLXButtonGroup> buttonGroups;
    private List<TLXElement> tlxElements;
    private TLXForm form;
    private JTable table;
    
    public AnalyseButtonListener(TLXForm form, List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements){  
        this.buttonGroups = buttonGroups;
        this.tlxElements = tlxElements;
        this.form = form;
        this.table = form.getAnalysTable();
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
            //TODO: set Slider value
            //evaluation slider
            setTable();
            //evaluation tabl
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
    
    
    public void setTable(){
        
        int[] summe;
        summe = new int[6];
        int[] weights;
        weights = new int[6];
        int valueSumme = 0;
        int valueWeights = 0;
        double avg = 0;
        
        
        //Rating
        int counter = 0;
        for (TLXElement ele : tlxElements) {
            int value = ele.getSliderValue();
            table.setValueAt(value, counter, 1);
            counter++;
        }
        
         //Weight
        int counter1 = 0;
        for(TLXElement element : tlxElements){
            int value1 = element.getCounter();
            table.setValueAt(value1,counter1,2);
            counter1 ++;
        }
        //Product
        int counter2 = 0;
        for (TLXElement ele : tlxElements){
            int valueRat = ele.getSliderValue();
            int valueWei = ele.getCounter();
            int valuePro =valueRat * valueWei;
            table.setValueAt(valuePro, counter2, 3);
            summe[counter2] = valueRat;
            weights[counter2] = valueWei;
            counter2 ++;
        }
        for (int i = 0; i < 6; i++){
            valueSumme = valueSumme + summe[i];
            valueWeights = valueWeights + weights[i];
        }
        
        avg = (valueSumme/valueWeights);
        form.setSumValue(valueSumme);
        form.setWeightValue(valueWeights);
        form.setAVGValue(avg);

 
    }
    
}
