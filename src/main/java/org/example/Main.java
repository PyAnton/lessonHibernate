package org.example;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Создание объекта и сохранение его в базе данных
        User person1 = new User("ivan", "Petrov");
        User person2 = new User("ivan", "Ivanov");
        User person3 = new User("Evgeniy", "Sidorov");
        session.save(person1);
        session.save(person2);
        session.save(person3);



        // Получение объекта из базы данных по идентификатору
        Long personId = person1.getId();
        User retrievedPerson = session.get(User.class, personId);
        System.out.println("Полученный объект: " + retrievedPerson.getName() + " ID: " + personId);

        // Обновление объекта
        person2.setName("Aaaaaaaaa");
        Long personId2 = person2.getId();
        session.update(person2);
        User retrievedPerson1 = session.get(User.class, personId2);
        System.out.println("Полученный объект: " + retrievedPerson1.getName());


        // Удаление объекта
        session.delete(retrievedPerson);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}