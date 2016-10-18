package com.antuple.tmdvreader;

/**
 * Created by patri on 10/18/2016.
 */

public class MajorMinorMacro {

    private int major, minor, macro;

    public MajorMinorMacro(int major, int minor, int macro) {
        this.major = major;
        this.minor = minor;
        this.macro = macro;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getMacro() {
        return macro;
    }

    public void setMacro(int macro) {
        this.macro = macro;
    }
}
