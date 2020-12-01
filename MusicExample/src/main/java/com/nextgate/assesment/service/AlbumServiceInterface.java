package com.nextgate.assesment.service;

import java.util.List;

import com.nextgate.assesment.datatypes.Album;

public interface AlbumServiceInterface {
	List<Album> allAlbums();
	Album getAlbum(String aAlbumName);
	void addAlbum(Album aAlbum);
}
