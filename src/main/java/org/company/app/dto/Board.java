package org.company.app.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class Board {
	private int bnum;
	private String email;
	private String subject;
	private String content;
	private int readcnt;
	private String ip;
	private Date regidate;
	private Date modidate;
	private String removeyn;
	public Board() {
		super();
	}
	public Board(int bnum, String email, String subject, String content, int readcnt, String ip, Date regidate,
			Date modidate, String removeyn) {
		super();
		this.bnum = bnum;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.readcnt = readcnt;
		this.ip = ip;
		this.regidate = regidate;
		this.modidate = modidate;
		this.removeyn = removeyn;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public String getRemoveyn() {
		return removeyn;
	}
	public void setRemoveyn(String removeyn) {
		this.removeyn = removeyn;
	}
	@Override
	public String toString() {
		return "Board [bnum=" + bnum + ", email=" + email + ", subject=" + subject + ", content=" + content
				+ ", readcnt=" + readcnt + ", ip=" + ip + ", regidate=" + regidate + ", modidate=" + modidate
				+ ", removeyn=" + removeyn + "]";
	}

	
	
	
}
