package com.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilters extends ZuulFilter {
	
private static org.slf4j.Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilters.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info(String.format("%s request unrutado a %s", request.getMethod(), request.getRequestURL().toString()));

		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		return null;
	}

	@Override
	public String filterType() {
		// Tipo de filtro, hay de tipo "pre" "post "route"
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
