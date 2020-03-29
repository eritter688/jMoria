package jMoria.game.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CSVReader {

    private static final String dataPath = "/game/data/";
    private BufferedReader bReader;

    public CSVReader(String fileName) {
        InputStream input = getClass().getResourceAsStream(dataPath + fileName);
        InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);
        bReader = new BufferedReader(isr);
    }

    public ArrayList<Integer> getLineDataFromKey(String key) throws IOException {

        String line;
        while (true) {
            line = bReader.readLine();
            if (line == null) {
                break;
            } else if (line.startsWith(key)) {
                break;
            }
        }

        return new int[1];
    }

}
