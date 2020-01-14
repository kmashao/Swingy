package za.co.wethinkcode.swingy.control;

import za.co.wethinkcode.swingy.view.console.ConsoleInterface;

public class Controller {

    private ConsoleInterface console;
    public Controller(){
        console = new ConsoleInterface();
    }

    public void run(){
        console.run();
    }
}
