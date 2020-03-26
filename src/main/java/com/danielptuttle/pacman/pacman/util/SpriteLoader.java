package com.danielptuttle.pacman.pacman.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    public BufferedImage[][] buildImageArray() throws IOException {
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
}
