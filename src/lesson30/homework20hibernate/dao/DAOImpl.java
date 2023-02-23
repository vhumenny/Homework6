package lesson30.homework20hibernate.dao;

import lesson30.homework20hibernate.entity.Student;
import lesson30.homework20hibernate.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DAOImpl implements DAO {
    @Override
    public void addStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = HibernateSession.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root root = criteriaQuery.from(Student.class);
        CriteriaQuery all = criteriaQuery.select(root);
        TypedQuery typedQuery = session.createQuery(all);
        return typedQuery.getResultList();
    }

    @Override
    public Student getStudentById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
