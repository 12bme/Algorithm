/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview;

/**
 *
 * @author jiseonoh
 */
public class DesignPattern {
    
}

class Restaurant {
    private static Restaurant _instance = null;
    public static Restaurant getInstance() {
        if(_instance == null ){
            _instance = new Restaurant();
        }
        return _instance;
    }
}


interface GameType {
    public static CardGame Poker = new PokerGame();
    public static CardGame BlackJack = new BlackJackGame();
}

class PokerGame extends CardGame {}
class BlackJackGame extends CardGame {}

class CardGame {
    public static CardGame createCardGame(GameType type) {
        if(type == GameType.Poker) {
            return new PokerGame();
        } else if (type == GameType.BlackJack) {
            return new BlackJackGame();
        }
        return null;
    }
}
