package view;

import constants.Menus;
import model.Card;
import trader.Trader;
import utils.UtilsViewMessages;

public class GameView extends View {

    public static int id;

    public GameView() {
        super(Menus.MENU_JUEGO);
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean answer=false;
        switch (value) {
            case "A":
                id =0;
                break;
            case "B":
                id=1;
                break;
            case "C":
                id=2;
                break;
            case "D":
                id=3;
                break;
            default:
                UtilsViewMessages.print("\n*** Invalid selection *** Try again");
                break;
        }
        check();
        return answer;
    }

    public static void displayQuestion(){
        UtilsViewMessages.printWithN("Do you want to buy this card or discard it?");
        UtilsViewMessages.printWithN("B Buy");
        UtilsViewMessages.printWithN("D Discard");
    }

    public static void check(){
        displayQuestion();
        String value = UtilsViewMessages.input.nextLine();
        switch (value){
            case "B":
                Trader.currentPlayer.getPlayed().add(Trader.currentPlayer.getCardsOnHand().get(id));
                Trader.currentPlayer.getCardsOnHand().remove(Trader.currentPlayer.getCardsOnHand().get(id));
                break;
            case "D":
                Trader.game.getCemetery().add(Trader.currentPlayer.getCardsOnHand().get(id));
                Trader.currentPlayer.getCardsOnHand().remove(Trader.currentPlayer.getCardsOnHand().get(id));
                break;
            default:
                UtilsViewMessages.printWithN("Wrong answer try again");
                displayQuestion();
                Trader.currentPlayer.getCardsOnHand().add(getCard());
        }
    }

    public static Card getCard(){
        if(Trader.game.getCardsOnDeck().size()>Trader.game.currentIndex){
            Card card = Trader.game.getCardsOnDeck().get(Trader.game.getCurrentIndex());
            MainMenuView.addCurrentIndex();
            return card;
        }else{
            UtilsViewMessages.printWithN("end of the deck");
            return null;
        }
    }

}
