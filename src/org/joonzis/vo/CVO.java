package org.joonzis.vo;

import java.sql.Date;

public class CVO {
	private int c_idx, b_idx;
	private String writer, content, pw, ip; 
	private Date reg_date;
	
	public CVO() {
		super();
	}

	public CVO(int c_idx, int b_idx, String writer, String content, String pw, String ip, Date reg_date) {
		super();
		this.c_idx = c_idx;
		this.b_idx = b_idx;
		this.writer = writer;
		this.content = content;
		this.pw = pw;
		this.ip = ip;
		this.reg_date = reg_date;
	}
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
