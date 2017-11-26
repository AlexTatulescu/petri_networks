package ace.ucv.coffe_machine;

import java.util.Arrays;

import ace.ucv.petri_net.Arc;
import ace.ucv.petri_net.Direction;
import ace.ucv.petri_net.Location;
import ace.ucv.petri_net.PetriNetwork;
import ace.ucv.petri_net.Transition;

public class CoffeMachine extends PetriNetwork {
	public CoffeMachine() {
		Location location0 = new Location("0", 1);
		Location location5 = new Location("5", 0);
		Location location10 = new Location("10", 0);
		Location location15 = new Location("15", 0);

		Arc arc05o = new Arc(1, location0, Direction.OUT);
		Arc arc05i = new Arc(1, location5, Direction.IN);

		Arc arc010o = new Arc(1, location0, Direction.OUT);
		Arc arc010i = new Arc(1, location10, Direction.IN);

		Arc arc510o = new Arc(1, location5, Direction.OUT);
		Arc arc510i = new Arc(1, location10, Direction.IN);

		Arc arc515o = new Arc(1, location5, Direction.OUT);
		Arc arc515i = new Arc(1, location15, Direction.IN);

		Arc arc1015o = new Arc(1, location10, Direction.OUT);
		Arc arc1015i = new Arc(1, location15, Direction.IN);

		Arc arc100o = new Arc(1, location10, Direction.OUT);
		Arc arc100i = new Arc(1, location0, Direction.IN);

		Arc arc155o = new Arc(1, location15, Direction.OUT);
		Arc arc155i = new Arc(1, location5, Direction.IN);

		Arc arc150o = new Arc(1, location15, Direction.OUT);
		Arc arc150i = new Arc(1, location0, Direction.IN);

		Transition transition_0_5_5 = new Transition(Arrays.asList(arc05o, arc05i), "5");
		Transition transition_0_10_10 = new Transition(Arrays.asList(arc010o, arc010i), "10");
		Transition transition_5_5_10 = new Transition(Arrays.asList(arc510o, arc510i), "5");
		Transition transition_5_10_15 = new Transition(Arrays.asList(arc515o, arc515i), "10");
		Transition transition_10_5_15 = new Transition(Arrays.asList(arc1015o, arc1015i), "5");
		Transition transition_10_c10_0 = new Transition(Arrays.asList(arc100o, arc100i), "c10");
		Transition transition_15_c10_5 = new Transition(Arrays.asList(arc155o, arc155i), "c10");
		Transition transition_15_c15_0 = new Transition(Arrays.asList(arc150o, arc150i), "c15");

		this.transitions = Arrays.asList(transition_0_5_5, transition_0_10_10, transition_5_5_10, transition_5_10_15,
				transition_10_5_15, transition_10_c10_0, transition_15_c10_5, transition_15_c15_0);
	}

	@Override
	public void messages(String action) {

		switch (action) {
		case "c10":
			System.out.println("Am dat o cafea la 10 lei");
			break;
		case "c15":
			System.out.println("Am dat o cafea la 15 lei");
			break;
		case "5":
			System.out.println("Am primit 5 lei");
			break;
		case "10":
			System.out.println("Am primit 10 lei");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

}
