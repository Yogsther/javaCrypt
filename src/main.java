public class main {
    public static void main(String[] args) {
        CryptView view = new CryptView();
        CryptModel model = new CryptModel();
        CryptController controller = new CryptController(view, model);
    }
}