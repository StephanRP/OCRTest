package org.launchcode;


import java.util.HashMap;


public class RenamePdfs {

    //make public fields private
    //getters and setters
    //ultimately move to dropdown window with autocomplete in server application

    private static String newName;
    private static String potentialName;
    private static HashMap<String, String> nameDict = new HashMap<>();
    public static TryName tryName = new TryName();
    public static UploadDate uploadDate = new UploadDate();

    public RenamePdfs() {
        String date = uploadDate.getUploadDate();
        HashMap<String, String> nameDict = new HashMap<>();
        nameDict.put("slro budget\r\n", date+" SLRO Budget");
        nameDict.put("iep\r\n", date+" IEP");
        nameDict.put("iep amend\r\n", date+" IEP Amendment");
        nameDict.put("emp referral\r\n", date+" Voc & Emp Referral");
        nameDict.put("client info\r\n", date+" Client Info");
        nameDict.put("vr auth\r\n", date+" VR Auth");
        nameDict.put("consent program\r\n", date+" Consent for Program Participation");
        nameDict.put("auth release\r\n", date+" Auth Release");
        nameDict.put("checklist\r\n", date+" Orientation Checklist");
        nameDict.put("release med\r\n", date+" Auth Release-Medical");
        nameDict.put("privacy\r\n", date+" Privacy Notice");
        nameDict.put("computer agreement\r\n", date+" Computer Agreement");
        nameDict.put("info released\r\n", date+" Information Released");
        nameDict.put("receipt alcohol\r\n", date+" Receipt Alcohol Drug");
        nameDict.put("release alcohol\r\n", date+" Release Alcohol Drug Testing");
        nameDict.put("edu family\r\n", date+" Edu Consumer-Family");
        nameDict.put("assess intake\r\n", date+" Assess-Intake Voc");
        nameDict.put("profile\r\n", date+" Profile");
        nameDict.put("isp\r\n", date+" ISP");
        nameDict.put("pr\r\n", date+" Release Research PR");
        nameDict.put("seizure\r\n", date+" Seizure");
        nameDict.put("cultural\r\n", date+" Assess Cultural");
        nameDict.put("vol\r\n", date+" Release Vol Work Participation");
        nameDict.put("transport\r\n", date+" Auth Transport");
        nameDict.put("tb\r\n", date+" TB Test");
        nameDict.put("assess voc\r\n", date+" Assess Voc");
        nameDict.put("on site\r\n", date+" Assess On Site");
        nameDict.put("progress\r\n", date+" Progress Rpt");
        nameDict.put("discharge plan\r\n", date+" Discharge Plan");
        nameDict.put("emp ver\r\n", date+" Emp Verification");
        nameDict.put("final discharge plan\r\n", date+" Discharge Plan Final");
        nameDict.put("satisfaction\r\n", date+" Satisfaction");
        nameDict.put("de final\r\n", date+" D&E Final Report");
        nameDict.put("interest\r\n", date+" Interest Profiler");
        nameDict.put("cve final\r\n", date+" CVE Final Report");
        nameDict.put("cve summary\r\n", date+" CVE Staffing Summary");
        nameDict.put("espa report\r\n", date+" ESPA Report");
        nameDict.put("espa plan\r\n", date+" ESPA Plan");
        nameDict.put("neuro\r\n", date+" Neuropsych Eval");
        nameDict.put("work capacity\r\n", date+" Work Capacity");
        nameDict.put("wri\r\n", date+" WRI");
        nameDict.put("job ready\r\n", date+" VR Job Ready");
        nameDict.put("behavior plan\r\n", date+" Behavior Plan");
        nameDict.put("behavior follow up\r\n", date+" Behavior Plan Follow Up");
        nameDict.put("cve plan\r\n", date+" Plan CVE");
        nameDict.put("de service plan\r\n", date+" D&E Service Plan");
        nameDict.put("ipe\r\n", date+" IPE");
        nameDict.put("job dev plan\r\n", date+" Job Dev Plan");
        nameDict.put("vpg\r\n", date+" VPG");
        nameDict.put("voc plan summary\r\n", date+" Voc Plan Summary");
        nameDict.put("counseling ref\r\n", date+" Counseling Referral");
        nameDict.put("job dev ref\r\n", date+" Job Dev Referral");
        nameDict.put("elig\r\n", date+" Consumer Elig");
        nameDict.put("vr ref\r\n", date+" VR Referral");
        nameDict.put("cimor\r\n", date+" CIMOR");
        nameDict.put("id\r\n", date+" IDs");
        nameDict.put("birth cert\r\n", date+" Birth Cert");
        nameDict.put("doa\r\n", date+" DOA");
        nameDict.put("intake q\r\n", date+" Intake Questionnaire");
        nameDict.put("q for client\r\n", date+" Questions To Ask Client");
        nameDict.put("guardianship\r\n", date+" Guardianship");
        nameDict.put("vr app\r\n", date+" VR Application");
        nameDict.put("job dev expect\r\n", date+" Job Dev Expect");
        nameDict.put("placement letter\r\n", date+" Placement Letter");
        nameDict.put("attend\r\n", date+" Staffing Attend");
        nameDict.put("md orders\r\n", date+" MD Orders");
        nameDict.put("dis priority\r\n", date+" Disability Priority");
        nameDict.put("resume\r\n", date+" Resume");
        nameDict.put("jd accept\r\n", date+" JD Accept");
        nameDict.put("voc accept\r\n", date+" Voc Acceptance Letter");
        nameDict.put("references\r\n", date+" Personal References");
        nameDict.put("pay stub\r\n", date+" Pay Stub");
        nameDict.put("add a\r\n", date+" Addendum A");
        nameDict.put("add b\r\n", date+" Addendum B");
        nameDict.put("vr health\r\n", date+" VR Health Assessment");
        nameDict.put("meds list\r\n", date+" Medications List");
        nameDict.put("dmh app\r\n", date+" DMH Application");
        nameDict.put("dmh plan\r\n", date+" DMH Plan");
        nameDict.put("rsb app\r\n", date+" RSB Application");
        nameDict.put("rsb purchase\r\n", date+" RSB Purchase Auth");
        nameDict.put("voc plan meeting\r\n", date+" Voc Planning Meeting");
        nameDict.put("twe\r\n", date+" TWE");
        nameDict.put("ss ben\r\n", date+" SS Benefit Form");
        nameDict.put("medical info\r\n", date+" Medical Information");
        nameDict.put("health exam\r\n", date+" Health Examination");
        nameDict.put("email\r\n", date+" Email");
        nameDict.put("vr questionnaire\r\n", date+" VR Questionnaire");
        nameDict.put("app prep\r\n", date+" App Prep Worksheet");
        nameDict.put("med insurance\r\n", date+" Medical Insurance");
        nameDict.put("vr case note\r\n", date+" VR Case Note");
        nameDict.put("rsb case note\r\n", date+" RSB Case Note");
        nameDict.put("voc guide\r\n", date+" VR Case Note");
        nameDict.put("auth purchase\r\n", date+" VR Purchase Auth");
        nameDict.put("education\r\n", date+" VR Education");
        nameDict.put("vr release\r\n", date+" VR Releases");
        nameDict.put("emp docs\r\n", date+" Employer Documents");
        nameDict.put("support logs\r\n", date+" Support Logs");
        nameDict.put("client file review\r\n", date+" Client File Review");
        nameDict.put("plb elig\r\n", date+" PLB Eligibility");
        this.nameDict = nameDict;
    }


    public static String renamePdfs(String firstParsedText) {
        if (nameDict.containsKey(firstParsedText)) {
            potentialName = nameDict.get(firstParsedText);
            newName = tryName.tryName(potentialName);
            return newName;
        } else {
            return "rename";
        }
    }
}

