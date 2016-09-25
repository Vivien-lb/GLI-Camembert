package Model;

import javax.swing.table.AbstractTableModel;

import Controller.IController;

public class TableCamembert extends AbstractTableModel {

	private IModel model;
	public IController controller;
	private String[] columns = { "Titre", "Description", "Prix" };

	public TableCamembert() {

	}

	public TableCamembert(IModel model, IController controller) {
		this.model = model;
		this.controller = controller;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return model.getItems().size();

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		switch (columnIndex) {
		case 0:
			return model.getItem(rowIndex).getTitre();
		case 1:
			return model.getItem(rowIndex).getDescription();
		case 2:
			return model.getItem(rowIndex).getPrix();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object avalue, int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			String titre = avalue.toString();
			model.getItem(rowIndex).setTitre(titre);
			break;
		case 1:
			String description = avalue.toString();
			model.getItem(rowIndex).setDescription(description);
			break;
		case 2: 
			double prix = Double.parseDouble(avalue.toString());
			model.getItem(rowIndex).setPrix(prix);
			break;
		}
		
		controller.update();
	}
		
	public boolean isCellEditable (int rowIndex, int columnIndex) {
		return true;
	}

}
