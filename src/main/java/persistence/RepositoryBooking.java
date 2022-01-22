package persistence;

import model.Booking;
import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RepositoryBooking extends CRUDRepository<Booking> {

    private final EntityManager em;

    public RepositoryBooking() {
        em = DBUtil.getEntityManager();
    }

    public List<Booking> getAllBookings() {
        return em.createQuery("from Booking")
                .getResultList();
    }

    public long totalBookings() {
        return (long) em.createQuery("Select count(bookingId) from Booking").getSingleResult();
    }


    public List<Object[]> totalActiveAndNotActiveBookings() {
        return em.createQuery("SELECT status, count(status) as total FROM Booking GROUP BY status").getResultList();
    }

    public long totalBookingsByCustomerName(int CustomerID) {
        Query q = em.createQuery("Select count(bookingId) from Booking where CustomerId = :CustomerId ", Long.class)
                .setParameter("CustomerId", CustomerID);
        return (long) q.getSingleResult();
    }

    public Booking searchByID(int id) {
        Booking booking = null;
        try {
            booking = em.find(Booking.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return booking;
    }



}
