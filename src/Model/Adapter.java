package Model;

import java.util.List;

import Controller.Controller;
import View.Vue;

public class Adapter implements IModel {
	
	private Model model;
	
	public Adapter() {
		
	}
	
	public Adapter(Model model) {
		this.model = model;
	}

	
	public void addItem(Item item) {
		model.addItem(item);		
	}

	public void removeItem(Item item) {
		model.removeItem(item);
	}
	
	public String getTitre() {
		return model.getTitre();
	}

	public void setTitre(String titre) {
		model.setTitre(titre);
		
	}
	
	public List<Item> getItems() {
		return model.getItems();
	}
	
	public Item getItem(int index) {
		return model.getItem(index);
	}
	
	
	
	
}
