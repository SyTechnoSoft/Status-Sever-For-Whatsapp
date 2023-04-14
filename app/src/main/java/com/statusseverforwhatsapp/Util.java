package com.statusseverforwhatsapp;

import android.os.Environment;

import java.io.File;

public class Util {
public static File RootDirectoryWhatsapp=
        new File(Environment.getExternalStorageDirectory()
        +"/download/MyStorySaver/Whatsapp");

public static void createFileFolder(){

    if (!RootDirectoryWhatsapp.exists()){
        RootDirectoryWhatsapp.mkdirs();
    }
}

}
