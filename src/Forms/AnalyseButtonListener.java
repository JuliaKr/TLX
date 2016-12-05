/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

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
    private List<TLXElement> evaSlide;
    private JTable table;
    
    /*--- Singelton --------------------------*/
    private static AnalyseButtonListener instance;
    
    public static AnalyseButtonListener getInstance (List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements, List<TLXElement> evaSlide, JTable table) {
        if (AnalyseButtonListener.instance == null) {
          AnalyseButtonListener.instance = new AnalyseButtonListener(buttonGroups, tlxElements, evaSlide, table);
        }
        return AnalyseButtonListener.instance;
    }
    private AnalyseButtonListener(List<TLXButtonGroup> buttonGroups, List<TLXElement> tlxElements, List<TLXElement> evaSlide, JTable table){  
        this.buttonGroups = buttonGroups;
        this.tlxElements = tlxElements;
        this.evaSlide = evaSlide;
        this.table = table;
    }
    /*-----------------------------------------*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //1. check if all groups have a selected Button
        
        
        if(comparPanalComplet()){
            //TODO: 2. check if the user has used the slider-panal
            //TODO: Compair vergleich und Counter setzen
            setCounter();
            displayCounter();
            //TODO: set Slider value
            updateSliderValue();
            //evaluation slider
            setTable();
            //evaluation table
            
        }else{
            System.out.println("es wurden nicht alle Paare vergleichen");
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
            }
        }
    }
    
    private void displayCounter(){
        for(TLXElement element : tlxElements){
            System.out.println(element.getName() + " " + element.getCounter());
        }
    }
    
    private void updateSliderValue(){
       
        for (TLXElement eva : evaSlide) {
            String name = eva.getName();
             for (TLXElement ele : tlxElements){
                 if(ele.getName().equalsIgnoreCase(name)){
                    eva.getSlider().setValue(ele.getSlider().getValue());
                 }
             }
             System.out.println(eva.getSlider().getValue());
        }
         
    }
    
    public void setTable(){
        
        //Rating
        int counter = 0;
        for (TLXElement eva : evaSlide) {
            String name = eva.getName();
             for (TLXElement ele : tlxElements){
                 if(ele.getName().equalsIgnoreCase(name)){
                    eva.getSlider().setValue(ele.getSlider().getValue());
                    int value = ele.getSlider().getValue();
                    table.setValueAt(value, counter, 0);
                    counter ++;
              
                 }
             }
             System.out.println(eva.getSlider().getValue());
        }
        
         //Weight
        int counter1 = 0;
        for(TLXElement element : tlxElements){
            int value1 = element.getCounter();
            table.setValueAt(value1,counter1,1);
            counter1 ++;
        }
        //Product
        int counter2 = 0;
        for (TLXElement eva : evaSlide) {
            String name = eva.getName();
             for (TLXElement ele : tlxElements){
                 if(ele.getName().equalsIgnoreCase(name)){
                    eva.getSlider().setValue(ele.getSlider().getValue());
                    int valueRat = ele.getSlider().getValue();
                    int valueWei = ele.getCounter();
                    int valuePro =valueRat * valueWei;
                    table.setValueAt(valuePro, counter2, 2);
                    //summe[counter2] = valuePro;
                    counter2 ++;
                 }
             }
        }
        
        //Summe
        //int[] summe = new int[6];
        table.setValueAt("SUM", 7, 0);
        table.setValueAt("WEIGHTS", 8, 0);
        table.setValueAt("AVG", 9, 0);
        
    }
    
}
