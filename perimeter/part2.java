
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public String findSimpleGene( String dna, int s, int e){
        int start= dna.indexOf("ATG",s);
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
        String first= "ATTTTTSGASATAA";
        String sec= "ATGGTGTGTGTGAAA";
        String third= "AAATGHGHFHFHWYTAA";
        String fourth= "TTATGAATAA";
        String fifth= "FGHFHJFDHJFDHJFD";
        String res1= findSimpleGene(first, 0, first.length());
        System.out.println(res1);
        String res2= findSimpleGene(sec,0, sec.length());
        System.out.println(res2);
        String res3= findSimpleGene(third, 0, third.length());
        System.out.println(res3);
        String res4= findSimpleGene(fourth,0, fourth.length());
        System.out.println(res4);
        String res5= findSimpleGene(fifth, 0, fifth.length());
        System.out.println(res5);
        
    }
}
