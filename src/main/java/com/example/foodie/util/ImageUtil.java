package com.example.foodie.util;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 生成图片验证码的工具类
 */

public class ImageUtil {

    // 图片的宽度。
    private int width = 160;
    // 图片的高度。
    private int height = 40;
    // 验证码字符个数
    private int codeCount = 5;
    // 验证码干扰线数
    private int lineCount = 150;
    // 验证码
    private String code = null;

    private char[] codeSequence = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private BufferedImage bufferedImage;

    private ImageUtil(int width, int height){
        this.width = width;
        this.height = height;
    }

    public ImageUtil(int width, int height, int codeCount, int lineCount){
        this(width, height);
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        createCodeImage();
    }
    private void createCodeImage(){
        //字符所在x坐标
        int x = 0;
        //字体高度
        int fontHeight = 0;
        //字符所在y坐标
        int codeY = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        x = width / (codeCount + 2);
        fontHeight = height - 2;
        codeY = height - 4;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        Random random = new Random();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width,height);
        Font font = new Font("Fixedays",Font.PLAIN,fontHeight);
        graphics2D.setFont(font);

//        产生干扰线
        for (int i = 0; i < lineCount; i++) {
            //x轴第一个点的位置
            int x1 = random.nextInt(width);
            //y轴第一个点的位置
            int y1 = random.nextInt(height);
            //x轴第二个点的位置
            int x2 = x1 + random.nextInt(width >> 2);
            //y轴第二个点的位置
            int y2 = y1 + random.nextInt(height >> 2);

            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            graphics2D.setColor(new Color(red, green, blue));
            graphics2D.drawLine(x1, y1, x2, y2);
        }

//        产生随机字符
        StringBuffer randomCode = new StringBuffer(codeCount);
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            graphics2D.setColor(new Color(red, green, blue));
            graphics2D.drawString(strRand, (i +1) * x, codeY);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }

    public void write(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        this.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public void write(OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage, "png", outputStream);
    }

    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }

    public String getCode(){
        return code;
    }

}
