package com.nicolaslagos.festivities.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.hibernate.exception.ConstraintViolationException;

import com.nicolaslagos.festivities.domain.Festivity;
import com.nicolaslagos.festivities.repository.FestivityDao;
 

/**
 * @author Nicolas Lagos Ruiz
 *
 */


@Path("/festivity")
public class FestivityController {
		
	    @GET
	    @Produces("application/json,application/xml")
	    public List<Festivity> getFestivities() {
	    	try{
	    		return  FestivityDao.getInstance().getFestivity();
	    	}
	    	catch (NotFoundException nfex){
	    		throw nfex;
	    	}
	    	catch (Exception ex){
	    		throw new InternalServerErrorException(ex.getMessage());	    		
	    	}			
	    }	 
	    
	    @GET
	    @Path("/by")	    
	    @Produces("application/json,application/xml")
	    public List<Festivity> getFestivities(@QueryParam("id") final int id, @QueryParam("name") final String name, 
	    		@QueryParam("place") final String place, @QueryParam("start") final String start,  @QueryParam("end") final String end,
	    		 @QueryParam("between1") final String between1,  @QueryParam("between2") final String between2) {
	    	
	    	Map<String, Object> queryFields = new HashMap<String, Object>();
	    	try{
	    	queryFields.put("name", name);
	    	queryFields.put("place", place);
	    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    	Date startDate = null;
	    	Date endDate = null;
	    	try {
				if(start != null)				
						startDate = simpleDateFormat.parse(start.toString());					
				if(end != null)
					endDate = simpleDateFormat.parse(end.toString());
	    	} catch (ParseException e) {
				throw new Exception ("Error while parsing date");
			}
    		queryFields.put("start", startDate);
	    	queryFields.put("end", endDate);
    		if(between1 != null)
				queryFields.put("between1D", between1);
			if(between2 != null)
				queryFields.put("between2D", between2);	    	
	    	
	    	//TODO check why when there is not id in the url it is set to 0
	    	if(id == 0)
	    		queryFields.put("id", null);
	    	else
	    		queryFields.put("id", id);	    	
	    	
	        return  FestivityDao.getInstance().getFestivity(queryFields);
	    	}
	        catch (NotFoundException nfex){
	    		throw nfex;
	    	}
	    	catch (Exception ex){
	    		throw new InternalServerErrorException(ex.getMessage());	    		
	    	}
	    }
	    
	    @POST
	    @Consumes("application/xml,application/json")
	    public Response addFestivity(Festivity festivity){	   
	    	try{
	    	FestivityDao.getInstance().addFestivity(festivity);	        
	        return Response.ok().build();
	    	}
	    	catch (ConstraintViolationException cvEx)
	    	{
	    		throw new BadRequestException(cvEx.getMessage());
	    	}
	        catch (BadRequestException brEx){
	    		throw brEx;
	    	}
	    	catch (Exception ex){
	    		throw new InternalServerErrorException(ex.getMessage());	    		
	    	}	    	
	    }	    
	    
	    @Path("/ETL")
	    @POST
	    @Consumes("application/xml")
	    public Response addListFestivity(List<Festivity> listFestivity){
	    	try{
	    	FestivityDao.getInstance().addListFestivity(listFestivity);	        
	        return Response.ok().build();
	    	}
	    	catch (ConstraintViolationException cvEx)
	    	{
	    		throw new BadRequestException(cvEx.getMessage());
	    	}
	        catch (BadRequestException brEx){
	    		throw brEx;
	    	}
	        catch (Exception ex){
	    		throw new InternalServerErrorException(ex.getMessage());	    		
	    	}	 
	    }
	    
	    @PUT
	    @Consumes("application/json")
	    public Response updateEmployee(@QueryParam("id") int id, Festivity festivity){
	    	try{
	    	FestivityDao.getInstance().updateFestivity(id, festivity);
	        return Response.ok().build();
	    	}
	        catch (ConstraintViolationException cvEx)
	    	{
	    		throw new BadRequestException(cvEx.getMessage());
	    	}
	        catch (BadRequestException brEx){
	    		throw brEx;
	    	}
	        catch (Exception ex){
	    		throw new InternalServerErrorException(ex.getMessage());	    		
	    	}	 
	    }

	}
	 