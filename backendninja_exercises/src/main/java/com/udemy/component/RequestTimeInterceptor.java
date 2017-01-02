package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	//Sera executado antes de entrar no metodo do Controller
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
	}

	@Override
	//Sera executado antes de renderizar a view no navegador
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long startTime = (long) request.getAttribute("startTime");
		
		String finalMessage = "--REQUEST URL: '" + request.getRequestURL().toString() + "' -- TOTAL TIME: '" + (System.currentTimeMillis() - startTime) + "'ms";
		
		request.setAttribute("finalMessage", finalMessage);
		
		LOGGER.info(finalMessage);
	}	
}