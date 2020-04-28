package jMoria.game.utils;

import jMoria.game.ResourcePackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

  private static final String DATA_PATH = "/jMoria/game/data/";

  private String fileName;
  private BufferedReader bReader;
  private ResourcePackage gameResources;

  public CSVReader(ResourcePackage gameResources) {
    this.gameResources = gameResources;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  private void openFile() {
    InputStream input = gameResources.game.getClass().getResourceAsStream(DATA_PATH + fileName);
    InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);
    bReader = new BufferedReader(isr);
  }

  private void closeFile() throws IOException {
    bReader.close();
  }

  public List<Integer> getLineDataFromKey(String key) {

    List<Integer> data = null;
    try {
      openFile();

      String row;
      data = new ArrayList<>();

      while ((row = bReader.readLine()) != null) {
        if (row.startsWith(key)) {
          String[] rawData = row.split(",");
          for (int i = 1; i < rawData.length; i++) {
            data.add(Integer.parseInt(rawData[i].trim()));
          }

        }
      }

      closeFile();
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }

    return data;
  }

}
