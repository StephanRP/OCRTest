package org.launchcode;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    //create a absolute path with getter
    //change class name from main to name of program
    //
    //private static String absolutePath = "C:\\Users\\steph\\Documents\\TestFolder\\";

    private static String absolutePath;

    public static String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    private static FileChooserDemo fileChooser = new FileChooserDemo();

    public Main() {

    }

    public Main(String absolutePath) throws IOException {
        this.setAbsolutePath(absolutePath);
        ArrayList<String> folders = new ArrayList<>();
        CreateFolder makeFolders = new CreateFolder(folders);
        ArrayList<String> missList = new ArrayList<>();
        SplitUp.splitUpPdf();
        Missing missingFiles = new Missing(missList);
        missingFiles.missingCarf();
        makeFolders.createFolders();
        HashMap<String, String> sortMap = new HashMap<>();
        SortPdfs sort = new SortPdfs(sortMap);
        sort.sortFolders();
        DelEmpty.startDel();
    }

    public static void main(String args[]) throws IOException {

        fileChooser.createAndShowGUI(); //does not set path

        /*ArrayList<String> folders = new ArrayList<>();
        CreateFolder makeFolders = new CreateFolder(folders);
        ArrayList<String> missList = new ArrayList<>();
        SplitUp.splitUpPdf();
        Missing missingFiles = new Missing(missList);
        missingFiles.missingCarf();
        makeFolders.createFolders();
        HashMap<String, String> sortMap = new HashMap<>();
        SortPdfs sort = new SortPdfs(sortMap);
        sort.sortFolders();
        DelEmpty.startDel();*/

    }
}