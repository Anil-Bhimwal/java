
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
    
    public int getTotalBirthsRankedHigher(int year , String name , String gender){
        String fileName= "C:/Users/HP/Desktop/java/BabyBirth week 4/us_babynames_by_year/yob"+ year+".csv";
        FileResource fr= new FileResource(fileName);
        CSVParser parser= fr.getCSVParser(false);
        //CSVRecord answer= null;
        //base case : if name is not present in the file
        int rank = getRank(year, name , gender);
        if(rank==-1){
            return -1;
        }
        int total =0;
        for(CSVRecord r : parser){
            if(r.get(0).equals(name) && r.get(1).equals(gender)){
               return total;
            }else if(r.get(1).equals(gender)){
                int numBirth = Integer.parseInt(r.get(2));
                total += numBirth;
            }
        }
        return total;
    }
    
    public double getAverageRank(String name, String gender){
        DirectoryResource dr= new DirectoryResource();
        double sum=0;
        int count =0;
        for(File f : dr.selectedFiles() ){
            FileResource fr= new FileResource(f);
            CSVParser parser= fr.getCSVParser();
            int currYear=Integer.parseInt(f.getName().substring(3,7));
            int rank = getRank(currYear, name , gender);
            sum+= rank;
            count++;
            
        }
        return count==0 ? -1: sum/count;
    }
    
    public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr= new DirectoryResource();
        int year= -1;
        int highestRank= -1;
        for(File f : dr.selectedFiles() ){
            FileResource fr= new FileResource(f);
            CSVParser parser= fr.getCSVParser();
            int currYear=Integer.parseInt(f.getName().substring(3,7));
            int rank = getRank(currYear, name , gender);
            //System.out.println(currYear + " "+rank);
            if(rank==-1){
                return -1;
            }
            if(highestRank< rank){
                year = currYear;
                highestRank= rank;
            }
            
        }
        return year;
        
    }
    
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + "  born in " + year + " would be "+ newName + " if born in "+ newYear);
        
    }
    
    public String getName(int year, int rank, String gender){
       String fileName= "C:/Users/HP/Desktop/java/BabyBirth week 4/us_babynames_by_year/yob"+ year+".csv";
        FileResource fr= new FileResource(fileName);
        CSVParser parser= fr.getCSVParser(false);
        int count =1;
        if(rank==-1){
            return "NO NAME";
        }
        for(CSVRecord r : parser){
            if(r.get(1).equals(gender)&& count== rank){
                return r.get(0);
                
            }
            else if(r.get(1).equals(gender))count++;
        }
        return "NO NAME";
    }
    
    
    public int getRank(int year, String name, String gender){
        String fileName= "C:/Users/HP/Desktop/java/BabyBirth week 4/us_babynames_by_year/yob"+ year+".csv";
        FileResource fr= new FileResource(fileName);
        CSVParser parser= fr.getCSVParser(false);
        //CSVRecord answer= null;
        int rank =1;
        boolean flag=false;
        for(CSVRecord r : parser){
            if(r.get(0).equals(name) && r.get(1).equals(gender)){
               flag = true;
            }else if(r.get(1).equals(gender)&&flag== false){
                rank++;
            }
        }
        if(flag){
            return rank;
        }
        else
        return -1;
        /*if(answer==null){
            return -1;
        }
        
        parser= fr.getCSVParser(false);
        for(CSVRecord r : parser){
            if( r.get(1).equals(gender) && Integer.parseInt(r.get(2))> Integer.parseInt(answer.get(2))){
                rank++;
            }
        }*/
        
    }
    
    
    
    /* Modify the method totalBirths (shown in the video for this 
     * project) to also print the number of girls names , 
     the number of boys names and the total names in the file.*/
    public void totalBirths(){
        int totalGNames=0;
        int totalBNames= 0;
        int totalBirths=0;
        int totalNames=0;
        FileResource fr= new FileResource();
        for(CSVRecord r : fr.getCSVParser(false)){
            int numbirth= Integer.parseInt(r.get(2));
            totalBirths+= numbirth;
            if((r.get(1)).equals("F")){
                totalGNames+=1;
            }else{
                totalBNames+=1;
            }
            totalNames++;
            
        }
        System.out.println("Total Births : "+ totalBirths + ", Total Names : "+ totalNames + ", Toatal girls Names : "+totalGNames + ", Total Boys Names : "+ totalBNames);
        
    }
    
    
    public void testGetRank(){
        int rank = getRank(1971, "Frank", "M");
        System.out.println("Rank for Emily is : "+ rank );
    } 
    
    public void testGetName(){
        String name = getName(1982, 450, "M");
        System.out.println("Name at Rank is : "+ name);
    }
    
    public void testwhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public void testyearOfHighestRank(){
        int year = yearOfHighestRank("Genevieve", "F");
        System.out.println(year +" is the year of highest rank");
    }
    
    public void testgetAverageRank(){
        double avg= getAverageRank("Robert", "M");
        System.out.println("Average of multiple files rank : "+ avg); 
    }
    
    public void testgetTotalBirthsRankedHigher(){
        int totalBirth= getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println("Total births ranked higher : "+ totalBirth); 
    }
}
