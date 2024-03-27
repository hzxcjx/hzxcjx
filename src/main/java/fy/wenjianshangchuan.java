package fy;

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

/**
 * Servlet implementation class wenjianshangchuang
 */
@WebServlet("/wenjianshangchuan")
@MultipartConfig
public class wenjianshangchuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wenjianshangchuan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("photo");
		String dis = part.getHeader("content-disposition");
		String fileName = dis.split(";")[2].split("=")[1].replaceAll("\"","");
		int pos = fileName.lastIndexOf('.');
		String ext= fileName.substring(pos);
		System.out.println(ext);
		String rndName = UUID.randomUUID().toString()
						.toUpperCase();
		String root= this.getServletContext().getRealPath("");
		System.out.println(root);
		File images = new File(root,"images");
		if(!images.exists()){
			images.mkdirs();
		}
		String photo =root +"/images/"+ rndName + ext;
		part.write(photo);
		request.setAttribute("photo",rndName +ext);
		request.getRequestDispatcher("upload.jsp");
	}

}