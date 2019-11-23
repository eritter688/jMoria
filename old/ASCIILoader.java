package jMoria;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ASCIILoader {
		
	private URL location = null;
	
	private List<String> listOfStrings = new ArrayList<>();
	private List<Text> listOfTexts = new ArrayList<>();
	
	private Font font = Font.font("Monospaced", 12.0);
	private Color color = Color.GRAY;
	
	public ASCIILoader()
	{}
	
	public void setLocation(String fileName)
	{
		this.location = getClass().getResource("/res/ascii/" + fileName);
		this.listOfStrings.clear();
		this.listOfTexts.clear();
	}
	
	public void setFont(Font f)
	{
		this.font = f;
	}
	
	public void setColor(Color c)
	{
		this.color = c;
	}
	
	public List<String> loadToStrings()
	{
		loadString();
		return this.listOfStrings;
	}
	
	public List<Text> loadToTexts()
	{
		loadString();
		convertToText();
		return this.listOfTexts;
	}
	
	private String loadFile() throws IOException
	{
		InputStream inputStream = null;
		ByteArrayOutputStream result = null;

		try
		{
			inputStream = this.location.openStream();
			result = new ByteArrayOutputStream();
			
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) != -1)
			{
				result.write(buffer, 0, length);
			}
			
			
		}
		catch (Exception e)
		{
			Debug.dString("ASCII Resource: Load Fail");
			e.printStackTrace();
		}
		finally
		{
			if(inputStream != null)
			{
				inputStream.close();
			}
		}
		return result.toString(StandardCharsets.UTF_8.name());
	}
	
	private void loadString()
	{
		String contents = null;
		
		try
		{
			contents = loadFile();
		}
		catch (Exception e)
		{
			Debug.dString("ASCII Resource: Load Fail");
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(contents);
		while(scanner.hasNextLine())
		{
			String line = (scanner.nextLine() + "\n");
			this.listOfStrings.add(line);
		}
		scanner.close();
	}
	
	private void convertToText()
	{
		this.listOfStrings.forEach(string -> {
			Text t = new Text(string);
			t.setFill(this.color);
			t.setFont(this.font);
			this.listOfTexts.add(t);
		});		
	}
}