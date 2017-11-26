package ace.ucv.reader_writer_problem;

import java.util.Arrays;

import ace.ucv.petri_net.Arc;
import ace.ucv.petri_net.Direction;
import ace.ucv.petri_net.Location;
import ace.ucv.petri_net.PetriNetwork;
import ace.ucv.petri_net.Transition;

public class ReadWrite extends PetriNetwork {

	public ReadWrite() {
		Location idle = new Location("workers", 5);
		Location reading = new Location("reading", 0);
		Location writing = new Location("writing", 0);

		Arc idle_read_o = new Arc(1, idle, Direction.OUT);
		Arc idle_read_i = new Arc(1, reading, Direction.IN);

		Arc read_idle_o = new Arc(1, reading, Direction.OUT);
		Arc read_idle_i = new Arc(1, idle, Direction.IN);

		Arc idle_write_o = new Arc(5, idle, Direction.OUT);
		Arc idle_write_i = new Arc(1, writing, Direction.IN);

		Arc write_idle_o = new Arc(1, writing, Direction.OUT);
		Arc write_idle_i = new Arc(5, idle, Direction.IN);

		Transition startReading = new Transition(Arrays.asList(idle_read_o, idle_read_i), "startReading");
		Transition endReading = new Transition(Arrays.asList(read_idle_o, read_idle_i), "endReading");
		Transition startWriting = new Transition(Arrays.asList(idle_write_o, idle_write_i), "startWriting");
		Transition endWriting = new Transition(Arrays.asList(write_idle_o, write_idle_i), "endWriting");

		this.transitions = Arrays.asList(startReading, endReading, startWriting, endWriting);
	}

	@Override
	public void messages(String action) {

		switch (action) {
		case "startReading":
			System.out.println("Started reading");
			break;
		case "endReading":
			System.out.println("Stopped reading");
			break;
		case "startWriting":
			System.out.println("Started Writing");
			break;
		case "endWriting":
			System.out.println("Stopped Writing");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

	}

}
