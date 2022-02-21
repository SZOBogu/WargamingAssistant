package TournamentHandler.pojos;

import ScoreCalculator.pojos.ScoringSystem;
import TournamentHandler.entities.PairingSystem;
import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Round;
import rosterBuilder.rules.ArmyPointCapRule;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.TeamCompositionRule;

import java.util.List;

public class TournamentStatute {
    private int idStatute;
    private String address;
    private double entryFee;
    private String prizes;
    private String description;

    public int getIdStatute() {
        return idStatute;
    }

    public void setIdStatute(int idStatute) {
        this.idStatute = idStatute;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
