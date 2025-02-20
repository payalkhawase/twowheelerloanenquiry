package in.shriram.dreambiketwowheelerloan.model.dto;

import java.util.Date;

public class UserResponse {

	private String msg;
	private Date timestamp;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public UserResponse(String msg, Date timestamp) {
		super();
		this.msg = msg;
		this.timestamp = timestamp;
	}
	public UserResponse() {
		
		super();
		
	}
}
