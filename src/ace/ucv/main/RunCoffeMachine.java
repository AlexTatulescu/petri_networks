package ace.ucv.main;

import ace.ucv.coffe_machine.CoffeMachine;

public class RunCoffeMachine {
	public static void main(String[] args) {
		CoffeMachine coffeMachine = new CoffeMachine();
		coffeMachine.execute("5");
		coffeMachine.execute("5");
		coffeMachine.execute("c10");
	}
}
