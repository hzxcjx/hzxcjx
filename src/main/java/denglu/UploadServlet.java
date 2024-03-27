package denglu;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/sc/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part part = request.getPart("photo");
		//获取文件名
		String dis = part.getHeader("content-disposition");
		String fileName = dis.split(";")[2].split("=")[1].replaceAll("\"","");
		//获取扩展名		
		int pos = fileName.lastIndexOf(".");
		String ext= fileName.substring(pos);
		System.out.println(ext);
		
		//随机生成一个文件名，扩展名不变
		String rndName = UUID.randomUUID().toString().toUpperCase();
		
		//获取发布后的工程根目录
		String root= this.getServletContext().getRealPath("");
		System.out.println(root);
		//创建images子文件夹
		File images = new File(root,"images");
		if (!images.exists()) {
			images.mkdirs();//不存在，则创建images文件夹
		}
		
		String photo =root +"/images/"+ rndName + ext;
		part.write(photo);
		
		request.setAttribute("photo",rndName +ext);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		
	}
}

