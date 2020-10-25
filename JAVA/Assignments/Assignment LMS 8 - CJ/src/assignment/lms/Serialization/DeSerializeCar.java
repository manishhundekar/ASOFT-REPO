package assignment.lms.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeCar {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("Cardata.ser");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Car car = (Car) ois.readObject();
		System.out.println("Car Make : " + car.getCarMake() + "\nCar Registration No : " + car.getRegistrationNo() + "\nCar Engine No : " +car.getEngine().getEngineNO() + "\nCar Cubic Capacity : " +car.getEngine().getCubicCapacity()  );
		ois.close();

	}

}
