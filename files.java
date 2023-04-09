import java.awt.Desktop;  
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
  // Import the IOException class to handle errors
import java.io.IOException;



public class files 
{
    

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.println("Do you want Open a file or Create a file. \nEnter 1 for Open and 2 for Creating. \nEnter:  ");
        int fileopc;
        fileopc=sc.nextInt();
        if(fileopc==2)
        {
        
            System.out.println("Enter your filename: ");
              String filename;
              filename=sc.nextLine();  
              File myObj = new File(filename);
            try {
              
              if (myObj.createNewFile()) 
              {
                System.out.println("File created: " + myObj.getName());
              } 
              else 
              {
                System.out.println("File already exists.");
              }
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(myObj);
                System.out.println("Enter the text you want to save: ");
                String text= sc.nextLine();
                myWriter.write(text);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();}
            System.out.println("Do you want to read the text you saved in your file: \n1.Yes\n2.No\nEnter Option No: ");
            int readop;
            readop=sc.nextInt();
            if (readop==1)
              {
              try {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  System.out.println("\n\n"+data);
                }
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
            }
        }
        if(fileopc==1)
        {
            try  
            {  
            //constructor of file class having file as argument
            System.out.println("Enter filename of file you want to open: ");
            String openfilen;
            openfilen=sc.nextLine();
            File file = new File(openfilen);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
            System.out.println("not supported");  
            return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         //checks file exists or not  
            desktop.open(file);              //opens the specified file  
            }  
            catch(Exception e)  
            {  
            e.printStackTrace();  
            }
        }
    }
    
  }
}
