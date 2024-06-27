package org.oarmour.security.pojo;

import java.util.ArrayList;
import java.util.List;

public class ControllerItem {
    public String className;
    public List<MappingItem> mappingItems = new ArrayList<>();

    public ControllerItem(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<MappingItem> getMappingItems() {
        return mappingItems;
    }

    public void setMappingItems(List<MappingItem> mappingItems) {
        this.mappingItems = mappingItems;
    }

    public void addMethod(MappingItem item) {
        this.mappingItems.add(item);
    }
}

