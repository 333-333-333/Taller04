package model;

public enum Posición {

    GK("GK"), DF("DF"), MF("MF"), FW("FW");

    private String Tag;

    private Posición(String tag) {
        this.Tag = tag;
    }

    public String getTag() {
        return this.Tag;
    }

}
