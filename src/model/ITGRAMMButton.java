package model;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ITGRAMMButton extends Button{
	
	private static final String FONT_PATH = null;
	private static final String BUTTON_PRESSED_STYLE = null;
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('model/resources/button.png');";

	public ITGRAMMButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}
	
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
		});
		

		setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(event.getButton().equals(MouseButton.PRIMARY)) {
						setButtonReleasedStyle();
					}
				}
			});

	setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					setEffect(new DropShadow());
			});
			
			setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					setEffect(null);
			});
		}
		
	
}}
