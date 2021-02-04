package org.cistercian.submario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private List<Sprite> platforms = new ArrayList<Sprite>();

    public void load(String fileName) {
        File inFile = new File("core/assets", fileName);
        try {
            Scanner fileReader = new Scanner(inFile);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                // process the line
                parseMap(line);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Map file %s not found.", inFile.getAbsolutePath());
            System.exit(-1);
        }
    }

    private void parseMap(String line) {
        line.split(",");
    }
}
