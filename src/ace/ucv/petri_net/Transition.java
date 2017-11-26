package ace.ucv.petri_net;

import java.util.List;

public class Transition {

	private List<Arc> arcs;
	private String tag;

	public Transition(List<Arc> arcs, String tag) {
		this.arcs = arcs;
		this.tag = tag;
	}

	public boolean isValid() {
		for (Arc arc : arcs) {
			if (!arc.isValid()) {
				return false;
			}
		}

		return true;
	}

	public void update() {
		if (!isValid()) {
			return;
		}

		for (Arc arc : arcs) {
			arc.update();
		}
	}

	public String getTag() {
		return tag;
	}

}
