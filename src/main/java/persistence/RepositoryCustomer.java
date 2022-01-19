package persistence;

import model.Customer;
import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;

import java.util.List;

public class RepositoryCustomer extends CRUDRepository<Customer> {
    private final EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    public List<Customer> getAllCustomers() {
        return em.createQuery("from Customer")
                .getResultList();
    }
        public Customer searchByID(int id) {
                Customer customer = null;
                try {

                        customer = em.find(Customer.class, id);
                } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                }
                return customer;
        }

}
