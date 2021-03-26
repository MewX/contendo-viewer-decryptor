package net.zamasoft.reader.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class i extends ResourceBundle {
  private Properties a = new Properties();
  
  i(InputStream paramInputStream) throws IOException {
    this.a.loadFromXML(paramInputStream);
  }
  
  protected Object handleGetObject(String paramString) {
    return this.a.getProperty(paramString);
  }
  
  public Enumeration<String> getKeys() {
    return (Enumeration)this.a.keys();
  }
}
