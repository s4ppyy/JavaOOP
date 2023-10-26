package slotmachinetest;

import java.util.*;

public class Terminal {
    private static int _coeffTrade = 2;
    private PrizeCategory smallPrize = new PrizeCategory("Маленький", 10, 5);
    private PrizeCategory mediumPrize = new PrizeCategory("Средний", 20, 5);
    private PrizeCategory bigPrize = new PrizeCategory("Большой", 30, 5);
    private int id;
    private ArcadeHeadOffice office;

    public Terminal(int idConstruct, ArcadeHeadOffice officeConstruct) throws Exception {
        if (idConstruct < 0) throw new Exception("Invalid Number");
        if (officeConstruct == null) throw new Exception("Null Value");
        office = officeConstruct;
        id = idConstruct;
    }

    public void UI(Card card) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------Меню-------");

        System.out.println("1. Пополнить баланс");
        System.out.println("2. Проверить баланс");
        System.out.println("3. Перевод кредитов и билетов");
        System.out.println("4. Играть");
        System.out.println("5. Купить призы");
        System.out.println("6. Вернуться в меню");
        System.out.println("0. Выход");

        System.out.println("Что бы вы хотели сделать?");

        int input = sc.nextInt();

        while (input != 0) {

            switch (input) {

                case 1:
                    System.out.println("-------Пополнить баланс-------");

                    System.out.println("ID карты: " + card.GetId());
                    System.out.println("Текущий баланс: " + card.GetBalanceCredit() + " кредитов(а)");
                    System.out.println("Внесённое количество: ");
                    TopUpCardCreditBalance(card, sc.nextInt());
                    System.out.println("Новый баланс: " + card.GetBalanceCredit());
                    System.out.println("-------------------\n");

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 2:
                    CheckBalance(card);

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 3:

                    System.out.println("Перевести кредиты на карту с ID: ");
                    int idCardCreditTo = sc.nextInt();
                    var cardCreditTo = office.GetCard(idCardCreditTo);
                    System.out.println("Сумма перевода: ");
                    int sumCredit = sc.nextInt();
                    if (cardCreditTo != null) TransferCredit(card, cardCreditTo, sumCredit);
                    else System.out.println("Карта не найдена");

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 4:

                    System.out.println("Перевести билеты на карту с ID: ");
                    int idCardTicketTo = sc.nextInt();
                    var cardTicketTo = office.GetCard(idCardTicketTo);
                    System.out.println("Сумма перевода: ");
                    int sumTicket = sc.nextInt();
                    if (cardTicketTo != null) TransferCredit(card, cardTicketTo, sumTicket);
                    else System.out.println("Карта не найдена");

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 5:

                    System.out.println("Играть в игру с ID: ");
                    int gameId = sc.nextInt();
                    Game gameToPlay = office.GetGame(gameId);
                    if (gameToPlay != null) gameToPlay.Play(card);
                    else System.out.println("Игра не найдена0");

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 6:

                    System.out.println("Выберите приз( 1(маленький), 2(средний) или 3(большой) ): ");
                    int prizeId = sc.nextInt();
                    switch (prizeId) {
                        case 1 -> {
                            GetSmallPrize(card);
                            // System.out.println("Осталось " + smallPrize.GetQuantity() + " призов(а)");
                            // Вывожу в методе this.GetSmallPrize - можно выбрать где выводить
                        }
                        case 2 -> {
                            GetMediumPrize(card);
                            // System.out.println("Осталось " + mediumPrize.GetQuantity() + " призов(а)");
                            // Аналогично с case 1 comment
                        }
                        case 3 -> {
                            GetBigPrize(card);
                            // System.out.println("Осталось " + bigPrize.GetQuantity() + " призов(а)");
                            // Аналогично с case 1 comment
                        }
                        default -> System.out.println("Некорректный ввод");
                    }

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 7:

                    System.out.println("-------Меню-------");
                    System.out.println("1. Пополнить баланс");
                    System.out.println("2. Проверить баланс");
                    System.out.println("3. Перевод кредитов");
                    System.out.println("4. Перевод билетов");
                    System.out.println("5. Играть");
                    System.out.println("6. Купить призы");
                    System.out.println("7. Вернуться в меню");
                    System.out.println("0. Выход\n");

                    input = sc.nextInt();
                    break;

                case 0:

                    break;

                default:

                    System.out.println("Некорректный ввод");

            }
        }
    }

    private void GetSmallPrize(Card card) throws Exception {
        if (card == null) throw new Exception("Null Value");
        if (card.GetBalanceTicket() < smallPrize.GetCost()) throw new Exception("Not Enough Tickets");
        if (smallPrize.GetQuantity() == 0) throw new Exception("Not Enough Prizes");
        card.WithdrawBalanceTicket(smallPrize.GetCost());
        smallPrize.GivePrize();
        System.out.println("Small Prizes Remain: " + smallPrize.GetQuantity());
    }

    private void GetMediumPrize(Card card) throws Exception {
        if (card == null) throw new Exception("Null Value");
        if (card.GetBalanceTicket() < smallPrize.GetCost()) throw new Exception("Not Enough Tickets");
        if (mediumPrize.GetQuantity() == 0) throw new Exception("Not Enough Prizes");
        card.WithdrawBalanceTicket(mediumPrize.GetCost());
        mediumPrize.GivePrize();
        System.out.println("Medium Prizes Remain: " + mediumPrize.GetQuantity());
    }

    private void GetBigPrize(Card card) throws Exception {
        if (card == null) throw new Exception("Null Value");
        if (card.GetBalanceTicket() < smallPrize.GetCost()) throw new Exception("Not Enough Tickets");
        if (bigPrize.GetQuantity() == 0) throw new Exception("Not Enough Prizes");
        card.WithdrawBalanceTicket(bigPrize.GetCost());
        bigPrize.GivePrize();
        System.out.println("Big Prizes Remain: " + bigPrize.GetQuantity());
    }

    private void SetSmallPrize(PrizeCategory newSmallPrize) throws Exception {
        if (newSmallPrize == null) throw new Exception("Null Value");
        smallPrize = newSmallPrize;
    }

    private void SetMediumPrize(PrizeCategory newMediumPrize) throws Exception {
        if (newMediumPrize == null) throw new Exception("Null Value");
        mediumPrize = newMediumPrize;
    }

    private void SetBigPrize(PrizeCategory newBigPrize) throws Exception {
        if (newBigPrize == null) throw new Exception("Null Value");
        bigPrize = newBigPrize;
    }

    private void TransferCredit(Card cardFrom, Card cardTo, int sumTransfer) throws Exception {
        if (cardFrom == null || cardTo == null) throw new Exception("Null Value");
        if (sumTransfer <= 0) throw new Exception("Invalid Sum");
        if (cardFrom.GetBalanceCredit() < sumTransfer) throw new Exception("Not Enough Credits");
        cardFrom.WithdrawBalanceCredit(sumTransfer);
        cardTo.TopUpBalanceCredit(sumTransfer);
        System.out.println("Balance From: " + cardFrom.GetBalanceCredit());
        System.out.println("Balance To: " + cardTo.GetBalanceCredit());
    }

    private void TransferTickets(Card cardFrom, Card cardTo, int sumTransfer) throws Exception {
        if (cardFrom == null || cardTo == null) throw new Exception("Null Value");
        if (sumTransfer <= 0) throw new Exception("Invalid Sum");
        if (cardFrom.GetBalanceTicket() < sumTransfer) throw new Exception("Not Enough Credits");
        cardFrom.WithdrawBalanceTicket(sumTransfer);
        cardTo.TopUpBalanceTicket(sumTransfer);
        System.out.println("Balance From: " + cardFrom.GetBalanceTicket());
        System.out.println("Balance To: " + cardTo.GetBalanceTicket());
    }

    private void TopUpCardCreditBalance(Card card, int money) throws Exception {
        if (card == null) throw new Exception("Null Value");
        if (money <= 0) throw new Exception("Invalid Sum");
        card.TopUpBalanceCredit(money * _coeffTrade);
    }

    private void CheckBalance(Card card) throws Exception {
        if (card == null) throw new Exception("Null Value");
        System.out.println("Card ID: " + card.GetId());
        System.out.println("Credits: " + card.GetBalanceCredit());
        System.out.println("Tickets " + card.GetBalanceTicket());
    }
}
