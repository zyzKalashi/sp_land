package com.kailash.land.common.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorConfig {

	/**
	 * 运行时异常
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException exception) {
		ModelAndView m = new ModelAndView();
		m.addObject("exception", exception.getMessage());
		m.setViewName("/error");
		return m;

	}

	/**
	 * Excepiton异常
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(Exception exception) {
		ModelAndView m = new ModelAndView();
		m.addObject("exception", exception.getMessage());
		m.setViewName("/error");
		return m;

	}
}