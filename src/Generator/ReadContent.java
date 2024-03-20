package Generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadContent {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the file name: ");
        String filename = scanner.next();

        File file = new File(filename);

        FileReader fileReader = new FileReader(file);
        System.out.println(fileReader.read());
        fileReader.close();
    }
}
