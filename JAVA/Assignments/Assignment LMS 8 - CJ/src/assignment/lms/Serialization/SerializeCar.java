package assignment.lms.Serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCar {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Car car = new Car("KA38S8133" , "Suzuki" , new Engine("AMD1425" , 500));
		File file = new File("Cardata.ser");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(car);
		oos.close();
	}

}
