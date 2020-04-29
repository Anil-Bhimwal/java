
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.lang.*;
public class WordPlay {
    
    public String emphasize(String phrase, char ch){
        StringBuilder input= new StringBuilder(phrase);
        for(int i=0;i<input.length();i++){
            if(Character.toLowerCase(input.charAt(i))==ch){
                if(i%2==0){
                    input.setCharAt(i, '*');
                }else{
                    input.setCharAt(i, '+');
                }
            }
        }
        return input.toString();
    }
    
    public String replaceVowels(String phrase, char ch){
        
        StringBuilder input= new StringBuilder(phrase);
        for(int i=0;i<input.length();i++){
            if(Character.toLowerCase(input.charAt(i))=='a'||Character.toLowerCase(input.charAt(i))=='e'||Character.toLowerCase(input.charAt(i))=='i'||Character.toLowerCase(input.charAt(i))=='o'||Character.toLowerCase(input.charAt(i))=='u'){
                input.setCharAt(i, ch);
            }
        }
        return input.toString();
    }
    
    public boolean isVowel(char  ch){
        char c= Character.toLowerCase(ch);
        if(c=='a'||c=='e'|| c=='i'|| c=='o'|| c=='u'){
            return true;
        }else{
            return false;
        }
    }
    
    public void testisVowel(){
        boolean ans= isVowel('F');
        System.out.println(ans);
    }
    
    public void testReplaceVowels(){
        String ans= replaceVowels("Hello World", '*');
        System.out.println(ans);
    } 
    
    public void testEmphasize(){
        String ans= emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(ans);
    } 
}
