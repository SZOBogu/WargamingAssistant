package rosterBuilder.daos;

import com.fasterxml.jackson.core.JsonProcessingException;
import rosterBuilder.pojos.Roster;
import rosterBuilder.pojos.UnitProfile;
import rosterBuilder.requests.GetUnitListRequest;
import rosterBuilder.requests.SaveDetachmentRequest;

import java.util.List;

public interface IUnitDAO {
    UnitProfile getUnitProfile(int unitIndex);
    List<List<UnitProfile>> getUnitList(GetUnitListRequest request);
}
