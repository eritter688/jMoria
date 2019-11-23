package jMoria.controller;

import java.util.List;

import jMoria.ASCIILoader;
import jMoria.jMoria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MainMenuController extends AbstractControllerTemplate
{
	
	@FXML
	private TextFlow asciiArea;
	@FXML
	private VBox buttonArea;
	@FXML
	private Button newButton;
	@FXML
	private Button loadButton;
	@FXML
	private Button scoresButton;
	@FXML
	private Button creditsButton;
	@FXML
	private Button quitButton;


	@Override
	public void setContent()
	{
		setLeftContent();
	}

	@Override
	public void handleKeys(KeyEvent e)
	{
		if(super.isListening() == false)
			return;

		switch(e.getCharacter())
		{
		case "n":
		case "N":
			super.changeScreen("game");
			break;
		case "l":
		case "L":
			//super.changeScreen("game");
			break;
		case "s":
		case "S":
			//super.changeScreen("game");
			break;
		case "c":
		case "C":
			//super.changeScreen("game");
			break;
		case "q":
		case "Q":
			release();
			super.getSceneManager().getPrimaryStage().close();
			break;
		}
	}
	
	private void setLeftContent()
	{
		ASCIILoader loader = jMoria.getInstance().getAsciiLoader();
		loader.setLocation("gandalf.txt");
		loader.setFont(Font.font("Monospaced", 12.0));
		loader.setColor(Color.CHARTREUSE);
		List<Text> listOfTexts = loader.loadToTexts();
		//TODO replace something like this with feature setTopPadding(int) in ASCIILoader
		Text t = new Text("\n\n\n\n\n\n");
		asciiArea.getChildren().add(t);
		asciiArea.getChildren().addAll(1, listOfTexts);
	}


}
