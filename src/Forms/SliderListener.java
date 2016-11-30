/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Julia
 */
public class SliderListener implements ChangeListener{
    
    private List<TLXElement> tlxElements;
    /*--- Singelton --------------------------*/
    private static SliderListener instance;
    
    public static SliderListener getInstance (List<TLXElement> tlxElements) {
        if (SliderListener.instance == null) {
          SliderListener.instance = new SliderListener(tlxElements);
        }
        return SliderListener.instance;
    }
    private SliderListener(List<TLXElement> tlxElements){     
        this.tlxElements = tlxElements;
    }
    /*-----------------------------------------*/
    

    @Override
    public void stateChanged(ChangeEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JSlider slider = (JSlider)e.getSource();
        int value = (int)slider.getValue();
        
        for(TLXElement elem : tlxElements){
            if(elem.getSlider() == slider){
                elem.setSliderLabeltext(value + " %");
                break;
            }
        }
    }
}
