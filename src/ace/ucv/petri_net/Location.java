package ace.ucv.petri_net;

public class Location {

	private String tag;
	private Integer tokens;

	public Location(String tag, Integer tokens) {
		this.tag = tag;
		this.tokens = tokens;
	}

	public void addTokens(int tokens) {
		this.tokens = tokens;
	}

	public void substractTokens(int tokens) {
		this.tokens -= tokens;
	}

	public Integer getTokens() {
		return tokens;
	}

	public void setTokens(Integer tokens) {
		this.tokens = tokens;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
