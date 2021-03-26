/*
 * Decompiled with CFR 0.151.
 */
package com.b.a.a.a.a;

public class a {
    static final int a = 2;
    static final int b = 2;
    static final int c = 4;
    static final int d = 8;
    static final int e = 4;
    static final int f = 8;

    public static char a(byte[] byArray, int n2) {
        int n3 = byArray[n2] & 0xFF;
        n3 = n3 << 8 | byArray[n2 + 1] & 0xFF;
        return (char) n3;
    }

    public static short b(byte[] byArray, int n2) {
        int n3 = byArray[n2] & 0xFF;
        n3 = n3 << 8 | byArray[n2 + 1] & 0xFF;
        return (short) n3;
    }

    public static int c(byte[] byArray, int n2) {
        int n3 = byArray[n2] & 0xFF;
        n3 = n3 << 8 | byArray[n2 + 1] & 0xFF;
        n3 = n3 << 8 | byArray[n2 + 2] & 0xFF;
        n3 = n3 << 8 | byArray[n2 + 3] & 0xFF;
        return n3;
    }

    public static long d(byte[] byArray, int n2) {
        long l2 = (long) byArray[n2] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 1] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 2] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 3] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 4] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 5] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 6] & 0xFFL;
        l2 = l2 << 8 | (long) byArray[n2 + 7] & 0xFFL;
        return l2;
    }

    public static int a(byte[] byArray, int n2, int n3) {
        if (byArray != null) {
            byArray[n3 + 3] = (byte) (n2 & 0xFF);
            byArray[n3 + 2] = (byte) ((n2 >>>= 8) & 0xFF);
            byArray[n3 + 1] = (byte) ((n2 >>>= 8) & 0xFF);
            byArray[n3] = (byte) ((n2 >>>= 8) & 0xFF);
        }
        return n3 + 4;
    }

    public static int a(byte[] byArray, short n2, int n3) {
        if (byArray != null) {
            int n4 = n2;
            byArray[n3 + 1] = (byte) (n4 & 0xFF);
            byArray[n3] = (byte) ((n4 >>>= 8) & 0xFF);
        }
        return n3 + 2;
    }

    public static int a(byte[] byArray, char n2, int n3) {
        if (byArray != null) {
            int n4 = n2;
            byArray[n3 + 1] = (byte) (n4 & 0xFF);
            byArray[n3] = (byte) ((n4 >>>= 8) & 0xFF);
        }
        return n3 + 2;
    }

    public static int a(byte[] byArray, long l2, int n2) {
        if (byArray != null) {
            byArray[n2 + 7] = (byte) (l2 & 0xFFL);
            byArray[n2 + 6] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2 + 5] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2 + 4] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2 + 3] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2 + 2] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2 + 1] = (byte) ((l2 >>>= 8) & 0xFFL);
            byArray[n2] = (byte) ((l2 >>>= 8) & 0xFFL);
        }
        return n2 + 8;
    }

    public static int a(byte[] byArray, byte by, int n2) {
        if (byArray != null) {
            byArray[n2] = by;
        }
        return n2 + 1;
    }

    public static int a(byte[] byArray, byte[] byArray2, int n2) {
        if (byArray != null) {
            System.arraycopy(byArray2, 0, byArray, n2, byArray2.length);
        }
        return n2 + byArray2.length;
    }

    public static char a(char c2) {
        return (char) ((c2 << 8 | c2 >>> 8) & 0xFFFF);
    }

    public static short a(short s2) {
        return (short) ((s2 << 8 | s2 >>> 8) & 0xFFFF);
    }

    public static int a(int n2) {
        int n3 = n2 << 8 & 0xFF00FF00;
        int n4 = n2 >>> 8 & 0xFF00FF;
        n2 = n3 | n4;
        n3 = n2 << 16;
        n4 = n2 >>> 16;
        return n3 | n4;
    }
}
