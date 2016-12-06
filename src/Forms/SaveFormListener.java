/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import tlx.TLXElement;

/**
 *
 * @author Julia
 */
public class SaveFormListener implements ActionListener{

    private SaveForm form;
    
    public SaveFormListener(SaveForm form){
        this.form = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("etwas gedrückt " + e.getSource());
        JFileChooser fileChooser = (JFileChooser)e.getSource();
        if(fileChooser.getDialogType() == 1){
            String path = fileChooser.getSelectedFile().getPath();
            form.writeXMLFile(form.getList(), path);
            
        }
    }
    
}
