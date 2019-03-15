package controller;

import controller.*;
import java.net.URL;
import java.util.ResourceBundle;

import application.*;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {

	@FXML
	public Button butbut;
	public AnchorPane anchor;
	public GridPane gridgrid;
	public TextField fieldX;
	public TextField fieldY;
	
	public Cell[][] typeArray;
	public Cell[][] dupeArray;
	public int gridX = 10;
	public int gridY = 10;

	@FXML
	public void initialize() {
		
		setWindow();
		setGrid(gridX,gridY);
		setCells(gridX,gridY);
		
		fieldX.setText(Integer.toString(gridX));
		fieldY.setText(Integer.toString(gridY));

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
	public void setGrid(int rows, int columns) {
		
		int minHeight = 0;
        int preferredHeight = 100;
        int maxHeight = 110;
        
        this.gridgrid.getChildren().clear();

        this.gridgrid.setGridLinesVisible(true);

        this.gridgrid.getRowConstraints().clear();
        this.gridgrid.getColumnConstraints().clear();
        
        this.typeArray = new Cell[rows][columns];
        this.dupeArray = new Cell[rows][columns];
		
		for (int i = 0; i <= rows-1; i++) {
			gridgrid.getRowConstraints().add(new RowConstraints(minHeight, preferredHeight, maxHeight));
		}
		
		for (int i = 0; i <= columns-1; i++) {
			gridgrid.getColumnConstraints().add(new ColumnConstraints(minHeight, preferredHeight, maxHeight));
		}

	}
	
	@FXML
	public void setCells(int rows, int columns) {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.typeArray[i][j] = new Cell(i,j);
				this.dupeArray[i][j] = new Cell(i,j);
				gridgrid.add(this.typeArray[i][j],i,j);
			}
		}
	}
	
	@FXML
	public void resetButton() {
		gridgrid.getChildren().clear();
        setGrid(gridX,gridY);
        setCells(gridX,gridY);
	}
	
	@FXML
	public void checkButton() {
		
		
		for (int i=0;i<gridX;i++) {
			for (int j=0;j<gridY;j++) {
				
				Simulation.stepGrowth(typeArray, typeArray[i][j], dupeArray[i][j], 4);
		
				typeArray[i][j].setType(dupeArray[i][j].getType());
				
				typeArray[i][j].setBushGrowth(dupeArray[i][j].getBushGrowth());
				
			}
		}
		
		System.out.println(typeArray[2][2].getType());
		
//		for (int i=0;i<gridX;i++) {
//			for (int j=0;j<gridY;j++) {
//				
//				typeArray[i][j].setType(dupeArray[i][j].getType());
//				typeArray[i][j].setBushGrowth(dupeArray[i][j].getBushGrowth());
//				
//			}
//		}
		
	}
	
	@FXML
	private void closeButtonAction(){
		Platform.exit();
	}
	
}
