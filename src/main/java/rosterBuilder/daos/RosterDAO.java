package rosterBuilder.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rosterBuilder.entities.*;
import rosterBuilder.requests.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RosterDAO implements IRosterDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Roster getRoster(int id) {
        Roster roster;
        try{
            Session session = sessionFactory.openSession();
            roster = session.get(Roster.class, id);
            session.beginTransaction();
            session.close();
        }
        finally {
            assert true;
        }
        return roster;
    }

    @Override
    public List<Detachment> getDetachmentList(GetDetachmentTypeListRequest request) {
        List<Detachment> detachments = new ArrayList<>();
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            detachments.addAll(system.getDetachments());
            session.close();
        }
        finally{
            assert true;
        }
        return detachments;
    }

    @Override
    public Roster deleteDetachment(DeleteDetachmentRequest request) {
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            roster = request.getRoster();
            roster.removeDetachment(request.getDetachmentIndex());
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    @Override
    public UnitProfile getUnitProfile(int id) {
        UnitProfile unitProfile;
        try{
            Session session = sessionFactory.openSession();
            unitProfile = session.get(UnitProfile.class, id);
            session.beginTransaction();
            session.close();
        }
        finally {
            assert true;
        }
        return unitProfile;
    }

    @Override
    public Unit saveUnit(Unit unit) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(unit);
            session.close();
        }
        finally {
            assert true;
        }
        return unit;
    }

    @Override
    public Roster saveDetachment(SaveDetachmentRequest request) {
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            roster = request.getRoster();
            roster.addDetachment(system.getDetachments().get(request.getDetachmentIndex()));
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    @Override
    public Roster deleteUnit(DeleteUnitRequest request) {
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            roster = request.getRoster();
            roster.getDetachments().get(request.getDetachmentIndex()).deleteUnit(request.getCategoryIndex(), request.getUnitIndex(), roster.getUniqueEntitiesPool());
            session.beginTransaction();
            session.delete(request.getUnit());
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    @Override
    public Roster createRoster(CreateRosterRequest request) {
        Roster roster = new Roster();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            Army army = session.get(Army.class, request.getArmyId());
            Detachment detachment = session.get(Detachment.class, request.getDetachmentId());

            roster.addDetachment(detachment);
            roster.setPrimaryArmy(army);
            roster.setUniqueEntitiesPool(system.getPool());
            roster.setPointCap(request.getPointLimit());
            session.save(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    @Override
    public Roster updateRoster(Roster roster) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(roster);
            session.close();
        }
        finally {
            assert true;
        }
        return roster;
    }
}
