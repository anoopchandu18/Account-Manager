import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {

	public static void main(String[] args){
		try {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Account_Manager.ser"));
			Account_Manager am=(Account_Manager)in.readObject();
			am.construct();
			in.close();
		} 
	catch (ClassNotFoundException e) {
		System.out.println("class not found exception");
	}
	catch (IOException e) {
		System.out.println("io exception");
	}
	//Account_Manager am=new Account_Manager();
	//am.construct();
	}
}