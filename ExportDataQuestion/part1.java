package ExportDataQuestion;
import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            if(value.length()> amount.length()){
                String country= record.get("Country");
                System.out.println(country + " " + value );
            }
        }
    }
    
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count=0;
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
                count++;
            }
        }
        return count;
    }
    
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1 , String exportItem2 ){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1)&& export.contains(exportItem2)){
                String country= record.get("Country");
                System.out.println(country);
            }
        }
    } 
    
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String countryName = record.get("Country");
            if(countryName.equals(country)){
                String exports= record.get("Exports");
                String value = record.get("Value (dollars)");
                String ans= countryName + ": " + exports + ", " + value;
                return ans;
            }
            
        }
        return "NOT FOUND";
    }

    
    
    public void tester(){
        FileResource fr= new FileResource();
        CSVParser parser= fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
        parser= fr.getCSVParser();
        int count = numberOfExporters(parser, "cocoa");
        System.out.println("number of countries which exports cocoa "+count);
        parser= fr.getCSVParser();
        String info= countryInfo(parser, "Nauru");
        System.out.println("information for Nauru "+ info);
        parser= fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
}
