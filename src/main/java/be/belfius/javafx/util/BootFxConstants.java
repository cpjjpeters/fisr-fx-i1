package be.belfius.javafx.util;

import javafx.stage.Screen;
public class BootFxConstants {

	public static final String CSS_PATH = "/styles/bootstrap3.css";
	public static final String PROJECT_TITLE = "Spring Boot Fx for FISR"; //"New FISR Application"
//
//	Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
//	double width = visualBounds.getWidth();
//	double height = visualBounds.getHeight();
	//
	public static final Double HEIGHT = Screen.getPrimary().getVisualBounds().getHeight() / 1.2;
	public static final Double WIDTH = Screen.getPrimary().getVisualBounds().getWidth() / 1.1;
}
