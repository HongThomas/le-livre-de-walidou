package com.android.LivreDeWalidou.model.repository;

import java.io.File;
import java.io.FileFilter;

public class JsonFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        return  file.isFile()
                && file.canRead()
                && file.exists()
                && file.getName().toLowerCase().endsWith(".json");
    }
}
