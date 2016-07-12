package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import model.Psassignment;
import model.Psstudent;




public class gbUtil {
	 public static List<Psassignment> allAssignments()
	    {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        List<Psassignment> assignments = null;
	        String qString = "select b from Psassignment b ";
	        
	        try{
	            TypedQuery<Psassignment> query = em.createQuery(qString,Psassignment.class);
	         //   query.setParameter();
	            assignments = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return assignments;    
	    }
    public static List<Psassignment> assignmentsOfStudent(int studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Psassignment> assignments = null;
        String qString = "select a from Psassignment a "
                + "where a.psstudent.studentid = :studentid";
        
        try{
            TypedQuery<Psassignment> query = em.createQuery(qString,Psassignment.class);
            query.setParameter("studentid", studentid);
              assignments = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return assignments;    
    }
    public static void insert(Psassignment assignment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(assignment);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Psassignment assignment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(assignment);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Psassignment assignment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(assignment));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static List<Psstudent> psstudents (){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Psstudent b";
        List<Psstudent> students = null;
        try{
            TypedQuery<Psstudent> query = em.createQuery(qString,Psstudent.class);
            students = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return students;
    }
    public static Psstudent singleStudent(int studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Psstudent student = null;
        String qString = "select b from Psstudent b "
                + "where b.studentid = :studentid";
        
        try{
            TypedQuery<Psstudent> query = em.createQuery(qString,Psstudent.class);
            query.setParameter("studentid", studentid);
            student = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return student;    
    }
	public static Psstudent singleStudent(String firstname, String lastname) {
		// TODO Auto-generated method stub
		  EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        Psstudent student = null;
	        String qString = "select b from Psstudent b "
	                + "where b.firstname = :firstname and b.lastname = :lastname";
	        
	        try{
	            TypedQuery<Psstudent> query = em.createQuery(qString,Psstudent.class);
	            query.setParameter("firstname", firstname);
	            query.setParameter("lastname", lastname);
	            student = query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return student;    
	}
	
	public static List<Object[]> StrongheimAverages(){
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 String qString = "select MIN(b.score),MAX(b.score), " + 
		 "AVG(b.score) as score,b.assignmenttype " + 
		 "from Psassignment b group by b.assignmenttype";
		 
		 List<Object[]> report = null;
		 try{
		TypedQuery<Object[]> query = em.createQuery(qString,Object[].class);	 
		 report = query.getResultList();
		}catch (Exception e){
		 e.printStackTrace();
		 }
		 finally{
		 em.close();
		 }
		 return report;
		 } 
	public static List<Object[]> StrongheimAveragesStudent(int studentid){
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 String qString = "select MIN(b.score),MAX(b.score), " + 
		 "AVG(b.score) as score,b.assignmenttype " + 
		 "from Psassignment b where b.psstudent.studentid= :studentid group by b.assignmenttype";
		 
		 List<Object[]> report = null;
		 try{
		TypedQuery<Object[]> query = em.createQuery(qString,Object[].class);
		query.setParameter("studentid", studentid);
		 report = query.getResultList();
		}catch (Exception e){
		 e.printStackTrace();
		 }
		 finally{
		 em.close();
		 }
		 return report;
		 }
}
