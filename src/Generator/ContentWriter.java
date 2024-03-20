package Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContentWriter {

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

    public void LaTeXMultipleColumnBegin(String pathname, int num) {
        append(pathname, "\n\\begin{multicols}{"+num+"}");
    }

    public void LaTeXMultipleColumnEnd(String pathname) {
        append(pathname,"\n\\end{multicols}");
    }

    public void LaTexNoIndent(String pathname){
        append(pathname, "\\noindent");
    }
}
