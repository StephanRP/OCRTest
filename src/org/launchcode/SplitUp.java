package org.launchcode;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SplitUp {

    //move absolutePath to main or enum
    //ultimately have filedialogue identify path
    //change public static to private and make public getters and setters

    //private static String absolutePath = "C:\\Users\\steph\\Documents\\TestFolder";

    public static RenamePdfs rename = new RenamePdfs();

    //public static String getAbsolutePath() {
    //    return absolutePath;
    //}

    private static Main main = new Main();

    public static void splitUpPdf() {

        String absolutePath = main.getAbsolutePath();

        PDDocument pdDoc = null;
        PDFTextStripper pdfStripper;

        String parsedText;

        File dir = new File(absolutePath);
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            String fileName = file.getName();
            String clientFolderName = main.getAbsolutePath() + fileName.substring(0, fileName.lastIndexOf('.'));
            new File(clientFolderName).mkdirs();

            Path temp = null;
            try {
                temp = Files.move(Paths.get(main.getAbsolutePath() + fileName),
                        Paths.get(clientFolderName + "\\" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (temp != null) {
                System.out.println("File renamed and moved successfully");
            } else {
                System.out.println("Failed to move the file");
            }
            try {
                //new set page number
                int i = 1;
                int j = 1;
                pdDoc = PDDocument.load(new File(clientFolderName + "\\" + fileName));
                int numPages = pdDoc.getNumberOfPages();
                //while statement for each page of document with empty list
                while (i <= numPages) {
                    //splitter
                    Splitter splitter = new Splitter();
                    splitter.setStartPage(j);
                    pdfStripper = new PDFTextStripper();
                    //new set start and end page
                    pdfStripper.setStartPage(i);
                    pdfStripper.setEndPage(i);
                    parsedText = pdfStripper.getText(pdDoc);
                    if (parsedText.equals("\r\n") || parsedText.equals("")) {
                        i++; //not taking first doc because no trigger to complete
                    } else if (i == 1) {
                        i++;

                    } else if (i == numPages) {

                        pdfStripper.setStartPage(j);
                        pdfStripper.setEndPage(j);
                        parsedText = pdfStripper.getText(pdDoc);
                        System.out.println(parsedText);
                        splitter.setEndPage(i);
                        splitter.setSplitAtPage(i);
                        List<PDDocument> pages = splitter.split(pdDoc);
                        PDDocument pd = pages.get(0);
                        String newName = rename.renamePdfs(parsedText); //new
                        pd.save(clientFolderName + "\\" + newName + ".pdf");
                        //pd.save(absolutePath + "\\" + (Integer.toString(x)) + ".pdf");
                        pd.close();
                        i++;

                    } else {

                        //new set start and end page
                        pdfStripper.setStartPage(j);
                        pdfStripper.setEndPage(j);
                        parsedText = pdfStripper.getText(pdDoc);
                        System.out.println(parsedText);
                        splitter.setEndPage(i - 1);
                        splitter.setSplitAtPage(i - 1);
                        List<PDDocument> pages = splitter.split(pdDoc);
                        PDDocument pd = pages.get(0);
                        String newName = rename.renamePdfs(parsedText); //new
                        pd.save(clientFolderName + "\\" + newName + ".pdf");
                        //pd.save(absolutePath + "\\" + (Integer.toString(x)) + ".pdf");
                        pd.close();
                        j = i;
                        i++;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (pdDoc != null)
                        pdDoc.close();
                } catch (Exception e1) {
                    e.printStackTrace();
                }

            }
            ArrayList<String> missList = new ArrayList<>();
            Missing missingFiles = new Missing(missList);
            try {
                missingFiles.missingCarf(clientFolderName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<String> folders = new ArrayList<>();
            CreateFolder makeFolders = new CreateFolder(folders);
            makeFolders.createFolders(clientFolderName);

            HashMap<String, String> sortMap = new HashMap<>(); //make initialize in main with get function
            SortPdfs sort = new SortPdfs(sortMap);
            sort.sortFolders(clientFolderName);
        }
    }
}
