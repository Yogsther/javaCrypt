import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CryptController {
    private CryptView view;
    private CryptModel model;

    public CryptController(CryptView view, CryptModel model) {
        this.view = view;
        this.model = model;

        this.view.addCryptListener(new CryptListener());
    }

    private class CryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action! : " + model.getNumber());
        }
    }
}