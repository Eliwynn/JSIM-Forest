package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class Controller {

	@FXML
//	private GridPane grid;
	public Button butbut;
	public GridPane gridgrid;
	
	@FXML
	public void initialize() {
		this.butbut.setText("Patrick fdp");
		this.gridgrid.setGridLinesVisible(true);
		setGrid();
	}

	@FXML
	public void setButtonText(String text) {
		butbut.setText(text);
	}

	@FXML
	public void setGrid() {
		
		int minHeight = 0;
        int preferredHeight = 100;
        int maxHeight = 110;
        
        int rows = 20;
        int columns = 20;
		
		RowConstraints con = new RowConstraints(minHeight, preferredHeight, maxHeight);
		ColumnConstraints col = new ColumnConstraints(minHeight, preferredHeight, maxHeight);
		
		Pane pane1 = new Pane();
		Pane pane2 = new Pane();
		Background bg = new Background(new BackgroundFill(Color.DARKGREEN, null, null));
		pane1.setBackground(bg);
		pane2.setBackground(bg);
		
		gridgrid.getRowConstraints().remove(0);
		
		for (int i = 0; i <= rows; i++) {
			gridgrid.getRowConstraints().add(con);
		}
		
		for (int i = 0; i <= columns-1; i++) {
			gridgrid.getColumnConstraints().add(col);
		}
		
		gridgrid.add(pane1, 0, 0);
		gridgrid.add(pane2, 5, 6);

		
	}
	
	@FXML
    public void mouseEntered(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        //Integer rowIndex = GridPane.getRowIndex(source);
        //System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
		System.out.println(colIndex.intValue());
    }
	
	@FXML
	public void testButton() {
		System.out.printf("Mon cul c'est du polystyrene");
	}
	
	
}
