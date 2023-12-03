package slotmachinetest;

public class SlotMachineTest {

    public static void main(String[] args) throws Exception {
        var arcadeOffice = new ArcadeHeadOffice();
        var card1 = arcadeOffice.CreateNewCard();
        var card2 = arcadeOffice.CreateNewCard();
        var game1 = arcadeOffice.CreateNewGame("Lucky Shot", 10);
        var terminal1 = arcadeOffice.CreateNewTerminal();
        terminal1.UI();
    }
}
