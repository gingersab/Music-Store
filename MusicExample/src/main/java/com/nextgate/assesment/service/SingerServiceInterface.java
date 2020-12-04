package com.nextgate.assesment.service;

import java.util.List;
import com.nextgate.assesment.datatypes.Singer;

public interface SingerServiceInterface {
	List<Singer> allSingers();
	List<Singer> Search(String aSearchTerm);
	Singer getSinger(String aSingerName);
	void addSinger(Singer aSinger);
}
