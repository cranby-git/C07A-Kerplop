

public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private Sting value;
	
	Setting(String aValue){
		value = aValue;
	}
	
	public String toSting() {
		return value;
	}


}
