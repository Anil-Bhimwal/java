
/**
 * Write a description of assignment2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    
    private String alphaCap;
    private String alpha;
    private String shiftedAlpha;
    private String shiftedAlphaCap;
    private int mainKey;
    public CaesarCipher(int key){
        mainKey= key;
        alphaCap= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alpha= "abcdefghijklmnopqrstuvwxyz";
        shiftedAlpha= alpha.substring(key)+ alpha.substring(0, key);
        shiftedAlphaCap= alphaCap.substring(key)+ alphaCap.substring(0, key);
    }
   /* public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted= new StringBuilder(input);
        for (int i=0;i<input.length();i++){
            char currChar= encrypted.charAt(i);
            String c= ""+ currChar;
            if(i%2==0){
                
               String  encChar= encrypt(c, key1);
               encrypted.setCharAt(i, encChar.charAt(0));
            }else{
               String encChar= encrypt(c, key2);
               encrypted.setCharAt(i, encChar.charAt(0));
            }
        }
        return encrypted.toString();
    }
    */
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

   
    public String encrypt(String input){
        StringBuilder encrypted= new StringBuilder(input);
        
        for(int i=0; i<encrypted.length();i++){
            char currChar= encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                //System.out.print(currChar);
                int idx= alpha.indexOf(currChar);
                if(idx!=-1){
                    char newChar= shiftedAlpha.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }else{
                int idx= alphaCap.indexOf(currChar);
                if(idx!=-1){
                    char newChar= shiftedAlphaCap.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
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
    public String decrypt(String encrypted){
         //CaesarCipher cc1 = new CaesarCipher(26 - mainKey );
         int key = getKey(encrypted);
         System.out.println("found key : " + key);
         CaesarCipher cc1= new CaesarCipher(26-key);
         return cc1.encrypt(encrypted);
    }
    
    public void testEncrypt(){
        String ans= encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println(ans);
    } 
    
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //CaesarCipher cc= new CaesarCipher(18);
        String encrypted = encrypt(message);
        System.out.println("encrypted string is "  + "\n" + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("decrypted string is "  + "\n" + decrypted);
    }
  /*  
    public void testEncryptTwoKeys(){
        String ans= encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
         System.out.println(ans);
    } */
}
