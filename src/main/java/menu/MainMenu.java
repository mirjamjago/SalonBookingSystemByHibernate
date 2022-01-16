package menu;

import java.util.Scanner;

public class MainMenu {
    private static SubMenuOptions subMenuOptions;
    private static Scanner input;

    public static void main(String[] ar4gs) {
        input = new Scanner(System.in);
        subMenuOptions = new SubMenuOptions();
        subMenuOptions.menuChoice(input);
    }

    public static void getMainMenu() {
        subMenuOptions.menuChoice(input);
    }
}
