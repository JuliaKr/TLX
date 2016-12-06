/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import tlx.TLXElement;

/**
 *
 * @author Julia
 */
public class NewStartButtonListener implements ActionListener{
    
    private TLXForm form;
    
    
    public NewStartButtonListener(TLXForm form){  
        this.form = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("neustart");
            TLXForm form2 = new TLXForm();
            form2.setVisible(true);
            form.setVisible(false);
            form.dispose();
        
    }
    
}
