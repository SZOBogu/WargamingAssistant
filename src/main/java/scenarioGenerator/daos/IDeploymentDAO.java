package scenarioGenerator.daos;

import scenarioGenerator.entities.Deployment;

import java.util.List;

public interface IDeploymentDAO {
    List<Deployment> getDeployments(int wargameId);
}
