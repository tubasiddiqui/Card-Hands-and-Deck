public class Hand
{
   // static class constants
   public static int MAX_CARDS = 30;

   // private member data
   private Card[] myCards;
   private int numCards;

   // public methods
   // default constructor
   public Hand()
   {
      numCards = 0;
      myCards = new Card[MAX_CARDS];
   }

   // remove all the cards from the hand
   void resetHand()
   {
      numCards = 0;
   }

   //add card if room an return true if successful and false otherwise
 boolean takeCard(Card card) {
    if (numCards < MAX_CARDS) {
       myCards[numCards] = card;
       numCards++;
       return true;
    }
    return false;
 }
   
 //return and removes card in top position 
 Card playCard() {       //no parameter since dont need any outside input
    Card temp = myCards [numCards -1];      //use temp to store the removed card
    numCards--;         //update numCards
    return temp;         //should be last statement, return the temp   
 }
 
 //stringizer to display entire hand 
  public String toString() {
     String val = ""; //initialize and declare variable
     
     for(int k = 0; k < numCards; k++) {   //iterate through hand
        val += myCards[k].toString();      //display each card in loop
     }
     return val;
  }
  
  //accessors for numCards 
   public int getNumCards() {
      return numCards;
   }
   
   //accessor for individual card
   //return errorFlag = true if k is bad
   Card inspectCard(int k) {
      if (k >= 0 && k <= numCards) {    //good range, k is good
         return myCards[k];    
         }                               //return k
      else {
         Card badCard = new Card('G', Card.Suit.spades);    //make a bad card since errorflag is private
         return badCard;
      }
      
   }


}

