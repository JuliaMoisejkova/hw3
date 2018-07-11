public class Card {
  private Suit suit;
  private Nominal nominal;

    public Card(Suit suit, Nominal nominal) {
        this.suit = suit;
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", nominal=" + nominal +
                '}';
    }
}
