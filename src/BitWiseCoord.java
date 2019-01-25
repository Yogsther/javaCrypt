/* public class BitWiseCoord {
    public static void main(String[] args) {

        byte x = (byte) 110;        
        byte y = (byte) 120;
        
        short value = (short)((x<<8) | y);

        System.out.println(Integer.toBinaryString(value) + " , x: " + Integer.toBinaryString((byte)(value >> 8)) + " , y: " + Integer.toBinaryString((byte) value));
    }
} */


public class BitWiseCoord {
    short coordinate;

    public BitWiseCoord(int x, int y) {
        
    }

    // Sätt x-koordinaten
    public void setHigh(int x) {

    }

    // Sätt y-koordinaten
    public void setLow(int y) {

    }

    // Hämta x-koordinaten
    public int getHigh() {
        return 1;
    }

    // Hämta y-koordinaten
    public int getLow() {
        return 1;
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        BitWiseCoord minKoordinat = new BitWiseCoord(156,87);
    }
}