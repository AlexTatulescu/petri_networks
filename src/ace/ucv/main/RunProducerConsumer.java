package ace.ucv.main;

import ace.ucv.producer_consumer_problem.ProducerConsumer;

public class RunProducerConsumer {

	public static void main(String[] args) {
		ProducerConsumer machine = new ProducerConsumer();
		machine.execute("Produce");
		machine.execute("Push");
		machine.execute("Pop");
		machine.execute("Consume");
	}

}
