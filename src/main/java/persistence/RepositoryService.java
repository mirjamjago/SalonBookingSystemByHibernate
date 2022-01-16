package persistence;


import model.Service;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryService extends CRUDRepository<Service> {

    private final EntityManager em;

    public RepositoryService() {
        em = DBUtil.getEntityManager();
    }

    public List<Service> getAllServices() {
        return em.createQuery("from Service")
                .getResultList();
    }

    public Service searchByID(int id) {
        Service service = null;
        try {
            service = em.find(Service.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return service;
    }


}
