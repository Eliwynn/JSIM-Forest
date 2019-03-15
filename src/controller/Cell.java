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
	private int y;
	private int type = 0;
	private int bushGrowth = 0;
	private String touchBounds = "Center";
	private int gridLength = 10;
	
	public String getTouchBounds() {
		return touchBounds;
	}

	public void setTouchBounds(String touchBounds) {
		this.touchBounds = touchBounds;
	}

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
		
		if (this.type > 3) {
    		this.type = 0;
		}
		
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
	
	public int getBushGrowth() {
		return bushGrowth;
	}

	public void setBushGrowth(int bushGrowth) {
		this.bushGrowth = bushGrowth;
	}



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
            		changeColor(type);
            		System.out.println("X : " + posX + " Y : " + posY + " Type : " + type);
            	}
            	else {
            		type++;
            		changeColor(type);
            		System.out.println("X : " + posX + " Y : " + posY + " Type : " + type);
            	}
            }
        });
	}
	
	public void changeColor(int type) {
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
	
	public void grow() {
		this.type++;
	}
	
	public void checkBoundaries(Cell cell) {
		
		if (cell.getX() == 0 && cell.getY() == gridLength ) {
			this.setTouchBounds("BottomLeft");
		}
		else if (cell.getX() == gridLength && cell.getY() == gridLength) {
			this.setTouchBounds("BottomRight");
		}
		else if (cell.getX() == 0 && cell.getY() == 0) {
			this.setTouchBounds("TopLeft");
		}
		else if (cell.getX() == gridLength && cell.getY() == 0) {
			this.setTouchBounds("TopRight");
		}
		else if (cell.getY() == 0) {
			this.setTouchBounds("Top");
		}
		else if (cell.getY() == gridLength) {
			this.setTouchBounds("Bottom");
		}
		else if (cell.getX() == 0) {
			this.setTouchBounds("Left");
		}
		else if (cell.getX() == gridLength) {
			this.setTouchBounds("Right");
		}
			
	}
	
}
