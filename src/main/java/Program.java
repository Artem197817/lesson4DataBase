import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Создайте базу данных (например, SchoolDB).
 * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
 * Настройте Hibernate для работы с вашей базой данных.
 * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
 * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
 * Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

public class Program {


    public static void main(String[] args) {

        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();

        Courses courses = new Courses("Java Junior", 2);

        try (Session session = sessionFactory.getCurrentSession()) {

            // Сохранение объекта в базе данных
            session.beginTransaction();
            session.save(courses);
            System.out.println("Object course save successfully");
            session.getTransaction().commit();
        }
            // Чтение объекта из базы данных
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Courses course = session.get(Courses.class, courses.getId());
            System.out.println("Object course successfully");
            System.out.println(course);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactory.getCurrentSession()) {
            // Обновление объекта
            session.beginTransaction();
            courses.setDuration(7);
            session.update(courses);
            System.out.println("Object course update successfully");
            session.getTransaction().commit();
        }
        try (Session session = sessionFactory.getCurrentSession()) {
        // Удаление объекта
            session.beginTransaction();
            session.delete(courses);
            System.out.println("Object course delete successfully");
            session.getTransaction().commit();

            System.out.println("Session complete");

        }
    }
}

