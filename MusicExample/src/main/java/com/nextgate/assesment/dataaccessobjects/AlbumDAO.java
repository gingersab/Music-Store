package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.assesment.datatypes.Album;

@Repository
public class AlbumDAO implements AlbumInterfaceDAO {
	
	@Autowired 
	private EntityManager mEntityManager;

	@Override
	public List<Album> allAlbums() {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Album> query = currentSession.createQuery("FROM Album", Album.class);
		List<Album> allAlbums = query.getResultList();
		return allAlbums;
	}

	@Override
	public Album getAlbum(String aAlbumName) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Album aAlbum = currentSession.get(Album.class, aAlbumName);
		return aAlbum;
	}

	@Override
	public void addAlbum(Album aAlbum) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(aAlbum);
	}
}
