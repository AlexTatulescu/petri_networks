package ace.ucv.producer_consumer_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ace.ucv.petri_net.Arc;
import ace.ucv.petri_net.Direction;
import ace.ucv.petri_net.Location;
import ace.ucv.petri_net.PetriNetwork;
import ace.ucv.petri_net.Transition;

public class ProducerConsumer extends PetriNetwork {

	public ProducerConsumer() {
		Location producer = new Location("P", 5);
		Location consumer = new Location("C", 7);
		Location prodDataReady = new Location("PDR", 0);
		Location consDataReady = new Location("CDR", 0);
		Location freePositions = new Location("FREE", 4);
		Location occupiedPositions = new Location("FULL", 0);
		Location mutex = new Location("MUTEX", 1);

		List<Transition> producerConsumerTransitions = new ArrayList<>();

		Arc prod_o = new Arc(1, producer, Direction.OUT);
		Arc p_data_i = new Arc(1, prodDataReady, Direction.IN);
		Arc p_data_o = new Arc(1, prodDataReady, Direction.OUT);
		Arc prod_i = new Arc(1, producer, Direction.IN);
		Arc free_o = new Arc(1, freePositions, Direction.OUT);
		Arc free_i = new Arc(1, freePositions, Direction.IN);
		Arc mutex_o = new Arc(1, mutex, Direction.OUT);
		Arc mutex_i = new Arc(1, mutex, Direction.IN);
		Arc full_i = new Arc(1, occupiedPositions, Direction.IN);
		Arc full_o = new Arc(1, occupiedPositions, Direction.OUT);
		Arc cons_o = new Arc(1, consumer, Direction.OUT);
		Arc cons_i = new Arc(1, consumer, Direction.IN);
		Arc c_data_i = new Arc(1, consDataReady, Direction.IN);
		Arc c_data_o = new Arc(1, consDataReady, Direction.OUT);

		List<Arc> pushArcs = new ArrayList<>();
		pushArcs.add(p_data_o);
		pushArcs.add(free_o);
		pushArcs.add(mutex_o);
		pushArcs.add(prod_i);
		pushArcs.add(full_i);
		pushArcs.add(mutex_i);
		producerConsumerTransitions.add(new Transition(pushArcs, "push"));

		List<Arc> popArcs = new ArrayList<>();
		popArcs.add(full_o);
		popArcs.add(mutex_o);
		popArcs.add(cons_o);
		popArcs.add(c_data_i);
		popArcs.add(free_i);
		popArcs.add(mutex_i);
		producerConsumerTransitions.add(new Transition(popArcs, "pop"));

		Transition produce = new Transition(Arrays.asList(prod_o, p_data_i), "produce");
		Transition consume = new Transition(Arrays.asList(c_data_o, cons_i), "consume");
		producerConsumerTransitions.add(produce);
		producerConsumerTransitions.add(consume);

		this.transitions = producerConsumerTransitions;

	}

	@Override
	public void messages(String action) {
		System.out.println(action);
	}

}
