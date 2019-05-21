import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

//Denna klass ärver Global så att man kan använda time och signalnamnen utan punktnotation
//It inherits Proc so that we can use time and the signal names without dot notation

;

public class MainSimulation2 extends Global{
	
	private static int no_sensors;
	private static int t_p;
	private static int radius;
	private static int size_x;
	private static int size_y;

    public static void main(String[] args) throws IOException {
    	getParams("C:\\Users\\Jesper\\eclipse-workspace\\Assignment 2.1\\Parameters\\params.txt");
    	Sensor[] sensors = new Sensor[no_sensors];
    	Random rand = new Random();
    	for(int i = 0; i < no_sensors; i++) {
    		double x = rand.nextDouble()*size_x;
    		double y = rand.nextDouble()*size_y;
    		Sensor s = new Sensor(x, y);
    		s.insertSensor(sensors, i);
    	}
    	
    	
    	/*//Signallistan startas och actSignal deklareras. actSignal är den senast utplockade signalen i huvudloopen nedan.
    	// The signal list is started and actSignal is declaree. actSignal is the latest signal that has been fetched from the 
    	// signal list in the main loop below.

    	Signal actSignal;
    	new SignalList();

    	//Här nedan skapas de processinstanser som behövs och parametrar i dem ges värden.
    	// Here process instances are created (two queues and one generator) and their parameters are given values. 

    	QS Q1 = new QS();
    	Q1.sendTo = null;

    	Gen Generator = new Gen();
    	Generator.lambda = 9; //Generator ska generera nio kunder per sekund  //Generator shall generate 9 customers per second
    	Generator.sendTo = Q1; //De genererade kunderna ska skickas till kösystemet QS  // The generated customers shall be sent to Q1

    	//Här nedan skickas de första signalerna för att simuleringen ska komma igång.
    	//To start the simulation the first signals are put in the signal list

    	SignalList.SendSignal(READY, Generator, time);
    	SignalList.SendSignal(MEASURE, Q1, time);


    	// Detta är simuleringsloopen:
    	// This is the main loop

    	while (time < 100000){
    		actSignal = SignalList.FetchSignal();
    		time = actSignal.arrivalTime;
    		actSignal.destination.TreatSignal(actSignal);
    	}

    	//Slutligen skrivs resultatet av simuleringen ut nedan:
    	//Finally the result of the simulation is printed below:

    	System.out.println("Mean number of customers in queuing system: " + 1.0*Q1.accumulated/Q1.noMeasurements);*/

    }

	private static void getParams(String fileName) throws IOException {
	    Path path = Paths.get(fileName);
	    Scanner scanner = new Scanner(path);
	    Pattern p = Pattern.compile("[0-9]+");
	    System.out.println("Read text file using Scanner");
	    //read line by line
	    int i = 1;
	    while(scanner.hasNextLine()){
	        //process each line
	    	String line = scanner.nextLine();
	    	Matcher m = p.matcher(line);
	    	if(m.find()) {
		    	String valueString = m.group();
			    int value = Integer.parseInt(valueString);
			    
			    switch(i) {
			    	case 1: {
			    		no_sensors = value;
			    	}
			    	case 2: {
			    		t_p = value;
			    	}
			    	case 3: {
			    		radius = value;
			    	}
			    	case 4: {
			    		size_x = value;
			    	}
			    	case 5: {
			    		size_y = value;
			    	}
			    }
		    	i++;
	    	}
	    }
	    scanner.close();
	}
}