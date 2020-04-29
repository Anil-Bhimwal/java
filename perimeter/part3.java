
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.net.*;
import java.io.*;
public class part3 {
    public void func() throws Exception {
        URL url = new URL("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        BufferedReader read = new BufferedReader(
        new InputStreamReader(url.openStream()));
        String i;
        System.out.println("Answers: ");
        while ((i = read.readLine()) != null)
        {
              
              if(i.toLowerCase().indexOf("youtube.com")!=-1){
                  int start= i.indexOf("\"");
                  int end= i. lastIndexOf("\"", i.length()); 
                  System.out.println(i.substring(start+1, end));
              }
        }
          
        read.close();
    }
}

