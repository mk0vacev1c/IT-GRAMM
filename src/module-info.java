module ITGRAMM {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	requires jdk.internal.le;
	
	opens application to javafx.graphics, javafx.fxml;
}
