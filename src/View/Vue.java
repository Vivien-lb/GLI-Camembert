package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

import Controller.IController;
import Model.IModel;
import Model.Item;

public class Vue extends JComponent implements MouseListener {

	Graphics2D g2d;
	IModel model;
	IController controller;

	String mTexte;
	List<Arc2D> arcs = new ArrayList<Arc2D>();
	List<Color> colors = new ArrayList<Color>();
	Arc2D.Double black = new Arc2D.Double(new Rectangle(126, 126, 150, 150), 0, 360, Arc2D.PIE);
	Arc2D.Double white = new Arc2D.Double(new Rectangle(115, 115, 170, 170), 0, 360, Arc2D.PIE);
	Rectangle previous = new Rectangle(50, 330, 30, 30);
	Rectangle next = new Rectangle(320, 330, 30, 30);
	Rectangle info = new Rectangle(320, 50, 150, 150);
	String titre = "";
	String description = "";
	String prix = "";
	int courant = -1;

	public Vue(IModel im, IController ic) {
		mTexte = new String("Hello");
		model = im;
		controller = ic;
		addMouseListener(this);
	}

	public List<Arc2D> getArcs() {
		return arcs;
	}

	public void setCourant(int i) {
		this.courant = i;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		g2d = (Graphics2D) g;

		

		List<Item> items = controller.getItems();
		double total = 0;
		double startAngle = 0;
		Random rand = new Random();

		for (Item item : items) {
			total += item.getPrix();
		}

		if (arcs.isEmpty()) {
			for (Item item : items) {
				double dd = total / item.getPrix();
				double angle = (360.0 / dd);
				Arc2D.Double arc = new Arc2D.Double(new Rectangle(100, 100, 200, 200), (int) startAngle, angle,
						Arc2D.PIE);
				arcs.add(arc);
				Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
				colors.add(randomColor);
				g2d.setColor(randomColor);
				g2d.fill(arc);
				g2d.setColor(Color.WHITE);
				g2d.drawString("yolo", 100, 100);
				startAngle += angle;
			}
		}

		else {
			for (Arc2D arc : arcs) {
				int i = arcs.indexOf(arc);
				Color color = colors.get(i);
				g2d.setColor(color);
				g2d.fill(arc);
			}
		}

		g2d.setColor(Color.WHITE);
		g2d.fill(white);

		g2d.setColor(Color.BLACK);
		g2d.fill(black);
		if (courant != -1) {
			Item item = items.get(courant);
			prix = "Prix : " + Double.toString(item.getPrix());
			description = "Description : " + item.getDescription();
			titre = "Titre : " + item.getTitre();
			g2d.drawString(titre, 330, 90);
			g2d.drawString(description, 330, 110);
			g2d.drawString(prix, 330, 130);
		}

		g2d.setColor(Color.WHITE);
		g2d.drawString(Double.toString(total), 185, 210);

		

		g2d.setColor(Color.BLUE);
		g2d.fill(previous);
		g2d.fill(next);

	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub


		for (Arc2D arc : arcs) {
			Point2D point = arg0.getPoint();
			if (arc.contains(point) && !black.contains(point) && !white.contains(point)) {
				System.out.println("YOLO");
				controller.zoom(arc, courant);
			}
		}

		if (previous.contains(arg0.getPoint())) {
			controller.previous(courant);
		}

		if (next.contains(arg0.getPoint())) {
			controller.next(courant);
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
