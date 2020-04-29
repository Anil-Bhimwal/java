
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    public void countWordLengths(FileResource fr, int[] counts){
        for(String word : fr.words()){
            int len= word.length();
            if(Character.isLetter(word.charAt(0))==true&& Character.isLetter(word.charAt(word.length()-1))==true){
                if(len>=30){
                    counts[30]+=1;
                }else{
                    counts[len]+=1;
                }
                
            }else if(Character.isLetter(word.charAt(0))==true&& Character.isLetter(word.charAt(word.length()-1))!=true){
                if(len-1>=30){
                    counts[30]+=1;
                }else{
                    if(len-2>=0)
                    counts[len-1]+=1;
                }
            }else if(Character.isLetter(word.charAt(0))!=true&& Character.isLetter(word.charAt(word.length()-1))!=true){
                if(len-2>=30){
                    counts[30]+=1;
                }else{
                    if(len-2>=0)
                        counts[len-2]+=1;
                }
            }
        }
    } 
    
     public int indexOfMax(int[] values){
        int maximum= values[0];
        for(int i=0;i<31;i++){
            if(values[i]>maximum){
                maximum= values[i];
            }
        }
        return maximum;
     }
    
    public void testCountWordLengths(){
        FileResource fr= new FileResource();
        int []counts= new int[31];
        countWordLengths(fr, counts);
        
        for(int i=1;i<31;i++){
            if(counts[i]>0)
                System.out.println("total words of length "+ i +" are : "+ counts[i] );
        }  
    }
    
   
}
