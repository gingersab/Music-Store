package com.nextgate.assesment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.dataaccessobjects.SingerDAO;
import com.nextgate.assesment.datatypes.Singer;

@Service
public class SingerService implements SingerServiceInterface {
	
	@Autowired
	private SingerDAO mSingerDAO;

	@Transactional
	@Override
	public List<Singer> allSingers() {
		return mSingerDAO.allSingers();
	}

	@Transactional
	@Override
	public Singer getSinger(String aSingerName) {
		return mSingerDAO.getSinger(aSingerName);
	}

	@Transactional
	@Override
	public void addSinger(Singer aSinger) {
		mSingerDAO.addSinger(aSinger);
	}

	@Override
	public List<Singer> Search(String aSearchTerm) {
		return mSingerDAO.Search(aSearchTerm);
	}

}
