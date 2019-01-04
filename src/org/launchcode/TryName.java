package org.launchcode;

import java.io.File;

public class TryName {

    //import absolutePath from main once its been established with a getter
    //make getters and setters

    private static Main main = new Main();
    private static String newName;
    private static String newNameAlt;

    public TryName() {
    }

    public static String tryName(String aNewName) {
        TryName.newName = aNewName; //I don't think I need the TryName
        File caseOne = new File(main.getAbsolutePath()+"\\"+newName+".pdf");
        boolean existsOne = caseOne.exists();
        boolean existsTwo = true;
        if (!existsOne) {
            return newName;
        }
        int x = 1;
        while (existsTwo){
            TryName.newNameAlt = newName + "(" + String.valueOf(x) +")";
            File caseTwo = new File(main.getAbsolutePath()+"\\"+ newNameAlt + ".pdf");
            existsTwo = caseTwo.exists();
            x++;
        }
        return newNameAlt;
    }
}

