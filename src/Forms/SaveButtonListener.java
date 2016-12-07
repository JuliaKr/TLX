/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import tlx.XMLWriter;
import Forms.SaveFormListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
       //System.out.println(e.getSource());
       //System.out.println(e.getActionCommand());
       //System.out.println(e.getID());
       JFileChooser fileChooser = new JFileChooser();           
       SaveFormListener sListener = new SaveFormListener(tlxElements);
       fileChooser.addActionListener(sListener);
       FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
       fileChooser.setFileFilter(xmlfilter);
       int rueckgabewert = fileChooser.showSaveDialog(null);
       
    }
}
