package Model;

import java.util.List;

public interface IModel {
	
	public void addItem (Item item);
	public void removeItem (Item item);
	public String getTitre();
	public void setTitre(String titre);
	public List<Item> getItems();
	public Item getItem(int index);
}
