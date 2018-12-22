package com.kailash.land.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.kailash.land.service.NewsService;

public class NewsController implements Serializable {
	@Autowired
	private NewsService newsService;
}
