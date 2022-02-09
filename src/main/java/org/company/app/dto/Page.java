package org.company.app.dto;

public class Page {
	private String findkey;
	private String findvalue;
	private int curPage=1;
	private int perPage=10;
	private int perBlock=10;
	
	private int totPage;
	private int startNum;
	private int endNum;
	private int startPage;
	private int endPage;
	public Page() {
		super();
	}
	public Page(String findkey, String findvalue, int curPage, int perPage, int perBlock, int totPage, int startNum,
			int endNum, int startPage, int endPage) {
		super();
		this.findkey = findkey;
		this.findvalue = findvalue;
		this.curPage = curPage;
		this.perPage = perPage;
		this.perBlock = perBlock;
		this.totPage = totPage;
		this.startNum = startNum;
		this.endNum = endNum;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public String getFindkey() {
		return findkey;
	}
	public void setFindkey(String findkey) {
		this.findkey = findkey;
	}
	public String getFindvalue() {
		return findvalue;
	}
	public void setFindvalue(String findvalue) {
		this.findvalue = findvalue;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "Page [findkey=" + findkey + ", findvalue=" + findvalue + ", curPage=" + curPage + ", perPage=" + perPage
				+ ", perBlock=" + perBlock + ", totPage=" + totPage + ", startNum=" + startNum + ", endNum=" + endNum
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}
