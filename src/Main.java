import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Main {

	public static void main(String[] args){
		/*try {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Account_Manager.ser"));
			Account_Manager am=(Account_Manager)in.readObject();
			am.construct();
			in.close();
		} 
	catch (ClassNotFoundException e) {
		System.out.println("SAVED FILE IS NOT FOUND");
	}
	catch (IOException e) {
		System.out.println("SOME ERROR IN INPUT OR OUTPUT");
	}*/
	Account_Manager am=new Account_Manager();
	am.construct();
	}
}