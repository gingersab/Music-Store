package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import com.nextgate.assesment.datatypes.Album;

public interface AlbumInterfaceDAO {
	List<Album> allAlbums();
	Album getAlbum(String aAlbumName);
	void addAlbum(Album aAlbum);
}
