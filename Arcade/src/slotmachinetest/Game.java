package slotmachinetest;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private String gameName;
    private static int _maxPrize = 30;
    private int playPrice;
    private int id;

    public Game(String gameNameConstruct, int playPriceConstruct, int idConstruct) throws Exception {
        if (gameNameConstruct.isEmpty()) throw new Exception("Empty String");
        if (playPriceConstruct <= 0) throw new Exception("Invalid number");
        if (idConstruct < 0) throw new Exception("Invalid number");
        gameName = gameNameConstruct;
        playPrice = playPriceConstruct;
        id = idConstruct;
    }

    public String GetGameName() {
        return gameName;
    }

    public int GetPlayPrize() {
        return playPrice;
    }

    public int GetGameID() {
        return id;
    }

    public void SetPlayPrice(int newPrice) throws Exception {
        if (newPrice <= 0) throw new Exception("Invalid number");
        playPrice = newPrice;
    }

    public void SetName(String newName) throws Exception {
        if (newName.isEmpty()) throw new Exception("Empty String");
        gameName = newName;
    }

    public void SetGameID(int newId) throws Exception {
        if (newId < 0) throw new Exception("Invalid Number");
        id = newId;
    }

    public void Play(Card card) throws Exception {

        int prize;
//        prize = rand.nextInt(_maxPrize);
        prize = ThreadLocalRandom.current().nextInt(_maxPrize);

        if (playPrice < card.GetBalanceCredit()) {

            card.WithdrawBalanceCredit(playPrice);
            card.TopUpBalanceTicket(prize);

            System.out.println("-------Игра-------");

            System.out.println("Вы получили " + prize + " билетов(а).");
            System.out.println("ID: " + card.GetId());
            System.out.println("Текущее количество кредитов: " + card.GetBalanceCredit());
            System.out.println("Текущее количество билетов: " + card.GetBalanceTicket());

            System.out.println("___________________\n");
        } else {

            System.out.println("У вас недостаточно кредитов");
            System.out.println("Ваш баланс: " + card.GetBalanceCredit() + " кредитов(а)");
            System.out.println("Стоимость игры: " + playPrice + " кредитов(а)");

            System.out.println("__________________\n");
        }
    }
}
