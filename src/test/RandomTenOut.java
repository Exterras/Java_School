package test;

public class RandomTenOut {
	
	private String[] threeStar = {"ThS01", "ThS02", "ThS03", "ThS04", "ThS05", 
			"ThS06", "ThS07", "ThS08", "ThS09", "ThS10"};
	private String[] fourStar = {"FoS01", "FoS02", "FoS03", "FoS04", "FoS05", 
			"FoS06", "FoS07", "FoS08", "FoS09", "FoS10"};
	private String[] fiveStar = {"FiS01", "FiS02", "FiS03", "FiS04", "FiS05", 
			"FiS06", "FiS07", "FiS08", "FiS09", "FiS10"};
	private String[] sixStar = {"SiS01", "SiS02", "SiS03", "SiS04", "SiS05", 
			"SiS06", "SiS07", "SiS08", "SiS09", "SiS10"};
	
	public RandomTenOut(){
		
	}
	
	public void tenOut(){
		int randNum = ((int)Math.random() * 10) + 1;
	}
	
	public static void main(String[] args) {
		
	}
}
