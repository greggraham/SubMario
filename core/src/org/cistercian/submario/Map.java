package org.cistercian.submario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private final List<Sprite> platforms = new ArrayList<>();

    public void load(String fileName, Texture[] textures) {
        File inFile = new File("core/assets", fileName);
        float tileSize = textures[0].getWidth();
        Scanner fileReader = null;
        try {
            int row = 1;
            fileReader = new Scanner(inFile);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                // process the line
                String[] values = line.split(",");
                for (int col = 0; col < values.length; col++) {
                    int spriteCode = Integer.parseInt(values[col]);
                    if (spriteCode > 0) {
                        Sprite s = new Sprite(textures[spriteCode - 1], tileSize * col,
                                Gdx.graphics.getHeight() - tileSize * row);
                        platforms.add(s);
                    }
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Map file %s not found.", inFile.getAbsolutePath());
            System.exit(-1);
        } finally {
            if (fileReader != null)
                fileReader.close();
        }
    }

    public void draw(SpriteBatch batch) {
        for (Sprite p : platforms) {
            p.draw(batch);
        }
    }

    public List<Sprite> checkPlatformCollision(Sprite s) {
        List<Sprite> collisionList = new ArrayList<>();
        for (Sprite p: platforms) {
            if (s.checkCollision(p)) {
                collisionList.add(p);
            }
        }
        return collisionList;
    }
}
