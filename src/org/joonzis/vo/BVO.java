package org.joonzis.vo;

import java.sql.Date;

public class BVO {
	private int b_idx, hit;
	private String writer, title, content, pw, ip, filename;
	private Date reg_date;
	
	public BVO() {
		super();
	}

	public BVO(int b_idx, int hit, String writer, String title, String content, String pw, String ip, String filename,
			Date reg_date) {
		super();
		this.b_idx = b_idx;
		this.hit = hit;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.pw = pw;
		this.ip = ip;
		this.filename = filename;
		this.reg_date = reg_date;
	}
	
	public int getB_idx() {
		return b_idx;
	}
	
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
