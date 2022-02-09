package org.company.app.dto;

public class Music {
	private int artistnumber; //아티스트 번호
	private String artistname; //아티스트명
	private String origin; //출신지
	private String genres; //장르
	private String yearsactive; //활동연도
	public Music() {
		super();
	}
	public Music(int artistnumber, String artistname, String origin, String genres, String yearsactive) {
		super();
		this.artistnumber = artistnumber;
		this.artistname = artistname;
		this.origin = origin;
		this.genres = genres;
		this.yearsactive = yearsactive;
	}
	public int getArtistnumber() {
		return artistnumber;
	}
	public void setArtistnumber(int artistnumber) {
		this.artistnumber = artistnumber;
	}
	public String getArtistname() {
		return artistname;
	}
	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getYearsactive() {
		return yearsactive;
	}
	public void setYearsactive(String yearsactive) {
		this.yearsactive = yearsactive;
	}
	@Override
	public String toString() {
		return "Music [artistnumber=" + artistnumber + ", artistname=" + artistname + ", origin=" + origin + ", genres="
				+ genres + ", yearsactive=" + yearsactive + "]";
	}
	
	
	
	
}
