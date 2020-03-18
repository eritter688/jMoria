package jMoria.ui;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Terminal extends TextFlow {

    public void dummyTerminal()
    {
        Text t = new Text("I AM A TERMINAL!");
        this.getChildren().add(t);
    }

}
