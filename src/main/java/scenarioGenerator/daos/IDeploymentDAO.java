package scenarioGenerator.daos;

import scenarioGenerator.pojos.Deployment;

import java.util.List;

public interface IDeploymentDAO {
    List<Deployment> getDeployments(int wargameId);
}
