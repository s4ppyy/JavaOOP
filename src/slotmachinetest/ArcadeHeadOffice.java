package slotmachinetest;

import java.util.ArrayList;

public class ArcadeHeadOffice {
    private ArrayList<Card> cards;
    private int cardIdCounter = 0;
    private ArrayList<Game> games;
    private int gameIdCounter = 0;
    private ArrayList<Terminal> terminals;
    private int terminalIdCounter = 0;

    public ArcadeHeadOffice() {
        cards = new ArrayList<Card>();
        games = new ArrayList<Game>();
        terminals = new ArrayList<Terminal>();
    }

    public Card CreateNewCard() throws Exception {
        var card = new Card(cardIdCounter);
        cardIdCounter++;
        cards.add(card);
        return card;
    }

    public Game CreateNewGame(String name, int price) throws Exception {
        if (name.isEmpty()) throw new Exception("Empty String");
        if (price <= 0) throw new Exception("Invalid Number");
        var game = new Game(name, price, gameIdCounter);
        gameIdCounter++;
        games.add(game);
        return game;
    }

    public Terminal CreateNewTerminal() throws Exception {
        var terminal = new Terminal(terminalIdCounter, this);
        terminalIdCounter++;
        terminals.add(terminal);
        return terminal;
    }

    public Card GetCard(int id) throws Exception {
        if (id < 0) throw new Exception("Invalid Number");
        return cards.stream().filter(cardToFind -> id == cardToFind.GetId()).findAny().orElse(null);
    }

    public Game GetGame(int id) throws Exception {
        if (id < 0) throw new Exception("Invalid Number");
        return games.stream().filter(gameToFind -> id == gameToFind.GetGameID()).findAny().orElse(null);
    }
}
