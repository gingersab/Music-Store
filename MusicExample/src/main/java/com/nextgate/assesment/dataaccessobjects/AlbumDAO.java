package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.User;

@Repository
public class AlbumDAO implements AlbumInterfaceDAO {
	
	@Autowired 
	private EntityManager mEntityManager;

	@Override
	public List<Album> allAlbums() {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Album> query = currentSession.createQuery("FROM Album a ORDER BY a.mAlbumYear", Album.class);
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
		System.out.println("Added new Album with title " + aAlbum.getAlbumName());
	}

	@Override
	public List<Album> Search(String aSearchTerm) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Album> query = currentSession.createQuery("FROM Album a where a.mAlbumName LIKE :searchQuery ORDER BY a.mAlbumYear", Album.class)
				.setParameter("searchQuery",'%'+aSearchTerm+'%');
		List<Album> allAlbums = query.getResultList();
		System.out.println(String.format("Found %1$d albums using search term %2$s", allAlbums.size(), aSearchTerm ));
		return allAlbums;
	}
}
