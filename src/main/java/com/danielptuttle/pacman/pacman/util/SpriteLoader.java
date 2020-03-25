package com.danielptuttle.pacman.pacman.util;

import org.springframework.boot.SpringBootConfiguration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteLoader {

    private String imageUrl;

    public SpriteLoader (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Builds a double array of Buffered Images containing all elements of the sprite sheet. Each sprite is approximnately
     * 42X42 pixels.
     * @return
     * @throws IOException
     */
    public BufferedImage[][] buildImageArray() throws IOException {
        BufferedImage[][] images = new BufferedImage[19][19];
        BufferedImage bufferedImage = ImageIO.read(new File((imageUrl)));
        BufferedImage subImage = bufferedImage.getSubimage(0,0, 42, 42);
        images[0][0] = subImage;
        return images;
    }
}
