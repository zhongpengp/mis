package common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String filename = request.getParameter("filename");
		 String [] Name = filename.split("/");
		 String sp = System.getProperty("file.separator"); 
	   //设置文件MIME类型  
	        response.setContentType(getServletContext().getMimeType(filename));  
	        //设置Content-Disposition  
	        response.setHeader("Content-Disposition", "attachment;filename="+filename);
	        String uploadPath = request.getSession().getServletContext().getRealPath("");
			uploadPath = uploadPath.split("mis")[0];
			int endIndex = uploadPath.lastIndexOf(File.separator);
			uploadPath = uploadPath.substring(0, endIndex);
	        //读取目标文件，通过response将目标文件写到客户端  
	        //获取目标文件的绝对路径  
	        String fullFileName = uploadPath +sp+Name[1]+sp+Name[2];  
	        //读取文件  
	        InputStream in = new FileInputStream(fullFileName);  
	        OutputStream out = response.getOutputStream();       
	        //写文件  
	        byte[] buffer = new byte[1024];
			int len ; 
	        while((len=in.read(buffer))!= -1)  
	        {  
	        	out.write(buffer, 0, len); 
	        }  
	          
	        in.close();  
	        out.close();  
	    }  
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
