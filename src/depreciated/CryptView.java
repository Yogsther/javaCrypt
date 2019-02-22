import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CryptView {

    private static JButton encryptButton;

    CryptView() {
        // GUI
        JFrame frame = new JFrame("javaCrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);

        Dimension bigButton = new Dimension(180, 80);

        JButton inputButton = new JButton("Choose input");
        JButton keyButton = new JButton("Choose key");
        JButton destinationButton = new JButton("Choose destination");
        encryptButton = new JButton("Encrypt (Test Button)");
        JButton decryptButton = new JButton("Decrypt");

        encryptButton.setPreferredSize(bigButton);
        decryptButton.setPreferredSize(bigButton);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.add(inputButton);
        panel1.add(keyButton);
        panel1.add(destinationButton);

        panel2.add(encryptButton);
        panel2.add(decryptButton);

        frame.getContentPane().add(BorderLayout.NORTH, panel1);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);

        //frame.getContentPane().add(BorderLayout.SOUTH, panel);

        frame.setVisible(true);
    }


    void addCryptListener(ActionListener listener) {
        encryptButton.addActionListener(listener);
    }

    // TODO: Add pop-up not just a console print
    void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}