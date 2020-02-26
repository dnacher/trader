package Model;
import java.util.List;

public class Player {

    private List<Card>cardsOnHand;
    private List<Card> played;
    private int money;
    private boolean yourTurn;

    public Player(){}

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}
