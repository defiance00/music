package org.company.app.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String email;
	private String passwd;
	private String newpasswd;
	private String zipcode;
	private String addr;
	private String addrdetail;
	private String filename;
	private String emailauth="0";
	private String simplejoin="0";
	private Date regidate;
	MultipartFile photofile;
	public Member() {
		super();
	}
	public Member(String email, String passwd, String newpasswd, String zipcode, String addr, String addrdetail,
			String filename, String emailauth, String simplejoin, Date regidate, MultipartFile photofile) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.newpasswd = newpasswd;
		this.zipcode = zipcode;
		this.addr = addr;
		this.addrdetail = addrdetail;
		this.filename = filename;
		this.emailauth = emailauth;
		this.simplejoin = simplejoin;
		this.regidate = regidate;
		this.photofile = photofile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNewpasswd() {
		return newpasswd;
	}
	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrdetail() {
		return addrdetail;
	}
	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getEmailauth() {
		return emailauth;
	}
	public void setEmailauth(String emailauth) {
		this.emailauth = emailauth;
	}
	public String getSimplejoin() {
		return simplejoin;
	}
	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public MultipartFile getPhotofile() {
		return photofile;
	}
	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", passwd=" + passwd + ", newpasswd=" + newpasswd + ", zipcode=" + zipcode
				+ ", addr=" + addr + ", addrdetail=" + addrdetail + ", filename=" + filename + ", emailauth="
				+ emailauth + ", simplejoin=" + simplejoin + ", regidate=" + regidate + ", photofile=" + photofile
				+ "]";
	}
	
}
