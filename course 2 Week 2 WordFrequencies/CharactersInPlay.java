/*checkpoint*/ 


/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> freqs;
    public CharactersInPlay(){
        characters = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index= characters.indexOf(person);
        if(index==-1){
            characters.add(person);
            freqs.add(1);
        }else{
            int value= freqs.get(index);
            freqs.set(index, value+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr= new FileResource();
        for(String line : fr.lines()){
            int key = line.indexOf(".");
            if(key!= -1){
                String name= line.substring(0, key);
                update(name);
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        for(int i=0;i< characters.size();i++){
            if (freqs.get(i) > 1){
                System.out.println("\""+ characters.get(i)+"\"" + " : " + freqs.get(i));
            }
        }
            
    }
    /*Write a void method called charactersWithNumParts that has two int 
     * parameters named num1 and num2, where you can assume num1 
     * should be less than or equal to num2.
     * This method should print out the names of all those 
     * characters that have exactly number speaking parts, 
     * where number is greater than or 
     *equal to num1 and less than or equal to num2.
     *Add code in tester to test this method out.*/
    public void charactersWithNumParts(int num1, int num2){//num1<num2
        for(int i=0;i< characters.size();i++){
            if(freqs.get(i)>=num1 && freqs.get(i)<=num2){
                System.out.println("\""+ characters.get(i)+"\"" + " : " + freqs.get(i));
            }
            
                
        }
    }
}
