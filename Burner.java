import Setting.java


public enum Temperature{
	COLD("Is this thing working?"), WARM("Not quite ready to cook"), HOT("Now were cooking"), 
	BLAZING("ABLAZING, DO NOT TOUCH");
	private String value;
	
	
	Setting(String aValue){
		value = aValue;
	}
	
	public String toSting() {
		return value;
	}
}

public class Burner {
	//needs a constructor, plusButton(), minusButton, need TIME_DURATION, updateTemperature, display
	//variables that will be needed
	protected Stting.Mode mySetting;
	protected Temperature myTemperature;
	int timePassed = 0;
	const int TIME_DURATION = 2;
	
	//constructor
	public Burner{
		//set Setting to off, and temp to cold
		this.mySetting = Setting.OFF;
		this.myTemperature = Temperature.COLD;
	}//end of constructor
	
	//increas temp
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
			case LOW:
				mySetting = Setting.MEDIUM;
			case MEDIUM:
				mySetting = Setting.HIGH;
			case HIGH:
		}//end of switch
		
	}//end of class plusButton 
	
	//decrease setting
	public void minusButton() {
		switch(mySetting) {
			case HIGH:
				mySetting = Setting.MEDIUM;
			case MEDIUM:
				mySetting = Setting.LOW;
			case LOW:
				mySetting = Setting.OFF;
			case OFF:
		}//end of switch
	}//end of minusButton
	
	void updateTemperature(){
		if (timePassed == timeDuration) {
			timePassed = 0;
			switch(mySetting) {
				case OFF:
					//check to see if the heat neede to be increased or decreased
					if (mySetting.ordinal() > Setting.OFF.ordinal()) {
						myTemperature = Temperature.WARM;
					}
				case LOW:
					if (mySetting.ordinal() > Setting.LOW.ordinal()) {
						myTemperature = Temperature.HOT;
					}
					else if(mySetting.ordinal() < Setting.OFF.ordinal()) {
						myTemperature = Temperature.COLD;
					}
				case MEDIUM:
					if (mySetting.ordinal() > Setting.OFF.ordinal()) {
						myTemperature = Temperature.BLAZING;
					}
					else if(mySetting.ordinal() < Setting.OFF.ordinal()){
						myTemperature = Temperature.WARM;
					}
				case HIGH:
					if (mySetting.ordinal() < Setting.Mode.ordinal()) {
						myTemperature = Temperature.HOT;
					}
			}//end of swithc
		}///end of if time == 2
		else {
			timePassed ++;
		}
	}// end of updateTemperature
	
	
}//end of class decloration 
