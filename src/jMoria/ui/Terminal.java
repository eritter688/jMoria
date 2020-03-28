package jMoria.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Terminal {

    private TextFlow terminal;

    public static final int defaultWidthInCharacters = 80;
    public static final int defaultHeightInCharacters = 25;

    public static final int defaultFontSize = 16;

    public int cursorX = 0;
    public int cursorY = 0;

    //background colors
    //foreground colors

    public List<Text> lines = new ArrayList<>();

    public Terminal(TextFlow terminal)
    {
        this.terminal = terminal;
    }

    public void getCursorPosition()
    {}

    public void setCursorPosition()
    {}

    public void clearScreen()
    {
        for (Text t : lines) {
            t.setText(" ".repeat(defaultWidthInCharacters) + "\n");
        }
    }

    public void clearLine(int line)
    {
        if (line < 0 || line >= defaultHeightInCharacters)
            throw new IllegalArgumentException("Line index invalid.");
        lines.get(line).setText(" ".repeat(defaultWidthInCharacters) + "\n");
    }

    public void writeLine(int line, String text)
    {
        if (line < 0 || line >= defaultHeightInCharacters)
            throw new IllegalArgumentException("Line index invalid.");

        if (text.length() > defaultWidthInCharacters)
            throw new IllegalArgumentException("Line too long.");

        if (text.contains("\n"))
            throw new IllegalArgumentException("Do not include linebreaks.");

        String tmp;

        if (text.length() < defaultWidthInCharacters) {
            tmp = text + " ".repeat(defaultWidthInCharacters - text.length());
        } else {
            tmp = text;
        }

        lines.get(line).setText(tmp + "\n");
    }

    public void writeStringAt(int line, int column, String text) {

        if (line < 0 || line >= defaultHeightInCharacters) {
            throw new IllegalArgumentException("Line index invalid.");
        }

        if (column < 0 || column >= defaultWidthInCharacters) {
            throw new IllegalArgumentException("Column index invalid.");
        }

        if ((column + text.length()) > defaultWidthInCharacters) {
            throw new IllegalArgumentException("String wont fit on line.");
        }

        if (text.contains("\n")) {
            throw new IllegalArgumentException("Do not include linebreaks.");
        }

        String currentLine = lines.get(line).getText();
        String left = currentLine.substring(0, column);
        String right = currentLine.substring(column + text.length());
        lines.get(line).setText(left + text + right);
    }

    public void dummyTerminal() {

        for (int x = 0; x < defaultHeightInCharacters; x++) {
            Text t = new Text(
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890\n");
            t.setFont(Font.font("Monospaced", defaultFontSize));
            t.setFill(Color.WHITE);
            t.setWrappingWidth(Double.MAX_VALUE);
            lines.add(t);
        }
        //System.out.println(lines.get(0).getText());
        //System.out.println(lines.get(0).getText().length());

        this.terminal.getChildren().addAll(lines);

//        System.out.println(this.terminal.getBoundsInLocal());
//        System.out.println(this.terminal.getBoundsInParent());
//        System.out.println(this.terminal.getLayoutBounds());
//
//        System.out.println(t1.getBoundsInLocal());
//        System.out.println(t1.getBoundsInParent());
//        System.out.println(t1.getLayoutBounds());

        terminal.setMinHeight(lines.get(0).getBoundsInLocal().getHeight()*defaultHeightInCharacters);
        terminal.setMaxHeight(lines.get(0).getBoundsInLocal().getHeight()*defaultHeightInCharacters);
//        terminal.setPrefHeight(t1.getBoundsInLocal().getHeight()*8.0);
//
        terminal.setMinWidth(lines.get(0).getBoundsInLocal().getWidth());
        terminal.setMaxWidth(lines.get(0).getBoundsInLocal().getWidth());
//        terminal.setPrefWidth(t1.getBoundsInLocal().getWidth());


    }

}
