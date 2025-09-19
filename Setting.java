
public class Setting {
	public enum Mode {
		OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
		private Sting value;
		
		Setting(String aValue){
			value = aValue;
		}
		
		public String toSting() {
			return value;
		}
	
	
	}
}
