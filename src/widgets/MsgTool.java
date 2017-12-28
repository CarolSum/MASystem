package widgets;

import java.text.SimpleDateFormat;
import java.util.Date;

import models.Message;
import models.MessageDAO;

public class MsgTool {

	public static void send(String ownerName, String msg) {
		// TODO Auto-generated method stub
		 MessageDAO md = new MessageDAO();
		 Message message = new Message();
		 Date date = new Date();
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String dateString = formatter.format(date);
	     System.out.println(dateString);
		 message.setOwner(ownerName);
		 message.setMsg(msg);
		 message.setDate(dateString);
		 md.insert(message);
	}

}
