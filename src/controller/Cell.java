package controller;

import controller.*;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Cell extends Pane {
	
	private int x;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private int y;
	private int type = 0;
	
	Background bg_white = new Background(new BackgroundFill(Color.WHITE, null, null));
	Background bg_lightgreen = new Background(new BackgroundFill(Color.LIGHTGREEN, null, null));
	Background bg_green = new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null));
	Background bg_darkgreen = new Background(new BackgroundFill(Color.DARKGREEN, null, null));

	public Cell(int posX, int posY) {
		this.x = posX;
		this.y = posY;
		
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(bg_white);
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	if (type > 2) {
            		type = 0;
            		changeColor();
            		System.out.println("X : " + posX + " Y : " + posY + " Type : " + type);
            	}
            	else {
            		type++;
            		changeColor();
            		System.out.println("X : " + posX + " Y : " + posY + " Type : " + type);
            	}
            }
        });
	}
	
	public void changeColor() {
		switch (type) {
		case 0:	this.setBackground(bg_white);
		break;
		case 1:	this.setBackground(bg_lightgreen);
		break;
		case 2:	this.setBackground(bg_green);
		break;
		case 3:	this.setBackground(bg_darkgreen);
		break;
		}
	}
	
	public void resetCell() {
		this.setType(0);
	}
}
