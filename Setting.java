
public enum Setting {
	OFF("Off"), LOW("Low"), MEDIUM("Medium"), HIGH("High");
	private Sting value;
	
	Setting(String aValue){
		value = aValue;
	}
	
	public String toSting() {
		return value;
	}


}
