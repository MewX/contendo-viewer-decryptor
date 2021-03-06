import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
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
        new Main().runAES("/mnt/r/info");
        // new Main().runDecrypt("/mnt/r/J0010495BK0099750001.S/OPS/xhtml/1.xhtml");
        new Main().runDecrypt("/mnt/r/comic.S/item/xhtml/p-001.xhtml");
    }

    /**
     * This function decodes the <user_home>/.ConTenDoViewer/info file.
     */
    public void runAES(String infoFilePath) {
        System.out.println("test");
        try {
            FileInputStream fileInputStream = new FileInputStream(infoFilePath);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = fileInputStream.read(); i != 19; i = fileInputStream.read())
                stringBuffer.append((char) i);
            // long l = Long.parseLong(stringBuffer.toString());

            // This is the Long object in the `info` file.
            // byte[] builtSecretKey = buildSecretKey(-345585222195293739L);
            byte[] builtSecretKey = buildSecretKey(6874628185188049249L);

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            SecretKeySpec secretKeySpec = new SecretKeySpec(messageDigest.digest(builtSecretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            ObjectInputStream objectInputStream = new ObjectInputStream(new CipherInputStream(fileInputStream, cipher));

            long secretKey = objectInputStream.readLong();
            HashMap<String, com.b.a.b.a> n = (HashMap<String, com.b.a.b.a>) objectInputStream.readObject();
            String k = (String) objectInputStream.readObject();
            String l = (String) objectInputStream.readObject();
            Boolean p = ((Boolean) objectInputStream.readObject()).booleanValue();
            Boolean o = ((Boolean) objectInputStream.readObject()).booleanValue();

            // Print everything
            System.out.println(secretKey);
            System.out.println("key_info:");
            for (String key : n.keySet()) {
                com.b.a.b.a a = n.get(key);
                System.out.println("  " + key + ":");
                System.out.println("    a.a: " + a.a.a());
                System.out.println("    b: " + a.a.b());
                System.out.println("    c: " + a.a.c());
                System.out.println("    d: " + a.a.d());
                System.out.println("    e: " + a.a.e().toString());
                System.out.println("    f: " + a.a.f());
                System.out.println("    a.b: " + a.b); // This is my key, existing in every file.
                System.out.println("    a.c: " + a.c);
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

    /**
     * This function decrypts the single file in epub archive. The decryped file has
     * magic numbers: 0x49686970 or 0x43444546.
     * 
     * @param filePath
     */
    public void runDecrypt(String filePath) {
        try {
            byte[] paramArrayOfbyte = Files.readAllBytes(Paths.get(filePath));
            if (paramArrayOfbyte.length >= 1024 && ((paramArrayOfbyte[0] == 73 && paramArrayOfbyte[1] == 71
                    && paramArrayOfbyte[2] == 69 && paramArrayOfbyte[3] == 70)
                    || (paramArrayOfbyte[0] == 67 && paramArrayOfbyte[1] == 68 && paramArrayOfbyte[2] == 69
                            && paramArrayOfbyte[3] == 70))) {
                // TODO: figure out why it only selects 1024 bytes.
                if (paramArrayOfbyte.length != 1024) {
                    byte[] arrayOfByte = new byte[1024];
                    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, 1024);
                    paramArrayOfbyte = arrayOfByte;
                }

                // Not sure why needing this section?
                byte[] arrayOfByte1 = new byte[12];
                byte[] arrayOfByte2 = new byte[12];
                System.arraycopy(paramArrayOfbyte, 4, arrayOfByte1, 0, 12);
                System.arraycopy(paramArrayOfbyte, 16, arrayOfByte2, 0, 12);

                // Init the most important object.
                com.b.a.b.aa.a h = new com.b.a.b.aa.a(new com.b.a.b.aa.b() {
                    public byte[] a() {
                        return null;
                    }

                    public int b() {
                        return 3;
                    }
                });

                String str1 = (new String(paramArrayOfbyte, 28, 32)).intern();
                // String str2 = a.a(this.n, str1);
                String str2 = Decrypt.DECRYPTION_KEY;
                int i = h.a(str2.getBytes());
                byte[] guessResult = h.b();
                h.b(guessResult); // Digest, this also sets com.b.a.a.aa.a.b. (The hashmap)
                if (i != 0)
                    System.out.println(Dumper.dump(h.a(i)));
                else
                    System.out.println("error in i.");

                // Using the official file reader.
                net.zamasoft.reader.book.a.b randomAccessFile = new net.zamasoft.reader.book.a.b(new File(filePath));
                System.out.println("file length: " + randomAccessFile.length());
                System.out.println("key: " + com.b.a.a.a.c.a.getBLatest());
                ArrayList<Byte> bytes = new ArrayList<>();
                while (!randomAccessFile.isEOF()) {
                    byte b = (byte) randomAccessFile.read();
                    bytes.add(b);
                }
                assert randomAccessFile.length() == bytes.size();
                byte[] bs = new byte[bytes.size()];
                for (int ii = 0; ii < bs.length; ii++) {
                    bs[ii] = bytes.get(ii);
                }
                System.out.println("bytes length: " + bytes.size());
                System.out.println(new String(bs, "utf-8"));
            } else {
                System.out.println("NOOOOOOOO!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
