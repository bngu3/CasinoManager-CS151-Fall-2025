public class Main {
    private static int menuChoice;

    public static void main(String args[]) {
        System.out.println("       Welcome to our Casino!       ");
        

        do {
            menuChoice = menu();
        }
        while(menuChoice != 0);
    }
    
    public static int menu() {
        System.out.println("            1. Roulette             ");
        System.out.println("            2. Blackjack            ");
        System.out.println("            3. Craps                ");
        System.out.println("            0. Exit                 ");     
        
        int choice = UserInput.readNextInt("  What game would you like to play?\n");  

        if ( choice < 0 || choice > 3 ) {
            throw new IllegalArgumentException("Invalid menu choice");
        }
        else if (choice == 0) {
            System.out.println("Thanks for coming. See you next time!");
        }
        else {
            System.out.print("You chose ");
            switch (choice) {
                case 1:
                    System.out.print("Roulette\n");
                    Roulette r = new Roulette();
                    Table t1 = new Table(r);
                    t1.playGame();
                case 2:
                    System.out.print("Blackjack\n");
                    Blackjack bj = new Blackjack();
                    Table t2 = new Table(bj);
                    t2.playGame();
                case 3:
                    System.out.print("Craps\n");
                    Craps c = new Craps();
                    Table t3 = new Table(c);
                    t3.playGame();
            }
            System.out.println("! Good luck!");
        }
        return choice;
    }
}
