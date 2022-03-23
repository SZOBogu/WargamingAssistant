package rosterBuilder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rosterBuilder.entities.ArmySubcategory;
import rosterBuilder.entities.UnitProfile;
import rosterBuilder.entities.WargamingSystem;
import rosterBuilder.requests.GetUnitListRequest;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UnitDAO implements IUnitDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UnitProfile getUnitProfile(int unitIndex) {
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

    @Override
    public List<List<UnitProfile>> getUnitList(GetUnitListRequest request) {
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
