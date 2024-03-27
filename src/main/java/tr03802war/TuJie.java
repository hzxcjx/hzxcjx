package tr03802war;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/Tupians")
public class TuJie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String value = request.getParameter("1");//获取单选值
		
		ServletContext application = this.getServletContext();
		String img1 = application.getRealPath("/imgs/0.jpg");
		String img2 = application.getRealPath("/imgs/1.jpg");
		
		Image image1 = ImageIO.read(new File(img1));
		Image image2 = ImageIO.read(new File(img2));
		
		int w1 = image1.getWidth(null)/2;
		int h1 = image1.getHeight(null)/2;
		
		int w2 = image2.getWidth(null)/2;
		int h2 = image2.getHeight(null)/2;
		
		if (value.equals("横向拼接")) {
			BufferedImage buf = new BufferedImage((w1+w2), h1, BufferedImage.TYPE_INT_RGB);
			
			
			Graphics g = buf.getGraphics();
			
			g.drawImage(image1, 0, 0, w1, h1, null);
			g.drawImage(image2, w1, 0, w2, h2, null);
			
			response.setContentType("image/jpg");
			ImageIO.write(buf, "jpg", response.getOutputStream());
		}
		else {
			BufferedImage buf = new BufferedImage(w1, (h1+h2), BufferedImage.TYPE_INT_RGB);
			
			
			Graphics g = buf.getGraphics();
			
			g.drawImage(image1, 0, 0, w1, h1, null);
			g.drawImage(image2, 0, h1, w2, h2, null);
			
			response.setContentType("image/jpg");
			ImageIO.write(buf, "jpg", response.getOutputStream());
		}
		
		
	}
}
