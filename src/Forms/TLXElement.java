/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 *
 * @author Julia
 */
public class TLXElement {
    
    private JSlider jSlider;
    private JLabel jSliderLabel;
    private String elementName;
    //the Pair-wise comparisons of factors:
    private int counter;
    
    public TLXElement(JSlider slider, JLabel sliderLabel, String name){
        this.jSlider = slider;
        this.jSliderLabel = sliderLabel;
        this.elementName = name;
        this.counter = 0;
    }
    
    public void addCounter(){
        counter++;
        System.out.println(elementName + ": " +counter);
    }
    public void subCounter(){
        counter--;
        System.out.println(elementName + ": " +counter);
    }
    
    public void setSliderLabeltext(String text){
        jSliderLabel.setText(text);
    }
    public JLabel getSliderLabel(){
        return jSliderLabel;
    }
    
    public JSlider getSlider(){
        return jSlider;
    }
    
    public String getName(){
        return elementName;
    }
}
