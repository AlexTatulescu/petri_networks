package ace.ucv.petri_net;

import java.util.ArrayList;
import java.util.List;

public abstract class PetriNetwork {

	protected List<Transition> transitions;

	public void execute(String action) {

		List<Transition> validTransitions = new ArrayList<Transition>();

		for (int i = 0; i < transitions.size(); i++) {
			if (transitions.get(i).getTag().equals(action) && transitions.get(i).isValid()) {
				validTransitions.add(transitions.get(i));
			}
		}

		for (Transition transition : validTransitions) {
			transition.update();
		}
		
		messages(action);

	}

	public abstract void messages(String action);
}
