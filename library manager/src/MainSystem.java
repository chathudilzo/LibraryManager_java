import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSystem {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			try {
				System.out.println("\nEnter 0 for load the Library" 
						+ "\nEnter 1 for save and quit"
						+ "\nEnter 2 for list all books and students in library" 
						+ "\nEnter 3 for add book to library "
						+ "\nEnter 4 for add student to the library"
						+ "\nEnter 5 for get all books"
						+ "\nEnter 6 for get all students");
				int answer=in.nextInt();
				
				switch(answer) {
				case 0:
					System.out.println("Enetr the library name to load");
					fileName=in.next();
					loadScript(fileName);
					break;
				case 1:
					saveAndQuit();
					
					break;
				case 2:
					System.out.println(lib.toString());
					break;
				case 3:
					addBook();
					break;
				default:
					
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Invalid Input!");
				break;
			}
			
				
				
			
			
			
		}
		System.exit(0);
	}

	private static void addBook() {
		int isbn;
		String title,author;
		double price;
		
		System.out.println("\n Enetr Book Title");
		title=in.next();
		
		System.out.println("\n Enetr Book Author");
		author=in.next();
		
		System.out.println("\n Enetr Book Isbn");
		isbn=in.nextInt();
		
		System.out.println("\n Enetr Book Price");
		price=in.nextDouble();
		
		Book b=new Book(isbn, author, author, price);
		
		lib.addBook(b);
		
		
	}

	private static void saveAndQuit() {
		System.out.println("Enetr file name");
		fileName=in.next()+".ser";
		running=false;
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		try {
			fos=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void loadScript(String fileName) {
		FileInputStream fis=null;
		ObjectInputStream in=null;
		File file=new File(fileName+".ser");
		
		if(file.exists()) {
			try {
				fis=new FileInputStream(file);
				in=new ObjectInputStream(fis);
				
				lib=(Library)in.readObject();
				fis.close();
				in.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("\nFile does not exists!");
		}
		
	}
}
