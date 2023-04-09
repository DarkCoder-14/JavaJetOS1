import java.awt.Desktop;  
import java.io.*;  
import java.util.Scanner;

public class openfiles  
{  
public static void main(String[] args)   
{  
    Scanner sc=new Scanner(System.in);
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