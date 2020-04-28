package jMoria.game.screens.keyhandlers;

public class GameKeyHandler extends AbstractKeyHandler {

    @Override
    public void handleKey(String key) {

      System.out.println(key);

      switch (key) {
        case "c":
          System.out.println("close");
          break;
        case "ESCAPE":
          System.out.println("escape");
          break;
      }


    }

}
