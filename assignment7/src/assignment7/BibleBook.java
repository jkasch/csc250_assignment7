package assignment7;

import java.io.File;
import java.util.Scanner;

public abstract class BibleBook {
	
	String book_type;
	String book;
    int chapters;
    
    public BibleBook (String book, int chapters, String book_type)
    {
        this.book = book;
        this.chapters = chapters;
        this.book_type = book_type;
    }
    public abstract void display();
    public int getChapters()
    {
       return chapters;
    }
    public String getBook()
    {
       return book;
    }
    public String getBook_Type()
    {
       return book_type;
    }    
}
    class MyMainClass{
    
    public static void main(String[] args)
	{
    	Gospel myGospel = new Gospel(); //Creates a Gospel object
    	Localchurches myLocalchurches = new Localchurches(); //Creates a Localchurches object
    	Pastoralepistles myPastoralepistles = new Pastoralepistles(); //Creates a Pastoralepistles object
    	Generalepistles myGeneralepistles = new Generalepistles(); //Creates a Generalepistles object
    	BibleBook[] bookArr = new BibleBook[100];
        int count=0;{
    	try
    	{
    		Scanner fileIn = new Scanner(new File(System.getProperty("user.dir") + "/src/assignment7/inputfile.dat"));
    		while(fileIn.hasNext())
    		{
    			String line = fileIn.nextLine();
    			String array[] = line.split(":");
    			
    				String book_type = array[0];
    				String book = array[1];
    				int chapters = Integer.parseInt(array[2]);
    				BibleBook b=new BibleBook(book_type,book,chapters);
                    bookArr[count++] = b;
    		System.out.print(bookArr);
    		}
    		fileIn.close();
    	}
    	catch(Exception e)
    	{
    	System.err.println(e.toString());}
    	}
        for(int i = 0; i < count; i=i+3){
        	if(book_type.equals("Gospel")) {
            	myGospel.display();
            }
            else if (book_type.equals("Localchurches")) {
            	myLocalchurches.display();
            }
            else if (book_type.equals("Pastoralepistles")) {
            	myPastoralepistles.display();   
            }
            else {
            	myGeneralepistles.display();
            }
        	System.out.println("Book name: " + book + "(" + chapters + " chapters)");
            }
	}
    
}
