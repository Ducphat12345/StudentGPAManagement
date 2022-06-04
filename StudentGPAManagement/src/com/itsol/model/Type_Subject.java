package com.itsol.model;

public enum Type_Subject {
    outline_Subject("Đại cương"), base_Building("Cơ sở ngành"), specialized("Chuyên ngành");
    private String type_Subject;
    private Type_Subject(String type_Subject){
        this.type_Subject = type_Subject;
    }
    public String getType_Subject() {
        return type_Subject;
    }
}
