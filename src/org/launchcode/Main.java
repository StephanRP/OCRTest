package org.launchcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    //create a absolute path with getter
    //change class name from main to name of program
    //


    public static void main(String args[]) throws IOException {

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
}