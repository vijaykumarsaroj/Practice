package net.codejava;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")

public class AlienResource {
	
	AlienRepository repo=new AlienRepository();
	
	@GET
	@Path("getAlien")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAlien() {
		System.out.println("get alien called...");
		
		return repo.getAliens();
		/*
		Alien a1=new Alien();
		a1.setId(12);
		a1.setName("manish");
		a1.setPoints(50);
		
		Alien a2=new Alien();
		a2.setId(13);
		a2.setName("rajesh");
		a1.setPoints(60);
		
		List<Alien>aliens=Arrays.asList(a1,a2);
		
		return aliens;
		*/
	}
	
	@POST
	@Path("alien")
	//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien a1) {
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0) {
			repo.create(a1);
		}
		else {
			repo.update(a1);
		}
		return a1;
	}
	
	@GET
	@Path("getAlienById/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id){
		return repo.getAlien(id);
	}
	
	@DELETE
	@Path("deleteAlien/{id}")
	public Alien killAlien(@PathParam("id") int id) {
		Alien a=repo.getAlien(id);
		if(a.getId()!=0) {
			repo.delete(id);
		}
		return a;
	}
	
	@GET
	@Path("Hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello() {
		return "we are done";
	}
}

