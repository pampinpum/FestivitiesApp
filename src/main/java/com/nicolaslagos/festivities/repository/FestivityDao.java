package com.nicolaslagos.festivities.repository;

import java.util.List;

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
    
    public void addListFestivity(List<Festivity> listFestivity){
    	try{
    	for (Festivity festivity : listFestivity){
    		Session session = SessionUtil.getSession();        
            Transaction tx = session.beginTransaction();
            session.save(festivity);      
            tx.commit();
            session.close();     
    	}    	
    	}catch (Exception ex){
    		System.out.println("ERRRRRRROR" + ex.getMessage());
    	}
    }
    
    /**
     * Gets all the festivities
     * @return List<Festivity> festivities
     */
    public List<Festivity> getFestivities(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Festivity");
        List<Festivity> festivities =  query.list();
        session.close();
        return festivities;
    }
 
    /**
     * Deletes a festivity
     * @param id festivity id
     * @return row count
     */
    public int deleteFestivity(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Festivity where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }
    
    /**
     * Updates a festivity
     * @param id festivity id 
     * @param festivity festivity to be updated
     * @return rowcount 
     */
    public int updateFestivitie(int id, Festivity festivity){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Festivity set festname = :festname, festplace = :festplace, feststartdate=:feststartdate"
            		+ "festenddate = : festenddate where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("festname",festivity.getFestname());
            query.setString("festplace", festivity.getFestplace());
            query.setTimestamp("feststartdate", festivity.getFeststartdate());
            query.setTimestamp("festenddate", festivity.getFestenddate());
            int rowCount = query.executeUpdate();
            tx.commit();
            session.close();
            return rowCount;
    }
}