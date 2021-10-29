
import java.security.SecureRandom;

public class Sha256 {
    public static byte[] rkey() {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[16]; // 128 bit
        random.nextBytes(values);

        return values;
    }
    public static void rkeyshow(byte[] values) {
            StringBuilder sb = new StringBuilder();
            for (byte b : values) {
                sb.append(String.format("%x", b));        
            }
            System.out.print("Key: ");
            System.out.println(sb.toString()); // случайный ключ
            System.out.println();
    }
    
}