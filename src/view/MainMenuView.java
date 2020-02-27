package view;

import constants.Cards;
import constants.Menus;
import model.Card;
import model.Game;
import model.Player;
import trader.Trader;
import utils.UtilsViewMessages;

import java.util.ArrayList;
import java.util.Collections;

public class MainMenuView extends View {

    public MainMenuView() {
        super(Menus.MENU_PRINCIPAL);
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean answer=false;
        switch (value) {
            case "N":
                createGame();
                displayPlayersInformation();
                break;
            default:
                UtilsViewMessages.print("\n*** Invalid selection *** Try again");
                break;
        }
        return answer;
    }

    public static void createGame(){
        Trader.game = new Game();
        System.out.println("How many players?");
        int numPlayers = UtilsViewMessages.input.nextInt();
        createCards();
        Trader.game.setCurrentIndex(0);
        for(int i=0; i<numPlayers;i++){
            Player player = new Player();
            player.setName("player" + i);
            player.setMoney(7);
            player.setYourTurn(false);
            int finalNum = Trader.game.currentIndex + 3;
            for(int x = Trader.game.currentIndex; x<finalNum; x++){
                player.getCardsOnHand().add(Trader.game.getCardsOnDeck().get(x));
            }
            add3CurrentIndex();
            Trader.game.getPlayers().add(player);
        }
        Trader.game.setCemetery(new ArrayList<>());
    }

    public static void createCards(){
        for(int i=0; i<7;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.TRADER,3,1,4, "T"));
        }
        for(int i=0; i<7;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.TRADER,3,1,4, "C"));
        }
        for(int i=0; i<7;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.TRADER,3,1,4, "R"));
        }
        for(int i=0; i<3;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.THIEF,-1,-1,2, "T"));
        }
        for(int i=0; i<3;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.THIEF,-1,-1,2, "C"));
        }
        for(int i=0; i<3;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.THIEF,-1,-1,2, "R"));
        }
        for(int i=0; i<8;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.ASSASIN,0,-2,2, "-"));
        }
        for(int i=0; i<4;i++){
            Trader.game.getCardsOnDeck().add(createCard(Cards.MERCENARY,0,1,2, "-"));
        }
        Collections.shuffle(Trader.game.getCardsOnDeck());
        Collections.shuffle(Trader.game.getCardsOnDeck());
    }

    public static Card createCard(String name, int gain, int karma, int price, String type){
        Card card = new Card();
        card.setGain(gain);
        card.setKarma(karma);
        card.setName(name);
        card.setRevealed(false);
        card.setPrice(price);
        card.setType(type);
        return card;
    }

    public static void add3CurrentIndex(){
        Trader.game.setCurrentIndex(Trader.game.getCurrentIndex()+3);
    }

    public static void addCurrentIndex(){
        Trader.game.setCurrentIndex(Trader.game.getCurrentIndex()+1);
    }

    public static void displayPlayersInformation(){
        for(Player player: Trader.game.getPlayers()){
            Trader.currentPlayer = player;
            UtilsViewMessages.printWithN(Trader.currentPlayer.getName());
            displayCards(Trader.currentPlayer);
            GameView gv = new GameView();
            gv.display();
        }
    }

    public static void displayCards(Player player){
        player.getCardsOnHand().add(Trader.getCard());
        UtilsViewMessages.print("Id      |Name      | Price     | Type     | karma      ");
        for(Card card: player.getCardsOnHand()){
            UtilsViewMessages.print(getIndexFormated(player.getCardsOnHand().indexOf(card)) +
                                    card.getName() + " " +
                                    getPriceFormated(card.getPrice()) + " " +
                                    getTypeFormated(card.getType()) + " " +
                                    getKarmaFormated(card.getKarma()));
        }
        UtilsViewMessages.print("\n");
    }

    private static String getIndexFormated(int indexOf) {
        return indexOf + "        ";
    }

    private static String getTypeFormated(String type) {
        return type + "         ";
    }

    private static String getKarmaFormated(Integer karma) {
        if(karma>0){
            return "+"+karma;
        }else{
            return karma.toString();
        }
    }

    public static String getPriceFormated(Integer price){
        if(price>9){
            return " " + price + "         ";
        }else{
            return " " + price + "          ";
        }
    }

}
