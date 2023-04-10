import java.awt.Desktop;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;  
import java.util.Scanner;

public class files 
{
    public static void main(String[] args) 
    {
            Scanner sc=new Scanner(System.in);
            int optionfile;
            System.out.println("Do you want to 1. Create a File or 2. Open a File\nEnter Option: ");
            optionfile=sc.nextInt();
            if(optionfile==1)
            {
                try  
                {
                    System.out.println("Enter your filename: ");
                    String filename;
                    filename=sc.nextLine();  
                    File myObj = new File(filename);
                    try
                    {
                    
                    if (myObj.createNewFile()) 
                    {
                        System.out.println("File created: " + myObj.getName());
                    } 
                    else 
                    {
                        System.out.println("File already exists.");
                    }
                    } 
                    catch (IOException e)
                    {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                    }
                    try 
                    {
                        FileWriter myWriter = new FileWriter(myObj);
                        System.out.println("Enter the text you want to save: ");
                        String text= sc.nextLine();
                        myWriter.write(text);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    System.out.println("Do you want to read the text you saved in your file: \n1.Yes\n2.No\nEnter Option No: ");
                    int readop;
                    readop=sc.nextInt();
                    if (readop==1)
                    {
                        try 
                        {
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) 
                            {
                            String data = myReader.nextLine();
                            System.out.println("\n\n"+data);
                            }
                            myReader.close();
                        }   
                        catch (FileNotFoundException e) 
                        {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        finally
                        {
                            System.out.println("finally1");
                        }
                    }
                    String openfilen;
                    if(optionfile==2)
                    {
                        System.out.println("Enter filename of file you want to open: ");
                        openfilen=sc.nextLine();
                        try  
                        { 
                        
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
                catch(Exception ex)
                {}
                finally
                {}
            }
        }
    }