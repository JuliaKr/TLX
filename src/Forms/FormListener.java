/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Julia
 */
public class FormListener implements ChangeListener{
    
    private TlxForm tlxForm;
    /*--- Singelton --------------------------*/
    private static FormListener instance;
    
    public static FormListener getInstance (TlxForm tlxForm) {
        if (FormListener.instance == null) {
          FormListener.instance = new FormListener(tlxForm);
        }
        return FormListener.instance;
    }
    private FormListener(TlxForm tlxForm){     
        this.tlxForm = tlxForm;
    }
    /*-----------------------------------------*/
    

    @Override
    public void stateChanged(ChangeEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JSlider slider = (JSlider)e.getSource();
        JLabel label = new JLabel();
        int value = (int)slider.getValue();
        label = tlxForm.getSliderLabel(slider);
        tlxForm.setLabeltext(label, value + " %");
     
    }
}
