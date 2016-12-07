/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import tlx.XMLWriter;
import tlx.CSVWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.transform.TransformerException;
import tlx.TLXElement;

/**
 *
 * @author Julia
 */
public class SaveFormListener implements ActionListener{

    private List<TLXElement> tlxElements;
    
    public SaveFormListener(List<TLXElement> tlxElements){
        this.tlxElements = tlxElements;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = (JFileChooser)e.getSource();
        //System.out.println(fileChooser);
        //System.out.println(fileChooser.getFileFilter().getDescription());
        if(fileChooser.getDialogType() == 1){
            String path = fileChooser.getSelectedFile().getPath();
            if(fileChooser.getFileFilter().getDescription().equalsIgnoreCase("xml files (*.xml)")){
                //get xml-file
                XMLWriter writer = new XMLWriter(tlxElements, path);
                try {
                    writer.writeXML();
                } catch (TransformerException ex) {
                    Logger.getLogger(SaveFormListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                //standard: get csv-file
                CSVWriter csvWriter = new CSVWriter(tlxElements, path);
                try {
                    csvWriter.writeCSVFile();
                } catch (IOException ex) {
                    Logger.getLogger(SaveFormListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
