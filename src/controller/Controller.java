package controller;

import application.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Controller {

	@FXML
//	private GridPane grid;
	public Button butbut;
	public GridPane gridgrid;
	
	@FXML
	public void initialize() {
		this.butbut.setText("test");
		this.gridgrid.setGridLinesVisible(true);
		setGrid();
	}

	@FXML
	public void setButtonText(String text) {
		butbut.setText(text);
	}

	@FXML
	public void setGrid() {
		
//		gridgrid.add(new Label("T"), 0, 0);
//        gridgrid.add(new Label("E"), 0, 1);
//        gridgrid.add(new Label("S"), 0, 2);
//        gridgrid.add(new Label("T"), 0, 3);
		
		int minHeight = 50;
        int preferredHeight = 100;
        int maxHeight = 110;
		
		RowConstraints con = new RowConstraints(minHeight, preferredHeight, maxHeight);
		ColumnConstraints col = new ColumnConstraints(minHeight, preferredHeight, maxHeight);
		
		gridgrid.getRowConstraints().remove(0);
		
		for (int i = 0; i <= 4; i++) {
			gridgrid.getRowConstraints().add(con);
		}
		
		for (int i = 0; i <= 4; i++) {
			gridgrid.getColumnConstraints().add(col);
		}

		
//        for (int i = 0; i <= 7; i++) {
//            RowConstraints con = new RowConstraints();
//            // Here we set the pref height of the row, but you could also use .setPercentHeight(double) if you don't know much space you will need for each label.
//            con.setPrefHeight(20);
//            gridgrid.getRowConstraints().add(con);
//        }
        
//		final int numCols = 10 ;
//        final int numRows = 10 ;
//        
//        for (int i = 0; i < numCols; i++) {
//            ColumnConstraints colConst = new ColumnConstraints();
//            colConst.setPercentWidth(100.0 / numCols);
//            gridgrid.getColumnConstraints().add(colConst);
//        }
//        for (int i = 0; i < numRows; i++) {
//            RowConstraints rowConst = new RowConstraints();
//            rowConst.setPercentHeight(100.0 / numRows);
//            gridgrid.getRowConstraints().add(rowConst); 
//            
//        }
	}
	
}
