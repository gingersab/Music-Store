package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.assesment.datatypes.Singer;

@Repository
public class SingerDAO implements SingerInterfaceDAO {
	
	@Autowired 
	private EntityManager mEntityManager;

	@Override
	public List<Singer> allSingers() {
		Session currentSession = mEntityManager.unwrap(Session.class);
		Query<Singer> query = currentSession.createQuery("FROM Singer", Singer.class);
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
	}

}
