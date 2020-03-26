//package jMoria.game;
//
//import jMoria.game.living.Player;
//import jMoria.game.screens.AbstractScreen;
//import jMoria.game.screens.ChooseRace;
//import jMoria.ui.Terminal;
//
//public class  NewGame {
//
//    private Terminal terminal;
//    private Player player;
//
//    public NewGame(Terminal terminal)
//    {
//        this.terminal = terminal;
//        this.player = new Player();
//    }
//
//    public void run() {
//        terminal.clearScreen();
//
//        AbstractScreen chooseRace = new ChooseRace(terminal, player);
//        chooseRace.init();
//
//        //chooseRace();
//        //chooseSex();
//        //chooseStats();
//        //chooseClass();
//    }
//
//    private void chooseRace()
//    {
//        terminal.writeLine(3, "  Name     :");
//        terminal.writeLine(4, "  Race     :");
//        terminal.writeLine(5, "  Sex      :");
//        terminal.writeLine(6, "  Class    :");
//
//        terminal.writeLine(19, "  Choose a race:");
//        terminal.writeLine(20, "  a) Human       b) Half-Elf    c) Elf         d) Halfling    e) Gnome");
//        terminal.writeLine(21, "  f) Dwarf       g) Half-Orc    h) Half-Troll");
//    }
//
//    private void chooseSex()
//    {
//        // terminal.write() put the selected race in place.
//
//        terminal.clearLine(21);
//        terminal.writeLine(19, "  Choose sex:");
//        terminal.writeLine(20, "  m) Male        f) Female");
//    }
//
//    private void chooseStats()
//    {}
//
//    private void chooseClass()
//    {
//    }
//
//}
