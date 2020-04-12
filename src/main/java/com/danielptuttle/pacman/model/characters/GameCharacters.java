package com.danielptuttle.pacman.model.characters;

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

public class GameCharacters {

    private static final Logger LOGGER = LogManager.getLogger(GameCharacters.class);

    private static final String imageUrl = "images.png";

    private static Map<GuyType, List<? extends Guy>> guyMap;

    private GameCharacters () {}

    /**
     * Builds a double array of Buffered Images containing all elements of the sprite sheet. Each sprite is approximnately
     * 50X50 pixels.
     * @return
     * @throws IOException
     */
    private static BufferedImage[][] loadSpritesFromSheet() throws IOException {
        BufferedImage[][] subImages = new BufferedImage[20][20];
        String fileName = GameCharacters.class.getClassLoader().getResource("images.png").getPath();
        BufferedImage sprite = ImageIO.read(new File((fileName)));
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

    private static Map<GuyType, List<? extends Guy>> loadGuys(BufferedImage[][] spriteImages) {
        Map<GuyType, List<? extends Guy>> guyMap = new HashMap<>();
        List<Ghost>  ghostList = new ArrayList<>();
        List<Pacman> pacmanList = new ArrayList<>();
        for(Enum color: Color.values()) {
            Image[] ghostImages = new Image[10];
            for (int i = 0; i < 10; i ++) {
                BufferedImage image = spriteImages[color.ordinal()][i];
                BufferedImage removedWs = removeWhiteSpace(image);
                ghostImages[i] = SwingFXUtils.toFXImage(removedWs, null);
            }
            Ghost ghost = new Ghost(color, ghostImages, 400, 400);
            ghostList.add(ghost);
        }
        guyMap.put(GuyType.GHOST, ghostList);

        Image[] pacmanImages = new Image[12];
        for (int i = 0; i < 12; i++ ) {
            BufferedImage pacman = spriteImages[17][i];
            BufferedImage removedWsPac = removeWhiteSpace(pacman);
            Image pacmanFx = SwingFXUtils.toFXImage(removedWsPac, null);
            pacmanImages[i] = pacmanFx;
        }
        Pacman pacman = new Pacman(pacmanImages, 30, 30);
        pacmanList.add(pacman);
        guyMap.put(GuyType.PACMAN, pacmanList);
        return guyMap;
    }

    //TODO: Implement this according to instructions in github issues.
    static BufferedImage removeWhiteSpace(BufferedImage image) {
        BufferedImage wsRemoved = null;

        int width = image.getWidth();
        int height = image.getHeight();

        int furthestLeft = -1;
        int furthestRight = -1;
        int furthestUp = -1;
        int furthestDown = -1;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int[] pixel = image.getRaster().getPixel(x, y, (int[]) null);
                if (pixel[0] != 255 || pixel[1] != 255 || pixel[2] != 255) {
                    furthestLeft = x;
                    break;
                }
            }
            if (furthestLeft != -1) {
                break;
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int[] pixel = image.getRaster().getPixel(x, y, (int[]) null);
                if (pixel[0] != 255 || pixel[1] != 255 || pixel[2] != 255) {
                    furthestUp = y;
                    break;
                }
            }
            if (furthestUp != -1) {
                break;
            }
        }

        for (int y = height - 1; y > 0; y--) {
            for (int x = width - 1; x > 0; x--) {
                int[] pixel = image.getRaster().getPixel(x, y, (int[]) null);
                if (pixel[0] != 255 || pixel[1]!=255 || pixel[2] != 255) {
                    furthestDown = y;
                    break;
                }
            }
            if (furthestDown != -1) {
                break;
            }
        }

        for (int x = width - 1; x > 0; x--) {
            for (int y = height - 1; y > 0; y--) {
                int[] pixel = image.getRaster().getPixel(x, y, (int[]) null);
                if (pixel[0] != 255 || pixel[1] != 255 || pixel[2] != 255) {
                    furthestRight = x + 1;
                    break;
                }
            }
            if (furthestRight != -1) {
                break;
            }
        }

        int newWidth = furthestRight - furthestLeft;
        int newHeight = furthestDown - furthestUp;

        wsRemoved = image.getSubimage(furthestLeft, furthestUp, newWidth, newHeight);

        return wsRemoved;
    }

    /**
     * The list includes
     * @return
     */
    public static Map<GuyType, List<? extends Guy>> get() {
        if (guyMap == null) {
            try {
                BufferedImage[][] subImages = loadSpritesFromSheet();
                guyMap = loadGuys(subImages);
            } catch (Exception e) {
                LOGGER.error("There was a problem creating sub images: ", e);
            }
        }
        return guyMap;
    }
}
