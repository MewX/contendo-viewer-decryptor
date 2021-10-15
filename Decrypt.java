import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Decrypt {
    public static String DECRYPTION_KEY = "5309124f237c691c7123affeffe94bca1e3d4028f044677bda9fc13688a0f529b49fbb815944d2c08b0a822081720cddeb0ec746c9fececaf8c8138998cb9a10";

    public String getOutputFullPath(String src, String dest, String fullSrcPath) {
        return dest + fullSrcPath.substring(src.length());
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Decrypt <input dir/file> <output dir/file>");
            System.exit(-1);
        }

        // Normalize the inputs.
        // (Only Consider the case that the file separater is used correctly.)
        String src = new File(args[0]).getAbsolutePath(), dest = new File(args[1]).getAbsolutePath();
        new Decrypt().showFiles(src, dest, new File[] { new File(args[0]) });
    }

    public void showFiles(String src, String dest, File[] files) throws IOException {
        for (File file : files) {
            final String inputFullPath = file.getAbsolutePath();
            if (file.isDirectory()) {
                System.out.println("Dir: " + inputFullPath + " -> " + getOutputFullPath(src, dest, inputFullPath));
                new File(getOutputFullPath(src, dest, inputFullPath)).mkdirs();
                showFiles(src, dest, file.listFiles());
            } else if (file.isFile()) {
                System.out.println("File: " + inputFullPath + " -> " + getOutputFullPath(src, dest, inputFullPath));

                // Save the file.
                byte[] bs = decryptFile(file);
                Files.write(new File(getOutputFullPath(src, dest, inputFullPath)).toPath(), bs,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                System.out.println("Unknown file type: " + inputFullPath);
            }
        }
    }

    private byte[] decryptFile(File file) throws IOException {
        // Init the key.
        com.b.a.a.a.c.a.bLatest = DECRYPTION_KEY.getBytes();

        // Check file size.
        byte[] byArray = Files.readAllBytes(file.toPath());
        if (byArray.length >= 1024 && (byArray[0] == 73 && byArray[1] == 71 && byArray[2] == 69 && byArray[3] == 70
                || byArray[0] == 67 && byArray[1] == 68 && byArray[2] == 69 && byArray[3] == 70)) {
            // Encrypted. Using the official file reader.
            net.zamasoft.reader.book.a.b randomAccessFile = new net.zamasoft.reader.book.a.b(file);
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
            return bs;
        }
        // By default, not encrypted.
        return byArray;
    }
}
