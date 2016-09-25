package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controller;
import Controller.IController;
import Model.Adapter;
import Model.IModel;
import Model.Item;
import Model.Model;
import Model.TableCamembert;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item("Loyer", "Un toit, c'est fort utile", 400.0);
		Item item2 = new Item("Sorties", "Les petits plaisirs du mois", 50.0);
		Item item3 = new Item("Miam miam", "Pizza, pâtes, pizza.", 100.0);
		Item item4 = new Item("Café", "Le café du matin, celui de 10h, celui de 16h", 15.0);
		
		
		Model model = new Model();
		
		model.addItem(item1);
		model.addItem(item2);
		model.addItem(item3);
		model.addItem(item4);
		
		IModel adapter = new Adapter(model);
		IController ic = new Controller();
		ic.setModel(adapter);
		TableCamembert tablecamembert = new TableCamembert(adapter, ic);
		Vue vue = new Vue(adapter, ic);
		ic.setVue(vue);
		JFrame jframe = new JFrame();
		JTable jtable = new JTable(tablecamembert);
		JScrollPane jscrollpane = new JScrollPane(jtable);
		JPanel paneltable = new JPanel();
		paneltable.add(jscrollpane);
		jframe.setSize(new Dimension (900, 900));
		jframe.getContentPane().add(vue);
		jframe.add(paneltable,BorderLayout.EAST);
		
		jframe.setVisible(true);
		
	
	}

}
