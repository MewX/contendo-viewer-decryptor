package net.zamasoft.reader.book.a;

// import com.b.a.a;
import com.b.a.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessRead;

public class b implements RandomAccessRead {
    private int a = 12;
    private int b = 1 << this.a;
    private long c = -1L << this.a;
    private int d = 1000;
    private byte[] e = null;
    private final Map<Long, byte[]> f = new LinkedHashMap<Long, byte[]>(this.d, 0.75f, true) {
        private static final long b = -6302488539257741101L;

        @Override
        protected boolean removeEldestEntry(Map.Entry<Long, byte[]> entry) {
            boolean bl;
            boolean bl2 = bl = this.size() > b.this.d;
            if (bl) {
                b.this.e = entry.getValue();
            }
            return bl;
        }
    };
    private long g = -1L;
    private byte[] h = new byte[this.b];
    private int i = 0;
    private final RandomAccessFile j;
    private final long k;
    private long l = 0L;
    private boolean m;
    private final c n;
    private static final int o = 1024;

    // public b(File file, a a2) throws IOException {
    public b(File file) throws IOException {
        this.j = new RandomAccessFile(file, "r");
        try {
            this.k = file.length() - 1024L;
            byte[] byArray = new byte[1024];
            this.j.readFully(byArray);
            // this.n = new c(a2);
            this.n = new c();
            this.n.a(byArray, 0, byArray.length);
        } catch (IOException iOException) {
            this.j.close();
            throw iOException;
        } catch (RuntimeException runtimeException) {
            this.j.close();
            throw runtimeException;
        }
    }

    @Override
    public long getPosition() {
        return this.l;
    }

    @Override
    public void seek(long l2) throws IOException {
        long l3 = l2 & this.c;
        if (l3 != this.g) {
            byte[] byArray = this.f.get(l3);
            if (byArray == null) {
                this.j.seek(l3 + 1024L);
                byArray = this.a();
                this.f.put(l3, byArray);
            }
            this.g = l3;
            this.h = byArray;
        }
        this.i = (int) (l2 - this.g);
        this.l = l2;
    }

    private byte[] a() throws IOException {
        int n2;
        byte[] byArray;
        if (this.e != null) {
            byArray = this.e;
            this.e = null;
        } else {
            byArray = new byte[this.b];
        }
        for (int i2 = 0; i2 < this.b; i2 += n2) {
            int n3 = (int) this.j.getFilePointer() - 1024;
            n2 = this.j.read(byArray, i2, this.b - i2);
            if (n2 < 0)
                break;
            this.n.a(byArray, n3, i2, n2);
        }
        return byArray;
    }

    @Override
    public int read() throws IOException {
        if (this.l >= this.k) {
            return -1;
        }
        if (this.i == this.b) {
            this.seek(this.l);
        }
        ++this.l;
        return this.h[this.i++] & 0xFF;
    }

    @Override
    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) throws IOException {
        if (this.l >= this.k) {
            return -1;
        }
        if (this.i == this.b) {
            this.seek(this.l);
        }
        int n4 = Math.min(this.b - this.i, n3);
        if (this.k - this.l < (long) this.b) {
            n4 = Math.min(n4, (int) (this.k - this.l));
        }
        System.arraycopy(this.h, this.i, byArray, n2, n4);
        this.i += n4;
        this.l += (long) n4;
        return n4;
    }

    @Override
    public int available() throws IOException {
        return (int) Math.min(this.k - this.l, Integer.MAX_VALUE);
    }

    @Override
    public long length() throws IOException {
        return this.k;
    }

    @Override
    public void close() throws IOException {
        this.j.close();
        this.f.clear();
        this.m = true;
    }

    @Override
    public boolean isClosed() {
        return this.m;
    }

    @Override
    public int peek() throws IOException {
        int n2 = this.read();
        if (n2 != -1) {
            this.rewind(1);
        }
        return n2;
    }

    @Override
    public void rewind(int n2) throws IOException {
        this.seek(this.getPosition() - (long) n2);
    }

    @Override
    public byte[] readFully(int n2) throws IOException {
        byte[] byArray = new byte[n2];
        for (int i2 = this.read(byArray); i2 < n2; i2 += this.read(byArray, i2, n2 - i2)) {
        }
        return byArray;
    }

    @Override
    public boolean isEOF() throws IOException {
        int n2 = this.peek();
        return n2 == -1;
    }
}
