package guest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }
    @Transactional
    public Student save(Student student) {

        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        delete(student);
    }


    public void delete(Student student) {
        em.remove(student);
    }


    public List<Student> getAll() {
        TypedQuery<Student> query = em.createQuery(
                "SELECT g FROM Student g ORDER BY g.id", Student.class);
        return query.getResultList();
    }


}
