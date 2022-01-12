package TournamentHandler.pojos;

import TournamentHandler.entities.Player;

public class EventScore implements Comparable{
    private Player player;
    private int score;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        EventScore otherEventScore;
        otherEventScore = (EventScore) o;

        return Integer.compare(this.getScore(), otherEventScore.getScore());
    }
}
