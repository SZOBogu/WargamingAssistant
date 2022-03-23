package rosterBuilder.daos;

import rosterBuilder.entities.UnitProfile;
import rosterBuilder.requests.GetUnitListRequest;

import java.util.List;

public interface IUnitDAO {
    UnitProfile getUnitProfile(int unitIndex);
    List<List<UnitProfile>> getUnitList(GetUnitListRequest request);
}
