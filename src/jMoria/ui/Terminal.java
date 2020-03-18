package jMoria.ui;

import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Terminal extends TextFlow {

    // w/h in characters
    public int widthInCharacters = 80;
    public int heightInCharacters = 80;

    public int cursorX;
    public int cursorY;

    public List<Text> lines = new ArrayList<>();

    public Terminal() {

    }

    public void loadTestTerminal() {
        Text t1 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t1.setFill(Color.DARKRED);
        t1.setFont(Font.font("Monospaced", 10 ));
        lines.add(t1);
        Text t2 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t2.setFill(Color.BEIGE);
        t2.setFont(Font.font("Monospaced", 10 ));
        lines.add(t2);
        Text t3 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t3.setFill(Color.BEIGE);
        t3.setFont(Font.font("Monospaced", 10 ));
        lines.add(t3);
        Text t4 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t4.setFill(Color.BEIGE);
        t4.setFont(Font.font("Monospaced", 10 ));
        lines.add(t4);
        Text t5 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t5.setFill(Color.BEIGE);
        t5.setFont(Font.font("Monospaced", 10 ));
        lines.add(t5);
        Text t6 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t6.setFill(Color.BEIGE);
        t6.setFont(Font.font("Monospaced", 10 ));
        lines.add(t6);
        Text t7 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t7.setFill(Color.BEIGE);
        t7.setFont(Font.font("Monospaced", 10 ));
        lines.add(t7);
        Text t8 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        t8.setFill(Color.BEIGE);
        t8.setFont(Font.font("Monospaced", 10 ));
        lines.add(t8);
        this.getChildren().addAll(0, lines);
    }

}
