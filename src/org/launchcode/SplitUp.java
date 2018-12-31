package org.launchcode;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.List;

class SplitUp {

    //move absolutePath to main or enum
    //ultimately have filedialogue identify path
    //change public static to private and make public getters and setters

    private static String absolutePath = "C:\\Users\\steph\\Documents\\TestFolder";

    public static RenamePdfs rename = new RenamePdfs();

    public static String getAbsolutePath() {
        return absolutePath;
    }


    public static void splitUpPdf() {
        PDDocument pdDoc = null;
        PDFTextStripper pdfStripper;

        String parsedText;

        File dir = new File(absolutePath);
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            String fileName = file.getName();
            try {
                //new set page number
                int i = 1;
                int j = 1;
                pdDoc = PDDocument.load(new File(absolutePath + "\\" + fileName));
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
                        pd.save(absolutePath + "\\" + newName + ".pdf");
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
                        pd.save(absolutePath + "\\" + newName + ".pdf");
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
        }
    }
}
