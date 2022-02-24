package scenarioGenerator.daos;

import scenarioGenerator.pojos.Mission;
import scenarioGenerator.pojos.MissionList;

import java.util.List;

public interface IMissionDAO {
    List<MissionList> getMissions(int wargameId);
}
