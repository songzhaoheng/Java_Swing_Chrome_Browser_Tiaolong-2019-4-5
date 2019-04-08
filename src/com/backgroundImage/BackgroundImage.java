package com.backgroundImage;

import com.file.GameOverFile;
import com.file.MapFile;
import com.file.YunFile;
import com.share.Speed;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
* 背景图生成
* */
@Getter
@Setter
public class BackgroundImage {

    //主图片
    private BufferedImage image;

    //滚动图片
    private BufferedImage image1, image2;
    private BufferedImage image_over;
    private BufferedImage image_yun;

    //画板
    private Graphics2D graphics2D;

    //两个图片的坐标
    private Integer x;
    private Integer y;

    private Integer x_yun=800;
    private Integer y_yun=50;

    private Integer x_over=240;
    private Integer y_over=50;

    //背景图片文件
    private MapFile mapFile;

    //游戏结束图片文件
    private GameOverFile gameOverFile;

    //云图片文件
    private YunFile yunFile;

    public BackgroundImage() {

        //设置坐标
        x = 0;
        y = 734;

        try {

            mapFile = new MapFile();

            gameOverFile = new GameOverFile();

            yunFile = new YunFile();

            image1 = ImageIO.read(mapFile.getMap());
            image2 = ImageIO.read(mapFile.getMap1());

            image_over = ImageIO.read(gameOverFile.getGameOverFile());

            image_yun = ImageIO.read(yunFile.getYunFile());

        } catch (Exception e) {
            e.printStackTrace();
        }

        image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_BGR);

        //创建绘画
        graphics2D = image.createGraphics();

        graphics2D.drawImage(image1, x, 0, null);
        graphics2D.drawImage(image2, y, 0, null);

    }

    //背景滚动
    public void roll() {

        x -= Speed.SPEED;
        y -= Speed.SPEED;

        if (x <= -734) {
            x = 734;
        }
        if (y <= -734) {
            y = 734;
        }

        graphics2D.drawImage(image1, x, 0, null);
        graphics2D.drawImage(image2, y, 0, null);

        x_yun -= 1;

        if (x_yun <= 0){

            graphics2D.drawImage(image_yun, x_yun, y_yun, null);

            x_yun = 750;

            if ( (y_yun+=26) < 80 ){
                y_yun += 26;
            }

        }

    }

}
