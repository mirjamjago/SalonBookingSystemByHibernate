package persistence;

import model.Customer;
import util.DBUtil;

import javax.persistence.EntityManager;

import java.util.List;

public class RepositoryCustomer extends CRUDRepository<Customer> {
        private final EntityManager em;

        public RepositoryCustomer(){
              em = DBUtil.getEntityManager();
        }

        public List<Customer> getAllCustomers() {
                return em.createQuery("from Customer")
                        .getResultList();
        }


}
