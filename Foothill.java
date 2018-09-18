
public class Foothill
{
   public static void main (String[] args) {
      Deck myDeck = new Deck();
      myDeck.init(1);
      
     for(int i=0; i<52; i++) {
        System.out.println(myDeck.dealCard());
     }
   }

}
