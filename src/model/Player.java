package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card>cardsOnHand = new ArrayList<>();
    private List<Card> played= new ArrayList<>();
    private Integer money;
    private boolean yourTurn;

    public Player(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public void setCardsOnHand(List<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public List<Card> getPlayed() {
        return played;
    }

    public void setPlayed(List<Card> played) {
        this.played = played;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}
