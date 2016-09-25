package Model;

public class Item {

	private String titre;
	private String description;
	private double prix;
	
	public Item() {
	
	}
	
	public Item(String titre, String description, double prix) {
		this.titre = titre;
		this.description = description;
		this.prix = prix;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
