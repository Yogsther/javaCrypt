import java.util.*;
import java.io.*;

public class Crypt {
    public static String textToCopy;

    /** Extends a string
     * 
     * @param String key The key you want to extend
     * @param int length the required minumum length of the key
     * @return The new, extended key
     */
    public static String checkKey(String key, int length) {
        while (key.length() < length) key += key; // While key is too short, extend it by dublicating it
        return key;
    }

    /**
     * @param String message The message to be encrypted / decrypted
     * @param String key the key to be used.
     * @return The encrypted or decrypted string
     */
    public static String encrypt(String message, String key) {
        if (key.length() < message.length()) key = checkKey(key, message.length()); // Make sure key is long enough

        // Convert message and key to byte arrays
        byte[] message_arr = message.getBytes(); 
        byte[] key_arr = key.getBytes();

        // Create a new byte array to store the final message / encrypted code
        byte[] encrypted = new byte[message_arr.length];

        // Loop through the message and encrypt it with the key
        for (int i = 0; i < message_arr.length; i++) {
            encrypted[i] = (byte)(message_arr[i] ^ key_arr[i]);
        }
        
        // Return the final array convertet to a String
        return new String(encrypted);
    }

    /** Read a file in storage
     * @param String location - The location of the file to be read
     * @return The read file
     */
    public static String readFile(String location) {
        String readString; // String to hold the loaded data
        try {
            Scanner scanner = new Scanner(new File(location), "UTF-8"); // Create a scanner and load the file
            readString = scanner.useDelimiter("\\A").next(); // Read through
            scanner.close();
        } catch (FileNotFoundException e) {
            // Watch for exception
            System.out.println("File not found.");
            return "";
        }
        return readString; // Read file to string
    }

    public static void main(String[] args) {
        if (args.length > 1) { // Make sure args are provided
            String product = encrypt(readFile(args[0]), readFile(args[1])); // Encrypt or decrypt input message

            Writer writer = null;
            String output = "output.txt";
            if(args.length > 2) output = args[2]; // If a third argument is provided, use that as output. 

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(output), "utf-8")); // Create file from output
                writer.write(product); // Write encrypted or decrypted message
                System.out.println("Success!"); // Signal when success
            } catch (IOException ex) {} finally {
                try {
                    writer.close();
                } catch (Exception ex) {}
            }
        } else {
            // TODO: Ask for inputs in terminal
            System.out.println("Usage: java -jar Crypt.jar message_dir key_dir [output_dir]");
            return;
        }
    }

}