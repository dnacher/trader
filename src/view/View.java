package view;

import java.util.Scanner;

public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final Scanner input = new Scanner(System.in);

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))
                return;
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {

        boolean valid = false;
        String value = null;

        while (!valid) {
            this.console(this.displayMessage);
            value = this.input.nextLine();
            value = value.trim();
            if(value.length() < 1){
                this.console("\n*** You must enter a value ***");
                continue;
            }
            break;
        }
        return value;
    }

    public void console(String message){
        System.out.println(message);
    }

}
