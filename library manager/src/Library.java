import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable{
	
	private List<Book> collection;
	private List<Student> stuCollection;
	
	public Library() {
		collection=new ArrayList<Book>();
		stuCollection=new ArrayList<Student>();
	}
	
	public void addBook(Book book) {
		collection.add(book);
	}
	
	public void addStudent(Student student) {
		stuCollection.add(student);
	}
	
	public String getStudents() {
		StringBuilder students=new StringBuilder("\nAll Students:\n");
		
		for (Student student:stuCollection) {
			students.append(student).append("\n");
		}
		return students.toString();
		
	}
	
	public String getBooks() {
		StringBuilder books=new StringBuilder("\nAll Books:\n");
		
		for(Book book:collection) {
			books.append(book).append("\n");
		}
		return books.toString();
	}
	
	
	
	@Override
	public String toString() {
		
		return getBooks()+getStudents();
	}
}
