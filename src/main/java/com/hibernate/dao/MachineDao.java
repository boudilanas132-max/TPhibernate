
package com.hibernate.dao;

import com.hibernate.entities.Machine;
import com.hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MachineDao implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(o);

            tx.commit();
            return true;

        } catch (java.lang.Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Machine o) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.delete(o);

            tx.commit();
            return true;

        } catch (java.lang.Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Machine o) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.update(o);

            tx.commit();
            return true;

        } catch (java.lang.Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Machine getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Machine.class, id);

        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Machine> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Machine", Machine.class).list();

        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return java.util.Collections.emptyList();
        }
    }
}
