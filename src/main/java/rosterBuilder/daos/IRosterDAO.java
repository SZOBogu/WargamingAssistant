package rosterBuilder.daos;

import rosterBuilder.pojos.Detachment;
import rosterBuilder.pojos.Roster;
import rosterBuilder.pojos.Unit;
import rosterBuilder.pojos.UnitProfile;
import rosterBuilder.requests.*;

import java.util.List;

public interface IRosterDAO {
    Roster getRoster(int id);
    List<Detachment> getDetachmentList(GetDetachmentTypeListRequest request);
    Roster deleteDetachment(DeleteDetachmentRequest request);
    UnitProfile getUnitProfile(int id);
    Unit saveUnit(Unit unit);
    Roster saveDetachment(SaveDetachmentRequest request);
    Roster deleteUnit(DeleteUnitRequest request);
    Roster createRoster(CreateRosterRequest request);
    Roster updateRoster(Roster roster);
}
