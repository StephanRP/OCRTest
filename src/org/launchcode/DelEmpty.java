package org.launchcode;

import java.io.File;

public class DelEmpty {

    //clean this all up

    private static final String FOLDER_LOCATION = "C:\\Users\\steph\\Documents\\TestFolder"; //make seperate enum?
    private static boolean isFinished = false;

    public static void startDel() {

        do {
            isFinished = true;
            replaceText(FOLDER_LOCATION);
        } while (!isFinished);
    }

    private static void replaceText(String fileLocation) {
        File folder = new File(fileLocation);
        File[] listofFiles = folder.listFiles();
        if (listofFiles.length == 0) {
            System.out.println("Folder Name :: " + folder.getAbsolutePath() + " is deleted.");
            folder.delete();
            isFinished = false;
        } else {
            for (int j = 0; j < listofFiles.length; j++) {
                File file = listofFiles[j];
                if (file.isDirectory()) {
                    replaceText(file.getAbsolutePath());
                }
            }
        }
    }
}


