package persistence;

import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployee extends CRUDRepository<Employee> {
    private final EntityManager em;

    public RepositoryEmployee (){
        em = DBUtil.getEntityManager();
    }

    public List<Employee> getAllEmployees(){
        return em.createQuery("from Employee")
                        .getResultList();
    }



}
