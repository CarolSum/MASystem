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
     
	    // �ϴ��ļ��洢Ŀ¼
	    private static final String UPLOAD_DIRECTORY = "D:\\JEE\\MASystem\\WebContent\\uploadFile";
	 
	    // �ϴ�����
	    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	 
	    /**
	     * �ϴ����ݼ������ļ�
	     */
	    protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException {
	    	
	    	User user = (User) request.getSession().getAttribute("user");
	    	Homework homework = (Homework) request.getSession().getAttribute("curHomework");
	    	
	        // ����Ƿ�Ϊ��ý���ϴ�
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // ���������ֹͣ
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: ��������� enctype=multipart/form-data");
	            writer.flush();
	            return;
	        }

	        // �����ϴ�����
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // ������ʱ�洢Ŀ¼
	        System.out.println("��ʱ�洢Ŀ¼��"+System.getProperty("java.io.tmpdir"));
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // ��������ļ��ϴ�ֵ
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // �����������ֵ (�����ļ��ͱ�����)
	        upload.setSizeMax(MAX_REQUEST_SIZE);

	        // ���Ĵ���
	        upload.setHeaderEncoding("UTF-8"); 

	        // ������ʱ·�����洢�ϴ����ļ�
	        // ���·����Ե�ǰӦ�õ�Ŀ¼
//	        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	        String uploadPath = UPLOAD_DIRECTORY;
	        System.out.println(uploadPath);
	        String filePath = "";
	        
	        // ���Ŀ¼�������򴴽�
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	            // ���������������ȡ�ļ�����
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // ����������
	                for (FileItem item : formItems) {
	                    // �����ڱ��е��ֶ�
	                    if (!item.isFormField()) {
	                        String fileName = user.getSid() + "-��ҵ" + homework.getId() + "-" + new File(item.getName()).getName();
	                        
	                        filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	                        // �ڿ���̨����ļ����ϴ�·��
	                        System.out.println(filePath);
	                        // �����ļ���Ӳ��
	                        item.write(storeFile);
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
	        /**
	         * ����homeworkItem״̬
	         * ��¼�ϴ���Url
	         */
	        HomeworkItemDAO hid = new HomeworkItemDAO();
	        HomeworkItem hi = (HomeworkItem) request.getSession().getAttribute("curHomeworkItem");
	        hi.setStatus(HomeworkItem.HomeworkStatus_HasSubmit);
	        hi.setUploadURL(filePath);
	        hid.update(hi);
	        
	        System.out.println(filePath.substring(filePath.lastIndexOf("\\")+1));
	        
	        //�����ϴ���ҵ�ɹ���Ϣ~
	        MsgTool.send(user.getName(), "��ҵ"+homework.getId()+"���ύ~�����>.<");
	        
	        // ��ת�� homework-detail.jsp
	        request.getRequestDispatcher("homework-detail.jsp").forward(request, response);
	    }
}
