package com.nicolaslagos.festivities.repository;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nicolaslagos.festivities.domain.Festivity;
import com.nicolaslagos.festivities.util.SessionUtil;

/**
 * @author Nicolas Lagos
 *
 */
public class FestivityDao {
    
	private static FestivityDao festivityDao;
	
	/**
	 * Singleton, returns the unique instance of FestivityDao
	 * @return festivityDao instance
	 */
	public static synchronized FestivityDao getInstance(){
		if(festivityDao == null)
			festivityDao = new FestivityDao();
		return festivityDao;		
	}
	
	/**
	 * Overrides Object clone() to prevent it
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Adds a new festivity
	 * @param festivity to be added
	 */
    public void addFestivity(Festivity festivity){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        session.save(festivity);      
        tx.commit();
        session.close();        
    }
    
    /**
     * Adds a list of festivities
     * @param listFestivity List of festivities
     */
    public void addListFestivity(List<Festivity> listFestivity){
    	for (Festivity festivity : listFestivity){
    		Session session = SessionUtil.getSession();        
            Transaction tx = session.beginTransaction();
            session.save(festivity);      
            tx.commit();
            session.close();     
    	}    	
    }
    
    /**
     * Gets all the festivities
     * @return List<Festivity> festivities
     */
    public List<Festivity> getFestivity() throws Exception, NotFoundException {
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Festivity");
        List<Festivity> festivities =  query.list();
        session.close();
        if(festivities.isEmpty())
        	throw new NotFoundException("No records found to display");
        return festivities;
    }   
    
    /**
     * Makes a custon query and to retive a Festivy List
     * @param queryFields Map<String, Object> with row in the key and the value in the value
     * @return List<Festivity> result of the query
     */
    public List<Festivity> getFestivity(Map<String, Object> queryFields){
    	Query query = null;
        Session session = SessionUtil.getSession();    
        StringBuilder queryString = new StringBuilder();
        queryString.append("from Festivity f WHERE ");        
        
       if (queryFields.containsKey("between1D") && queryFields.containsKey("between2D")) {
        	 String between1D = (String) queryFields.get("between1D");
        	 String between2D = (String) queryFields.get("between2D");
        	 queryString.append(" f.start BETWEEN  '" + between1D + "' AND '" + between2D + "' AND ");
        	 queryFields.remove("between1D");
        	 queryFields.remove("between2D");
        }
       
       Iterator<Entry<String, Object>> iterator = queryFields.entrySet().iterator();        
        while (iterator.hasNext()) {        
        	Entry<String, Object> entry = (Entry) iterator.next(); 
        	if(entry.getValue() == null){
        		iterator.remove();
        		queryFields.remove(entry.getKey());
        	}
        	else
        		queryString.append("f." + entry.getKey() + " =:" + entry.getKey() + " AND ");
        }
        
        //TODO check if there's a way to create the query before putting the string query
        query = session.createQuery(queryString.toString().substring(0, queryString.length() - 5));

        for (Entry<String, Object> entry : queryFields.entrySet())
        	query.setParameter(entry.getKey(), entry.getValue());   
        
        List<Festivity> festivities =  query.list();
        session.close();
        return festivities;
    }
     
    /**
     * Updates a festivity
     * @param id festivity id 
     * @param festivity festivity to be updated
     * @return rowcount 
     */
    public int updateFestivity(int id, Festivity festivity){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Festivity f set f.name =:nameU, f.start =:start, f.end =:end where f.id =:id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("nameU",festivity.getName());
            query.setTimestamp("start", festivity.getStartDate());
            query.setTimestamp("end", festivity.getEndDate());
            int rowCount = query.executeUpdate();
            tx.commit();
            session.close();
            return rowCount;
    }
}