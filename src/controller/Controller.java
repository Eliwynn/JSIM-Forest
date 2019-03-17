package controller;

import controller.*;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.*;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
	public TextField nbOfIterations;
	public TextField iterationSpeed;
	
	public Cell[][] typeArray;
	public Cell[][] dupeArray;
	public int gridX = 40;
	public int gridY = 40;
	public Timer autoSim;
	public int iterationCt;
	public int v_nbOfIterations = 100;
	public int v_iterationSpeed = 10;

	@FXML
	public void initialize() {
		
		setWindow();
		setGrid(gridX,gridY);
		setCells(gridX,gridY);
		
		nbOfIterations.setText(Integer.toString(v_nbOfIterations));
		iterationSpeed.setText(Integer.toString(v_iterationSpeed));

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
	public void okGrid() {
		gridgrid.getChildren().clear();
        setGrid(gridX,gridY);
        setCells(gridX,gridY);
		System.out.println("Grille changée.");
	}
	
	@FXML
	public void okSpeed() {
		System.out.println("Vitesse changée");
	}
	
	@FXML
	public void resetButton() {
		gridgrid.getChildren().clear();
        setGrid(gridX,gridY);
        setCells(gridX,gridY);
	}
	
	@FXML
	public void stepButton() {
		for (int i=0;i<gridX;i++) {
			for (int j=0;j<gridY;j++) {
				Simulation.stepGrowth(typeArray, typeArray[i][j], dupeArray[i][j], 7);
			}
		}
		for (int i=0;i<gridX;i++) {
			for (int j=0;j<gridY;j++) {
				typeArray[i][j].setType(dupeArray[i][j].getType());
				typeArray[i][j].setBushGrowth(dupeArray[i][j].getBushGrowth());
			}
		}
		
	}
	
	@FXML
	public void simuButton() {
		this.autoSim = simulationTimer(Integer.parseInt(iterationSpeed.getCharacters().toString()));
		autoSim.start();
	}
	
	@FXML
	public Timer simulationTimer(int iterationSec) {
		this.iterationCt = 0;
		ActionListener task = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (iterationCt < Integer.parseInt(nbOfIterations.getCharacters().toString())) {
					for (int i=0;i<gridX;i++) {
						for (int j=0;j<gridY;j++) {
							Simulation.stepGrowth(typeArray, typeArray[i][j], dupeArray[i][j], 7);
						}
					}
					for (int i=0;i<gridX;i++) {
						for (int j=0;j<gridY;j++) {
							typeArray[i][j].setType(dupeArray[i][j].getType());
							typeArray[i][j].setBushGrowth(dupeArray[i][j].getBushGrowth());
						}
					}
					iterationCt++;
				}
				else {
					autoSim.stop();
				}
			}
		};
		Timer timer = new Timer(1000/iterationSec, task);
		return timer;
	}
	
	@FXML
    public void stopTimer(){
        autoSim.stop();
    }
	
	@FXML
	private void closeButtonAction(){
		Platform.exit();
	}
	
}
