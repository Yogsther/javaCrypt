import java.util.*;
import java.io.*;

public class Crypt {
    // ARGS: 0: File path, 1: In binary (bool, 0-1)
    public static String textToCopy;

    /** Extends a string
     * 
     * @param String key The key you want to extend
     * @param int length the required minumum length of the key
     * @return The new, extended key
     */
    public static String checkKey(String key, int length) {
        while (key.length() < length) key += key;
        return key;
    }

    /**
     * @param String message The message to be encrypted / decrypted
     * @param String key the key to be used.
     * @return The encrypted or decrypted string
     */
    public static String encrypt(String message, String key) {
        if (key.length() < message.length()) key = checkKey(key, message.length());

        byte[] message_arr = message.getBytes();
        byte[] key_arr = key.getBytes();

        byte[] encrypted = new byte[message_arr.length];

        for (int i = 0; i < message_arr.length; i++) {
            encrypted[i] = (byte)(message_arr[i] ^ key_arr[i]);
        }

        return new String(encrypted);
    }

    /** Read a file in storage
     * @param String location - The location of the file to be read
     * @return The read file
     */
    public static String readFile(String location) {
        String readString;
        try {
            Scanner scanner = new Scanner(new File(location), "UTF-8");
            readString = scanner.useDelimiter("\\A").next();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return "";
        }
        return readString;
    }

    public static void main(String[] args) {
        if (args.length > 1) {
            String product = encrypt(readFile(args[0]), readFile(args[1]));

            Writer writer = null;
            String output = "output.txt";
            if(args.length > 2) output = args[2]; 

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(output), "utf-8"));
                writer.write(product);
                System.out.println("Success!");
            } catch (IOException ex) {
                // Report
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                    /*ignore*/ }
            }


        } else {
            // Ask in terminal
            System.out.println("At least two arguments are needed, Directory of message and location");
            return;
        }
    }

}