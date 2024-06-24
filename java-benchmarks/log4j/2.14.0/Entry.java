//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Entry {
    public Entry() {
    }

    public static void entry() {
        Logger var1 = LogManager.getLogger(Entry.class);
        String var2 = getInput();
        var1.error(var2);
    }

    private static String getInput() {
        return "hello";
    }
}
