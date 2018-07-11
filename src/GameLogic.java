import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameLogic {

    private static LinkedList<Card> createDeck(LinkedList<Card> cardDeck) {
        for (Suit suit :
                Suit.values()) {
            for (Nominal nominal :
                    Nominal.values()) {
                cardDeck.add(new Card(suit, nominal));
            }
        }
        return cardDeck;
    }

    private static LinkedList<Card> shuffle(LinkedList<Card> cardDeck, LinkedList<Card> shuffleDeck) {
        while (cardDeck.size() > 0) {
            for (int i = 51; i >= 0; i--) {
                int index = (int) (Math.random() * i);
                shuffleDeck.add(cardDeck.get(index));
                cardDeck.remove(index);
            }
        }
        return shuffleDeck;
    }

    private static void setPlayersets(Integer n, LinkedList<Card> shuffleDeck) {
        for (int i = 0; i < n; i++) {
            LinkedList<Card> playerSet = new LinkedList<Card>();
            Player player = new Player(playerSet);

            for (int j = 0; j < 5; j++) {
                playerSet.add(shuffleDeck.poll());

            }
            System.out.println("Раздача игрока " + (i + 1) + ":");
            System.out.println(player);
            System.out.println();
        }
    }

    public static void startGame() {

        LinkedList<Card> cardDeck = new LinkedList<>();

        createDeck(cardDeck);

        LinkedList<Card> shuffleDeck = new LinkedList<>();


        shuffle(cardDeck, shuffleDeck);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во игроков");

        Boolean flag= false;
        while (!flag) {
            try {
                Integer n = check(scanner.nextInt(), scanner);
                flag= true;
                setPlayersets(n, shuffleDeck);
            } catch (InputMismatchException e) {
                System.out.println(" Вы ввели буквы, введите число от 1 до 10");
                scanner.nextInt();
            }
        }
    }

    private static Integer check(Integer n, Scanner scanner) {

        while (n <= 0 || n > 10) {
            System.out.println(" Неверный ввод, введите число игроков от 1 до 10 включительно");
            n = scanner.nextInt();
        }
        return n;
    }
}
