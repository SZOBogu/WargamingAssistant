package scenarioGenerator.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rosterBuilder.entities.WargamingSystem;
import scenarioGenerator.entities.MissionList;

import java.util.List;

@Repository
public class MissionDAO implements IMissionDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<MissionList> getMissions(int wargameId) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            WargamingSystem system = session.get(WargamingSystem.class, wargameId);
            session.close();
            return system.getMissions();
        }
        finally{
            assert true;
        }
    }
}
