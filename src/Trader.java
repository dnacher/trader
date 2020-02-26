public class Trader {

    public static Game game;

    public static void main(String[] args) {
        MainMenuView mmv = new MainMenuView();
        mmv.display();
    }

    public static Card getCard(){
        if(game.getCardsOnDeck().size()>game.currentIndex){
            Card card = game.getCardsOnDeck().get(game.currentIndex);
            game.currentIndex = game.currentIndex++;
            return card;
        }else{
            return null;
        }
    }
}
