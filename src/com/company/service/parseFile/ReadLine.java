package com.company.service.parseFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class ReadLine {
    private File file;

    public ReadLine(File file){

        this.file = file;
    }

    public List<String> getLines() throws IOException {

        return Files.readAllLines(file.toPath(), Charset.forName("cp1251"));
    }
}
