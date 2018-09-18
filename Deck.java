import java.util.Random;

//source of all cards
public class Deck
{
   // private static class constants
   private static final int MAX_PACKS = 6;
   private static final int NUM_CARDS_PER_PACK = 52;
   private static final int MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;

   // private static member data
   // stores card info in the masterPack array for us to copy and use
   private static Card[] masterPack; // contain 52 card references to avoid repeatedly decalring same 52 cards

   // private member data
   private Card[] cards; // array of card objects
   private int topCard; // like numCards, keep track of how many cards are in card[]
   private int numPacks;
   private static boolean hereBefore = false;

   // public methods
   // constructor that will assign initial values to parameters
   // default to assume if no parameters then one pack is assumed
   public Deck()
   {
      numPacks = 1;
      allocateMasterPack();
      init(numPacks); // restock deck
   }

   // constructor with parameter
   public Deck(int numPacks)
   {
      this.numPacks = numPacks;
      allocateMasterPack();
      init(numPacks);
   }

   // restock deck with standards 52 cards * numPacks
   // can change the numPacks here
   boolean init(int numPacks)
   {
      this.numPacks = numPacks;
      topCard = (NUM_CARDS_PER_PACK * numPacks);
      
      if(numPacks < 0 || numPacks > MAX_PACKS) {
         return false;
      }
      else 
         {
         cards = new Card[NUM_CARDS_PER_PACK * numPacks];
         for(int i = 0; i < numPacks; i++) {   //repopulate card based on how many pack
            for(int k = 0; k < 52; k++) {      //repopulate card based on 52 decks in one pack
               cards[k + (52*i)] = masterPack[k];    //52 times how many packs + k will be adding it to the number last left off
            }
         }
         return true;
         }
      
   }

   // mixes up cards via random number generator
   public void shuffle()
   {
      Random rand = new Random();
      for (int k = cards.length - 1; k > 0; k--)
      {
         int randIndex = rand.nextInt(k + 1);
         Card temp = cards[randIndex];
         cards[randIndex] = cards[k];
         cards[k] = temp;
      }
      // create deck of 52 cards using for loop
      // shuffle deck using temp to swap cards in loop
   }

   // return and remove(effectively) the top card in cards[]
   // return copy of card not actual reference to object in card array
   // since that object is also object in masterPack[] so we cant change it
   public Card dealCard()
   {
      Card getCard = cards[topCard - 1];
      topCard--;
      return getCard;
   }

   // accessor, no mutator, for topCard
   public int getTopCard()
   {
      return topCard;
   }

   // accessor for the individual card, same as before
   public Card inspectCard(int k)
   {
      // if card is good and is within the limits, the return the card
      if (k >= 0 && k <= topCard)
      { // good range, k is good
         return cards[k];
      } else
      {
         // if errorFlag is true return a bad card by making a badCard
         Card badCard = new Card('G', Card.Suit.spades);
         return badCard;
      }

   }

   // called by constructor
   // will not allow itself to be executed more than once
   private static void allocateMasterPack()
   {
      // ask if it has been here before
      // if yes then return without doing anything
      Card.Suit suits[] = {Card.Suit.spades, Card.Suit.clubs, Card.Suit.diamonds, Card.Suit.hearts};
      char values[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
      if (hereBefore == false)
      {
         masterPack = new Card[NUM_CARDS_PER_PACK];
         int tracker = 0;
         
            for(int i=0; i < suits.length; i++) {
               for(int j=0; j < values.length; j++) {
                 Card copyCard = new Card(values[j], suits[i]);
                 masterPack[tracker] = copyCard;
                 tracker++;
              }     
            }
     hereBefore=true;
      } 
      else
      {
         return;
      }

   }

}
