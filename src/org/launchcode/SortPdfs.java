package org.launchcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class SortPdfs {

    //make sortedDict object to pass into hashmap
    //ultimately move to data base

    private static HashMap<String, String> sortedDict;
    private static String date = UploadDate.getUploadDate();
    //private static ArrayList<String> sortedFiles;

    public SortPdfs(HashMap<String, String> sortedDict) {
        sortedDict.put("-- Privacy Notice", "Annual Paperwork");
        sortedDict.put("-- Assess Checklist", "Annual Paperwork");
        sortedDict.put("-- Auth Release", "Annual Paperwork");
        sortedDict.put("-- Computer Agreement", "Annual Paperwork");
        sortedDict.put("-- Release Participation", "Annual Paperwork");
        sortedDict.put("-- Release Alcohol Drug Testing", "Annual Paperwork");
        sortedDict.put("-- Orientation Checklist", "Annual Paperwork");
        sortedDict.put("-- Edu Consumer-Family", "Annual Paperwork");
        sortedDict.put("-- Receipt Alcohol Drug", "Annual Paperwork");
        sortedDict.put("-- Assess-Intake Voc", "Annual Paperwork");
        sortedDict.put("-- Profile", "Annual Paperwork");
        sortedDict.put("-- Release Research PR", "Annual Paperwork");
        sortedDict.put("-- Seizure", "Annual Paperwork");
        sortedDict.put("-- Consent for Program Participation", "Annual Paperwork");
        sortedDict.put("-- Assess Cultural", "Annual Paperwork");
        sortedDict.put("-- Release Vol Work Participation", "Annual Paperwork");
        sortedDict.put("-- Auth Transport", "Annual Paperwork");
        sortedDict.put("-- TB Test", "Annual Paperwork");
        sortedDict.put("-- Assess Voc", "Annual Paperwork");
        sortedDict.put("-- Assess On Site", "Annual Paperwork");
        sortedDict.put("-- Progress Rpt", "Monthly Reports");
        sortedDict.put("-- Follow-Up", "Follow-Along");
        sortedDict.put("-- SS Benefit Form", "Follow-Along");
        sortedDict.put("-- Medical Info", "Follow-Along");
        sortedDict.put("-- Discharge Plan", "Plans");
        sortedDict.put("-- Emp Verification", "Follow-Along");
        sortedDict.put("-- Satisfaction", "Follow-Along");
        sortedDict.put("-- Worksheet", "Assessments");
        sortedDict.put("-- Intake Questionnaire", "Assessments");
        sortedDict.put("-- Interest Profiler", "Assessments");
        sortedDict.put("-- CVE Staffing Summary", "Assessments");
        sortedDict.put("-- Voc Acceptance Letter", "Assessments");
        sortedDict.put("-- CVE Final Report", "Assessments");
        sortedDict.put("-- D&E Final Report", "Assessments");
        sortedDict.put("-- Disc Report", "Assessments");
        sortedDict.put("-- ESPA Report", "Assessments");
        sortedDict.put("-- TBI Report", "Assessments");
        sortedDict.put("-- Exp Report", "Assessments");
        sortedDict.put("-- MOCABI", "Assessments");
        sortedDict.put("-- Neuropsych Eval", "Assessments");
        sortedDict.put("-- Recomm Report", "Assessments");
        sortedDict.put("-- Risk", "Assessments");
        sortedDict.put("-- Work Capacity", "Assessments");
        sortedDict.put("-- Health Examination", "Assessments");
        sortedDict.put("-- WRI", "Assessments");
        sortedDict.put("-- Questions To Ask Client", "Assessments");
        sortedDict.put("-- Behavior Plan", "Plans");
        sortedDict.put("-- Plan CVE", "Plans");
        sortedDict.put("-- D&E Service Plan", "Plans");
        sortedDict.put("-- Plan of Care", "Plans");
        sortedDict.put("-- Behavior Plan Follow Up", "Plans");
        sortedDict.put("-- IPE", "Plans");
        sortedDict.put("-- IEP", "Plans");
        sortedDict.put("-- IEP Amendment", "Plans");
        sortedDict.put("-- DMH Plan", "Plans");
        sortedDict.put("-- ISP", "Plans");
        sortedDict.put("-- Job Dev Plan", "Plans");
        sortedDict.put("-- RSB Job Dev Plan", "Plans");
        sortedDict.put("-- SE Job Dev Plan", "Plans");
        sortedDict.put("-- ESPA Plan", "Plans");
        sortedDict.put("-- SLRO Plan", "Plans");
        sortedDict.put("-- VPG", "Plans");
        sortedDict.put("-- Voc Plan Summary", "Plans");
        sortedDict.put("-- Counseling Referrals", "Referrals");
        sortedDict.put("-- Job Dev Referral", "Referrals");
        sortedDict.put("-- Voc & Emp Referral", "Referrals");
        sortedDict.put("-- VR Referral", "Referrals");
        sortedDict.put("-- Consumer Elig", "Authorizations-Funding");
        sortedDict.put("-- SLRO Budget", "Authorizations-Funding");
        sortedDict.put("-- VR Releases", "Authorizations-Funding");
        sortedDict.put("-- VR Auth", "Authorizations-Funding");
        sortedDict.put("-- VR Education", "Authorizations-Funding");
        sortedDict.put("-- VR Job Ready", "Authorizations-Funding");
        sortedDict.put("-- VR Questionnaire", "Authorizations-Funding");
        sortedDict.put("-- VR Purchase Auth", "Authorizations-Funding");
        sortedDict.put("-- VR Health Assessment", "Authorizations-Funding");
        sortedDict.put("-- RSB Purchase Auth", "Authorizations-Funding");
        sortedDict.put("-- PLB Eligibility Form", "Authorizations-Funding");
        sortedDict.put("-- Client Info", "Authorizations-Funding");
        sortedDict.put("-- Disability Priority", "Authorizations-Funding");
        sortedDict.put("-- VR Case Note", "Authorizations-Funding");
        sortedDict.put("-- RSB Case Note", "Authorizations-Funding");
        sortedDict.put("-- VR Application", "Job Development");
        sortedDict.put("-- Addendum A", "Job Development");
        sortedDict.put("-- Addendum B", "Job Development");
        sortedDict.put("-- App Prep Worksheet", "Job Development");
        sortedDict.put("-- Resume", "Job Development");
        sortedDict.put("-- Employer Documents", "Job Development");
        sortedDict.put("-- Job Dev Expect", "Job Development");
        sortedDict.put("-- Placement Letter", "Job Development");
        sortedDict.put("-- Staffing Attend", "Job Development");
        sortedDict.put("-- JD Accept", "Job Development");
        sortedDict.put("-- MD Orders", "Medical");
        sortedDict.put("-- PT Eval", "Medical");
        sortedDict.put("-- Misc Medical", "Medical");
        this.sortedDict = sortedDict;

    }

    public static void sortFolders() {
        File dir = new File("C:\\Users\\steph\\Documents\\TestFolder");
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            String fileName = file.getName();
            String noNum = fileName.replaceAll("[0-9]", "");
            String noPar = noNum.replaceAll("[()]", "");
            //String noDash = noPar.replaceAll("[-]", "");
            String finalVar = noPar.replaceAll(".pdf", "");
            if (sortedDict.containsKey(finalVar)) {
                String newPath = sortedDict.get(finalVar);
                Path temp = null;
                try {
                    temp = Files.move(Paths.get("C:\\Users\\steph\\Documents\\TestFolder\\"+fileName),
                            Paths.get("C:\\Users\\steph\\Documents\\TestFolder\\"+newPath+"\\"+fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (temp != null) {
                    System.out.println("File renamed and moved successfully");
                } else {
                    System.out.println("Failed to move the file");
                }

            }

        }
    }
}
