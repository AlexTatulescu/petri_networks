package ace.ucv.petri_net;

public class Arc {

	private Integer capacity;
	private Location location;
	private String direction;

	public Arc(Integer capacity, Location location, String direction) {
		this.capacity = capacity;
		this.location = location;
		this.direction = direction;
	}

	public boolean isValid() {

		if (direction.equals(Direction.OUT)) {
			return true;
		}

		if (direction.equals(Direction.IN) && capacity <= location.getTokens()) {
			return true;
		}

		return false;
	}

	public void update() {

		if (direction.equals(Direction.IN)) {
			location.addTokens(capacity);
			return;
		}

		location.substractTokens(capacity);
	}
}
