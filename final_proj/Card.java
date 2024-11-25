package gui;

public class Card {
	
	public String Name;
	public String Type;
	public String image;
	
	public Card(String name, String type) {
		Name = name;
		Type = type;
		
	}
	
	public String getName() {
		return Name;
	}
	
	public String getType() {
		return Type;
	}
	
	public String getImage() {
		return image;
	}

}
