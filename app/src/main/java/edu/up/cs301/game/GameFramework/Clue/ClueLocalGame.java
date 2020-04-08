package edu.up.cs301.game.GameFramework.Clue;

import java.util.ArrayList;
import java.util.Collections;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueLocalGame extends LocalGame
{
    //private Player whoseTurn;
    private int movesLeft;
    private ArrayList<Card> winningCards = new ArrayList<Card>();
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ClueGameState gameState;
    private int handSize;
    private Card[][] playerHands;


    public ClueLocalGame()
    {
        this.gameState = new ClueGameState();

        //make deck
        deck.add(new Card("wrench", 2));
        deck.add(new Card("candlestick", 2));
        deck.add(new Card("pipe", 2));
        deck.add(new Card("rope", 2));
        deck.add(new Card("gun", 2));
        deck.add(new Card("knife", 2));
        deck.add(new Card("yard", 0));
        deck.add(new Card("conservatory", 0));
        deck.add(new Card("lounge", 0));
        deck.add(new Card("kitchen", 0));
        deck.add(new Card("courtyard", 0));
        deck.add(new Card("pool", 0));
        deck.add(new Card("ballroom", 0));
        deck.add(new Card("dining", 0));
        deck.add(new Card("library", 0));
        deck.add(new Card("scarlet", 1));
        deck.add(new Card("plum", 1));
        deck.add(new Card("mustard", 1));
        deck.add(new Card("green", 1));
        deck.add(new Card("white", 1));
        deck.add(new Card("peacock", 1));

        Collections.shuffle(deck);
        for(Card card: deck)
        {
            if(card.getCardType() == 0)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }

        for(Card card: deck)
        {
            if(card.getCardType() == 1)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }

        for(Card card: deck)
        {
            if(card.getCardType() == 2)
            {
                winningCards.add(card);
                deck.remove(card);
                break;
            }
        }
        playerHands = new Card[deck.size()/2][2];
        int numPlayers = 2;
        handSize = deck.size()/numPlayers;
        for(int i = 0; i < handSize; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playerHands[i][j] = deck.get(0);
                deck.remove(0);
            }
        }

    }

    @Override
    protected String checkIfGameOver()
    {
        return null; //put actual content here
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer pl)
    {
        pl.sendInfo(new ClueGameState(gameState));
    }

    @Override
    protected boolean canMove(int pl)
    {
        return false;
    }

    @Override
    protected boolean makeMove(GameAction action)
    {
        //this method checks which state of the game we are in, and if a certain move can be made then
        //updated the gameState if the move was valid, and returns false, else returns false
        return false; //filler
    }


    private GamePlayer disproveTurn()
    {
        return null;
    }

    public boolean canRoll(GamePlayer pl)
    {
        return false;
    }

    public boolean canAccuse(GamePlayer pl)
    {
        return false;
    }

    public boolean canSuggest(GamePlayer pl)
    {
        return false;
    }

    public boolean canDisprove(GamePlayer pl)
    {
        return false;
    }

    public boolean canPassageway(GamePlayer pl)
    {
        return false;
    }

    public boolean checkAccusation(Card[] cd)
    {
        int correct = 0;
        for(Card card: cd){
            if(card == winningCards.get(0) || card == winningCards.get(1) || card == winningCards.get(2)){
                correct++;
            }
            if(correct == 3){
                return true;
            }
        }
        return false;
    }

}
