package peaksoft.repo;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonRepository {
    void saveLesson(Lesson lesson);
    void updateLesson(long id, Lesson lesson);
    void deleteLesson(long id);
    Lesson getLessonById(long id);
    List<Lesson> getAllLessons();
}
