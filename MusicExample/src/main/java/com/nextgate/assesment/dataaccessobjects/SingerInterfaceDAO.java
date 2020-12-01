package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import com.nextgate.assesment.datatypes.Singer;

public interface SingerInterfaceDAO {
	List<Singer> allSingers();
	Singer getSinger(String aSingerName);
	void addSinger(Singer aSinger);
}
