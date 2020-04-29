 


/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords= new ArrayList<String>();
        myFreqs= new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr= new FileResource();
        for(String s : fr.words()){
            s= s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index==-1){
                myWords.add(s);
                myFreqs.add(1);
            
            }else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int maximum=myFreqs.get(0);
        int maxIndex=0;
        for(int i=1;i<myWords.size();i++){
            if(maximum< myFreqs.get(i)){
                maximum= myFreqs.get(i);
                maxIndex= i;
            }
        }
        return maxIndex;
        
    }
    
    
    
    public void tester(){
        findUnique();
        
        for(int i=0;i<myWords.size();i++){
            System.out.println("\""+myWords.get(i)+"\""+ " occurs " + myFreqs.get(i) + " times");
        }
        
        System.out.println("Total unique words : "+ myWords.size());
        int index= findIndexOfMax();
        System.out.println("\""+ myWords.get(index)+"\"" + " occurs maximum times i.e, " + myFreqs.get(index) );
    }
    
    
    
    
}
