package org.launchcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UploadDate {

    private static String uploadDate;

    public UploadDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy MM dd");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        this.uploadDate = String.valueOf(parsedDate);
    }

    public static String getUploadDate() {
        return uploadDate;
    }

}
