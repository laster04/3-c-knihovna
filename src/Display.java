import java.util.Map;

public class Display {
    public void printMenu() {
        String menu = "KNIHOVNA MENU: \n" +
                "1: Přidat authora. \n" +
                "2: Vypis knihy. \n" +
                "3: Smaz knihu. \n" +
                "0: Exit()";
        System.out.println(menu);
    }

    public void printAddBook() {
        System.out.println("Přídávám knihu!");
    }

}
