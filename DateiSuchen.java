import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;
import java.util.*;
//Created by Kamron Soldozy 
public class DateiSuchen {
   public static File a;
   public static File[] b;
   public static String suchen;
    
   public static void main(String[] args) {
      
      System.out.println("Welche Datei suchen Sie? (Fügen Sie Erweiterungsname)");
      Scanner infile = new Scanner(System.in);
      suchen = (infile.nextLine());
      System.out.println("C:\\Users\\Kamron\\Documents");
      System.out.println("C:\\Users\\Kamron\\Downloads");
      System.out.println("C:\\Users\\Kamron\\Desktop");
      System.out.println("C:\\Users\\Kamron\\Desktop\\School");
      System.out.println("Was Verzeichnis? Entweder kopieren und von oben einfügen, oder das gleiche Format verwenden:");
      
      a = new File(infile.nextLine());
      b = a.listFiles();
      
      wiederkehren(b);
   
   
   }
   public static void wiederkehren(File[] array){
      try{
         Desktop desktop = Desktop.getDesktop();
         String prüfen=null;
         
         if(array!=null&&array.length!=0)
            for(int aa = 0; aa < array.length; aa++){
               //if(array[0].getParent()!=null){
              
               prüfen = (array[aa].getAbsolutePath().substring(array[aa].getAbsolutePath().lastIndexOf("\\")));
               prüfen=prüfen.substring(1);
               //}
               
               if(prüfen!=null){
                  if(prüfen.compareTo(suchen)==0){
                     desktop.open(array[aa].getAbsoluteFile());
                     System.out.println("Gefunden am : "+ array[aa].getAbsolutePath());
                     System.exit(0);
                  }}
            }
         if(array!=null&&array.length!=0)
            for(int z = 0; z < array.length; z++){
               System.out.println(array[z].getAbsolutePath());
               if(!array[z].isHidden()){
                  wiederkehren(array[z].listFiles());   
               }}
      }
      catch(IOException e){
         e.printStackTrace();
      }
   
   }
}