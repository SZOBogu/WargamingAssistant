package rosterBuilder.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.daos.IUnitDAO;
import rosterBuilder.entities.UnitProfile;
import rosterBuilder.requests.GetUnitListRequest;


import java.util.List;

@Service
public class UnitService {
    @Autowired
    private IUnitDAO unitDAO;

    public UnitProfile getUnitProfile(int unitIndex){
        return this.unitDAO.getUnitProfile(unitIndex);
    }

    public List<List<UnitProfile>> getUnitList(GetUnitListRequest request) throws JsonProcessingException {
        return this.unitDAO.getUnitList(request);
    }
}
