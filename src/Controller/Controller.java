package Controller;

import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import Model.IModel;
import Model.Item;
import View.Vue;

public class Controller implements IController {

	private Vue vue;
	private IModel model;

	public Controller() {

	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	public void setModel(IModel model) {
		this.model = model;
	}
	
	public List<Item> getItems() {
		return model.getItems();
	}

	
	public void zoom(Arc2D arc, int i) {

		List<Arc2D> arcs = vue.getArcs();
		int index = arcs.indexOf(arc);

		if (i == -1) {
			double x = arc.getX() - 20;
			double y = arc.getY() - 20;
			double h = arc.getHeight() + 40;
			double w = arc.getWidth() + 40;

			Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, h, w);

			arc.setFrame(rectangle);
			vue.setCourant(index);
		}

		else if (index == i) {
			double x = arc.getX() + 20;
			double y = arc.getY() + 20;
			double h = arc.getHeight() - 40;
			double w = arc.getWidth() - 40;

			Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, h, w);

			arc.setFrame(rectangle);
			vue.setCourant(-1);
		}

		else { // !arc.equals(courant)
			double x = arc.getX() - 20;
			double y = arc.getY() - 20;
			double h = arc.getHeight() + 40;
			double w = arc.getWidth() + 40;

			Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, h, w);

			arc.setFrame(rectangle);
			System.out.println(i);

			Arc2D arc2 = arcs.get(i);
			double x2 = arc2.getX() + 20;
			double y2 = arc2.getY() + 20;
			double h2 = arc2.getHeight() - 40;
			double w2 = arc2.getWidth() - 40;

			Rectangle2D.Double rectangle2 = new Rectangle2D.Double(x2, y2, h2, w2);

			arc2.setFrame(rectangle2);
			arcs.set(i, arc2);
			vue.setCourant(index);
		}
		vue.repaint();
	}

	public void previous(int courant) {
		if (courant != -1) {
			List<Arc2D> arcs = vue.getArcs();
			Arc2D arc = arcs.get((courant + 1) % arcs.size());
			zoom(arc, courant);
		}
	}

	public void next(int courant) {
		if (courant != -1) {
			List<Arc2D> arcs = vue.getArcs();
			Arc2D arc = arcs.get(((courant - 1) + arcs.size()) % arcs.size());
			zoom(arc, courant);
		}
	}
	

	public void update() {
		vue.repaint();
	}
}
