package rosterBuilder.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.*;
import rosterBuilder.requests.DeleteUnitRequest;
import rosterBuilder.requests.GetUnitListRequest;
import rosterBuilder.requests.SaveUnitRequest;
import rosterBuilder.rules.UnitBuildingRule;
import rosterBuilder.utility.UnitAndProfileFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService {
    private SessionFactory sessionFactory;

    public UnitProfile getUnitProfile(int unitIndex){
        try{
            Session session = sessionFactory.openSession();
            UnitProfile unitProfile = session.get(UnitProfile.class, unitIndex);
            session.close();
            return unitProfile;
        }
        finally{
            assert true;
        }
    }

    public List<List<UnitProfile>> getUnitList(GetUnitListRequest request) throws JsonProcessingException {
        List<List<UnitProfile>> unitNameList = new ArrayList<>();

        try{
            Session session = sessionFactory.openSession();
            WargamingSystem wargamingSystem = session.get(WargamingSystem.class, request.getWargameIndex());
            for(ArmySubcategory category : wargamingSystem.getArmies().get(request.getArmyIndex()).getArmySubcategories()){
                unitNameList.add(category.getUnitProfiles());
            }
            session.close();
        }
        finally {
            assert true;
        }
        return unitNameList;
    }
}
