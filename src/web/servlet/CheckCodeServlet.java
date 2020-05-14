package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author liyu
 */
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int height = 50;
        int width = 100;
        //1,创建一对象，在内存中画图片
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.模糊图片
        //2.1填充背景色
        //获取画笔对象
        Graphics gra = img.getGraphics();
        gra.setColor(Color.PINK);
        gra.fillRect(0, 0, width, height);
        //2.2 画边框
        gra.setColor(Color.BLUE);
        //这个是画边框，默认1像素宽度
        gra.drawRect(0, 0, width - 1, height - 1);
        //2.3写验证码
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            index = ran.nextInt(str.length());
            sb.append(str.charAt(index));
            gra.drawString(str.charAt(index) + "", width/5*(i+1), height/2);
        }

        req.getSession().setAttribute("checkcode",sb.toString());

        //2.4 画干扰线
        gra.setColor(Color.GREEN);

        for (int i=0;i<10;i++) {
            gra.drawLine(ran.nextInt(width),ran.nextInt(height),ran.nextInt(width),ran.nextInt(height));
        }

        //3. 将图片输出到页面展示
        ImageIO.write(img, "jpg", resp.getOutputStream());

    }
}
