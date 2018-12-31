package org.launchcode;

import java.io.File;

public class TryName {

    //import absolutePath from main once its been established with a getter
    //make getters and setters

    private static String absolutePath;
    private static String newName;
    private static String newNameAlt;

    public TryName() {
        this.absolutePath = "C:\\Users\\steph\\Documents\\TestFolder";


    }

    public static String tryName(String aNewName) {
        TryName.newName = aNewName; //I don't think I need the TryName
        File caseOne = new File(absolutePath+"\\"+newName+".pdf");
        boolean existsOne = caseOne.exists();
        boolean existsTwo = true;
        if (!existsOne) {
            return newName;
        }
        int x = 1;
        while (existsTwo){
            TryName.newNameAlt = newName + "(" + String.valueOf(x) +")";
            File caseTwo = new File(absolutePath+"\\"+ newNameAlt + ".pdf");
            existsTwo = caseTwo.exists();
            x++;
        }
        return newNameAlt;
    }
}

