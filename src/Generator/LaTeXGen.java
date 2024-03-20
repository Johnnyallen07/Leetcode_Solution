package Generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LaTeXGen {

    public File fileGen(String pathname){
        try {
            File file = new File(pathname);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                return file;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void fileWriter(String pathname, String content){
        try {
            FileWriter myWriter = new FileWriter(pathname);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void LaTeXFileBegin(String pathname){
        fileGen(pathname);
        String begin = "\\documentclass[a4paper] {article}\n" +
                "\\usepackage{xcolor}\n" +
                "\\usepackage{float}\n" +
                "\\usepackage{graphicx}\n" +
                "\\usepackage[font=footnotesize,labelfont=bf]{caption}\n" +
                "\\usepackage{amsmath,amsfonts,amssymb}\n" +
                "\\usepackage{mathtools}\n" +
                "\\usepackage{multicol}\n"+
                "\\addtolength{\\oddsidemargin}{-.875in}\n" +
                "\\addtolength{\\evensidemargin}{-.875in}\n" +
                "\\addtolength{\\textwidth}{1.75in}\n" +
                "\\addtolength{\\topmargin}{-.875in}\n" +
                "\\addtolength{\\textheight}{1.75in}\n" +
                "\\renewcommand{\\figurename}{Fig.}\n" +
                "\\renewcommand{\\baselinestretch}{2.5} "+
                "\\setlength{\\columnsep}{1cm}\n"+
                "\\begin{document}";
        fileWriter(pathname, begin);

    }

    public void append(String pathname, String content){
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(pathname, true));

            // Writing on output stream
            out.write(content);
            // Closing the connection
            out.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occurred" + e);
        }
    }

    public void LaTeXFileEnd(String pathname){
        String end =  "\n\n\\end{document}";

        append(pathname, end);

    }

}
