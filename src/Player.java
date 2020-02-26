import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card>cardsOnHand = new ArrayList<>();
    private List<Card> played= new ArrayList<>();
    private Integer money;
    private boolean yourTurn;

    public Player(){
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
