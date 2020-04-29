
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    public String findSimpleGene( String dna){
        int start= dna.indexOf("ATG");
        int stop= dna.indexOf("TAA", start+3);
        if(stop!= -1&& start!=-1){
            String result= dna.substring(start, stop);
            int length= result.length();
            if(length%3==0){
                return result;
            }
        }
        return "";
        
    }
    
    public void testSimpleGene(){
        String first= "AATGCCCTAACTAGATTAAGAAACC";
        String sec= "ATGGTGTGTGTGAAA";
        String third= "AAATGHGHFHFHWYTAA";
        String fourth= "TTATGAATAA";
        String fifth= "FGHFHJFDHJFDHJFD";
        String res1= findSimpleGene(first);
        System.out.println("answer" +res1);
        String res2= findSimpleGene(sec);
        System.out.println(res2);
        String res3= findSimpleGene(third);
        System.out.println(res3);
        String res4= findSimpleGene(fourth);
        System.out.println(res4);
        String res5= findSimpleGene(fifth);
        System.out.println(res5);
        
    }
}
