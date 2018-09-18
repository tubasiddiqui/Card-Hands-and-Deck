
public class Card
{
   enum Suit
   {
      spades, hearts, clubs, diamonds
   }; // use enum for the suit names

   // private members
   private char value;
   private Suit suit;
   private boolean errorFlag;

   // default constructor with no parameters
   // initialize the instance variables to the default value
   Card()
   {
      value = 'A';
      suit = Suit.spades;
      errorFlag = false;
   }

   // public method: constructor with parameters
   Card(char value, Suit suit)
   {
      set(value, suit);
   }

   // accessors for private data
   public char getValue()
   {
      return value;
   }

   public Suit getSuit()
   {
      return suit;
   }

   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   // mutator that accepts the legal values and returns errorFlag if good or bad
   boolean set(char value, Suit suit)
   {
      boolean valid = true;
      if (isValid(value, suit) == true)
      {
         errorFlag = false;
         this.value = value;
         this.suit = suit;
      } else
      {
         errorFlag = true;
         valid = false;
         this.value = 'A';
         this.suit = Suit.spades;
      }
      return valid;
   }

   boolean equals(Card card)
   {
      if (this.value == card.value && this.suit == card.suit && this.errorFlag == card.errorFlag)
      {
         return true;
      } else
      {
         return false;
      }
   }

   // display cards in the hand
   public String toString()
   {
      if (errorFlag == true)
      {
         return ("invalid card");
      } else
      {
         String retVal;

         retVal = String.valueOf(value) + " of " + suit + " ";
         return retVal;
      }
   }

   // private methods
   // will return true or false depending on if values are legal or not
   // suit is always legal since it is enum
   private static boolean isValid(char value, Suit suit)
   {
      boolean valid = true;
      if (value == 'A' || value == 'T' || value == 'K' || value=='J' || value == 'Q' || (value >= '2' && value <= '9'))
      {
         return valid;
      } else
      {
         valid = false;
      }
      return valid;
   }
}