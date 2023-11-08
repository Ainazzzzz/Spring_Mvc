package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Lesson;
import peaksoft.repo.LessonRepository;

import java.util.List;

@Repository
@Transactional
public class LessonRepoImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveLesson(Lesson lesson) {
        entityManager.persist(lesson);
    }

    @Override
    public void updateLesson(long id, Lesson lesson) {

    }

    @Override
    public void deleteLesson(long id) {
   entityManager.remove(entityManager.find(Lesson.class,id));
    }

    @Override
    public Lesson getLessonById(long id) {
        return null;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return entityManager
                .createQuery("select l from Lesson l", Lesson.class)
                .getResultList();
    }
}
