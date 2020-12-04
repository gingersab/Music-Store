package com.nextgate.assesment.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.dataaccessobjects.AlbumDAO;
import com.nextgate.assesment.datatypes.Album;

@Service
public class AlbumService implements AlbumServiceInterface {

	@Autowired
	private AlbumDAO mAlbumDAO;

	@Transactional
	@Override
	public List<Album> allAlbums() {
		return mAlbumDAO.allAlbums();
	}

	@Transactional
	@Override
	public Album getAlbum(String aAlbumName) {
		return mAlbumDAO.getAlbum(aAlbumName);
	}

	@Transactional
	@Override
	public void addAlbum(Album aAlbum) {
		mAlbumDAO.addAlbum(aAlbum);
	}

	@Override
	public List<Album> Search(String aSearchTerm) {
		return mAlbumDAO.Search(aSearchTerm);
	}
}
