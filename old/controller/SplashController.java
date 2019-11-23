package jMoria.controller;

import java.util.List;

import jMoria.ASCIILoader;
import jMoria.jMoria;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SplashController extends AbstractControllerTemplate
{

	@FXML
	private TextFlow asciiArea;
	@FXML
	private TextFlow keyField;


	@Override
	public void setContent()
	{
		setTopContent();
		setBottomContent();
	}
	
	@Override
	public void handleKeys(KeyEvent e)
	{
		if(super.isListening() == false)
			return;

		super.changeScreen("mainmenu");
	}
	
	private void setTopContent()
	{
		ASCIILoader loader = jMoria.getInstance().getAsciiLoader();
		loader.setLocation("durindoor.txt");
		loader.setFont(Font.font("Monospaced", 11.0));
		loader.setColor(Color.CHARTREUSE);
		List<Text> listOfTexts = loader.loadToTexts();
		asciiArea.getChildren().addAll(0, listOfTexts);
	}
	
	private void setBottomContent()
	{
		Text t = new Text("press any key to enter");
		t.setFill(Color.WHITE);
		t.setFont(Font.font("Monospaced", 14.0));
		keyField.getChildren().add(t);
	}

}
