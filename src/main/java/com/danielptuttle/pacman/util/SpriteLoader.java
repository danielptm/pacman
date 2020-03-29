package com.danielptuttle.pacman.util;

import com.danielptuttle.pacman.model.characters.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpriteLoader {

    private static final Logger LOGGER = LogManager.getLogger(SpriteLoader.class);

    private String imageUrl;

    public SpriteLoader (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Builds a double array of Buffered Images containing all elements of the sprite sheet. Each sprite is approximnately
     * 50X50 pixels.
     * @return
     * @throws IOException
     */
    public BufferedImage[][] loadSpritesFromSheet() throws IOException {
        BufferedImage[][] subImages = new BufferedImage[20][20];
            BufferedImage sprite = ImageIO.read(new File((imageUrl)));
            int startX = 0;
            int startY = 0;
            int subImageWidth = 50;
            int subImageHeight = 50;

            for (int i = 0; i < 20; i++) {
                startY = 0;
                for (int j = 0; j < 20; j++) {
                    BufferedImage subImage = sprite.getSubimage(startX, startY, subImageWidth, subImageHeight);
                    subImages[i][j] = subImage;
                    startY += subImageHeight;
                }
                startX += subImageWidth;
            }
        return subImages;
    }

    public Map<GuyType, List<? extends Guy>> loadGuys(BufferedImage[][] spriteImages) {
        Map<GuyType, List<? extends Guy>> guyMap = new HashMap<>();
        List<Ghost>  ghostList = new ArrayList<>();
        List<Pacman> pacmanList = new ArrayList<>();
        for(Enum color: Color.values()) {
            Image[] ghostImages = new Image[10];
            for (int i = 0; i < 10; i ++) {
                BufferedImage image = spriteImages[color.ordinal()][i];
                ghostImages[i] = SwingFXUtils.toFXImage(image, null);
            }
            Ghost ghost = new Ghost(color, ghostImages);
            ghostList.add(ghost);
        }
        guyMap.put(GuyType.GHOST, ghostList);

        Image[] pacmanImages = new Image[12];
        for (int i = 0; i < 12; i++ ) {
            BufferedImage pacman = spriteImages[17][i];
            Image pacmanFx = SwingFXUtils.toFXImage(pacman, null);
            pacmanImages[i] = pacmanFx;
        }
        Pacman pacman = new Pacman(pacmanImages);
        pacmanList.add(pacman);
        guyMap.put(GuyType.PACMAN, pacmanList);
        return guyMap;
    }
}
