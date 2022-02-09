package org.company.app.dto;

public class Album {
	private int albumnumber; 
	private int artistnumber; 
	private String albums;
	private String images;
	private String favtracks;
	private String clipid;
	
	private String artistname;
	private String origin;
	private String genres;
	private String yearsactive;
	public Album() {
		super();
	}
	public Album(int albumnumber, int artistnumber, String albums, String images, String favtracks, String clipid,
			String artistname, String origin, String genres, String yearsactive) {
		super();
		this.albumnumber = albumnumber;
		this.artistnumber = artistnumber;
		this.albums = albums;
		this.images = images;
		this.favtracks = favtracks;
		this.clipid = clipid;
		this.artistname = artistname;
		this.origin = origin;
		this.genres = genres;
		this.yearsactive = yearsactive;
	}
	public int getAlbumnumber() {
		return albumnumber;
	}
	public void setAlbumnumber(int albumnumber) {
		this.albumnumber = albumnumber;
	}
	public int getArtistnumber() {
		return artistnumber;
	}
	public void setArtistnumber(int artistnumber) {
		this.artistnumber = artistnumber;
	}
	public String getAlbums() {
		return albums;
	}
	public void setAlbums(String albums) {
		this.albums = albums;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getFavtracks() {
		return favtracks;
	}
	public void setFavtracks(String favtracks) {
		this.favtracks = favtracks;
	}
	public String getClipid() {
		return clipid;
	}
	public void setClipid(String clipid) {
		this.clipid = clipid;
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
		return "Album [albumnumber=" + albumnumber + ", artistnumber=" + artistnumber + ", albums=" + albums
				+ ", images=" + images + ", favtracks=" + favtracks + ", clipid=" + clipid + ", artistname="
				+ artistname + ", origin=" + origin + ", genres=" + genres + ", yearsactive=" + yearsactive + "]";
	}
	
	

}
