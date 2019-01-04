package org.launchcode;

import java.io.File;
import java.util.ArrayList;

public class CreateFolder {

    //import absolute path

    private static ArrayList<String> folders;

    private static Main main = new Main();

    public CreateFolder(ArrayList<String> folders) {
        folders.add("Assessments");
        folders.add("Plans");
        folders.add("Referrals");
        folders.add("Authorizations-Funding");
        folders.add("Follow-Along");
        folders.add("Monthly Reports");
        folders.add("Log Notes");
        folders.add("Annual Paperwork");
        folders.add("Job Development");
        folders.add("Medical");
        folders.add("Counseling");
        folders.add("Day-MAAP");
        this.folders = folders;

    }

    public static void createFolders() {
        for (String folder : folders) {
            new File(main.getAbsolutePath() + folder).mkdirs();

        }

    }
}
