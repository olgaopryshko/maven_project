package sportgames.exe;

import sportgames.menu.Menu;

import org.apache.log4j.Logger;

public class Executor {

    private static Logger LOGGER = Logger.getLogger(Executor.class);


    public static void main(String[] args) {
        Menu menu = new Menu();
        LOGGER.debug("Application started");

        menu.run();
    }
}

