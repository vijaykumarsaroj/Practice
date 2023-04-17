package net.codejava;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myResource")
public class HelloResource {
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello, It's working";
	}
	
	@GET
	@Path("sayHTMLHello")
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
	    return "<html><title>Hello</title><body><h1>This is First HTML Page </h1><body></html>";
	}
	
	@GET
	@Path("sayJsonHello") 
	public String sayJsonHello() {
	    return "{\"name\":\"greeting\", \"message\":\"Hello I am doing good!\"}";
	}
	
	
}
