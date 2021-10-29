
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {
    
    public static byte[] rhmac(String s) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac sha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec sk = new SecretKeySpec(Sha256.rkey(), "HmacSHA256");
        sha256.init(sk);
        byte[] result = sha256.doFinal(s.getBytes("UTF-8"));
        return result;
    }
    
    public static void rhmacshow(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%x", b));
        }
        System.out.print("HMAC: ");
        System.out.println(sb.toString()); //захешеный ход
    }
}
