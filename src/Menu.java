import Model.Card;
import Model.Game;
import Model.Player;

import java.util.*;

public class Menu {


    static Game game = Trader.game;
    public static Scanner input = new Scanner(System.in);
    public static boolean exit = false;

    public static void Menu(String menu){
        do{
            System.out.println(menu);
            String option = input.nextLine();
            optionSelected(option);
        }while (!exit);
    }

    public static void optionSelected(String option){
        switch (option) {
            case "1":
                createGame();
                Menu(Menus.MENU_JUEGO);
                break;
            case "2":
                System.out.println("opcion 2");
                break;
            case "3":
                exit=true;
                break;
            default:
                System.out.println("wrong answer");
                break;
        }
    }

    public static void createGame(){
        game = new Game();
        System.out.println("How many players?");
        int numPlayers = input.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<numPlayers;i++){
            Player player = new Player();
            List<Card> cardsOnHand = new ArrayList<>();
            List<Card> cardsPlayed = new ArrayList<>();
            player.setCardsOnHand(cardsOnHand);
            player.setMoney(7);
            player.setPlayed(cardsPlayed);
            player.setYourTurn(false);
            players.add(player);
        }
        game.setCurrentIndex(0);
        game.setCemetery(new ArrayList<>());
        createCards();
    }

    public static void createCards(){
        for(int i=0; i<7;i++){
            game.getCardsOnDeck().add(createCard("Trader",3,1,4, "T"));
        }
        for(int i=0; i<7;i++){
            game.getCardsOnDeck().add(createCard("Trader",3,1,4, "C"));
        }
        for(int i=0; i<7;i++){
            game.getCardsOnDeck().add(createCard("Trader",3,1,4, "R"));
        }
        for(int i=0; i<3;i++){
            game.getCardsOnDeck().add(createCard("Thief",-1,-1,2, "T"));
        }
        for(int i=0; i<3;i++){
            game.getCardsOnDeck().add(createCard("Thief",-1,-1,2, "C"));
        }
        for(int i=0; i<3;i++){
            game.getCardsOnDeck().add(createCard("Thief",-1,-1,2, "R"));
        }
        for(int i=0; i<8;i++){
            game.getCardsOnDeck().add(createCard("Assasin",0,-2,2, ""));
        }
        for(int i=0; i<4;i++){
            game.getCardsOnDeck().add(createCard("Mercenary",0,1,2, ""));
        }
        Collections.shuffle(game.getCardsOnDeck());
        Collections.shuffle(game.getCardsOnDeck());
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
}
