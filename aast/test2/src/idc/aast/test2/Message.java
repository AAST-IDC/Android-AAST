package idc.aast.test2;

public class Message {
	private String message;
	private String message_title;
	private String message_desc;
	private String Serial;
	private String Read;
	private String dateTime;
	private String link;
	private String sys_code;
	private String sys_name;
	private String user_name;
	private String user_type;
	public int  id;
	public Message(String message,String message_title,String message_desc,String Read,String datetime,String link,String sys_code,String sys_name,String user_name,String user_type, String Serial)
	{
		this.message=message;
		this.message_title=message_title;
		this.message_desc=message_desc;
		this.Serial=Serial;
		this.Read=Read;
		this.dateTime=datetime;
		this.link=link;
		this.sys_code=sys_code;
		this.sys_name=sys_name;
		this.user_name=user_name;
		this.user_type=user_type;
		
		
	}
	public Message(int id,String message,String message_title,String message_desc,String Read,String datetime,String link,String sys_code,String sys_name,String user_name,String user_type, String Serial)
	{
		this.message=message;
		this.message_title=message_title;
		this.message_desc=message_desc;
		this.Serial=Serial;
		this.Read=Read;
		this.dateTime=datetime;
		this.link=link;
		this.sys_code=sys_code;
		this.sys_name=sys_name;
		this.user_name=user_name;
		this.user_type=user_type;
		this.id=id;
		
		
	}
	
	public Message(String message,String dateTime,String user_name,String user_type)
	{
		String[] arr = message.split("\\^");
		this.message=message;
		this.message_title=arr[2];
		this.message_desc=arr[0];
		this.Serial=arr[3];
		this.Read=arr[6].substring(0,1);
		this.dateTime=dateTime;
		this.link=arr[1];
		this.sys_code=arr[4];
		this.sys_name=arr[5];
		this.user_name=user_name;
		this.user_type=user_type;
		
		
	}
	public String getSerial() {
		return Serial;
	}
	public void setSerial(String serial) {
		Serial = serial;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage_title() {
		return message_title;
	}
	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	public String getMessage_desc() {
		return message_desc;
	}
	public void setMessage_desc(String message_desc) {
		this.message_desc = message_desc;
	}
	public String getRead() {
		return Read;
	}
	public void setRead(String read) {
		Read = read;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSys_code() {
		return sys_code;
	}
	public void setSys_code(String sys_code) {
		this.sys_code = sys_code;
	}
	public String getSys_name() {
		return sys_name;
	}
	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}
