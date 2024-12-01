package final_proj;

public class Card {
	
	public String Name;
	public String Type;
	public String image;
	public int Id;
	
	public Card(int id,String name, String type) {
		Id = id;
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
	
	public int getID() {
		return Id;
	}

}
