package com.example.weddingplanner.model.viewComponent;

public class Attribute {
    private String columnName;
    private String val;

    public Attribute(String columnName, String val) {
        this.columnName = columnName;
        this.val = val;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
