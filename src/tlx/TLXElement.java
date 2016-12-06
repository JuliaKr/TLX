/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlx;

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
    private String elementFullName;
    //the Pair-wise comparisons of factors:
    private int counter;
    private int slidervalue;
    
    public TLXElement(JSlider slider, JLabel sliderLabel, String name, String fullName){
        this.jSlider = slider;
        this.jSliderLabel = sliderLabel;
        this.elementName = name;
        this.counter = 0;
        this.elementFullName = fullName;
    }
    
    public void addCounter(){
        counter++;
        //System.out.println(elementName + ": " +counter);
    }
    public void subCounter(){
        counter--;
        //System.out.println(elementName + ": " +counter);
    }
    
    public void setSliderValue(){       
        slidervalue = jSlider.getValue();
        jSliderLabel.setText(slidervalue + " %");
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
    
    public int getCounter(){
        return counter;
    }
    
    public String getFullName(){
        return elementFullName;
    }
    
    public int getSliderValue(){
        return slidervalue;
    }
}
