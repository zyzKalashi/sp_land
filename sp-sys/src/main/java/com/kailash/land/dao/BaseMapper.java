package com.kailash.land.dao;

import org.apache.poi.ss.formula.functions.T;

@SuppressWarnings("hiding")
public interface BaseMapper<T> {
	
	int instertEntity(T enetiy);
	
	int updateEntity(T enetiy);
}
