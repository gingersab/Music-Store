package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;

@Repository
public class SingerDAO implements SingerInterfaceDAO {
	
	@Autowired 
	private EntityManager mEntityManager;

	@Override
	public List<Singer> allSingers() {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Singer> query = currentSession.createQuery("FROM Singer s ORDER BY s.mSingerName", Singer.class);
		List<Singer> allSingers = query.getResultList();
		return allSingers;
	}

	@Override
	public Singer getSinger(String aSingerName) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Singer aSinger = currentSession.get(Singer.class, aSingerName);
		return aSinger;
	}

	@Override
	public void addSinger(Singer aSinger) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(aSinger);
		System.out.println("Added new Singer with name " + aSinger.getSingerName());
	}

	@Override
	public List<Singer> Search(String aSearchTerm) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Singer> query = currentSession.createQuery("FROM Singer a where a.mSingerName LIKE :searchQuery ORDER BY a.mSingerName", Singer.class)
				.setParameter("searchQuery",'%'+aSearchTerm+'%');
		List<Singer> allSingers = query.getResultList();
		System.out.println(String.format("Found %1$d singers using search term %2$s", allSingers.size(), aSearchTerm ));
		return allSingers;
	}

}
