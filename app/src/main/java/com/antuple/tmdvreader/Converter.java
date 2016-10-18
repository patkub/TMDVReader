package com.antuple.tmdvreader;

/**
 * Created by patri on 10/18/2016.
 */

public class Converter {

    public static MajorMinorMacro convert(String strHex) {
        // convert string hex to decimal, decimal to binary
        int dec = Integer.parseInt(strHex, 16);
        String strBin = Integer.toBinaryString(dec);

        // format to 16-bit
        strBin = formatBin(strBin);

        // extract major, minor, macro
        String strMajor = strBin.substring(0, 6);
        String strMinor = strBin.substring(6, 12);
        String strMacro = strBin.substring(12, 16);

        // convert binary to decimal and store
        int major = Integer.parseInt(strMajor, 2);
        int minor = Integer.parseInt(strMinor, 2);
        int macro = Integer.parseInt(strMacro, 2);

        return new MajorMinorMacro(major, minor, macro);
    }

    /**
     * Format binary string to have 16 digits
     * @param strBin binary string to format
     * @return binary string of length >= 16 with padded 0's
     */
    public static String formatBin(String strBin) {
        if (strBin.length() < 16) {
            strBin = "0" + strBin;
            return formatBin(strBin);
        }

        return strBin;
    }

}
