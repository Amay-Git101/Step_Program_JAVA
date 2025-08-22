import java.util.*;

public class CardGame {

    static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    public static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    
    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int n, int players) {
        if (n % players != 0) {
            System.out.println("Cannot distribute " + n + " cards evenly among " + players + " players.");
            return null;
        }
        int cardsPerPlayer = n / players;
        String[][] distributed = new String[players][cardsPerPlayer];

        int index = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                distributed[i][j] = deck[index++];
            }
        }
        return distributed;
    }

    public static void printPlayers(String[][] playersCards) {
        if (playersCards == null) return;
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (String card : playersCards[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        String[] deck = initializeDeck();

        shuffleDeck(deck);

        String[][] playersCards = distributeCards(deck, n, players);

        printPlayers(playersCards);

        sc.close();
    }
}
