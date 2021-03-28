package com.b.a.a.a.c;

import com.b.a.a.aa;
import com.b.a.a.a.b.b;

import java.io.UnsupportedEncodingException;
import java.util.WeakHashMap;

public class a implements aa {
    // b is bookID to decryptionKey map.
    private static WeakHashMap<Object, byte[]> b = (WeakHashMap) new WeakHashMap<>();
    public static byte[] bLatest = null; // This is the a.c printed previously.

    public static String getBLatest() {
        try {
            return new String(bLatest, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "??????";
        }
    }

    public static Object a(byte[] paramArrayOfbyte) {
        Object object = new Object();
        b.put(object, paramArrayOfbyte);
        bLatest = paramArrayOfbyte;
        return object;
    }

    public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
        byte[] arrayOfByte1 = new byte[paramArrayOfbyte1.length];
        byte[] arrayOfByte2 = new byte[paramArrayOfbyte2.length];
        System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte2, 0, paramArrayOfbyte2.length);
        b b = new b(paramArrayOfbyte1.length, 2, paramArrayOfbyte2.length, 4);
        byte[] arrayOfByte3 = new byte[Math.min(paramArrayOfbyte2.length, 64)];
        b.nextBytes(arrayOfByte3);
        byte b1 = 0;
        int i = arrayOfByte3.length;
        while (b1 < i) {
            arrayOfByte2[b1] = (byte) ((arrayOfByte2[b1] ^ arrayOfByte3[b1]) & 0xFF);
            b1++;
        }
        a(arrayOfByte1, 0, paramArrayOfbyte1, arrayOfByte2, 0, 0, paramArrayOfbyte1.length);
        return arrayOfByte1;
    }

    // JD-GUI decompiled wrong.
    // public static void a(byte[] paramArrayOfbyte1, int paramInt1, byte[]
    // paramArrayOfbyte2, byte[] paramArrayOfbyte3,
    // int paramInt2, int paramInt3, int paramInt4) {
    // int i = paramArrayOfbyte3.length;
    // int j = paramInt2 % i;
    // int k = paramInt2;
    // for (byte b = 0; b < paramInt4; b++) {
    // paramArrayOfbyte1[paramInt1++] = (byte) (paramArrayOfbyte2[paramInt3++] ^
    // paramArrayOfbyte3[j]
    // ^ (k ^ k >> 8 ^ k >> 16 ^ k >> 24) & 0xFF);
    // if (++j >= i)
    // j = 0;
    // k++;
    // }
    // }

    public static void a(byte[] byArray, int n2, byte[] byArray2, byte[] byArray3, int n3, int n4, int n5) {
        int n6 = byArray3.length;
        int n7 = n3 % n6;
        int n8 = n3;
        for (int i2 = 0; i2 < n5; ++i2) {
            byArray[n2++] = (byte) (byArray2[n4++] ^ byArray3[n7] ^ (n8 ^ n8 >> 8 ^ n8 >> 16 ^ n8 >> 24) & 0xFF);
            if (++n7 >= n6) {
                n7 = 0;
            }
            ++n8;
      }
  }

    public static void a(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, Object paramObject,
            int paramInt2, int paramInt3, int paramInt4) {
        byte[] arrayOfByte = b.get(paramObject);
        a(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, arrayOfByte, paramInt2, paramInt3, paramInt4);
    }

    public static void a(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2,
            int paramInt3, int paramInt4) {
        a(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, bLatest, paramInt2, paramInt3, paramInt4);
    }
}
