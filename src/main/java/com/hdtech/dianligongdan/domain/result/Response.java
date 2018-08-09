package com.hdtech.dianligongdan.domain.result;

public class Response {
	private String statusCode="";
	private String message="操作成功";
	private Object data;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Response(String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public Response(String statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
}
