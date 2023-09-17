package org.example;

import org.example.entities.User;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int action =0;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("0. Exit");
            System.out.println("1. Add");
            System.out.println("2. Showe");
            System.out.println("->_");

            action = Integer.parseInt(in.nextLine());
            switch (action){
                case 1:
                    InsertUser();
                    break;
                case 2:
                    showUsers();
                    break;
            }
        }while(action!=0);

        //InsertUser();

    }
    public  static void showUsers() {
        // Get the Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Open a Hibernate Session
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Query to fetch all users from the database
            Query<User> query = session.createQuery("FROM User", User.class);

            // Execute the query and get the list of users
            List<User> userList = query.getResultList();

            // Display the list of users
            System.out.println("List of Users:");
            for (User user : userList) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Name: " + user.getLastName()+ " "+ user.getLastName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone: " + user.getPhone());
                System.out.println();
            }

            session.getTransaction().commit();

        }
    }


    public  static  void InsertUser(){
        Scanner in = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx= session.beginTransaction();
            User user = new User();
            System.out.println("Enter email");
            String email = in.nextLine();
            user.setEmail(email);

            System.out.println("Enter first Name");
            String fName = in.nextLine();
            user.setFirstName(fName);

            System.out.println("Enter last Name");
            String lName = in.nextLine();
            user.setLastName(lName);

            System.out.println("Enter phone");
            String phone = in.nextLine();
            user.setPhone(phone);

            System.out.println("Enter password");
            String password = in.nextLine();
            user.setPassword(password);

            session.save(user);
            tx.commit();
        }
    }
}