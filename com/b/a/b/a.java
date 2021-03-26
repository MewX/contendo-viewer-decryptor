package com.b.a.b;

import com.b.a.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.zamasoft.reader.b;

public class a implements Serializable {
//   private static final long serialVersionUID = -1370564015154108825L;
  private static final long serialVersionUID = -5690525552757311754L;
  
  final com.b.a.b.b a;
  
  final String b;
  
  final String c;
  
  public static HashMap<String, Object> a(Collection<com.b.a.b.b> paramCollection) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (com.b.a.b.b b1 : paramCollection) {
      a a1 = new a(b1);
      Object object = hashMap.get(a1.b);
      if (object == null) {
        hashMap.put(a1.b, a1);
        continue;
      } 
      if (object instanceof List) {
        ((List<a>)object).add(a1);
        continue;
      } 
      ArrayList<Object> arrayList = new ArrayList();
      arrayList.add(object);
      arrayList.add(a1);
      hashMap.put(a1.b, arrayList);
    } 
    return (HashMap)hashMap;
  }
  
  public static String a(HashMap<String, Object> paramHashMap, String paramString) {
      return "";
    // if (paramHashMap != null) {
    //   Object object = paramHashMap.get(paramString);
    //   String str = null;
    //   if (object != null) {
    //     Date date = new Date();
    //     if (object instanceof List) {
    //       for (a a1 : object) {
    //         if (a1.a(date)) {
    //           str = a1.c;
    //           break;
    //         } 
    //       } 
    //       if (str == null)
    //         throw new SecurityException("keyExpired"); 
    //     } else if (object instanceof a) {
    //       a a1 = (a)object;
    //       if (a1.a(date)) {
    //         str = a1.c;
    //       } else {
    //         throw new SecurityException("keyExpired"); 
    //       } 
    //     } 
    //     if (str == null)
    //       throw new SecurityException("keyExpired"); 
    //     return str;
    //   } 
    // } 
    // throw new SecurityException("noPermission"); 
  }
  
  private boolean a(Date paramDate) {
    return !(this.a.e() != null && paramDate.compareTo(this.a.e()) > 0);
  }
  
  private a(com.b.a.b.b paramb) {
    this.a = paramb;
    // this.c = g.a(this.a.a, this.a.b).intern();
    this.c = "asdf";
    // this.b = g.a(this.c).intern();
    this.b = "fgj";
  }
}
