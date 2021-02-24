package com.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilters extends ZuulFilter {
	
private static org.slf4j.Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilters.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Entrando a post filter");

		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		log.info(String.format("Tiempo transcurrido en segundos: %s", tiempoTranscurrido.doubleValue()/1000.00));
		
		return null;
	}

	@Override
	public String filterType() {
		// Tipo de filtro, hay de tipo "pre" "post "route" "error"
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
