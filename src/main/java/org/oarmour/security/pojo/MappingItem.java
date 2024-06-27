package org.oarmour.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class MappingItem {
    String name;
    List<String> args = new ArrayList<>();

    public MappingItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public void addArg(String arg) {
        this.args.add(arg);
    }
}
