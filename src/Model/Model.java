package Model;
import java.util.ArrayList;
import java.util.List;

public class Model {

	private String titre;
	private List<Item> items = new ArrayList<Item>();
	
	public Model() {
		
	}
	
	public Model(String titre) {
		this.titre = titre;
	}
	
	public void addItem (Item item) {
		items.add(item);
	}
	
	public void removeItem (Item item) {
		items.remove(item);
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public Item getItem (int index) {
		return items.get(index);	
	}
	
}

