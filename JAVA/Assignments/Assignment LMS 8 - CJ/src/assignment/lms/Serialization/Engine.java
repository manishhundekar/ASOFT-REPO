package assignment.lms.Serialization;

import java.io.Serializable;

public class Engine implements Serializable{

	private transient String engineNO;
	private int cubicCapacity;
	
	public Engine(String engineNO, int cubicCapacity) {
		this.engineNO = engineNO;
		this.cubicCapacity = cubicCapacity;
	}

	public String getEngineNO() {
		return engineNO;
	}

	public void setEngineNO(String engineNO) {
		this.engineNO = engineNO;
	}

	public int getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}
	
	
	
}
