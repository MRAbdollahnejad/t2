import jakarta.persistence.*;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory ENTITY_MANAGER_FACTORY
                = Persistence.createEntityManagerFactory("Item");
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root);

        TypedQuery<Item> query = entityManager.createQuery(cr);
        List<Item> results = query.getResultList();
    }
}
