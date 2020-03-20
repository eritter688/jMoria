package jMoria.ui;

import javafx.scene.Parent;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class Terminal {

    TextFlow terminal;

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

    public void writeLine()
    {}

    public void writeChar()
    {}

    public void dummyTerminal()
    {

        for (int x = 0; x < defaultHeightInCharacters; x++)
        {
            Text t = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
            t.setFont(Font.font("Monospaced", defaultFontSize));
            t.setFill(Color.WHITE);
            t.setWrappingWidth(Double.MAX_VALUE);
            lines.add(t);
        }

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




    /*


    ON HOLD -> FEATURE CREEP


     */


//    // This needs to resize the terminal itself to accommodate the new size
//    // of it's containing Text elements.
//    public void changeFontSize(int size)
//    {
//        if (size <= 0)
//            throw new IllegalArgumentException("Size must be a positive number.");
//
//        if (fontSize == size)
//            return;
//
////        Text temp = new Text("");
////        temp.setFont(Font.font("Monospaced", size));
////        StringBuilder sb = new StringBuilder();
////        sb.append("0".repeat(Math.max(0, widthInCharacters)));
////        sb.append("\n");
////        temp.setText(sb.toString());
//
////        terminal.getChildren().removeAll();
////
////        List<Text> tempLines = new ArrayList<>();
////        for (Text t : lines)
////        {
////            //t.setFont(Font.font("Monospaced", size));
////            Text temp = new Text();
////            temp.setFont(Font.font("Monospaced", size));
////            temp.setText(t.getText());
////            tempLines.add(temp);
////        }
////        lines = tempLines;
//
//        terminal.setMinHeight(lines.get(0).getBoundsInLocal().getHeight()*16.0);
//        terminal.setMaxHeight(lines.get(0).getBoundsInLocal().getHeight()*16.0);
//        terminal.setPrefHeight(lines.get(0).getBoundsInLocal().getHeight()*16.0);
//
//        terminal.setMinWidth(lines.get(0).getBoundsInLocal().getWidth()*10);
//        terminal.setMaxWidth(lines.get(0).getBoundsInLocal().getWidth()*10);
//        terminal.setPrefWidth(lines.get(0).getBoundsInLocal().getWidth()*10);
//
//
//        for (Text t: lines)
//        {
//            t.setFont(Font.font("Monospaced", size));
//        }
//
//        //(Parent)terminal.updateBounds();
//        //terminal.getParent().updateBounds();
//
//        terminal.setMinHeight(lines.get(0).getBoundsInLocal().getHeight()*8.0);
//        terminal.setMaxHeight(lines.get(0).getBoundsInLocal().getHeight()*8.0);
//        terminal.setPrefHeight(lines.get(0).getBoundsInLocal().getHeight()*8.0);
//
//        terminal.setMinWidth(lines.get(0).getBoundsInLocal().getWidth());
//        terminal.setMaxWidth(lines.get(0).getBoundsInLocal().getWidth());
//        terminal.setPrefWidth(lines.get(0).getBoundsInLocal().getWidth());
//
//        //terminal.getChildren().addAll(lines);
//
//    }

}
