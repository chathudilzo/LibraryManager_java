import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int index;
	private String stuClass;
	
	Student(){
		name=null;
		index=0;
		stuClass=null;
	}
	
	Student(String name,int index,String stuClass){
		this.name=name;
		this.index=index;
		this.stuClass=stuClass;
	}
	
	@Override
	public String toString() {
		return "\nStudent Name:"+name+"\nIndex:"+index+"\nClass:"+stuClass;
	}
}
