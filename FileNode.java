package fr.cedric.programme;

import java.io.File;

public class FileNode {

    private File file;

    public FileNode(File file) {
        this.file = file;
    }
    public String toString() {
        String name = file.getAbsolutePath();
        if (name.equals("")) {
            return file.getName();
        } else {
            return name;
        }
     
    }

    }
