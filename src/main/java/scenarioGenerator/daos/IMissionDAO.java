package scenarioGenerator.daos;

import scenarioGenerator.entities.MissionList;

import java.util.List;

public interface IMissionDAO {
    List<MissionList> getMissions(int wargameId);
}
