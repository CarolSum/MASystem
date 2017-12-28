package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Homework;
import models.HomeworkItem;
import models.HomeworkItemDAO;
import models.User;
import widgets.MsgTool;


public class UploadServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	    // 上传文件存储目录
	    private static final String UPLOAD_DIRECTORY = "D:\\JEE\\MASystem\\WebContent\\uploadFile";
	 
	    // 上传配置
	    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	 
	    /**
	     * 上传数据及保存文件
	     */
	    protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
	    	
	    	User user = (User) request.getSession().getAttribute("user");
	    	Homework homework = (Homework) request.getSession().getAttribute("curHomework");
	    	
	        // 检测是否为多媒体上传
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // 如果不是则停止
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
	            writer.flush();
	            return;
	        }

	        // 配置上传参数
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // 设置临时存储目录
	        System.out.println("临时存储目录："+System.getProperty("java.io.tmpdir"));
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // 设置最大文件上传值
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // 设置最大请求值 (包含文件和表单数据)
	        upload.setSizeMax(MAX_REQUEST_SIZE);

	        // 中文处理
	        upload.setHeaderEncoding("UTF-8"); 

	        // 构造临时路径来存储上传的文件
	        // 这个路径相对当前应用的目录
//	        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	        String uploadPath = UPLOAD_DIRECTORY;
	        System.out.println(uploadPath);
	        String filePath = "";
	        
	        // 如果目录不存在则创建
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	            // 解析请求的内容提取文件数据
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // 迭代表单数据
	                for (FileItem item : formItems) {
	                    // 处理不在表单中的字段
	                    if (!item.isFormField()) {
	                        String fileName = user.getSid() + "-作业" + homework.getId() + "-" + new File(item.getName()).getName();
	                        
	                        filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	                        // 在控制台输出文件的上传路径
	                        System.out.println(filePath);
	                        // 保存文件到硬盘
	                        item.write(storeFile);
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
	        /**
	         * 更新homeworkItem状态
	         * 记录上传的Url
	         */
	        HomeworkItemDAO hid = new HomeworkItemDAO();
	        HomeworkItem hi = (HomeworkItem) request.getSession().getAttribute("curHomeworkItem");
	        hi.setStatus(HomeworkItem.HomeworkStatus_HasSubmit);
	        hi.setUploadURL(filePath);
	        hid.update(hi);
	        
	        System.out.println(filePath.substring(filePath.lastIndexOf("\\")+1));
	        
	        //发送上传作业成功消息~
	        MsgTool.send(user.getName(), "作业"+homework.getId()+"已提交~请查收>.<");
	        
	        // 跳转到 homework-detail.jsp
	        request.getRequestDispatcher("homework-detail.jsp").forward(request, response);
	    }
}
