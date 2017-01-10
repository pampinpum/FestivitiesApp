package com.nicolaslagos.festivities.web;

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
import javax.ws.rs.core.Response;

import com.nicolaslagos.festivities.domain.Festivity;
import com.nicolaslagos.festivities.repository.FestivityDao;
 

@Path("/festivity")
public class FestivityController {
		
	    @GET
	    @Produces("application/json")
	    public List<Festivity> getFestivities() {
	        return  FestivityDao.getInstance().getFestivities();
	    }	 
	    
	    @POST
	    @Consumes("application/xml,application/json")
	    public Response addFestivity(Festivity festivity){
	    	FestivityDao.getInstance().addFestivity(festivity);	        
	        return Response.ok().build();
	    }	    
	    
	    @Path("/ETL")
	    @POST
	    @Consumes("application/xml")
	    public Response addListFestivity(List<Festivity> listFestivity){
	    	FestivityDao.getInstance().addListFestivity(listFestivity);	        
	        return Response.ok().build();
	    }
	    
	    @PUT
	    //@Path("/update/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Festivity festivity){
	        int count = FestivityDao.getInstance().updateFestivitie(id, festivity);
	        return Response.ok().build();
	    }
	    
	    @DELETE
	    @Path("/{id}")
	    @Consumes("application/json")
	    public Response deleteEmployee(@PathParam("id") int id){
	        int count = FestivityDao.getInstance().deleteFestivity(id);
	        return Response.ok().build();
	    }
	}
	 