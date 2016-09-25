package Controller;

import java.awt.geom.Arc2D;
import java.util.List;

import Model.IModel;
import Model.Item;
import View.Vue;

public interface IController {
	public void setVue(Vue vue);
	public void setModel(IModel model);
	public List<Item> getItems();
	public void zoom(Arc2D arc, int i);
	public void previous(int courant);
	public void next(int courant);
	public void update();
}
