import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameView extends View {

    public GameView() {
        super(Menus.MENU_JUEGO);
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean answer=false;
        switch (value) {
            case "N":

                break;
            case "G":

                break;

            default:
                UtilsViewMessages.print("\n*** Invalid selection *** Try again");
                break;
        }
        return answer;
    }

    public static void round(){

    }


}
