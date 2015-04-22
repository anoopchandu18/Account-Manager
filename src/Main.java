import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {

	public static void main(String[] args){
		Account_Manager am;
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("Account_Manager.ser"));
			am=(Account_Manager)in.readObject();
			am.construct();
			in.close();
		} 
		catch (ClassNotFoundException e) {
			System.out.println("class not found exception");
		}
		catch (IOException e) {
			System.out.println("io exception");
			am=new Account_Manager();
			am.construct();
		}
	}
}
