package persistence;

import model.Employee;
import model.Service;
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

    public Employee searchByID(int id) {
        Employee employee = null;
        try {
            employee = em.find(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return employee;
    }



}
