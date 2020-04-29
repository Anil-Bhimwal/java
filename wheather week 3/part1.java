
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part1 {
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum =0;
        int count=0;
        for(CSVRecord curr: parser){
            if(Double.parseDouble(curr.get("TemperatureF"))!=-9999&& !curr.get("Humidity").equals("NaN")&&Double.parseDouble(curr.get("Humidity"))>=value){
                sum += Double.parseDouble(curr.get("TemperatureF"));
                count++;
            }
        }
        if(count==0){
            return -1;
        }
        return sum/count;
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double sum =0;
        int count=0;
        for(CSVRecord curr: parser){
            if(Double.parseDouble(curr.get("TemperatureF"))!=-9999){
                sum += Double.parseDouble(curr.get("TemperatureF"));
                count++;
            }
        }
        return sum/count;
    }
    
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowest =null;
    
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord curr = lowestHumidityInFile(fr.getCSVParser());
            if(lowest==null&& !curr.get("Humidity").equals("N/A")){
                lowest= curr;
            }else{ 
                if(!curr.get("Humidity").equals("N/A")){
                   double currHumidity= Double.parseDouble(curr.get("Humidity"));
                    double lowestHumidity= Double.parseDouble(lowest.get("Humidity"));
                    if(currHumidity< lowestHumidity){
                        lowest = curr;
                    } 
                }
                
            }
        }
        return lowest;
            
    }
    
    
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest =null;
        for(CSVRecord curr: parser){
            if(lowest==null&& !curr.get("Humidity").equals("N/A")){
                lowest= curr;
            }else{ 
                if(!curr.get("Humidity").equals("N/A")){
                   double currTemp= Double.parseDouble(curr.get("Humidity"));
                    double coolestTemp= Double.parseDouble(lowest.get("Humidity"));
                    if(currTemp< coolestTemp&& currTemp!= -9999){
                        lowest = curr;
                    } 
                }
                
            }
        }
        return lowest;
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord coolest= null;
        File coolestFile= null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord curr = coldestHourInFile(fr.getCSVParser());
            if(coolest==null&& Double.parseDouble(curr.get("TemperatureF"))!=-9999){
                coolest= curr;
                coolestFile= f;
            }else{
                double currTemp= Double.parseDouble(curr.get("TemperatureF"));
                double coolestTemp= Double.parseDouble(coolest.get("TemperatureF"));
                if(currTemp< coolestTemp&& currTemp!= -9999){
                    coolest = curr;
                    coolestFile= f;
                }
            }
            
        }
        return coolestFile.getName();
    }
    
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coolest =null;
        for(CSVRecord curr: parser){
            if(coolest==null&& Double.parseDouble(curr.get("TemperatureF"))!=-9999){
                coolest= curr;
            }else{
                double currTemp= Double.parseDouble(curr.get("TemperatureF"));
                double coolestTemp= Double.parseDouble(coolest.get("TemperatureF"));
                if(currTemp< coolestTemp&& currTemp!= -9999){
                    coolest = curr;
                }
            }
        }
        return coolest;
    }
    
    public void testColdestHourInFile(){
        FileResource fr= new FileResource();
        CSVRecord coolest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Date: "+ coolest.get("DateUTC") + " Temperature: "+ coolest.get("TemperatureF")+ " Humidity: "+ coolest.get("Humidity")+ " Date: "+ coolest.get("DateUTC"));
    }
    
    
    
    public void testFileWithColdestTemperature(){
        String coolestFile= fileWithColdestTemperature();
        String fileName ="C:/Users/HP/Desktop/java/wheather week 3/2013/"+coolestFile;
        System.out.println("Coldest day was in file weather- "+ coolestFile);
        FileResource fr= new FileResource(fileName);
        CSVRecord coolest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was "+ coolest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        CSVParser parser= fr.getCSVParser();
        for(CSVRecord curr : parser){
            System.out.println("TimeEST: "+ curr.get("TimeEST") + " Temperature: "+ curr.get("TemperatureF"));
        }
    }
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+ csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+ csv.get("Humidity") + " at " + csv.get("DateUTC"));
        
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double avg = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+ avg);
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
         FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double avg = averageTemperatureWithHighHumidityInFile(parser, 80);
        if(avg ==-1){
            System.out.println("No temperatures with that humidity");
        }else{
            System.out.println("Average Temp when high Humidity is "+ avg);
        }
        
        
    }
}

/* Zambia
 * 17
 * Germany
 * 40
 * 20:51:00
 * 16
 * 21:51
 * 80.1964
 * 72.593
 * jan 23 2013
 * 19
 */