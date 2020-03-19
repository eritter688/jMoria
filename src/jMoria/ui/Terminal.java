package jMoria.ui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

// This class should really be an extension of TextFlow.
// Not super happy about the boilerplate required to make that happen.
public class Terminal {

    TextFlow terminal;

    public List<Text> lines = new ArrayList<>();

    public Terminal(TextFlow terminal)
    {
        this.terminal = terminal;
        //Text text = new Text("I AM A TERMINAL!!!");
        //this.terminal.getChildren().add(0, text);
    }

    public void dummyTerminal()
    {
        Text t1 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t1.setFill(Color.DARKRED);
        t1.setFont(Font.font("Monospaced", 10 ));
        lines.add(t1);
        Text t2 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t2.setFill(Color.BEIGE);
        t2.setFont(Font.font("Monospaced", 10 ));
        lines.add(t2);
        Text t3 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t3.setFill(Color.BEIGE);
        t3.setFont(Font.font("Monospaced", 10 ));
        lines.add(t3);
        Text t4 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t4.setFill(Color.BEIGE);
        t4.setFont(Font.font("Monospaced", 10 ));
        lines.add(t4);
        Text t5 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t5.setFill(Color.BEIGE);
        t5.setFont(Font.font("Monospaced", 10 ));
        lines.add(t5);
        Text t6 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t6.setFill(Color.BEIGE);
        t6.setFont(Font.font("Monospaced", 10 ));
        lines.add(t6);
        Text t7 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t7.setFill(Color.BEIGE);
        t7.setFont(Font.font("Monospaced", 10 ));
        lines.add(t7);
        Text t8 = new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890\n");
        t8.setFill(Color.BEIGE);
        t8.setFont(Font.font("Monospaced", 10 ));
        lines.add(t8);
        this.terminal.getChildren().addAll(lines);

        System.out.println(this.terminal.getBoundsInLocal());
        System.out.println(this.terminal.getBoundsInParent());
        System.out.println(this.terminal.getLayoutBounds());

        System.out.println(t1.getBoundsInLocal());
        System.out.println(t1.getBoundsInParent());
        System.out.println(t1.getLayoutBounds());

        terminal.setMinHeight(t1.getBoundsInLocal().getHeight()*8.0);
        terminal.setMaxHeight(t1.getBoundsInLocal().getHeight()*8.0);
        terminal.setPrefHeight(t1.getBoundsInLocal().getHeight()*8.0);

        terminal.setMinWidth(t1.getBoundsInLocal().getWidth());
        terminal.setMaxWidth(t1.getBoundsInLocal().getWidth());
        terminal.setPrefWidth(t1.getBoundsInLocal().getWidth());

        Text tt= new Text("123567890123456789012345678901234567890123567890123456789012345678901234567890");
        tt.setFill(Color.BROWN);
        tt.setFont(Font.font("Monospaced", 10));
        tt.applyCss();
        System.out.println(tt.getBoundsInLocal());


    }

}
