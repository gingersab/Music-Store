package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import com.nextgate.assesment.datatypes.Album;

public interface AlbumInterfaceDAO {
	List<Album> allAlbums();
	List<Album> Search(String aSearchTerm);
	Album getAlbum(String aAlbumName);
	void addAlbum(Album aAlbum);
}
