package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Player>players;
    private List<Card> cardsOnDeck= new ArrayList<>();
    private List<Card> cemetery = new ArrayList<>();
    public int currentIndex;
    private Map<String,String>currentOnDemand;

    public Game(){}

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Card> getCardsOnDeck() {
        return cardsOnDeck;
    }

    public void setCardsOnDeck(List<Card> cardsOnDeck) {
        this.cardsOnDeck = cardsOnDeck;
    }

    public List<Card> getCemetery() {
        return cemetery;
    }

    public void setCemetery(List<Card> cemetery) {
        this.cemetery = cemetery;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Map<String, String> getCurrentOnDemand() {
        return currentOnDemand;
    }

    public void setCurrentOnDemand(Map<String, String> currentOnDemand) {
        this.currentOnDemand = currentOnDemand;
    }
}
