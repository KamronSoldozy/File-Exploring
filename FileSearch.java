import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;
import java.util.*;

public class FileSearch {
   public static File a;
   public static File[] b;
   public static String search;
    
   public static void main(String[] args) {
      
      //try{ 
         /*URI uri = new URI("http://ksoldozy.me");
      
         Desktop desktop = Desktop.getDesktop();
         desktop.browse(uri);
         File x = new File("C:\\Users\\Kamron\\Desktop\\my fav table.pdf");
         File z = new File("C:\\Users\\Kamron\\Documents\\Credits.txt");
         desktop.open(x);
         desktop.open(z);
         */
      //}
        /*
      File x =new File("C:\\Users");
      File[] z = x.listFiles();
      for(int j = 0; j < z.length; j++)
         System.out.println(z[j]);
      File[] a = z[5].listFiles();
      for(int b = 0; b < a.length; b++)
         System.out.println(a[b]);
      */    
      /*
      catch (IOException ioe) {
         ioe.printStackTrace();
      } 
      catch (URISyntaxException use) {
         use.printStackTrace();
      }
      */
      
      
      
      
      System.out.println("What file are you looking for? (Include Extension name)");
      Scanner infile = new Scanner(System.in);
      search = (infile.nextLine());
      System.out.println("C:\\Users\\Kamron\\Documents");
      System.out.println("C:\\Users\\Kamron\\Downloads");
      System.out.println("C:\\Users\\Kamron\\Desktop");
      System.out.println("C:\\Users\\Kamron\\Desktop\\School");
      System.out.println("What directory? Either copy and paste from above, or use the same format:");
      
      a = new File(infile.nextLine());
      b = a.listFiles();
      
      recurs(b);
   
   
   }
   public static void recurs(File[] array){
      try{
         Desktop desktop = Desktop.getDesktop();
         String check=null;
         
         if(array!=null&&array.length!=0)
            for(int aa = 0; aa < array.length; aa++){
               if(array[0].getParent()!=null){
                  check = (array[aa].getAbsolutePath().substring(array[aa].getAbsolutePath().lastIndexOf("\\")));
                  check=check.substring(1);
               }
               if(check!=null){
                  if(check.compareTo(search)==0){
                     desktop.open(array[aa].getAbsoluteFile());
                     System.exit(0);
                  }}
            }
         if(array!=null&&array.length!=0)
            for(int z = 0; z < array.length; z++){
            
               recurs(array[z].listFiles());   
            }
      }
      catch(IOException e){
         e.printStackTrace();
      }
   
   }
}