package controller;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Types {
	
	static Background bg_white = new Background(new BackgroundFill(Color.WHITE, null, null));
	static Background bg_lightgreen = new Background(new BackgroundFill(Color.LIGHTGREEN, null, null));
	static Background bg_green = new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null));
	static Background bg_darkgreen = new Background(new BackgroundFill(Color.DARKGREEN, null, null));
	static Background bg_orange = new Background(new BackgroundFill(Color.DARKORANGE, null, null));
	static Background bg_grey = new Background(new BackgroundFill(Color.GREY, null, null));
	static Background bg_purple = new Background(new BackgroundFill(Color.PURPLE, null, null));

	static void changeColor(int type, Cell cell) {
		switch (type) {
		case 0:	cell.setBackground(bg_white);
		break;
		case 1:	cell.setBackground(bg_lightgreen);
		break;
		case 2:	cell.setBackground(bg_green);
		break;
		case 3:	cell.setBackground(bg_darkgreen);
		break;
		}
	}
}
