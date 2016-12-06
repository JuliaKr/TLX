/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import tlx.XMLWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import tlx.TLXElement;

/**
 *
 * @author Julia
 */
public class SaveButtonListener implements ActionListener{
    
    private List<TLXElement> tlxElements;
    
    public SaveButtonListener(List<TLXElement> tlxElements){
        this.tlxElements = tlxElements;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       SaveForm saveform = new SaveForm();
       saveform.setList(tlxElements);
        /* 
        XMLWriter writer = new XMLWriter(tlxElements);
        try {
            writer.writeXML();
        } catch (TransformerException ex) {
            Logger.getLogger(SaveButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }
}
