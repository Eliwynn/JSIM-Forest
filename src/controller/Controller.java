package controller;

import controller.*;
import java.net.URL;
import java.util.ResourceBundle;

import application.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class Controller {

	@FXML
	public Button butbut;
	public AnchorPane anchor;
	public GridPane gridgrid;
	
    int rows = 20;
    int columns = 20;
	
	
	@FXML
	public void initialize() {
		
		setWindow();
		setGrid();
		setCells();

	}

	@FXML
	public void setButtonText(String text) {
		butbut.setText(text);
	}
	
	@FXML
	public void setWindow() {
		this.butbut.setText("Reset");
	}
	
	@FXML
	public void setGrid() {
		
		int minHeight = 0;
        int preferredHeight = 100;
        int maxHeight = 110;
        
        this.gridgrid.getChildren().clear();
		
        gridgrid.setGridLinesVisible(true);
        
		gridgrid.getRowConstraints().remove(0);
		gridgrid.getColumnConstraints().remove(0);
		
		for (int i = 0; i <= rows; i++) {
			gridgrid.getRowConstraints().add(new RowConstraints(minHeight, preferredHeight, maxHeight));
		}
		
		for (int i = 0; i <= columns-1; i++) {
			gridgrid.getColumnConstraints().add(new ColumnConstraints(minHeight, preferredHeight, maxHeight));
		}

	}
	
	@FXML
	public void setCells() {
		
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= columns; j++) {
				gridgrid.add(new Cell(i,j), i, j);
			}
		}
	}
	
	@FXML
    public void coordCheck(MouseEvent e) {
        //Node source = (Node)e.getSource() ;
        //Integer colIndex = GridPane.getColumnIndex(source);
        //Integer rowIndex = GridPane.getRowIndex(source);
        //System.out.println(GridPane.getColumnIndex(source));
		
//		Node source = (Node)e.getSource();
//        Integer colIndex = (GridPane.getColumnIndex(source) == null) ?  0 : (GridPane.getColumnIndex(source));
//        Integer colRow = (GridPane.getRowIndex(source) == null) ? 0 : (GridPane.getRowIndex(source));
//        System.out.println(colIndex + " : " + colRow);
    }
	

	
	@FXML
	public void resetButton() {
		
		
	}
	
	
}
