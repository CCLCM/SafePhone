package com.safe.safephone.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtils {
    public static String readFromStream(InputStream in) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int len =0 ;
            byte[]  buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
              outputStream.write(buffer,0,len);
            }
           return  outputStream.toString();
        }catch (Exception e) {

        }

        return "";
    }
}
