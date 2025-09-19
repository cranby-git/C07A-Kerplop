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
	package Stting.Mode mySetting;
	package Temperature myTemperature;
	const int TIME_DURATION = 2;
	
	//constructor
	public Burner{
		//set Setting to off, and temp to cold
		this.mySetting = Setting.Mode.OFF;
		this.myTemperature = Temperature.COLD;
	}//end of constructor
	
	//increas temp
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting = Setting.Mode.LOW;
			case LOW:
				mySetting = Setting.Mode.MEDIUM;
			case MEDIUM:
				mySetting = Setting.Mode.HIGH;
			case HIGH:
		}//end of switch
		
	}//end of class plusButton 
	
	//decrease setting
	public void minusButton() {
		switch(mySetting) {
			case HIGH:
				mySetting = Setting.Mode.MEDIUM;
			case MEDIUM:
				mySetting = Setting.Mode.LOW;
			case LOW:
				mySetting = Setting.Mode.OFF;
			case OFF:
		}//end of switch
	}//end of minusButton
	
	
}//end of class decloration 
