import java.util.Arrays;


public class Ascall {
    
	
    public static void main(String args[] ){
        char m = '\02';
        System.out.println(byteToChar(charToByte(m)));
        String endTag = "\03\01";
        String good = "good";
        byte[] bGod = good.getBytes();
        byte [] myTag =endTag.getBytes();
        System.out.println(Arrays.toString(myTag));
    }
    public static byte[] charToByte(char c) { 
        byte[] b = new byte[2]; 
        b[0] = (byte) ((c & 0xFF00) >> 8); 
        b[1] = (byte) (c & 0xFF); 
        return b; 
    }
    public static char byteToChar(byte[] b) { 
        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF)); 
        return c; 
    }
}
