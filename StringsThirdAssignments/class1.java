package StringsThirdAssignments;


/**
 * Write a description of class1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class class1 {
    /*public StorageResource findAbc(String input){
       int index = input.indexOf("abc");
       StorageResource s= new StorageResource();
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           s.add(found);
           index = input.indexOf("abc",index+3);
           
       }
       return s;
   } */
   public double cgRatio(String input){
       int i=0;
       int count=0;
       while(i< input.length()){
           if(input.charAt(i)=='C' || input.charAt(i)=='G'){
               count++;
            }
            i++;
        }
        int len= input.length();
        return (count*1.0)/ len;
    } 
   
    public int countCTG(String input){
        int curr= input.indexOf("CTG");
        int count=0;
        while(curr!=-1){
            count++;
            if(curr> input.length()-3){
                break;
            }
            curr= input.indexOf("CTG", curr+3);
        }
        return count;
    } 
    public void processGenes (StorageResource sr){
        int countlen=0, countcg=0;
        StorageResource cgs= new StorageResource();
        StorageResource len9= new StorageResource();
        
        String longest="";
        int len60=0;
        int i=0;
        for(String s : sr.data()){
            StorageResource genes= new StorageResource();
            if(s.length()>9){
                len9.add(s);
                countlen++;
            }
            if(cgRatio(s)>0.35){
                cgs.add(s);
                countcg++;
            }
            i++;
            System.out.println("Genes of " + s + " are");
            
            int start= s.indexOf("ATG");
            int first= s.indexOf("TAA", start+3);
            int sec= s.indexOf("TAG", start+3);
            int third= s.indexOf("TGA", start+3);
            int stop= Math.min(first, Math.min(sec, third));
            while(true){
                 first= s.indexOf("TAA", start+3);
                 sec= s.indexOf("TAG", start+3);
                 third= s.indexOf("TGA", start+3);
                stop= Math.min(first, Math.min(sec, third));
                if(start==-1|| start>s.length()-3|| stop==-1){
                    break;
                }
                else{
                    if((stop-start)%3==0){
                        String found= s.substring(start, stop+3);
                        if(found.length()> longest.length()){
                            longest= s;
                        }
                        genes.add(found);
                        if(found.length()>60){
                            len60++;
                        }
                    }
                   
                    
                }
                start= s.indexOf("ATG", stop+3);
                
            }
            int c=0;
            for(String str : genes.data()){
                System.out.println(str);
                c++;
            } 
            System.out.println("number of Gene Strings of " + i +"th dna:" + c);
            System.out.println("number of Gene Strings >60  :" + len60);
        }
        System.out.println("Strings of length >9");
        for(String str : len9.data()){
           System.out.println(str);
        }
        System.out.println("number of Strings of length >9 " + countlen);;
        System.out.println("Strings whose cg ratio >0.35");
        for(String str : cgs.data()){
           System.out.println(str);
        }
        System.out.println("number of Strings whose cg> 0.35 :" + countcg);
        System.out.println("Length of longest gene in sr " + longest.length());
        System.out.println("Longest gene string is : " + longest);
        
    }
   public void testProcessGenes(){
       //findAbc("abcd");
       StorageResource test= new StorageResource();
       FileResource fr = new FileResource("brca1line.fa");;
       String dna = fr.asString();
       dna= dna.toUpperCase();
       test.add(dna);
        processGenes(test);
        return;
       
   }
}
