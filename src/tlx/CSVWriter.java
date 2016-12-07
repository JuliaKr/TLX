/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlx;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Julia
 * helpfull: https://www.mkyong.com/java/how-to-export-data-to-csv-file-java/
 */
public class CSVWriter {
    
    private String filepath;
    private List<TLXElement> tlxElements;
    private String[] value;
    
    private static final char DEFAULT_SEPARATOR = ';';
    
    public CSVWriter(List<TLXElement> tlxElements, String filepath){
        this.tlxElements = tlxElements;
        this.filepath = filepath;
        checkFileString();
    }
    
    // the Writer ---------------------------------------------------------------------------
    private void writeLine(Writer w, List<String> values) throws IOException{
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }
    
    private void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }
    
    private String followCVSformat(String value) {
        
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }
    
    private void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
        /*
            write the csv file
            "first" -> first element at the "values"-List
        */
        boolean first = true;
        
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    private void checkFileString(){
        if(filepath.indexOf(".csv") == -1){
            filepath = filepath + ".csv";
        }
    }
    
    // ---------------------------------------------------------------------------
    
    public void writeCSVFile() throws IOException{
        //first row -------------------------------------
        try (FileWriter writer = new FileWriter(filepath)) {
            //first row -------------------------------------
            writeLine(writer, Arrays.asList("", "Proband"));
            
            //second part: all pair-wise factors --------------
            writeLine(writer, Arrays.asList("Weight", ""));
            for(TLXElement element : tlxElements){
                writeLine(writer, Arrays.asList(element.getFullName(), String.valueOf(element.getCounter())));
            }
            //third part: all ratings ----------
            writeLine(writer, Arrays.asList("Rating", ""));
            for(TLXElement element : tlxElements){
                writeLine(writer, Arrays.asList(element.getFullName(), String.valueOf(element.getSliderValue())));
            }
            
            writer.flush();
        }
    }
}
