import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

class Main {
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static byte[] buildSecretKey(long paramLong) {
        paramLong += 984563510L;
        return new byte[] { (byte) (int) (paramLong >> 56L), (byte) (int) (paramLong >> 48L),
                (byte) (int) (paramLong >> 40L), (byte) (int) (paramLong >> 32L), (byte) (int) (paramLong >> 24L),
                (byte) (int) (paramLong >> 16L), (byte) (int) (paramLong >> 8L), (byte) (int) (paramLong >> 0L) };
    }
    
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        System.out.println("test");
        try {
            FileInputStream fileInputStream = new FileInputStream("/mnt/r/info");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = fileInputStream.read(); i != 19; i = fileInputStream.read())
                stringBuffer.append((char) i);
            // long l = Long.parseLong(stringBuffer.toString());
            byte[] builtSecretKey = buildSecretKey(-345585222195293739L);

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            SecretKeySpec secretKeySpec = new SecretKeySpec(messageDigest.digest(builtSecretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            ObjectInputStream objectInputStream = new ObjectInputStream(new CipherInputStream(fileInputStream, cipher));

            long secretKey = objectInputStream.readLong();
            HashMap<String, Object> n = (HashMap<String, Object>) objectInputStream.readObject();
            String k = (String) objectInputStream.readObject();
            String l = (String) objectInputStream.readObject();
            Boolean p = ((Boolean) objectInputStream.readObject()).booleanValue();
            Boolean o = ((Boolean) objectInputStream.readObject()).booleanValue();

            // Print everything
            System.out.println(secretKey);
            for (String key : n.keySet()) {
                System.out.println(key + ": " + n.get(key));
            }
            System.out.println(k);
            System.out.println(l);
            System.out.println(p);
            System.out.println(o);

            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}