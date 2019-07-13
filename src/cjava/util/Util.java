package cjava.util;

import java.util.ResourceBundle;

public class Util {
    public static final int CSTM=2;
   
   public static int opc;
   public static String error;
   
   static {
    ResourceBundle properties = ResourceBundle.getBundle("cjava.util.config");
    opc = Integer.parseInt(properties.getString("opc"));
    error = properties.getString("error1");
   }
   
   public static final String RUTA= "C:/bd/Datos.ini";
    
}
