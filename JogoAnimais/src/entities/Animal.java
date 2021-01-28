package entities;

public class Animal {
	private String name;
	private String habitat;
	
	public Animal() {
	}
		
	public Animal(String name, String habitat) {
		this.name = name;
		this.habitat = habitat;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHabitat() {
		return habitat;
	}
	
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return name + " é um animal " + habitat + ".";
	}
	
	
}
