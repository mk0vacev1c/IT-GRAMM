package view;



import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;

//import java.awt.Button;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.ITGRAMMButton;
import model.ITGRAMMSubScene;

public class ViewManager {
	
	// private classes
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPain;
	private Scene mainScene;
	private Stage mainStage;
	
	// first button position
	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_BUTTONS_START_Y = 150;
	
	private ITGRAMMSubScene credits.SubScene;
	private ITGRAMMSubScene help.SubScene;
	private ITGRAMMSubScene score.SubScene;
	private ITGRAMMSubScene characterChooser.SubScene;
	
	private ITGRAMMSubScene sceneToHide;
	
	List<ITGRAMMButton> menuButtons;
	
	// constructor for intializing our scenes
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPain = new AnchorPane();
		mainScene = new Scene(mainPain,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createSubScenes();
		createButtons();
		createBackground();
		createLogo();
		
		
		
	}
	
	private void showSubScene(ITGRAMMSubScene subScene) {
		if(sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	// initialize subscenes
	private void createSubScenes() {
		creditsSubScene = new ITGRAMMSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		helpSubScene = new ITGRAMMSubScene();
		mainPane.getChildren().add(helpSubScene);
		
		scoreSubScene = new ITGRAMMSubScene();
		mainPane.getChildren().add(scoreSubScene);
		
		characterChooserSubScene = new ITGRAMMSubScene();
		mainPane.getChildren().add(characterChooserSubScene);
	}
	
	// method for returning main stage
	public Stage getMainStage() {
		return mainStage;
	}
	
	// method for adding menu buttons
	private void addMenuPain(ITGRAMMButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y +menuButtons.size() * 100);
		menuButtons.add(button);
		mainPain.getChildren().add(button);
	}
	
	// creating method for button mainPain
	private void createButtons() {	
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
		
	}
	
	private void createStartButton() {
		ITGRAMMButton startButton = new ITGRAMMButton("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(characterChooserScene);
			}
		});
	}
	
	private void createScoresButton() {
		ITGRAMMButton scoresButton = new ITGRAMMButton("SCORES");
		addMenuButton(scoresButton);
		
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubScene);
			}
		});
	}
	
	private void createHelpButton() {
		ITGRAMMButton helpButton = new ITGRAMMButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					showSubScene(scoreSubScene);
				}
		});
	}
	
	private void createCreditsButton() {
		ITGRAMMButton creditsButton = new ITGRAMMButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(creditsSubScene);
			}
		});
	}
	
	private void createExitButton() {
		ITGRAMMButton exitButton = new ITGRAMMButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}
	
	// method for setting background
	private void createBackground() {
		Image backgroundImage = new Image("view/resources/panello.png", 256,256,false,true);
		// create background image
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		// set background
		mainPain.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("view/resources/logo.png");
		logo.setLayoutX(400);
		logo.setLayoutY(50);
		
		mainPain.getChildren().add(logo);
	}
}
