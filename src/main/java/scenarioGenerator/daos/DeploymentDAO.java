package scenarioGenerator.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rosterBuilder.pojos.WargamingSystem;
import scenarioGenerator.entities.Deployment;

import java.util.List;

@Repository
public class DeploymentDAO implements IDeploymentDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Deployment> getDeployments(int wargameId) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            WargamingSystem system = session.get(WargamingSystem.class, wargameId);
            session.close();
            return system.getDeployments();
        }
        finally{
            assert true;
        }
    }
}
