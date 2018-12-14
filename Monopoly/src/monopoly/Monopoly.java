/*
MONOPOLY ASSIGNMENT
By: Shawn Sun, Christopher Jordan, Gabriel Martell, and Bryce Batten
ICS3U
 */
package monopoly;

import java.awt.Font;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Monopoly {

    public static JButton number;
    public static JButton newNum;
    public static int num;
    public static JLabel[] player = new JLabel[4];
    public static int playerturn = 0;
    public static int[] space = new int[4];
    public static String[] spacename = {"Go!", "Mr. Royko's Room", "Community Chest", "Ms. Dale's Room", "Student Fee", "Retaj", "Ms. Brooks' Room", "Chance", "Mr. Blank's Room", "Mr. Loy's Room", "Jail/Just Visiting", "Mr. Ketcheson's Room", "Cafeteria", "Ms. Turnbulll's Room", "Mr. Yemensky's Room", "Subway", "Ms. Galveals' Room", "Community Chest", "Mr. Lahey's Room", "Ms. Andreoli's Room", "Hall Pass", "Mr. McKee's Room", "Chance Card", "Ms. Egan's Room", "Mr. Baar's Room", "DQ", "Mr. Thompson's Room", "Ms. Miri's Room", "Learning Commons", "Mr. Scerbo's Room", "Go to Detention", "Ms. Sipes' Room", "Mrs. Gibson's Room", "Community Chest", "Ms. Ramsay's Room", "Gabriel's Pizza", "Chance", "Mr. Blakely's Room", "Field Trip", "Mr. Schwartz's Room"};
    public static String[] chanceCards = {"Advance to 'Go', Collect $200", "Advance to Mrs. Egan’s Religion. If you pass “Go”, collect $200.", "Advance to Mr. Ketcheson’s Visual Arts. If you pass Go, collect $200.", "Advance your player piece to nearest Lunch Hangout Area. If unowned, you may buy it from the RBC. If owned, throw dice and pay owner a total 10 times the amount thrown.", "Advance your player piece to the nearest Plaza Restaurant and pay owner twice the rental to which he/she is otherwise entitled. If the Plaza Restaurant is unowned, you may buy it from the RBC.", "RBC pays you the $50 your parents put into your account.", "Get out of Detention Free Card. This card may be kept until needed, or traded/sold.", "Go back Three (3) tiles.", "You got caught skipping! Go to Detention. . . directly to Detention! Do not pass “Go”, do not collect $200.", "Out of rage because of a bad grade, you accidentally broke stuff at all your property sites! For each house pay $25, For each hotel pay $100.", "Mr. Adams’ charming voice forces you to buy pizza! You pay $15 worth of pizza.", "Take your time at lunch to go to the plaza’s Retaj. If you pass Go, collect $200.", "Time to play BINGO. Advance your player piece to Mr. Schwartz’s Tech.", "You have been elected as the Student Council President. Pay each player $50.", "You somehow find a jackpot of money under your couch?! Collect $150.", "You have won a contest of sorts. Collect $100."};
    public static String[] ccCards = {"Advance to \"Go\", Collect $200", "RBC withdrawal error in your favor. Collect $200.", "You stand on a stool in drama class but fall. Your friends will probably make fun of you for quite some time. Pay hospital fee of $50.", "Sold baked good at the cafeteria, you got $50.", "Get out of Detention Free Card. This card may be kept until needed, or traded/sold.", "You got caught skipping! Go to Detention. . . directly to Detention! Do not pass “Go”, do not collect $200.", "Elf Auction! Collect $50 from every player for the entry tickets.", "Coyote Prowl! Receive $100 for putting on a good show.", "You asked your parents for money. They were feeling generous and gave you a bit extra. Collect $20.", "It is your birthday, everyone in your class sings “Happy Birthday” out of tune. Collect $10 from every player.", "A student was low-riding to a point where they gave away their Gucci belt, and gave it to you. You sell it because brands don’t mean anything. Collect $100 ", "You want to purchase a school hoodie to show off your Coyote Spirit! Pay $50. ", "At the elf auction, you got into a bid battle and won. On the negative side, you battled for quite a while. Pay $50.", "You tutor a student and they pay you out of generosity. Receive $25.", "You connect to the bluetooth speaker at every property site you own and play Youtube Rewind 2018, wasn’t a bright idea… Pay $40 per house and $115 per hotel you own.", "Your grandparent slips you some money when your parents wouldn't. Receive $100."};
    public static JLabel turn = new JLabel();
    public static Integer[] money = {1500, 1500, 1500, 1500};
    public static JLabel[] moneyLabel = new JLabel[4];
    public static String[] name = new String[4];
    public static Integer[] deckChance = new Integer[16];
    public static Integer[] deckChest = new Integer[16];

    public static void main(String[] args) throws IOException {
        JFrame HUD = new JFrame();
        HUD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HUD.setSize(1800, 1050);
        HUD.setLayout(null);

        for (int nameInput = 0; nameInput < 4; nameInput++) {
            do {
            name[nameInput] = JOptionPane.showInputDialog("What is your name Player " + (nameInput + 1) + " (12 Characters Max)");
            if ((name[nameInput].length() > 12) || (name[nameInput].length() == 0)){
                JOptionPane.showMessageDialog(null, "Please input a valid name");
            }
            } while((name[nameInput].length() > 12) || (name[nameInput].length() == 0));
        
            }
        for (int playericon = 0; playericon < 4; playericon++) {
            String[] options = {"Binder", "Mouse", "Sun G.'s", "Phone", "Soccer", "Paint"};
            int iconchoice = JOptionPane.showOptionDialog(null, "Choose a playerpiece " + name[playericon],
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (iconchoice) {
                case 0:
                    player[playericon] = new JLabel(new ImageIcon("images/players/binderfix.png"));
                    break;
                case 1:
                    player[playericon] = new JLabel(new ImageIcon("images/players/mousefix.png"));
                    break;
                case 2:
                    player[playericon] = new JLabel(new ImageIcon("images/players/sunfix.png"));
                    break;
                case 3:
                    player[playericon] = new JLabel(new ImageIcon("images/players/phonefix.png"));
                    break;
                case 4:
                    player[playericon] = new JLabel(new ImageIcon("images/players/soccerfix.png"));
                    break;
                case 5:
                    player[playericon] = new JLabel(new ImageIcon("images/players/paintfix.png"));
                    break;
            }
            HUD.add(player[playericon]);
        }
        player[0].setBounds((855), (875), player[0].getPreferredSize().width, player[0].getPreferredSize().height);
        player[1].setBounds((895), (875), player[1].getPreferredSize().width, player[1].getPreferredSize().height);
        player[2].setBounds((855), (925), player[2].getPreferredSize().width, player[2].getPreferredSize().height);
        player[3].setBounds((895), (925), player[3].getPreferredSize().width, player[3].getPreferredSize().height);

        for (int moneyicon = 0; moneyicon < 4; moneyicon++) {
            moneyLabel[moneyicon] = new JLabel(name[moneyicon] + "'s money: $" + money[moneyicon] + "");
            moneyLabel[moneyicon].setFont(new Font("Monospaced Plain", Font.PLAIN, 35));
            HUD.add(moneyLabel[moneyicon]);
        }
        moneyLabel[0].setBounds(1350, 110, 1000, 100);
        moneyLabel[1].setBounds(1350, 210, 1000, 100);
        moneyLabel[2].setBounds(1350, 310, 1000, 100);
        moneyLabel[3].setBounds(1350, 410, 1000, 100);

        number = new JButton(num + "");
        number.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        number.setBounds(1050, 10, 100, 100);
        HUD.add(number);

        turn.setText(name[playerturn] + "'s turn");
        turn.setFont(new Font("Monospaced Plain", Font.PLAIN, 50));
        turn.setBounds(1350, 10, 1000, 100);
        HUD.add(turn);

        JLabel board = new JLabel();
        board.setIcon(new ImageIcon("images/monopolyboard.jpg"));
        board.setBounds((1), (1), board.getPreferredSize().width, board.getPreferredSize().height);
        HUD.add(board);

        HUD.setVisible(true);

        while (true) {
            String[] options = {"Roll", "blank", "blank", "blank"};
            int menuchoice = JOptionPane.showOptionDialog(null, "What would you like to do, " + name[playerturn] + "?",
                    "PICK SOMETHING",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (menuchoice) {
                case 0:
                    moverMethod();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            turn.setText(name[playerturn] + "'s turn");
        }
    }

    public static void moverMethod() {
        num = ((new Random()).nextInt((12 - 2) + 1) + 2);
        number.setText(num + "");
        JOptionPane.showMessageDialog(null, "You rolled " + num);
        space[playerturn] += num;
        do {
            if (space[playerturn] >= 40) {
                space[playerturn] -= 40;
                JOptionPane.showMessageDialog(null, "You passed go, collect $200");
                money[playerturn] += 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
            }
        } while (space[playerturn] >= 40);
        spaceMaker();
        spaceLanded();

        playerturn += 1;
        if (playerturn == 4) {
            playerturn = 0;
        }
    }

    public static void spaceLanded() {
        JOptionPane.showMessageDialog(null, name[playerturn] + ", you landed on " + spacename[space[playerturn]]);
        switch (space[playerturn]) {
            case 0:
                landedOnGo();
                break;
            case 7:
            case 22:
            case 36:
                landedOnChance();
                break;
            case 2:
            case 17:
            case 33:
                landedOnCChest();
                break;
            case 4:
            case 38:
                landedOnPay();
                break;
            case 30:
                landedOnGoTo();
                break;
            case 10:
            case 20:
                landedOnRelax();
                break;
            default:
                landedOnProperty();
                break;
        }
    }

    public static void landedOnGo() {
        JOptionPane.showMessageDialog(null, "GO, time to relax!");

    }

    public static void landedOnChance() {
        JOptionPane.showMessageDialog(null, "You landed on a Chance Card");

    }

    public static void landedOnCChest() {
        JOptionPane.showMessageDialog(null, "You landed on a Community Chest Card");

    }

    public static void landedOnPay() {
        switch (space[playerturn]) {
            case 4:
                JOptionPane.showMessageDialog(null, "Please pay $200 for a Student Fee");
                money[playerturn] -= 200;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
            case 38:
                JOptionPane.showMessageDialog(null, "FIELD TRIP!!! Pay $100");
                money[playerturn] -= 100;
                moneyLabel[playerturn].setText(name[playerturn] + "'s money: $" + money[playerturn] + "");
                break;
        }
    }
    public static void landedOnGoTo() {
        JOptionPane.showMessageDialog(null, "GO TO JAIL, DO NOT PASS GO, DO NOT COLLECT 200");

    }

    public static void landedOnRelax() {
        JOptionPane.showMessageDialog(null, "Ahh finally, a space that does nothing!");

    }

    public static void landedOnProperty() {
        JOptionPane.showMessageDialog(null, "Property");

    }

    public static void spaceMaker() {
        switch (playerturn) {
            case 0:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((614), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((534), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((458), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((383), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((307), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((227), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((145), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (845), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((18), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((18), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((18), (615), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((18), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((18), (455), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((18), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((18), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((18), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((18), (150), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((50), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((145), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((227), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((307), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((383), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((458), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((534), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((614), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((690), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((765), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (155), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (460), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (620), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 1:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((895), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((800), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((725), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((649), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((569), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((493), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((418), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((342), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((262), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((180), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (875), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((68), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((68), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((68), (615), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((68), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((68), (455), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((68), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((68), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((68), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((68), (150), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((100), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((180), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((262), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((342), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((418), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((493), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((569), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((649), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((725), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((800), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((925), (25), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((925), (155), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((925), (230), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((925), (305), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((925), (385), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((925), (460), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((925), (535), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((925), (620), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((925), (695), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((925), (760), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 2:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((855), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((765), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((690), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((614), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((534), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((458), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((383), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((307), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((227), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((145), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (905), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((18), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((18), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((18), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((18), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((18), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((18), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((18), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((18), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((18), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((50), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((145), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((227), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((307), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((383), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((458), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((534), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((614), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((690), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((765), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((875), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((875), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((875), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((875), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((875), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((875), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((875), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((875), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((875), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((875), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
            case 3:
                switch (space[playerturn]) {
                    case 0:
                        player[playerturn].setBounds((895), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 1:
                        player[playerturn].setBounds((800), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 2:
                        player[playerturn].setBounds((725), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 3:
                        player[playerturn].setBounds((649), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 4:
                        player[playerturn].setBounds((569), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 5:
                        player[playerturn].setBounds((493), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 6:
                        player[playerturn].setBounds((418), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 7:
                        player[playerturn].setBounds((342), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 8:
                        player[playerturn].setBounds((262), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 9:
                        player[playerturn].setBounds((180), (925), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 10:
                        player[playerturn].setBounds((18), (935), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 11:
                        player[playerturn].setBounds((68), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 12:
                        player[playerturn].setBounds((68), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 13:
                        player[playerturn].setBounds((68), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 14:
                        player[playerturn].setBounds((68), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 15:
                        player[playerturn].setBounds((68), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 16:
                        player[playerturn].setBounds((68), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 17:
                        player[playerturn].setBounds((68), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 18:
                        player[playerturn].setBounds((68), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 19:
                        player[playerturn].setBounds((68), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 20:
                        player[playerturn].setBounds((100), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 21:
                        player[playerturn].setBounds((180), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 22:
                        player[playerturn].setBounds((262), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 23:
                        player[playerturn].setBounds((342), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 24:
                        player[playerturn].setBounds((418), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 25:
                        player[playerturn].setBounds((493), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 26:
                        player[playerturn].setBounds((569), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 27:
                        player[playerturn].setBounds((649), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 28:
                        player[playerturn].setBounds((725), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 29:
                        player[playerturn].setBounds((800), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 30:
                        player[playerturn].setBounds((925), (75), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 31:
                        player[playerturn].setBounds((925), (190), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 32:
                        player[playerturn].setBounds((925), (270), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 33:
                        player[playerturn].setBounds((925), (345), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 34:
                        player[playerturn].setBounds((925), (425), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 35:
                        player[playerturn].setBounds((925), (495), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 36:
                        player[playerturn].setBounds((925), (575), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 37:
                        player[playerturn].setBounds((925), (650), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 38:
                        player[playerturn].setBounds((925), (730), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                    case 39:
                        player[playerturn].setBounds((925), (800), player[playerturn].getPreferredSize().width, player[playerturn].getPreferredSize().height);
                        break;
                }
                break;
        }
    }
}
