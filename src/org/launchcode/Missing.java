package org.launchcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Missing {

    //make getters and setters
    //move list to seperate enum?
    //ultimately move list to data base

    private static ArrayList<String> missingList;
    public static UploadDate uploadDate = new UploadDate();

    public Missing(ArrayList<String> missingList) {
        String date = uploadDate.getUploadDate();
        missingList.add(date + " Assess Cultural.pdf");
        missingList.add(date + " Profile.pdf");
        missingList.add(date + " Neuropsych Eval.pdf");
        missingList.add(date + " Auth Release.pdf");
        missingList.add(date + " Auth Release.pdf");
        missingList.add(date + " Privacy Notice.pdf");
        missingList.add(date + " Release Vol Work Participation.pdf");
        missingList.add(date + " Release Alcohol Drug Testing.pdf");
        missingList.add(date + " Release Research PR.pdf");
        missingList.add(date + " Edu Consumer-Family.pdf");
        missingList.add(date + " App Prep Worksheet.pdf");
        missingList.add(date + " Auth Transport.pdf");
        missingList.add(date + " Assess-Intake Voc.pdf");
        missingList.add(date + " Seizure.pdf");
        missingList.add(date + " Guardianship.pdf");
        missingList.add(date + " Computer Agreement.pdf");
        missingList.add(date + " Job Dev Expect.pdf");
        missingList.add(date + " ISP.pdf");
        missingList.add(date + " Discharge Plan.pdf");
        missingList.add(date + " Satisfaction.pdf");
        missingList.add(date + " VR Auth.pdf");
        missingList.add(date + " Voc & Emp Referral.pdf");
        missingList.add(date + " D&E Final Report.pdf");
        missingList.add(date + " Job Dev Plan.pdf");
        missingList.add(date + " Placement Letter.pdf");
        missingList.add(date + " Emp Verification.pdf");
        missingList.add(date + " IPE.pdf");
        missingList.add(date + " Orientation Checklist.pdf");
        missingList.add(date + " CIMOR.pdf");
        missingList.add(date + " Consent for Program Participation.pdf");
        missingList.add(date + " Questions To Ask Client.pdf");
        this.missingList = missingList;
    }

    public static void missingCarf() throws IOException {
        ArrayList<String> missingListFile = new ArrayList<>();
        for (String fileName : missingList) {
            File caseOne = new File("C:\\Users\\steph\\Documents\\TestFolder\\"+fileName);
            boolean exists = caseOne.exists();
            if (!exists) {
                missingListFile.add(fileName);
            }
        }
        FileWriter writer = new FileWriter("C:\\Users\\steph\\Documents\\TestFolder\\Missing CARF.txt");
        for (String str : missingListFile) {
            str = str.replaceAll("[0-9]", "");
            String finalStr = str.replaceAll(".pdf", "");
            writer.write(finalStr+"\r\n");
        }
        writer.close();
    }
}

