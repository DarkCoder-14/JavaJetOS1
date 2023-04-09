import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class readwritetofiles 
{
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        try {
          System.out.println("Enter your filename: ");
          String filename;
          filename=sc.nextLine();  
          File myObj = new File(filename);
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
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
            File myObj = new File("filename.txt");
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
  }
}