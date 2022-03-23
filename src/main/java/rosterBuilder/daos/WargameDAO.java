package rosterBuilder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rosterBuilder.entities.WargamingSystem;

@Repository
public class WargameDAO implements IWargameDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public WargamingSystem getWargamingSystem(int id) {
        WargamingSystem system;
        try{
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();

            system = session.get(WargamingSystem.class, id);

            session.close();
            return system;
        }
        finally{
            assert true;
        }
    }
}
