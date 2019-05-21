
public class Sensor {
	public double xCoord;
	public double yCoord;
	
	Sensor(double x, double y){
		xCoord = x;
		yCoord = y;
	}
	
	public void insertSensor(Sensor[] sensors, int i) {
		sensors[i] = this;
	}
}
