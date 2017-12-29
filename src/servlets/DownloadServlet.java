package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.HomeworkItem;
import models.HomeworkItemDAO;

public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		HomeworkItemDAO hid = new HomeworkItemDAO();
		int hiid = Integer.parseInt(request.getParameter("hiid"));
		System.out.println(hiid);
		HomeworkItem hi =  hid.getHomeworkItemByHiId(hiid);
//		(HomeworkItem) request.getSession().getAttribute("curHomeworkItem");
		System.out.println(hi.getUploadURL());
			
        //处理请求  
        //读取要下载的文件  
        File f = new File(hi.getUploadURL());  
        if(f.exists()){  
            FileInputStream  fis = new FileInputStream(f);  
            String filename=URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题  
            byte[] b = new byte[fis.available()];  
            fis.read(b);  
            response.setCharacterEncoding("utf-8");  
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");  
            //获取响应报文输出流对象  
            ServletOutputStream  out =response.getOutputStream();  
            //输出  
            out.write(b);  
            out.flush();  
            out.close();  
            fis.close();
        }     
    }  
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        
          
    }  
}
