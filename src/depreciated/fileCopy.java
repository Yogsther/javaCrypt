import java.util.*;
import java.io.*;

public class fileCopy {
    // ARGS: 0: File path, 1: In binary (bool, 0-1)
    public static String textToCopy;


    public static void main(String[] args) {
        if (args.length > 0) {
            try{
                Scanner scanner = new Scanner(new File(args[0]), "UTF-8");
                textToCopy = scanner.useDelimiter("\\A").next();
                scanner.close();
            } catch(FileNotFoundException e){
                System.out.println("File not found.");
                return;
            }
        } else {
            // Ask in terminal
        }
    }


}