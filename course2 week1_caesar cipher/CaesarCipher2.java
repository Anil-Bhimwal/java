
/**
 * Write a description of caesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher2 {
    private String alpha;
    private String shiftedAlpha1;
    private String shiftedAlpha2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipher2(int key1, int key2){
        mainKey1= key1;
        mainKey2= key2;
        alpha= "abcdefghijklmnopqrstuvwxyz";
        shiftedAlpha1= alpha.substring(key2)+ alpha.substring(0, key1);
        shiftedAlpha2= alpha.substring(key2)+ alpha.substring(0, key2);
    }
    
    public String encryptTwoKeys(String input){
        StringBuilder encrypted= new StringBuilder(input);
        CaesarCipher cc1= new CaesarCipher(mainKey1);
        CaesarCipher cc2= new CaesarCipher(mainKey2);
        for (int i=0;i<input.length();i++){
            char currChar= encrypted.charAt(i);
            String c= ""+ currChar;
            if(i%2==0){
               String  encChar= cc1.encrypt(c);
               encrypted.setCharAt(i, encChar.charAt(0));
            }else{
               String encChar= cc2.encrypt(c);
               encrypted.setCharAt(i, encChar.charAt(0));
            }
        }
        return encrypted.toString();
    }
    public int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;
        
        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }

    public int getKey(String e_message){
       int[] freqs = countLetters(e_message);
       int maxDex = maxIndex(freqs);
       int dkey = maxDex-4;
       if (maxDex < 4) {
           dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    
    public String halfOfString(String message, int start){
       String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }
    
    
    public String decrypt(String encrypted){
       
       
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       StringBuilder theAnswer = new StringBuilder(encrypted);
       int key1=getKey(message1);
       int key2=getKey(message2);
       CaesarCipher cc1 = new CaesarCipher(26-key1);
       CaesarCipher cc2 = new CaesarCipher(26-key2);
       String d_message1=cc1.encrypt(message1);
       String d_message2=cc2.encrypt(message2);
       
       //build up the final answer
       
       for (int k=0; k<(message1.length());k++){
           theAnswer.setCharAt((2*k), d_message1.charAt(k) );
           }
           
       for (int k=0; k<(message2.length());k++){
           theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
           }
           
       System.out.println(key1+" "+key2+" " + theAnswer.toString());    
        
    
       return theAnswer.toString();
    }
    
    public void simpleTest(){
        FileResource fr= new FileResource();
        String input= fr.asString();
        String encrypted= encryptTwoKeys(input);
        System.out.println("Encrypted string: "+ encrypted);
        String decrypted= decrypt(encrypted);
        System.out.println("Decrypted string: "+ decrypted);
    }
}
