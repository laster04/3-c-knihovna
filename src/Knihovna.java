import java.util.Scanner;

public class Knihovna {
    private Display display;
    private Scanner scanner;
    private DBConnect dbConnect;

    public Knihovna() {
        this.display = new Display();
        this.scanner = new Scanner(System.in);
        this.dbConnect = new DBConnect();
    }

    public void run() {
        Boolean running = true;
        while (running) {
            display.printMenu();
            String userInput = this.scanner.nextLine();
            if ("0".equals(userInput)) {
                running = false;
            } else if ("1".equals(userInput)) {
                System.out.println("Insert author values");
                String authorValues = this.scanner.nextLine();
                String[] values = authorValues.split("\\|");
                dbConnect.insertAuthor(values);
            }
        }
    }

}
