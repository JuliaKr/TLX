/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlx;
import tlx.TLXElement;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Julia
 */
public class XMLWriter {
    // help: https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
    
    
    private List<TLXElement> tlxElements;
    private String path;
    
    public XMLWriter (List<TLXElement> tlxElements, String path){
        this.tlxElements = tlxElements;
        this.path = path;
        checkPathString();
    }
    
    private void checkPathString(){
        path = path.replace("\\", "\\\\");
        //TODO: .xml anhängen
        if(path.indexOf(".xml") == -1){
            path = path + ".xml";
        }
        System.out.println(path );
    }
    
    private String checkSpace(String word){
        word = word.replaceAll(" ", "_");
        return word;
    }
    
    public void writeXML() throws TransformerConfigurationException, TransformerException{
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("proband");
            doc.appendChild(rootElement);

            
            for(TLXElement element : tlxElements){
                Element docElement = doc.createElement(checkSpace(element.getFullName()));
                
                Element docElementChild1 = doc.createElement("pair-wise_factor");
                docElementChild1.appendChild(doc.createTextNode(String.valueOf(element.getCounter())));
                Element docElementChild2 = doc.createElement("rating_scale");
                docElementChild2.appendChild(doc.createTextNode(String.valueOf(element.getSliderValue())));
                
                docElement.appendChild(docElementChild1);
                docElement.appendChild(docElementChild2);
                rootElement.appendChild(docElement);
            }
            
            //TODO: AVG wert mit abspeichern
            
            // write into a xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
            System.out.println("write xml ");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
