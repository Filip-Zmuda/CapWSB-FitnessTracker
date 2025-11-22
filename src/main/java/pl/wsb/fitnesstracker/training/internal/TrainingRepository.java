package pl.wsb.fitnesstracker.training.internal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.List;

@Repository
public class TrainingRepository {

    @PersistenceContext
    private EntityManager em;

    // Natwyne SQL: pobierz wszystkie rekordy z tabeli trainings
    public List<Training> findAll() {
        String sql = "SELECT * FROM trainings";

        return em.createNativeQuery(sql, Training.class)
                .getResultList();
    }

    // Metoda zapisująca do bazy
    public void save(Training training) {
        em.persist(training);
    }
}
