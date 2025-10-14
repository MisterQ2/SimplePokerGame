package poker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Poker {
//deck of cards
    static ArrayList<String> cards = new ArrayList<String>();
    static ArrayList<String> deckChanger;
    static boolean PlayerAllInPreFlop = false;
    static boolean PlayerAllInFlop = false;
    static boolean PlayerAllInTurn = false;
    static boolean PlayerAllInRiver = false;
    static boolean OpponentAllInPreFlop = false;
    static boolean OpponentAllInFlop = false;
    static boolean OpponentAllInTurn = false;
    static boolean OpponentAllInRiver = false;
    static int counter = 0;
    static int deckReset = 0;
    static int PlayerHearts = 0;
    static int PlayerDiamonds = 0;
    static int PlayerSpades = 0;
    static int PlayerClubs = 0;
    static int OpponentHearts = 0;
    static int OpponentDiamonds = 0;
    static int OpponentSpades = 0;
    static int OpponentClubs = 0;
    static boolean PlayerRoyalFlush = false;
    static boolean OpponentRoyalFlush = false;
    static boolean PlayerStraightFlush = false;
    static int PlayerStraightFlushHigh = 0;
    static boolean OpponentStraightFlush = false;
    static int OpponentStraightFlushHigh = 0;
    static boolean PlayerFourOfAKind = false;
    static int PlayerFourOfAKindHigh = 0;
    static boolean OpponentFourOfAKind = false;
    static int OpponentFourOfAKindHigh = 0;
    static boolean PlayerFullHouse = false;
    static int PlayerFullHouseHigh1 = 0;
    static int PlayerFullHouseHigh2 = 0;
    static boolean OpponentFullHouse = false;
    static int OpponentFullHouseHigh1 = 0;
    static int OpponentFullHouseHigh2 = 0;
    static boolean PlayerFlush = false;
    static int PlayerFlushHigh = 0;
    static int PlayerFlushHighHeart;
    static int PlayerFlushHighDiamond;
    static int PlayerFlushHighSpade;
    static int PlayerFlushHighClub;
    static boolean OpponentFlush = false;
    static int OpponentFlushHigh;
    static int OpponentFlushHighHeart;
    static int OpponentFlushHighDiamond;
    static int OpponentFlushHighSpade;
    static int OpponentFlushHighClub;
    static int FlushHigh;
    static boolean PlayerStraight = false;
    static int PlayerStraightHigh = 0;
    static boolean OpponentStraight = false;
    static int OpponentStraightHigh = 0;
    static int StraightHigh;
    static boolean PlayerThreeOfAKind = false;
    static int PlayerThreeOfAKindHigh = 0;
    static boolean OpponentThreeOfAKind = false;
    static int OpponentThreeOfAKindHigh = 0;
    static boolean PlayerTwoPair = false;
    static int PlayerTwoPairHigh = 0;
    static boolean OpponentTwoPair = false;
    static int OpponentTwoPairHigh = 0;
    static boolean PlayerOnePair = false;
    static int PlayerOnePairHigh = 0;
    static boolean OpponentOnePair = false;
    static int OpponentOnePairHigh = 0;
    static boolean PlayerHighCard = false;
    static int PlayerHighCardValue = 0;
    static boolean OpponentHighCard = false;
    static int OpponentHighCardValue = 0;
    static boolean Chop = false;
    static boolean PlayerWin = false;
    static boolean OpponentWin = false;
    static int one;
    static int two;
    static int three;
    static int four;
    static int five;
    static int six;
    static int seven;
    static int eight;
    static int nine;


    public static void main(String[] args) {
        //for ai computer's decisions
        Random r = new Random();
        
        System.out.println("Enter Buy In:");
        Scanner scanner = new Scanner(System.in);
        int BuyIn = scanner.nextInt();
        if(BuyIn <= 0) {
            System.out.println("Please enter a valid buy in above 0.");
            System.exit(0);
        }
        
        int opponentStack = BuyIn;
        System.out.println("\nYour stack: " + BuyIn);
        System.out.println("Opponent's stack: " + opponentStack);
        
        int PlayerBetTotal = 0;
        int OpponentBetTotal = 0;
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        
        
        //array list definition starts
        for(int i = 2; i < 38; i++) {
            if(i <= 10) {
                cards.add(String.valueOf(i) + " hearts");
            }
            else if(i <= 19) {
                cards.add(String.valueOf(i+1-10) + " diamonds");
            }
            else if(i <= 28) {
                cards.add(String.valueOf(i+2-20) + " spades");
            }
            else if(i <= 37) {
                cards.add(String.valueOf(i+3-30) + " clubs");
            }
        }
        cards.add("J hearts");
        cards.add("J diamonds");
        cards.add("J spades");
        cards.add("J clubs");
        cards.add("Q hearts");
        cards.add("Q diamonds");
        cards.add("Q spades");
        cards.add("Q clubs");
        cards.add("K hearts");
        cards.add("K diamonds");
        cards.add("K spades");
        cards.add("K clubs");
        cards.add("A hearts");
        cards.add("A diamonds");
        cards.add("A spades");
        cards.add("A clubs");
        //array list definition ends
        //backup deck
        deckChanger = new ArrayList<>(cards);
        //start of while loop for game
        int a = 0;
        while(true) {
            if(!PlayerAllInPreFlop && !PlayerAllInFlop && !PlayerAllInTurn && !PlayerAllInRiver && !OpponentAllInPreFlop && !OpponentAllInFlop && !OpponentAllInTurn && !OpponentAllInRiver) {
                PlayerBetTotal = 0;
                OpponentBetTotal = 0;
            }
            int countera = 0;
            
            if(PlayerAllInPreFlop || PlayerAllInFlop || PlayerAllInTurn || PlayerAllInRiver || OpponentAllInPreFlop || OpponentAllInFlop || OpponentAllInTurn || OpponentAllInRiver) {
                str5 = deal();
                str6 = deal();
                str7 = deal();
                str8 = deal();
                str9 = deal();
                
                if(PlayerAllInPreFlop || OpponentAllInPreFlop) {
                    System.out.println("\n@@@@@@@@@@@@");
                    System.out.println("    FLOP");
                    System.out.println("@@@@@@@@@@@@");

                    System.out.println("\n" + str5 + ", " + str6 + ", " + str7);
                    System.out.println("\nPress p to proceed:");
                    scanner.nextLine();
                    countera++;
                    if(!scanner.nextLine().equals("p")) {
                        System.out.println("\nPlease enter a valid response.");
                        System.exit(0);
                    }
                }
                ////////////////////////////////////////////////////////
                if(PlayerAllInFlop || OpponentAllInFlop || PlayerAllInPreFlop || OpponentAllInPreFlop) {
                    System.out.println("\n@@@@@@@@@@@@");
                    System.out.println("    TURN");
                    System.out.println("@@@@@@@@@@@@");

                    System.out.println("\n" + str5 + ", " + str6 + ", " + str7 + ", " + str8);
                    System.out.println("\nPress p to proceed:");
                    if(PlayerAllInFlop || OpponentAllInFlop) {
                        scanner.nextLine();
                        countera++;
                    }
                    if(!scanner.nextLine().equals("p")) {
                        System.out.println("\nPlease enter a valid response.");
                        System.exit(0);
                    }
                    
                }
                ////////////////////////////////////////////////////////
                if(PlayerAllInTurn || OpponentAllInTurn || PlayerAllInFlop || OpponentAllInFlop || PlayerAllInPreFlop || OpponentAllInPreFlop) {
                    System.out.println("\n@@@@@@@@@@@@@");
                    System.out.println("    RIVER");
                    System.out.println("@@@@@@@@@@@@@");

                    System.out.println("\n" + str5 + ", " + str6 + ", " + str7 + ", " + str8 + ", " + str9);
                    
                    System.out.println("\nPress p to proceed:");
                    if(PlayerAllInTurn || OpponentAllInTurn) {
                        scanner.nextLine();
                        countera++;
                    }
                    if(!scanner.nextLine().equals("p")) {
                        System.out.println("\nPlease enter a valid response.");
                        System.exit(0);
                    }
                }
                ////////////////////////////////////////////////////////
                Showdown(str1, str2, str3, str4, str5, str6, str7, str8, str9, BuyIn, PlayerBetTotal, opponentStack, OpponentBetTotal);
            }
            
            PlayerAllInPreFlop = false;
            PlayerAllInFlop = false;
            PlayerAllInTurn = false;
            PlayerAllInRiver = false;
            OpponentAllInPreFlop = false;
            OpponentAllInFlop = false;
            OpponentAllInTurn = false;
            OpponentAllInRiver = false;
            PlayerHearts = 0;
            PlayerDiamonds = 0;
            PlayerSpades = 0;
            PlayerClubs = 0;
            OpponentHearts = 0;
            OpponentDiamonds = 0;
            OpponentDiamonds = 0;
            OpponentDiamonds = 0;
            OpponentSpades = 0;
            OpponentSpades = 0;
            OpponentClubs = 0;
            PlayerRoyalFlush = false;
            OpponentRoyalFlush = false;
            PlayerStraightFlush = false;
            PlayerStraightFlushHigh = 0;
            OpponentStraightFlush = false;
            OpponentStraightFlushHigh = 0;
            PlayerFourOfAKind = false;
            PlayerFourOfAKindHigh = 0;
            OpponentFourOfAKind = false;
            OpponentFourOfAKindHigh = 0;
            PlayerFullHouse = false;
            PlayerFullHouseHigh1 = 0;
            PlayerFullHouseHigh2 = 0;
            OpponentFullHouse = false;
            OpponentFullHouseHigh1 = 0;
            OpponentFullHouseHigh2 = 0;
            PlayerFlush = false;
            PlayerFlushHigh = 0;
            PlayerFlushHighHeart = 0;
            PlayerFlushHighDiamond = 0;
            PlayerFlushHighSpade = 0;
            PlayerFlushHighClub = 0;
            OpponentFlush = false;
            OpponentFlushHigh = 0;
            OpponentFlushHighHeart = 0;
            OpponentFlushHighDiamond = 0;
            OpponentFlushHighSpade = 0;
            OpponentFlushHighClub = 0;
            FlushHigh = 0;
            PlayerStraight = false;
            PlayerStraightHigh = 0;
            OpponentStraight = false;
            OpponentStraightHigh = 0;
            StraightHigh = 0;
            PlayerThreeOfAKind = false;
            PlayerThreeOfAKindHigh = 0;
            OpponentThreeOfAKind = false;
            OpponentThreeOfAKindHigh = 0;
            PlayerTwoPair = false;
            PlayerTwoPairHigh = 0;
            OpponentTwoPair = false;
            OpponentTwoPairHigh = 0;
            PlayerOnePair = false;
            PlayerOnePairHigh = 0;
            OpponentOnePair = false;
            OpponentOnePairHigh = 0;
            PlayerHighCard = false;
            PlayerHighCardValue = 0;
            OpponentHighCard = false;
            OpponentHighCardValue = 0;
            Chop = false;
            PlayerWin = false;
            OpponentWin = false;
            one = 0;
            two = 0;
            three = 0;
            four = 0;
            five = 0;
            six = 0;
            seven = 0;
            eight = 0;
            nine = 0;
            
            
            if(a >= 1) {
                if(countera == 0) {
                    scanner.nextLine();
                }
                else {
                    countera = 0;
                }
                System.out.println("\nAnother round? (Y/N)");
                String input = scanner.nextLine();
                if(input.equals("N")) {
                    System.out.println("\nYou leave with $" + BuyIn + ". Thanks for playing!");
                    System.exit(0);
                }
            }
            a++;
            
            System.out.println("\n@@@@@@@@@@@@@@@@@");
            System.out.println("    NEW ROUND");
            System.out.println("@@@@@@@@@@@@@@@@@");
            System.out.println("\nDealing hole cards...");
            //Player's hole cards
            str1 = deal();
            str2 = deal();
            System.out.println("\nYour cards: " + str1 + ", " + str2);
            //Opponent's hole cards
            str3 = deal();
            str4 = deal();
            
            System.out.println("\nChoose an option:");
            System.out.println("-------------------");
            System.out.println("1: Fold");
            System.out.println("2: Check");
            System.out.println("3: Bet");
            int option1 = scanner.nextInt();
            int PlayerBet = 0;
            PlayerBetTotal = 0;
            int OpponentBet = 0;
            OpponentBetTotal = 0;
            int PlayerBetRange = 0;
            int RandomRange = 0;
            if(option1 == 1) {
                System.out.println("\nYou fold. You lose.");
                System.out.println("You lost $" + PlayerBetTotal + ".");
                System.out.println("Your stack is now $" + BuyIn + ".");
                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                deckReset++;
                continue;
            }
            else if(option1 == 2) {
                System.out.println("\nYou check.");
            }
            else if(option1 == 3) {
                PlayerBetRange = BuyIn - PlayerBetTotal;
                System.out.println("How much do you want to bet? (You can bet up to $" + PlayerBetRange + ")");
                PlayerBet = scanner.nextInt();
                if(PlayerBet + PlayerBetTotal == BuyIn) {
                    PlayerAllInPreFlop = true;
                    
                    System.out.println("\nYou're All In!");
                    int RandomNum = r.nextInt(10) + 1;
                        if(RandomNum == 1) {
                            BuyIn += PlayerBetTotal;
                            opponentStack -= OpponentBetTotal;
                            System.out.println("\nOpponent folds. You win!");
                            System.out.println("You win $" + PlayerBetTotal + "!");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            PlayerAllInPreFlop = false;
                            continue;
                        }
                        else {
                            System.out.println("\nOpponent calls.");
                            PlayerBetTotal += PlayerBet;
                            if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                OpponentBetTotal += PlayerBet;
                            }
                            else {
                                OpponentBetTotal = opponentStack;
                            }
                            continue;
                        }
                }
                PlayerBetTotal += PlayerBet;
                if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                    System.out.println("Please enter a valid bet.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Please choose a valid option.");
                System.exit(0);
            }
            
            if(option1 == 2) {
                int RandomNum = r.nextInt(2) + 1;
                if(RandomNum == 1) {
                    System.out.println("\nOpponent checks back.");
                }
                else if(RandomNum == 2) {
                    int RandomNum2;
                    if(opponentStack > BuyIn) {
                        RandomRange = BuyIn - PlayerBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                    }
                    else {
                        RandomRange = opponentStack - OpponentBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                        if(RandomNum2 == RandomRange) {
                            OpponentAllInPreFlop = true;
                            System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                            
                            System.out.println("\nOpponent's All In!");
                            System.out.println("\nChoose an option:");
                            System.out.println("-------------------");
                            System.out.println("1: Fold");
                            System.out.println("2: Call");
                            int input1 = scanner.nextInt();
                            if(input1 == 1) {
                                BuyIn -= PlayerBetTotal;
                                opponentStack += OpponentBetTotal;
                                System.out.println("\nYou fold. You lose.");
                                System.out.println("You lost $" + PlayerBetTotal + ".");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                OpponentAllInPreFlop = false;
                                continue;
                            }
                            else if(input1 == 2) {
                                OpponentBetTotal += RandomNum2;
                                if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                    PlayerBetTotal += RandomNum2;
                                }
                                else {
                                    PlayerBetTotal = BuyIn;
                                }
                                continue;
                            }
                        }
                    }
                    System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                    OpponentBetTotal += RandomNum2;
                    if(BuyIn == PlayerBetTotal + RandomNum2) {
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        int input1 = scanner.nextInt();
                        
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                            System.out.println("\nYou're All In!");
                            PlayerAllInPreFlop = true;
                            continue;
                        }
                    }
                    System.out.println("\nChoose an option:");
                    System.out.println("-------------------");
                    System.out.println("1: Fold");
                    System.out.println("2: Call");
                    System.out.println("3: Raise");
                    int input1 = scanner.nextInt();
                    if(input1 == 1) {
                        OpponentBetTotal -= RandomNum2;
                        BuyIn -= PlayerBetTotal;
                        opponentStack += OpponentBetTotal;
                        System.out.println("\nYou fold. You lose.");
                        System.out.println("You lost $" + PlayerBetTotal + ".");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if(input1 == 2) {
                        PlayerBetTotal += RandomNum2;
                    }
                    else if(input1 == 3) {
                            int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                            System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                            PlayerBet = scanner.nextInt();
                            if(PlayerBet == PlayerRaise) {
                                PlayerAllInPreFlop = true;
                                
                                System.out.println("\nYou're All In!");
                                RandomNum = r.nextInt(10) + 1;
                                    if(RandomNum == 1) {
                                        BuyIn += PlayerBetTotal;
                                        opponentStack -= OpponentBetTotal;
                                        System.out.println("\nOpponent folds. You win!");
                                        System.out.println("You win $" + PlayerBetTotal + "!");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        PlayerAllInPreFlop = false;
                                        continue;
                                    }
                                    else {
                                        System.out.println("\nOpponent calls.");
                                        PlayerBetTotal += PlayerBet;
                                        if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                            OpponentBetTotal += PlayerBet;
                                        }
                                        else {
                                            OpponentBetTotal = opponentStack;
                                        }
                                        continue;
                                    }
                            }
                            PlayerBetTotal += PlayerBet + RandomNum2;
                            if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                System.out.println("Please enter a valid bet.");
                                System.exit(0);
                            }
                            
                            RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                PlayerBetTotal -= PlayerBet;
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                deckReset++;
                                continue;
                            }
                            else {
                                if(opponentStack > OpponentBetTotal + PlayerBet) {
                                   System.out.println("\nOpponent calls.");
                                   OpponentBetTotal += PlayerBet; 
                                }
                                else {
                                    OpponentBetTotal = opponentStack;
                                    OpponentAllInPreFlop = true;
                                    
                                    System.out.println("\nOpponent's All In!");
                                    System.out.println("\nChoose an option:");
                                    System.out.println("-------------------");
                                    System.out.println("1: Fold");
                                    System.out.println("2: Call");
                                    input1 = scanner.nextInt();
                                    if(input1 == 1) {
                                        BuyIn -= PlayerBetTotal;
                                        opponentStack += OpponentBetTotal;
                                        System.out.println("\nYou fold. You lose.");
                                        System.out.println("You lost $" + PlayerBetTotal + ".");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        OpponentAllInPreFlop = false;
                                        continue;
                                    }
                                    else if(input1 == 2) {
                                        OpponentBetTotal += RandomNum2;
                                        if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                            PlayerBetTotal += RandomNum2;
                                        }
                                        else {
                                            PlayerBetTotal = BuyIn;
                                        }
                                        continue;
                                    }
                                }
                            }
                    }
                }
                System.out.println("\n@@@@@@@@@@@@");
                System.out.println("    FLOP");
                System.out.println("@@@@@@@@@@@@");
            }
            else if(option1 == 3) {
                int RandomNum = r.nextInt(10) + 1;
                    if(RandomNum == 1 || RandomNum == 2) {
                        PlayerBetTotal -= PlayerBet;
                        BuyIn += PlayerBetTotal;
                        opponentStack -= OpponentBetTotal;
                        System.out.println("\nOpponent folds. You win!");
                        System.out.println("You win $" + PlayerBetTotal + "!");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if (RandomNum == 3 || RandomNum == 4 || RandomNum == 5 || RandomNum == 6 || opponentStack - OpponentBetTotal <= PlayerBet){
                        if(opponentStack - OpponentBetTotal == PlayerBet) {
                            OpponentAllInPreFlop = true;
                            System.out.println("\nOpponent's All In!");
                            OpponentBetTotal += PlayerBet;
                            continue;
                        }
                        System.out.println("\nOpponent calls.");
                        OpponentBetTotal += PlayerBet;
                    }
                    else {
                        int RandomNum2;
                        if(opponentStack > BuyIn) {
                            RandomNum2 = r.nextInt(BuyIn - PlayerBetTotal) + 1;
                        }
                        else {
                            RandomNum2 = r.nextInt(opponentStack - OpponentBetTotal - PlayerBet) + 1;
                            if(RandomNum2 == opponentStack - OpponentBetTotal - PlayerBet) {
                                OpponentAllInPreFlop = true;
                                System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                                
                                System.out.println("\nOpponent's All In!");
                                System.out.println("\nChoose an option:");
                                System.out.println("-------------------");
                                System.out.println("1: Fold");
                                System.out.println("2: Call");
                                int input1 = scanner.nextInt();
                                if(input1 == 1) {
                                    BuyIn -= PlayerBetTotal;
                                    OpponentBetTotal += PlayerBet;
                                    opponentStack += OpponentBetTotal;
                                    System.out.println("\nYou fold. You lose.");
                                    System.out.println("You lost $" + PlayerBetTotal + ".");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    OpponentAllInPreFlop = false;
                                    continue;
                                }
                                else if(input1 == 2) {
                                    OpponentBetTotal += RandomNum2 + PlayerBet;
                                    if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                        PlayerBetTotal += RandomNum2;
                                    }
                                    else {
                                        PlayerBetTotal = BuyIn;
                                    }
                                    continue;
                                }
                            }
                        }
                        System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                        OpponentBetTotal += RandomNum2 + PlayerBet;
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        System.out.println("3: Raise");
                        int input1 = scanner.nextInt();
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                        }
                        else if(input1 == 3) {
                                int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                                System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                                PlayerBet = scanner.nextInt();
                                if(PlayerBet == PlayerRaise) {
                                    PlayerAllInPreFlop = true;
                                    
                                    System.out.println("\nYou're All In!");
                                    RandomNum = r.nextInt(10) + 1;
                                        if(RandomNum == 1) {
                                            BuyIn += PlayerBetTotal;
                                            opponentStack -= OpponentBetTotal;
                                            System.out.println("\nOpponent folds. You win!");
                                            System.out.println("You win $" + PlayerBetTotal + "!");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            PlayerAllInPreFlop = false;
                                            continue;
                                        }
                                        else {
                                            System.out.println("\nOpponent calls.");
                                            PlayerBetTotal += PlayerBet;
                                            if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                                OpponentBetTotal += PlayerBet;
                                            }
                                            else {
                                                OpponentBetTotal = opponentStack;
                                            }
                                            continue;
                                        }
                                }
                                PlayerBetTotal += PlayerBet + RandomNum2;
                                if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                    System.out.println("Please enter a valid bet.");
                                    System.exit(0);
                                }

                                RandomNum = r.nextInt(10) + 1;
                                if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                    PlayerBetTotal -= PlayerBet;
                                    BuyIn += PlayerBetTotal;
                                    opponentStack -= OpponentBetTotal;
                                    System.out.println("\nOpponent folds. You win!");
                                    System.out.println("You win $" + PlayerBetTotal + "!");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    deckReset++;
                                    continue;
                                }
                                else {
                                    if(opponentStack > OpponentBetTotal + PlayerBet) {
                                        System.out.println("\nOpponent calls.");
                                        OpponentBetTotal += PlayerBet; 
                                    }
                                    else {
                                        OpponentBetTotal = BuyIn;
                                        OpponentAllInPreFlop = true;
                                        
                                        System.out.println("\nOpponent's All In!");
                                        System.out.println("\nChoose an option:");
                                        System.out.println("-------------------");
                                        System.out.println("1: Fold");
                                        System.out.println("2: Call");
                                        input1 = scanner.nextInt();
                                        if(input1 == 1) {
                                            BuyIn -= PlayerBetTotal;
                                            opponentStack += OpponentBetTotal;
                                            System.out.println("\nYou fold. You lose.");
                                            System.out.println("You lost $" + PlayerBetTotal + ".");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            OpponentAllInPreFlop = false;
                                            continue;
                                        }
                                        else if(input1 == 2) {
                                            OpponentBetTotal += RandomNum2;
                                            if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                                PlayerBetTotal += RandomNum2;
                                            }
                                            else {
                                                PlayerBetTotal = BuyIn;
                                            }
                                            continue;
                                        }
                                    }
                                }
                        }
                    }
                
                System.out.println("\n@@@@@@@@@@@@");
                System.out.println("    FLOP");
                System.out.println("@@@@@@@@@@@@");
            }

            str5 = deal();
            str6 = deal();
            str7 = deal();
            
            System.out.println("\n" + str5 + ", " + str6 + ", " + str7);
            
                System.out.println("\nChoose an option:");
                System.out.println("-------------------");
                System.out.println("1: Fold");
                System.out.println("2: Check");
                System.out.println("3: Bet");
            int option2 = scanner.nextInt();
            int PlayerBet2 = 0;
            int OpponentBet2 = 0;
            if(option2 == 1) {
                BuyIn -= PlayerBetTotal;
                opponentStack += OpponentBetTotal;
                System.out.println("\nYou fold. You lose.");
                System.out.println("You lost $" + PlayerBetTotal + ".");
                System.out.println("Your stack is now $" + BuyIn + ".");
                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                deckReset++;
                continue;
            }
            else if(option2 == 2) {
                System.out.println("\nYou check.");
            }
            else if(option2 == 3) {
                PlayerBetRange = BuyIn - PlayerBetTotal;
                System.out.println("How much do you want to bet? (You can bet up to $" + PlayerBetRange + ")");
                PlayerBet2 = scanner.nextInt();
                if(PlayerBet2 + PlayerBetTotal == BuyIn) {
                    PlayerAllInFlop = true;
                    
                    System.out.println("\nYou're All In!");
                        int RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1) {
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                PlayerAllInFlop = false;
                                continue;
                            }
                            else {
                                System.out.println("\nOpponent calls.");
                                PlayerBetTotal += PlayerBet;
                                if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                    OpponentBetTotal += PlayerBet;
                                }
                                else {
                                    OpponentBetTotal = opponentStack;
                                }
                                continue;
                            }
                }
                PlayerBetTotal += PlayerBet2;
                if(PlayerBetTotal > BuyIn || PlayerBet2 <= 0) {
                    System.out.println("Please enter a valid bet.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Please choose a valid option.");
                System.exit(0);
            }
            
            
            if(option2 == 2) {
                int RandomNum = r.nextInt(2) + 1;
                if(RandomNum == 1) {
                    System.out.println("\nOpponent checks back.");
                }
                else if(RandomNum == 2) {
                    int RandomNum2;
                    if(opponentStack > BuyIn) {
                        RandomRange = BuyIn - PlayerBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                    }
                    else {
                        RandomRange = opponentStack - OpponentBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                        if(RandomNum2 == RandomRange) {
                            OpponentAllInFlop = true;
                            System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                            
                            System.out.println("\nOpponent's All In!");
                            System.out.println("\nChoose an option:");
                            System.out.println("-------------------");
                            System.out.println("1: Fold");
                            System.out.println("2: Call");
                            int input1 = scanner.nextInt();
                            if(input1 == 1) {
                                BuyIn -= PlayerBetTotal;
                                opponentStack += OpponentBetTotal;
                                System.out.println("\nYou fold. You lose.");
                                System.out.println("You lost $" + PlayerBetTotal + ".");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                OpponentAllInFlop = false;
                                continue;
                            }
                            else if(input1 == 2) {
                                OpponentBetTotal += RandomNum2;
                                if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                    PlayerBetTotal += RandomNum2;
                                }
                                else {
                                    PlayerBetTotal = BuyIn;
                                }
                                continue;
                            }
                        }
                    }
                    System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                    OpponentBetTotal += RandomNum2;
                    if(BuyIn == PlayerBetTotal + RandomNum2) {
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        int input1 = scanner.nextInt();
                        
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                            System.out.println("\nYou're All In!");
                            PlayerAllInFlop = true;
                            continue;
                        }
                    }
                    System.out.println("\nChoose an option:");
                    System.out.println("-------------------");
                    System.out.println("1: Fold");
                    System.out.println("2: Call");
                    System.out.println("3: Raise");
                    int input1 = scanner.nextInt();
                    if(input1 == 1) {
                        OpponentBetTotal -= RandomNum2;
                        BuyIn -= PlayerBetTotal;
                        opponentStack += OpponentBetTotal;
                        System.out.println("\nYou fold. You lose.");
                        System.out.println("You lost $" + PlayerBetTotal + ".");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if(input1 == 2) {
                        PlayerBetTotal += RandomNum2;
                    }
                    else if(input1 == 3) {
                            int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                            System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                            PlayerBet = scanner.nextInt();
                            if(PlayerBet == PlayerRaise) {
                                PlayerAllInFlop = true;
                                
                                System.out.println("\nYou're All In!");
                                RandomNum = r.nextInt(10) + 1;
                                    if(RandomNum == 1) {
                                        BuyIn += PlayerBetTotal;
                                        opponentStack -= OpponentBetTotal;
                                        System.out.println("\nOpponent folds. You win!");
                                        System.out.println("You win $" + PlayerBetTotal + "!");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        PlayerAllInFlop = false;
                                        continue;
                                    }
                                    else {
                                        System.out.println("\nOpponent calls.");
                                        PlayerBetTotal += PlayerBet;
                                        if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                            OpponentBetTotal += PlayerBet;
                                        }
                                        else {
                                            OpponentBetTotal = opponentStack;
                                        }
                                        continue;
                                    }
                            }
                            PlayerBetTotal += PlayerBet + RandomNum2;
                            if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                System.out.println("Please enter a valid bet.");
                                System.exit(0);
                            }
                            
                            RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                PlayerBetTotal -= PlayerBet;
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                deckReset++;
                                continue;
                            }
                            else {
                                if(opponentStack > OpponentBetTotal + PlayerBet) {
                                   System.out.println("\nOpponent calls.");
                                   OpponentBetTotal += PlayerBet; 
                                }
                                else {
                                    OpponentBetTotal = BuyIn;
                                    OpponentAllInFlop = true;
                                    
                                    System.out.println("\nOpponent's All In!");
                                    System.out.println("\nChoose an option:");
                                    System.out.println("-------------------");
                                    System.out.println("1: Fold");
                                    System.out.println("2: Call");
                                    input1 = scanner.nextInt();
                                    if(input1 == 1) {
                                        BuyIn -= PlayerBetTotal;
                                        opponentStack += OpponentBetTotal;
                                        System.out.println("\nYou fold. You lose.");
                                        System.out.println("You lost $" + PlayerBetTotal + ".");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        OpponentAllInFlop = false;
                                        continue;
                                    }
                                    else if(input1 == 2) {
                                        OpponentBetTotal += RandomNum2;
                                        if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                            PlayerBetTotal += RandomNum2;
                                        }
                                        else {
                                            PlayerBetTotal = BuyIn;
                                        }
                                        continue;
                                    }
                                }
                            }
                    }
                }
                System.out.println("\n@@@@@@@@@@@@");
                System.out.println("    TURN");
                System.out.println("@@@@@@@@@@@@");
            }
            else if(option2 == 3) {
                int RandomNum = r.nextInt(10) + 1;
                    if(RandomNum == 1 || RandomNum == 2) {
                        PlayerBetTotal -= PlayerBet2;
                        BuyIn += PlayerBetTotal;
                        opponentStack -= OpponentBetTotal;
                        System.out.println("\nOpponent folds. You win!");
                        System.out.println("You win $" + PlayerBetTotal + "!");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if (RandomNum == 3 || RandomNum == 4 || RandomNum == 5 || RandomNum == 6 || opponentStack - OpponentBetTotal == PlayerBet2){
                        if(opponentStack - OpponentBetTotal == PlayerBet2) {
                            OpponentAllInFlop = true;
                            System.out.println("\nOpponent's All In!");
                            OpponentBetTotal += PlayerBet2;
                            continue;
                        }
                        System.out.println("\nOpponent calls.");
                        OpponentBetTotal += PlayerBet2;
                    }
                    else {
                        int RandomNum2;
                        if(opponentStack > BuyIn) {
                            RandomNum2 = r.nextInt(BuyIn - 1 - PlayerBetTotal) + 1;
                        }
                        else {
                            RandomNum2 = r.nextInt(opponentStack - OpponentBetTotal - PlayerBet2) + 1;
                            if(RandomNum2 == opponentStack - OpponentBetTotal - PlayerBet2) {
                                OpponentAllInFlop = true;
                                System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                                
                                System.out.println("\nOpponent's All In!");
                                System.out.println("\nChoose an option:");
                                System.out.println("-------------------");
                                System.out.println("1: Fold");
                                System.out.println("2: Call");
                                int input1 = scanner.nextInt();
                                if(input1 == 1) {
                                    BuyIn -= PlayerBetTotal;
                                    OpponentBetTotal += PlayerBet2;
                                    opponentStack += OpponentBetTotal;
                                    System.out.println("\nYou fold. You lose.");
                                    System.out.println("You lost $" + PlayerBetTotal + ".");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    OpponentAllInFlop = false;
                                    continue;
                                }
                                else if(input1 == 2) {
                                    OpponentBetTotal += RandomNum2 + PlayerBet2;
                                    if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                        PlayerBetTotal += RandomNum2;
                                    }
                                    else {
                                        PlayerBetTotal = BuyIn;
                                    }
                                    continue;
                                }
                            }
                        }
                        System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                        OpponentBetTotal += RandomNum2 + PlayerBet2;
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        System.out.println("3: Raise");
                        int input1 = scanner.nextInt();
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                        }
                        else if(input1 == 3) {
                                int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                                System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                                PlayerBet = scanner.nextInt();
                                if(PlayerBet == PlayerRaise) {
                                    PlayerAllInFlop = true;
                                    
                                    System.out.println("\nYou're All In!");
                                    RandomNum = r.nextInt(10) + 1;
                                        if(RandomNum == 1) {
                                            BuyIn += PlayerBetTotal;
                                            opponentStack -= OpponentBetTotal;
                                            System.out.println("\nOpponent folds. You win!");
                                            System.out.println("You win $" + PlayerBetTotal + "!");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            PlayerAllInFlop = false;
                                            continue;
                                        }
                                        else {
                                            System.out.println("\nOpponent calls.");
                                            PlayerBetTotal += PlayerBet;
                                            if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                                OpponentBetTotal += PlayerBet;
                                            }
                                            else {
                                                OpponentBetTotal = opponentStack;
                                            }
                                            continue;
                                        }
                                }
                                PlayerBetTotal += PlayerBet + RandomNum2;
                                if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                    System.out.println("Please enter a valid bet.");
                                    System.exit(0);
                                }

                                RandomNum = r.nextInt(10) + 1;
                                if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                    PlayerBetTotal -= PlayerBet;
                                    BuyIn += PlayerBetTotal;
                                    opponentStack -= OpponentBetTotal;
                                    System.out.println("\nOpponent folds. You win!");
                                    System.out.println("You win $" + PlayerBetTotal + "!");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    deckReset++;
                                    continue;
                                }
                                else {
                                    if(opponentStack > OpponentBetTotal + PlayerBet) {
                                        System.out.println("\nOpponent calls.");
                                        OpponentBetTotal += PlayerBet; 
                                    }
                                    else {
                                        OpponentBetTotal = BuyIn;
                                        OpponentAllInFlop = true;
                                        
                                        System.out.println("\nOpponent's All In!");
                                        System.out.println("\nChoose an option:");
                                        System.out.println("-------------------");
                                        System.out.println("1: Fold");
                                        System.out.println("2: Call");
                                        input1 = scanner.nextInt();
                                        if(input1 == 1) {
                                            BuyIn -= PlayerBetTotal;
                                            opponentStack += OpponentBetTotal;
                                            System.out.println("\nYou fold. You lose.");
                                            System.out.println("You lost $" + PlayerBetTotal + ".");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            OpponentAllInFlop = false;
                                            continue;
                                        }
                                        else if(input1 == 2) {
                                            OpponentBetTotal += RandomNum2;
                                            if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                                PlayerBetTotal += RandomNum2;
                                            }
                                            else {
                                                PlayerBetTotal = BuyIn;
                                            }
                                            continue;
                                        }
                                    }
                                }
                        }
                    }
                
                System.out.println("\n@@@@@@@@@@@@");
                System.out.println("    TURN");
                System.out.println("@@@@@@@@@@@@");
            }
            
            str8 = deal();
            
            System.out.println("\n" + str5 + ", " + str6 + ", " + str7 + ", " + str8);
            
            System.out.println("\nChoose an option:");
            System.out.println("-------------------");
            System.out.println("1: Fold");
            System.out.println("2: Check");
            System.out.println("3: Bet");
            int option3 = scanner.nextInt();
            int PlayerBet3 = 0;
            int OpponentBet3 = 0;
            if(option3 == 1) {
                BuyIn -= PlayerBetTotal;
                opponentStack += OpponentBetTotal;
                System.out.println("\nYou fold. You lose.");
                System.out.println("You lost $" + PlayerBetTotal + ".");
                System.out.println("Your stack is now $" + BuyIn + ".");
                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                deckReset++;
                continue;
            }
            else if(option3 == 2) {
                System.out.println("\nYou check.");
            }
            else if(option3 == 3) {
                PlayerBetRange = BuyIn - PlayerBetTotal;
                System.out.println("How much do you want to bet? (You can bet up to $" + PlayerBetRange + ")");
                PlayerBet3 = scanner.nextInt();
                if(PlayerBet3 == PlayerBetRange) {
                    PlayerAllInTurn = true;
                    
                    System.out.println("\nYou're All In!");
                        int RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1) {
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                PlayerAllInTurn = false;
                                continue;
                            }
                            else {
                                System.out.println("\nOpponent calls.");
                                PlayerBetTotal += PlayerBet;
                                if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                    OpponentBetTotal += PlayerBet;
                                }
                                else {
                                    OpponentBetTotal = opponentStack;
                                }
                                continue;
                            }
                }
                PlayerBetTotal += PlayerBet3;
                if(PlayerBetTotal > BuyIn || PlayerBet3 <= 0) {
                    System.out.println("Please enter a valid bet.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Please choose a valid option.");
                System.exit(0);
            }
            
            
            if(option3 == 2) {
                int RandomNum = r.nextInt(2) + 1;
                if(RandomNum == 1) {
                    System.out.println("\nOpponent checks back.");
                }
                else if(RandomNum == 2) {
                    int RandomNum2;
                    if(opponentStack > BuyIn) {
                        RandomRange = BuyIn - PlayerBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                    }
                    else {
                        RandomRange = opponentStack - OpponentBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                        if(RandomNum2 == RandomRange) {
                            OpponentAllInTurn = true;
                            System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                            
                            System.out.println("\nOpponent's All In!");
                            System.out.println("\nChoose an option:");
                            System.out.println("-------------------");
                            System.out.println("1: Fold");
                            System.out.println("2: Call");
                            int input1 = scanner.nextInt();
                            if(input1 == 1) {
                                BuyIn -= PlayerBetTotal;
                                opponentStack += OpponentBetTotal;
                                System.out.println("\nYou fold. You lose.");
                                System.out.println("You lost $" + PlayerBetTotal + ".");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                OpponentAllInTurn = false;
                                continue;
                            }
                            else if(input1 == 2) {
                                OpponentBetTotal += RandomNum2;
                                if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                    PlayerBetTotal += RandomNum2;
                                }
                                else {
                                    PlayerBetTotal = BuyIn;
                                }
                                continue;
                            }
                        }
                    }
                    System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                    OpponentBetTotal += RandomNum2;
                    if(BuyIn == PlayerBetTotal + RandomNum2) {
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        int input1 = scanner.nextInt();
                        
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                            System.out.println("\nYou're All In!");
                            PlayerAllInTurn = true;
                            continue;
                        }
                    }
                    System.out.println("\nChoose an option:");
                    System.out.println("-------------------");
                    System.out.println("1: Fold");
                    System.out.println("2: Call");
                    System.out.println("3: Raise");
                    int input1 = scanner.nextInt();
                    if(input1 == 1) {
                        OpponentBetTotal -= RandomNum2;
                        BuyIn -= PlayerBetTotal;
                        opponentStack += OpponentBetTotal;
                        System.out.println("\nYou fold. You lose.");
                        System.out.println("You lost $" + PlayerBetTotal + ".");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if(input1 == 2) {
                        PlayerBetTotal += RandomNum2;
                    }
                    else if(input1 == 3) {
                            int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                            System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                            PlayerBet = scanner.nextInt();
                            if(PlayerBet == PlayerRaise) {
                                PlayerAllInTurn = true;
                                
                                System.out.println("\nYou're All In!");
                                RandomNum = r.nextInt(10) + 1;
                                    if(RandomNum == 1) {
                                        BuyIn += PlayerBetTotal;
                                        opponentStack -= OpponentBetTotal;
                                        System.out.println("\nOpponent folds. You win!");
                                        System.out.println("You win $" + PlayerBetTotal + "!");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        PlayerAllInTurn = false;
                                        continue;
                                    }
                                    else {
                                        System.out.println("\nOpponent calls.");
                                        PlayerBetTotal += PlayerBet;
                                        if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                            OpponentBetTotal += PlayerBet;
                                        }
                                        else {
                                            OpponentBetTotal = opponentStack;
                                        }
                                        continue;
                                    }
                            }
                            PlayerBetTotal += PlayerBet + RandomNum2;
                            if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                System.out.println("Please enter a valid bet.");
                                System.exit(0);
                            }
                            
                            RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                PlayerBetTotal -= PlayerBet;
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                deckReset++;
                                continue;
                            }
                            else {
                                if(opponentStack > OpponentBetTotal + PlayerBet) {
                                   System.out.println("\nOpponent calls.");
                                   OpponentBetTotal += PlayerBet; 
                                }
                                else {
                                    OpponentBetTotal = BuyIn;
                                    OpponentAllInTurn = true;
                                    
                                    System.out.println("\nOpponent's All In!");
                                    System.out.println("\nChoose an option:");
                                    System.out.println("-------------------");
                                    System.out.println("1: Fold");
                                    System.out.println("2: Call");
                                    input1 = scanner.nextInt();
                                    if(input1 == 1) {
                                        BuyIn -= PlayerBetTotal;
                                        opponentStack += OpponentBetTotal;
                                        System.out.println("\nYou fold. You lose.");
                                        System.out.println("You lost $" + PlayerBetTotal + ".");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        OpponentAllInTurn = false;
                                        continue;
                                    }
                                    else if(input1 == 2) {
                                        OpponentBetTotal += RandomNum2;
                                        if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                            PlayerBetTotal += RandomNum2;
                                        }
                                        else {
                                            PlayerBetTotal = BuyIn;
                                        }
                                        continue;
                                    }
                                }
                            }
                    }
                }

                System.out.println("\n@@@@@@@@@@@@@");
                System.out.println("    RIVER");
                System.out.println("@@@@@@@@@@@@@");
            }
            else if(option3 == 3) {
                int RandomNum = r.nextInt(10) + 1;
                    if(RandomNum == 1 || RandomNum == 2) {
                        PlayerBetTotal -= PlayerBet3;
                        BuyIn += PlayerBetTotal;
                        opponentStack -= OpponentBetTotal;
                        System.out.println("\nOpponent folds. You win!");
                        System.out.println("You win $" + PlayerBetTotal + "!");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if (RandomNum == 3 || RandomNum == 4 || RandomNum == 5 || RandomNum == 6 || opponentStack - OpponentBetTotal == PlayerBet3){
                        if(opponentStack - OpponentBetTotal == PlayerBet3) {
                            OpponentAllInTurn = true;
                            System.out.println("\nOpponent's All In!");
                            OpponentBetTotal += PlayerBet3;
                            continue;
                        }
                        System.out.println("\nOpponent calls.");
                        OpponentBetTotal += PlayerBet3;
                    }
                    else {
                        int RandomNum2;
                        if(opponentStack > BuyIn) {
                            RandomNum2 = r.nextInt(BuyIn - 1 - PlayerBetTotal) + 1;
                        }
                        else {
                            RandomNum2 = r.nextInt(opponentStack - OpponentBetTotal - PlayerBet3) + 1;
                            if(RandomNum2 == opponentStack - OpponentBetTotal - PlayerBet3) {
                                OpponentAllInTurn = true;
                                System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                                
                                System.out.println("\nOpponent's All In!");
                                System.out.println("\nChoose an option:");
                                System.out.println("-------------------");
                                System.out.println("1: Fold");
                                System.out.println("2: Call");
                                int input1 = scanner.nextInt();
                                if(input1 == 1) {
                                    BuyIn -= PlayerBetTotal;
                                    OpponentBetTotal += PlayerBet3;
                                    opponentStack += OpponentBetTotal;
                                    System.out.println("\nYou fold. You lose.");
                                    System.out.println("You lost $" + PlayerBetTotal + ".");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    OpponentAllInTurn = false;
                                    continue;
                                }
                                else if(input1 == 2) {
                                    OpponentBetTotal += RandomNum2 + PlayerBet3;
                                    if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                        PlayerBetTotal += RandomNum2;
                                    }
                                    else {
                                        PlayerBetTotal = BuyIn;
                                    }
                                    continue;
                                }
                            }
                        }
                        System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                        OpponentBetTotal += RandomNum2 + PlayerBet3;
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        System.out.println("3: Raise");
                        int input1 = scanner.nextInt();
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                        }
                        else if(input1 == 3) {
                                int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                                System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                                PlayerBet = scanner.nextInt();
                                if(PlayerBet == PlayerRaise) {
                                    PlayerAllInTurn = true;
                                    
                                    System.out.println("\nYou're All In!");
                                    RandomNum = r.nextInt(10) + 1;
                                        if(RandomNum == 1) {
                                            BuyIn += PlayerBetTotal;
                                            opponentStack -= OpponentBetTotal;
                                            System.out.println("\nOpponent folds. You win!");
                                            System.out.println("You win $" + PlayerBetTotal + "!");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            PlayerAllInTurn = false;
                                            continue;
                                        }
                                        else {
                                            System.out.println("\nOpponent calls.");
                                            PlayerBetTotal += PlayerBet;
                                            if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                                OpponentBetTotal += PlayerBet;
                                            }
                                            else {
                                                OpponentBetTotal = opponentStack;
                                            }
                                            continue;
                                        }
                                }
                                PlayerBetTotal += PlayerBet + RandomNum2;
                                if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                    System.out.println("Please enter a valid bet.");
                                    System.exit(0);
                                }

                                RandomNum = r.nextInt(10) + 1;
                                if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                    PlayerBetTotal -= PlayerBet;
                                    BuyIn += PlayerBetTotal;
                                    opponentStack -= OpponentBetTotal;
                                    System.out.println("\nOpponent folds. You win!");
                                    System.out.println("You win $" + PlayerBetTotal + "!");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    deckReset++;
                                    continue;
                                }
                                else {
                                    if(opponentStack > OpponentBetTotal + PlayerBet) {
                                        System.out.println("\nOpponent calls.");
                                        OpponentBetTotal += PlayerBet; 
                                    }
                                    else {
                                        OpponentBetTotal = BuyIn;
                                        OpponentAllInTurn = true;
                                        
                                        System.out.println("\nOpponent's All In!");
                                        System.out.println("\nChoose an option:");
                                        System.out.println("-------------------");
                                        System.out.println("1: Fold");
                                        System.out.println("2: Call");
                                        input1 = scanner.nextInt();
                                        if(input1 == 1) {
                                            BuyIn -= PlayerBetTotal;
                                            opponentStack += OpponentBetTotal;
                                            System.out.println("\nYou fold. You lose.");
                                            System.out.println("You lost $" + PlayerBetTotal + ".");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            OpponentAllInTurn = false;
                                            continue;
                                        }
                                        else if(input1 == 2) {
                                            OpponentBetTotal += RandomNum2;
                                            if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                                PlayerBetTotal += RandomNum2;
                                            }
                                            else {
                                                PlayerBetTotal = BuyIn;
                                            }
                                            continue;
                                        }
                                    }
                                }
                        }
                    }
                
                System.out.println("\n@@@@@@@@@@@@@");
                System.out.println("    RIVER");
                System.out.println("@@@@@@@@@@@@@");
            }
            
            str9 = deal();
            
            System.out.println("\n" + str5 + ", " + str6 + ", " + str7 + ", " + str8 + ", " + str9);
            
            System.out.println("\nChoose an option:");
            System.out.println("-------------------");
            System.out.println("1: Fold");
            System.out.println("2: Check");
            System.out.println("3: Bet");
            int option4 = scanner.nextInt();
            int PlayerBet4 = 0;
            int OpponentBet4 = 0;
            if(option4 == 1) {
                BuyIn -= PlayerBetTotal;
                opponentStack += OpponentBetTotal;
                System.out.println("\nYou fold. You lose.");
                System.out.println("You lost $" + PlayerBetTotal + ".");
                System.out.println("Your stack is now $" + BuyIn + ".");
                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                deckReset++;
                continue;
            }
            else if(option4 == 2) {
                System.out.println("\nYou check.");
            }
            else if(option4 == 3) {
                PlayerBetRange = BuyIn - PlayerBetTotal;
                System.out.println("How much do you want to bet? (You can bet up to $" + PlayerBetRange + ")");
                PlayerBet4 = scanner.nextInt();
                if(PlayerBet4 == PlayerBetRange) {
                    PlayerAllInRiver = true;
                    
                    System.out.println("\nYou're All In!");
                        int RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1) {
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                PlayerAllInRiver = false;
                                continue;
                            }
                            else {
                                System.out.println("\nOpponent calls.");
                                PlayerBetTotal += PlayerBet;
                                if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                    OpponentBetTotal += PlayerBet;
                                }
                                else {
                                    OpponentBetTotal = opponentStack;
                                }
                                continue;
                            }
                }
                PlayerBetTotal += PlayerBet4;
                if(PlayerBetTotal > BuyIn || PlayerBet4 <= 0) {
                    System.out.println("Please enter a valid bet.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Please choose a valid option.");
                System.exit(0);
            }
            
            
            if(option4 == 2) {
                int RandomNum = r.nextInt(2) + 1;
                if(RandomNum == 1) {
                    System.out.println("\nOpponent checks back.");
                }
                else if(RandomNum == 2) {
                    int RandomNum2;
                    if(opponentStack > BuyIn) {
                        RandomRange = BuyIn - PlayerBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                    }
                    else {
                        RandomRange = opponentStack - OpponentBetTotal;
                        RandomNum2 = r.nextInt(RandomRange) + 1;
                        if(RandomNum2 == RandomRange) {
                            OpponentAllInRiver = true;
                            System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                            
                            System.out.println("\nOpponent's All In!");
                            System.out.println("\nChoose an option:");
                            System.out.println("-------------------");
                            System.out.println("1: Fold");
                            System.out.println("2: Call");
                            int input1 = scanner.nextInt();
                            if(input1 == 1) {
                                BuyIn -= PlayerBetTotal;
                                opponentStack += OpponentBetTotal;
                                System.out.println("\nYou fold. You lose.");
                                System.out.println("You lost $" + PlayerBetTotal + ".");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                OpponentAllInRiver = false;
                                continue;
                            }
                            else if(input1 == 2) {
                                OpponentBetTotal += RandomNum2;
                                if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                    PlayerBetTotal += RandomNum2;
                                }
                                else {
                                    PlayerBetTotal = BuyIn;
                                }
                                continue;
                            }
                        }
                    }
                    System.out.println("\nOpponent bets $" + RandomNum2 + ".");
                    OpponentBetTotal += RandomNum2;
                    if(BuyIn == PlayerBetTotal + RandomNum2) {
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        int input1 = scanner.nextInt();
                        
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                            System.out.println("\nYou're All In!");
                            PlayerAllInRiver = true;
                            continue;
                        }
                    }
                    System.out.println("\nChoose an option:");
                    System.out.println("-------------------");
                    System.out.println("1: Fold");
                    System.out.println("2: Call");
                    System.out.println("3: Raise");
                    int input1 = scanner.nextInt();
                    if(input1 == 1) {
                        OpponentBetTotal -= RandomNum2;
                        BuyIn -= PlayerBetTotal;
                        opponentStack += OpponentBetTotal;
                        System.out.println("\nYou fold. You lose.");
                        System.out.println("You lost $" + PlayerBetTotal + ".");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if(input1 == 2) {
                        PlayerBetTotal += RandomNum2;
                    }
                    else if(input1 == 3) {
                            int PlayerRaise = BuyIn - PlayerBetTotal - RandomNum2;
                            System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                            PlayerBet = scanner.nextInt();
                            if(PlayerBet == PlayerRaise) {
                                PlayerAllInRiver = true;
                                
                                System.out.println("\nYou're All In!");
                                RandomNum = r.nextInt(10) + 1;
                                    if(RandomNum == 1) {
                                        BuyIn += PlayerBetTotal;
                                        opponentStack -= OpponentBetTotal;
                                        System.out.println("\nOpponent folds. You win!");
                                        System.out.println("You win $" + PlayerBetTotal + "!");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        PlayerAllInRiver = false;
                                        continue;
                                    }
                                    else {
                                        System.out.println("\nOpponent calls.");
                                        PlayerBetTotal += PlayerBet;
                                        if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                            OpponentBetTotal += PlayerBet;
                                        }
                                        else {
                                            OpponentBetTotal = opponentStack;
                                        }
                                        continue;
                                    }
                            }
                            PlayerBetTotal += PlayerBet + RandomNum2;
                            if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                System.out.println("Please enter a valid bet.");
                                System.exit(0);
                            }
                            
                            RandomNum = r.nextInt(10) + 1;
                            if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                PlayerBetTotal -= PlayerBet;
                                BuyIn += PlayerBetTotal;
                                opponentStack -= OpponentBetTotal;
                                System.out.println("\nOpponent folds. You win!");
                                System.out.println("You win $" + PlayerBetTotal + "!");
                                System.out.println("Your stack is now $" + BuyIn + ".");
                                System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                deckReset++;
                                continue;
                            }
                            else {
                                if(opponentStack > OpponentBetTotal + PlayerBet) {
                                   System.out.println("\nOpponent calls.");
                                   OpponentBetTotal += PlayerBet; 
                                }
                                else {
                                    OpponentBetTotal = BuyIn;
                                    OpponentAllInRiver = true;
                                    
                                    System.out.println("\nOpponent's All In!");
                                    System.out.println("\nChoose an option:");
                                    System.out.println("-------------------");
                                    System.out.println("1: Fold");
                                    System.out.println("2: Call");
                                    input1 = scanner.nextInt();
                                    if(input1 == 1) {
                                        BuyIn -= PlayerBetTotal;
                                        opponentStack += OpponentBetTotal;
                                        System.out.println("\nYou fold. You lose.");
                                        System.out.println("You lost $" + PlayerBetTotal + ".");
                                        System.out.println("Your stack is now $" + BuyIn + ".");
                                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                        OpponentAllInRiver = false;
                                        continue;
                                    }
                                    else if(input1 == 2) {
                                        OpponentBetTotal += RandomNum2;
                                        if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                            PlayerBetTotal += RandomNum2;
                                        }
                                        else {
                                            PlayerBetTotal = BuyIn;
                                        }
                                        continue;
                                    }
                                }
                            }
                    }
                }
            }
            else if(option4 == 3) {
                int RandomNum = r.nextInt(10) + 1;
                    if(RandomNum == 1 || RandomNum == 2) {
                        PlayerBetTotal -= PlayerBet4;
                        BuyIn += PlayerBetTotal;
                        opponentStack -= OpponentBetTotal;
                        System.out.println("\nOpponent folds. You win!");
                        System.out.println("You win $" + PlayerBetTotal + "!");
                        System.out.println("Your stack is now $" + BuyIn + ".");
                        System.out.println("Opponent's stack is now $" + opponentStack + ".");
                        deckReset++;
                        continue;
                    }
                    else if (RandomNum == 3 || RandomNum == 4 || RandomNum == 5 || RandomNum == 6 || opponentStack - OpponentBetTotal == PlayerBet4){
                        if(opponentStack - OpponentBetTotal == PlayerBet4) {
                            OpponentAllInRiver = true;
                            System.out.println("\nOpponent's All In!");
                            OpponentBetTotal += PlayerBet4;
                            continue;
                        }
                        System.out.println("\nOpponent calls.");
                        OpponentBetTotal += PlayerBet4;
                    }
                    else {
                        int RandomNum2;
                        if(opponentStack > BuyIn) {
                            RandomNum2 = r.nextInt(BuyIn - 1 - PlayerBetTotal) + 1;
                        }
                        else {
                            RandomNum2 = r.nextInt(opponentStack - OpponentBetTotal - PlayerBet4) + 1;
                            if(RandomNum2 == opponentStack - OpponentBetTotal - PlayerBet4) {
                                OpponentAllInRiver = true;
                                System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                                
                                System.out.println("\nOpponent's All In!");
                                System.out.println("\nChoose an option:");
                                System.out.println("-------------------");
                                System.out.println("1: Fold");
                                System.out.println("2: Call");
                                int input1 = scanner.nextInt();
                                if(input1 == 1) {
                                    BuyIn -= PlayerBetTotal;
                                    OpponentBetTotal += PlayerBet4;
                                    opponentStack += OpponentBetTotal;
                                    System.out.println("\nYou fold. You lose.");
                                    System.out.println("You lost $" + PlayerBetTotal + ".");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    OpponentAllInRiver = false;
                                    continue;
                                }
                                else if(input1 == 2) {
                                    OpponentBetTotal += RandomNum2 + PlayerBet4;
                                    if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                        PlayerBetTotal += RandomNum2;
                                    }
                                    else {
                                        PlayerBetTotal = BuyIn;
                                    }
                                    continue;
                                }
                            }
                        }
                        System.out.println("\nOpponent raises by $" + RandomNum2 + ".");
                        OpponentBetTotal += RandomNum2 + PlayerBet4;
                        System.out.println("\nChoose an option:");
                        System.out.println("-------------------");
                        System.out.println("1: Fold");
                        System.out.println("2: Call");
                        System.out.println("3: Raise");
                        int input1 = scanner.nextInt();
                        if(input1 == 1) {
                            OpponentBetTotal -= RandomNum2;
                            BuyIn -= PlayerBetTotal;
                            opponentStack += OpponentBetTotal;
                            System.out.println("\nYou fold. You lose.");
                            System.out.println("You lost $" + PlayerBetTotal + ".");
                            System.out.println("Your stack is now $" + BuyIn + ".");
                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                            deckReset++;
                            continue;
                        }
                        else if(input1 == 2) {
                            PlayerBetTotal += RandomNum2;
                        }
                        else if(input1 == 3) {
                                int PlayerRaise = BuyIn - PlayerBetTotal;
                                System.out.println("How much do you want to raise? (You can raise up to $" + PlayerRaise + ")");
                                PlayerBet = scanner.nextInt();
                                if(PlayerBet == PlayerRaise) {
                                    PlayerAllInRiver = true;
                                    
                                    System.out.println("\nYou're All In!");
                                    RandomNum = r.nextInt(10) + 1;
                                        if(RandomNum == 1) {
                                            BuyIn += PlayerBetTotal;
                                            opponentStack -= OpponentBetTotal;
                                            System.out.println("\nOpponent folds. You win!");
                                            System.out.println("You win $" + PlayerBetTotal + "!");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            PlayerAllInRiver = false;
                                            continue;
                                        }
                                        else {
                                            System.out.println("\nOpponent calls.");
                                            PlayerBetTotal += PlayerBet;
                                            if(opponentStack - OpponentBetTotal >= PlayerBet) {
                                                OpponentBetTotal += PlayerBet;
                                            }
                                            else {
                                                OpponentBetTotal = opponentStack;
                                            }
                                            continue;
                                        }
                                }
                                PlayerBetTotal += PlayerBet + RandomNum2;
                                if(PlayerBetTotal > BuyIn || PlayerBet <= 0) {
                                    System.out.println("Please enter a valid bet.");
                                    System.exit(0);
                                }

                                RandomNum = r.nextInt(10) + 1;
                                if(RandomNum == 1 || RandomNum == 2 || RandomNum == 3) {
                                    PlayerBetTotal -= PlayerBet;
                                    BuyIn += PlayerBetTotal;
                                    opponentStack -= OpponentBetTotal;
                                    System.out.println("\nOpponent folds. You win!");
                                    System.out.println("You win $" + PlayerBetTotal + "!");
                                    System.out.println("Your stack is now $" + BuyIn + ".");
                                    System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                    deckReset++;
                                    continue;
                                }
                                else {
                                    if(opponentStack > OpponentBetTotal + PlayerBet) {
                                        System.out.println("\nOpponent calls.");
                                        OpponentBetTotal += PlayerBet; 
                                    }
                                    else {
                                        OpponentBetTotal = BuyIn;
                                        OpponentAllInRiver = true;
                                        
                                        System.out.println("\nOpponent's All In!");
                                        System.out.println("\nChoose an option:");
                                        System.out.println("-------------------");
                                        System.out.println("1: Fold");
                                        System.out.println("2: Call");
                                        input1 = scanner.nextInt();
                                        if(input1 == 1) {
                                            BuyIn -= PlayerBetTotal;
                                            opponentStack += OpponentBetTotal;
                                            System.out.println("\nYou fold. You lose.");
                                            System.out.println("You lost $" + PlayerBetTotal + ".");
                                            System.out.println("Your stack is now $" + BuyIn + ".");
                                            System.out.println("Opponent's stack is now $" + opponentStack + ".");
                                            OpponentAllInRiver = false;
                                            continue;
                                        }
                                        else if(input1 == 2) {
                                            OpponentBetTotal += RandomNum2;
                                            if(BuyIn - PlayerBetTotal >= RandomNum2) {
                                                PlayerBetTotal += RandomNum2;
                                            }
                                            else {
                                                PlayerBetTotal = BuyIn;
                                            }
                                            continue;
                                        }
                                    }
                                }
                        }
                    }
            }
            //calls showdown method, which ends the game
            Showdown(str1, str2, str3, str4, str5, str6, str7, str8, str9, BuyIn, PlayerBetTotal, opponentStack, OpponentBetTotal);
            

        }
        
    }
    
    //END OF MAIN METHOD /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    
    //dealing cards method
    static String deal() {
        if(deckReset == 1) {
            cards = new ArrayList<>(deckChanger);
            deckReset = 0;
        }
        Random random1 = new Random();
        int x = random1.nextInt(cards.size());
        //stores the selected card as another string before removing it from the deck
        String str = String.valueOf(cards.get(x));
        //removes card from deck
        cards.remove(x);
        counter++;
        //return the selected card
        return str;
        
        }
    
    static String SuitChecker(String str) {
        String j = "J";
        String q = "Q";
        String k = "K";
        String a = "A";
        
        if(!str.replace(" hearts", "").equals(str)) {
            String str1change = str.replace("hearts", "").trim();
            try{
            FlushHigh = Integer.parseInt(str1change);
            }
            catch(NumberFormatException e) {
                if(str1change.equals(j)) {
                    FlushHigh = 11;
                }
                else if(str1change.equals(q)) {
                    FlushHigh = 12;
                }
                else if(str1change.equals(k)) {
                    FlushHigh = 13;
                }
                else if(str1change.equals(a)) {
                    FlushHigh = 14;
                }
            }
            return "H";
        }
        else if(!str.replace(" diamonds", "").equals(str)) {
            String str2change = str.replace("diamonds", "").trim();
            try{
            FlushHigh = Integer.parseInt(str2change);
            }
            catch(NumberFormatException e) {
                if(str2change.equals(j)) {
                    FlushHigh = 11;
                }
                else if(str2change.equals(q)) {
                    FlushHigh = 12;
                }
                else if(str2change.equals(k)) {
                    FlushHigh = 13;
                }
                else if(str2change.equals(a)) {
                    FlushHigh = 14;
                }
            }
            return "D";
        }
        else if(!str.replace(" spades", "").equals(str)) {
            String str3change = str.replace("spades", "").trim();
            try{
            FlushHigh = Integer.parseInt(str3change);
            }
            catch(NumberFormatException e) {
                if(str3change.equals(j)) {
                    FlushHigh = 11;
                }
                else if(str3change.equals(q)) {
                    FlushHigh = 12;
                }
                else if(str3change.equals(k)) {
                    FlushHigh = 13;
                }
                else if(str3change.equals(a)) {
                    FlushHigh = 14;
                }
            }
            return "S";
        }
        else {
            String str4change = str.replace("clubs", "").trim();
            try{
            FlushHigh = Integer.parseInt(str4change);
            }
            catch(NumberFormatException e) {
                if(str4change.equals(j)) {
                    FlushHigh = 11;
                }
                else if(str4change.equals(q)) {
                    FlushHigh = 12;
                }
                else if(str4change.equals(k)) {
                    FlushHigh = 13;
                }
                else if(str4change.equals(a)) {
                    FlushHigh = 14;
                }
            }
            return "C";
        }
        
    }
    
    static void PlayersuitCounter (String str) {
        String h = "H";
        String d = "D";
        String s = "S";
        String c = "C";
        if(str.equals(h)) {
                PlayerHearts++;
                if(FlushHigh > PlayerFlushHighHeart) {
                    PlayerFlushHighHeart = FlushHigh;
                }
            }
            else if(str.equals(d)) {
                PlayerDiamonds++;
                if(FlushHigh > PlayerFlushHighDiamond) {
                    PlayerFlushHighDiamond = FlushHigh;
                }
            }
            else if(str.equals(s)) {
                PlayerSpades++;
                if(FlushHigh > PlayerFlushHighSpade) {
                    PlayerFlushHighSpade = FlushHigh;
                }
            }
            else if(str.equals(c)) {
                PlayerClubs++;
                if(FlushHigh > PlayerFlushHighClub) {
                    PlayerFlushHighClub = FlushHigh;
                }
            }
    }
    
    static void OpponentsuitCounter (String str) {
        String h = "H";
        String d = "D";
        String s = "S";
        String c = "C";
            
        if(str.equals(h)) {
                OpponentHearts++;
                if(FlushHigh > OpponentFlushHighHeart) {
                    OpponentFlushHighHeart = FlushHigh;
                }
            }
            else if(str.equals(d)) {
                OpponentDiamonds++;
                if(FlushHigh > OpponentFlushHighDiamond) {
                    OpponentFlushHighDiamond = FlushHigh;
                }
            }
            else if(str.equals(s)) {
                OpponentSpades++;
                if(FlushHigh > OpponentFlushHighSpade) {
                    OpponentFlushHighSpade = FlushHigh;
                }
            }
            else if(str.equals(c)) {
                OpponentClubs++;
                if(FlushHigh > OpponentFlushHighClub) {
                    OpponentFlushHighClub = FlushHigh;
                }
            }
    }
    
    static int NumConverter(String str) {
        str = str.replace(" hearts", ""); 
        str = str.replace(" diamonds", "");
        str = str.replace(" spades", "");
        str = str.replace(" clubs", "");
        String j = "J";
        String q = "Q";
        String k = "K";
        String a = "A";
        int num = 0;
        
        try {
            num = Integer.parseInt(str);
            return num;
        }
        catch(NumberFormatException e) {
            if(str.equals(j)) {
                return 11;
            }
            else if(str.equals(q)) {
                return 12;
            }
            else if(str.equals(k)) {
                return 13;
            }
            else if(str.equals(a)) {
                return 14;
            }
        }
        return -1;
    }
    
    static boolean Straight(int one, int two, int three, int four, int five) {
        int[] nums = {one, two, three, four, five};
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] - nums[i] != 1) {
                if(nums[4] != 14) {
                    return false;
                }
                else {
                    nums[4] = 1;
                    Arrays.sort(nums);
                    for(i = 0; i < nums.length - 1; i++) {
                        if(nums[i + 1] - nums[i] != 1) {
                            return false;
                        }
                    }
                }
            }
        }
        Arrays.sort(nums);
        StraightHigh = nums[4];
        return true;
    }
    
    static boolean StraightChecker(int one, int two, int three, int four, int five, int six, int seven) {
        if(Straight(one, two, three, four, five)) {
            return true;
        }
        else if(Straight(one, two, three, four, six)) {
            return true;
        }
        else if(Straight(one, two, three, four, six)) {
            return true;
        }
        else if(Straight(one, two, three, four, seven)) {
            return true;
        }
        else if(Straight(one, two, three, five, six)) {
            return true;
        }
        else if(Straight(one, two, three, five, seven)) {
            return true;
        }
        else if(Straight(one, two, three, six, seven)) {
            return true;
        }
        else if(Straight(one, two, four, five, six)) {
            return true;
        }
        else if(Straight(one, two, four, five, seven)) {
            return true;
        }
        else if(Straight(one, two, four, six, seven)) {
            return true;
        }
        else if(Straight(one, two, five, six, seven)) {
            return true;
        }
        else if(Straight(one, three, four, five, six)) {
            return true;
        }
        else if(Straight(one, three, four, five, seven)) {
            return true;
        }
        else if(Straight(one, three, four, six, seven)) {
            return true;
        }
        else if(Straight(one, three, five, six, seven)) {
            return true;
        }
        else if(Straight(one, four, five, six, seven)) {
            return true;
        }
        else if(Straight(two, three, four, five, six)) {
            return true;
        }
        else if(Straight(two, three, four, six, seven)) {
            return true;
        }
        else if(Straight(two, three, five, six, seven)) {
            return true;
        }
        else if(Straight(two, four, five, six, seven)) {
            return true;
        }
        else if(Straight(three, four, five, six, seven)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    static String SuitChecker2(String str) {
        if(!str.replace(" hearts", "").equals(str)) {
            return "heart";
        }
        else if(!str.replace(" diamonds", "").equals(str)) {
            return "diamond";
        }
        else if(!str.replace(" spades", "").equals(str)) {
            return "spade";
        }
        else if(!str.replace(" clubs", "").equals(str)) {
            return "club";
        }
        else {
            return "";
        }
    }
    
    static boolean PlayerStraightFlush(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        if(PlayerStraight && PlayerFlush) {
            int[] nums = {NumConverter(str1), NumConverter(str2), NumConverter(str3), NumConverter(str4), NumConverter(str5), NumConverter(str6), NumConverter(str7)};
            Arrays.sort(nums);
            String[] strings = new String[nums.length];
            for(int i = 0; i < strings.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == NumConverter(str1)) {
                    strings[i] = SuitChecker2(str1);
                }
                else if(nums[i] == NumConverter(str2)) {
                    strings[i] = SuitChecker2(str2);
                }
                else if(nums[i] == NumConverter(str3)) {
                    strings[i] = SuitChecker2(str3);
                }
                else if(nums[i] == NumConverter(str4)) {
                    strings[i] = SuitChecker2(str4);
                }
                else if(nums[i] == NumConverter(str5)) {
                    strings[i] = SuitChecker2(str5);
                }
                else if(nums[i] == NumConverter(str6)) {
                    strings[i] = SuitChecker2(str6);
                }
                else if(nums[i] == NumConverter(str7)) {
                    strings[i] = SuitChecker2(str7);
                }
            }
            
            String String7 = strings[6];
            String String6 = strings[5];
            String String5 = strings[4];
            String String4 = strings[3];
            String String3 = strings[2];
            String String2 = strings[1];
            String String1 = strings[0];
            if(nums[6] == PlayerStraightHigh) {
                if(PlayerHearts >= 5) {
                    if(String7.equals("heart") && String6.equals("heart") && String5.equals("heart") && String4.equals("heart") && String3.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerDiamonds >= 5) {
                    if(String7.equals("diamond") && String6.equals("diamond") && String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerSpades >= 5) {
                    if(String7.equals("spade") && String6.equals("spade") && String5.equals("spade") && String4.equals("spade") && String3.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerClubs >= 5) {
                    if(String7.equals("club") && String6.equals("club") && String5.equals("club") && String4.equals("club") && String3.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else if(nums[5] == PlayerStraightHigh) {
                if(PlayerHearts >= 5) {
                    if(String6.equals("heart") && String5.equals("heart") && String4.equals("heart") && String3.equals("heart") && String2.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerDiamonds >= 5) {
                    if(String6.equals("diamond") && String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond") && String2.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerSpades >= 5) {
                    if(String6.equals("spade") && String5.equals("spade") && String4.equals("spade") && String3.equals("spade") && String2.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerClubs >= 5) {
                    if(String6.equals("club") && String5.equals("club") && String4.equals("club") && String3.equals("club") && String2.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else if(nums[4] == PlayerStraightHigh) {
                if(PlayerHearts >= 5) {
                    if(String5.equals("heart") && String4.equals("heart") && String3.equals("heart") && String2.equals("heart") && String1.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerDiamonds >= 5) {
                    if(String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond") && String2.equals("diamond") && String1.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerSpades >= 5) {
                    if(String5.equals("spade") && String4.equals("spade") && String3.equals("spade") && String2.equals("spade") && String1.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(PlayerClubs >= 5) {
                    if(String5.equals("club") && String4.equals("club") && String3.equals("club") && String2.equals("club") && String1.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
            return false;
    }
    
    static boolean OpponentStraightFlush(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        if(OpponentStraight && OpponentFlush) {
            int[] nums = {NumConverter(str1), NumConverter(str2), NumConverter(str3), NumConverter(str4), NumConverter(str5), NumConverter(str6), NumConverter(str7)};
            Arrays.sort(nums);
            String[] strings = new String[nums.length];
            for(int i = 0; i < strings.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == NumConverter(str1)) {
                    strings[i] = SuitChecker2(str1);
                }
                else if(nums[i] == NumConverter(str2)) {
                    strings[i] = SuitChecker2(str2);
                }
                else if(nums[i] == NumConverter(str3)) {
                    strings[i] = SuitChecker2(str3);
                }
                else if(nums[i] == NumConverter(str4)) {
                    strings[i] = SuitChecker2(str4);
                }
                else if(nums[i] == NumConverter(str5)) {
                    strings[i] = SuitChecker2(str5);
                }
                else if(nums[i] == NumConverter(str6)) {
                    strings[i] = SuitChecker2(str6);
                }
                else if(nums[i] == NumConverter(str7)) {
                    strings[i] = SuitChecker2(str7);
                }
            }
            
            String String7 = strings[6];
            String String6 = strings[5];
            String String5 = strings[4];
            String String4 = strings[3];
            String String3 = strings[2];
            String String2 = strings[1];
            String String1 = strings[0];
            if(nums[6] == OpponentStraightHigh) {
                if(OpponentHearts >= 5) {
                    if(String7.equals("heart") && String6.equals("heart") && String5.equals("heart") && String4.equals("heart") && String3.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentDiamonds >= 5) {
                    if(String7.equals("diamond") && String6.equals("diamond") && String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentSpades >= 5) {
                    if(String7.equals("spade") && String6.equals("spade") && String5.equals("spade") && String4.equals("spade") && String3.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentClubs >= 5) {
                    if(String7.equals("club") && String6.equals("club") && String5.equals("club") && String4.equals("club") && String3.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else if(nums[5] == OpponentStraightHigh) {
                if(OpponentHearts >= 5) {
                    if(String6.equals("heart") && String5.equals("heart") && String4.equals("heart") && String3.equals("heart") && String2.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentDiamonds >= 5) {
                    if(String6.equals("diamond") && String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond") && String2.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentSpades >= 5) {
                    if(String6.equals("spade") && String5.equals("spade") && String4.equals("spade") && String3.equals("spade") && String2.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentClubs >= 5) {
                    if(String6.equals("club") && String5.equals("club") && String4.equals("club") && String3.equals("club") && String2.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else if(nums[4] == OpponentStraightHigh) {
                if(OpponentHearts >= 5) {
                    if(String5.equals("heart") && String4.equals("heart") && String3.equals("heart") && String2.equals("heart") && String1.equals("heart")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentDiamonds >= 5) {
                    if(String5.equals("diamond") && String4.equals("diamond") && String3.equals("diamond") && String2.equals("diamond") && String1.equals("diamond")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentSpades >= 5) {
                    if(String5.equals("spade") && String4.equals("spade") && String3.equals("spade") && String2.equals("spade") && String1.equals("spade")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if(OpponentClubs >= 5) {
                    if(String5.equals("club") && String4.equals("club") && String3.equals("club") && String2.equals("club") && String1.equals("club")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
            return false;
    }
    
    static boolean PlayerFourOfAKind(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        for(int i = 6; i >= 3; i--) {
            if(nums[i] - nums[i - 1] == 0 && nums[i - 1] - nums[i - 2] == 0 && nums[i - 2] - nums[i - 3] == 0) {
                PlayerFourOfAKindHigh = nums[i];
                return true;
            }
        }
        return false;
    }
    
    static boolean OpponentFourOfAKind(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        for(int i = 6; i >= 3; i--) {
            if(nums[i] - nums[i - 1] == 0 && nums[i - 1] - nums[i - 2] == 0 && nums[i - 2] - nums[i - 3] == 0) {
                OpponentFourOfAKindHigh = nums[i];
                return true;
            }
        }
        return false;
    }
    
    static boolean PlayerThreeOfAKind(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        int value2 = 0;
        int counter2 = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                if(i == 6) {
                    counter1++;
                    value = nums[i];
                }
                else if(nums[i] == value) {
                    counter1++;
                }
                else if(value == 0) {
                    value = nums[i];
                    counter1++;
                }
                else if(value2 == 0) {
                    value2 = nums[i];
                    counter2++;
                }
                else if(nums[i] == value2) {
                    counter2++;
                }
            }
        }
        if(counter1 == 2 || counter2 == 2) {
            if(value > value2) {
                PlayerThreeOfAKindHigh = value;
            }
            else {
                PlayerThreeOfAKindHigh = value2;
            }
            return true;
        }
        return false;
    }
    
    static boolean OpponentThreeOfAKind(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        int value2 = 0;
        int counter2 = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                if(i == 6) {
                    counter1++;
                    value = nums[i];
                }
                else if(nums[i] == value) {
                    counter1++;
                }
                else if(value == 0) {
                    value = nums[i];
                    counter1++;
                }
                else if(value2 == 0) {
                    value2 = nums[i];
                    counter2++;
                }
                else if(nums[i] == value2) {
                    counter2++;
                }
            }
        }
        if(counter1 == 2 || counter2 == 2) {
            if(value > value2) {
                OpponentThreeOfAKindHigh = value;
            }
            else {
                OpponentThreeOfAKindHigh = value2;
            }
            return true;
        }
        return false;
    }
    
    static boolean PlayerTwoPair(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                counter1++;
                if(nums[i] > value) {
                    value = nums[i];
                }
            }
        }
        if(counter1 >= 2) {
            PlayerTwoPairHigh = value;
            return true;
        }
        return false;
    }
    
    static boolean OpponentTwoPair(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                counter1++;
                if(nums[i] > value) {
                    value = nums[i];
                }
            }
        }
        if(counter1 >= 2) {
            OpponentTwoPairHigh = value;
            return true;
        }
        return false;
    }
    
    static boolean PlayerOnePair(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                counter1++;
                if(nums[i] > value && nums[i] != PlayerThreeOfAKindHigh) {
                    value = nums[i];
                }
            }
        }
        if(counter1 >= 1) {
            PlayerOnePairHigh = value;
            return true;
        }
        return false;
    }
    
    static boolean OpponentOnePair(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        int counter1 = 0;
        int value = 0;
        for(int i = 6; i > 0; i--) {
            if(nums[i] - nums[i - 1] == 0) {
                counter1++;
                if(nums[i] > value && nums[i] != OpponentThreeOfAKindHigh) {
                    value = nums[i];
                }
            }
        }
        if(counter1 >= 1) {
            OpponentOnePairHigh = value;
            return true;
        }
        return false;
    }
    
    static boolean PlayerFullHouse(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        if(PlayerOnePairHigh > 0 && PlayerThreeOfAKindHigh > 0) {
            PlayerFullHouseHigh1 = PlayerThreeOfAKindHigh;
            PlayerFullHouseHigh2 = PlayerOnePairHigh;
            return true;
        }
        return false;
    }
    
    static boolean OpponentFullHouse(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        if(OpponentOnePairHigh > 0 && OpponentThreeOfAKindHigh > 0) {
            OpponentFullHouseHigh1 = OpponentThreeOfAKindHigh;
            OpponentFullHouseHigh2 = OpponentOnePairHigh;
            return true;
        }
        return false;
    }
    
    static void PlayerHighCard(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        PlayerHighCardValue = nums[6];
    }
    
    static void OpponentHighCard(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
        int one1 = NumConverter(str1);
        int two2 = NumConverter(str2);
        int three3 = NumConverter(str3);
        int four4 = NumConverter(str4);
        int five5 = NumConverter(str5);
        int six6 = NumConverter(str6);
        int seven7 = NumConverter(str7);
        int[] nums = {one1, two2, three3, four4, five5, six6, seven7};
        Arrays.sort(nums);
        OpponentHighCardValue = nums[6];
    }
    
    static void Showdown(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int BuyIn, int PlayerBetTotal, int opponentStack, int OpponentBetTotal) {
        System.out.println("\n@@@@@@@@@@@@@@@@");
        System.out.println("    SHOWDOWN");
        System.out.println("@@@@@@@@@@@@@@@@");
        System.out.println("\nYour Hand: " + str1 + ", " + str2);
        System.out.println("Opponent's Hand: " + str3 + ", " + str4);


        String str1Suit = SuitChecker(str1);
        PlayersuitCounter(str1Suit);
        one = NumConverter(str1);

        String str2Suit = SuitChecker(str2);
        PlayersuitCounter(str2Suit);
        two = NumConverter(str2);

        String str3Suit = SuitChecker(str3);
        OpponentsuitCounter(str3Suit);
        three = NumConverter(str3);

        String str4Suit = SuitChecker(str4);
        OpponentsuitCounter(str4Suit);
        four = NumConverter(str4);

        String str5Suit = SuitChecker(str5);
        OpponentsuitCounter(str5Suit);
        PlayersuitCounter(str5Suit);
        five = NumConverter(str5);

        String str6Suit = SuitChecker(str6);
        OpponentsuitCounter(str6Suit);
        PlayersuitCounter(str6Suit);
        six = NumConverter(str6);

        String str7Suit = SuitChecker(str7);
        OpponentsuitCounter(str7Suit);
        PlayersuitCounter(str7Suit);
        seven = NumConverter(str7);

        String str8Suit = SuitChecker(str8);
        OpponentsuitCounter(str8Suit);
        PlayersuitCounter(str8Suit);
        eight = NumConverter(str8);

        String str9Suit = SuitChecker(str9);
        OpponentsuitCounter(str9Suit);
        PlayersuitCounter(str9Suit);
        nine = NumConverter(str9);


        if(PlayerTwoPair(str1, str2, str5, str6, str7, str8, str9)) {
            PlayerTwoPair = true;
            PlayerOnePair = false;
        }
        if(OpponentTwoPair(str3, str4, str5, str6, str7, str8, str9)) {
            OpponentTwoPair = true;
            OpponentOnePair = false;
        }

        if(PlayerThreeOfAKind(str1, str2, str5, str6, str7, str8, str9)) {
            PlayerThreeOfAKind = true;
            PlayerTwoPair = false;
            PlayerOnePair = false;
        }
        if(OpponentThreeOfAKind(str3, str4, str5, str6, str7, str8, str9)) {
            OpponentThreeOfAKind = true;
            OpponentTwoPair = false;
            OpponentOnePair = false;
        }

        if(PlayerOnePair(str1, str2, str5, str6, str7, str8, str9)) {
            if(!PlayerTwoPair && !PlayerThreeOfAKind) {
                PlayerOnePair = true;
            }
        }
        if(OpponentOnePair(str3, str4, str5, str6, str7, str8, str9)) {
            if(!OpponentTwoPair && !OpponentThreeOfAKind) {
                OpponentOnePair = true;
            }
        }

        if(StraightChecker(one, two, five, six, seven, eight, nine)) {
            PlayerStraight = true;
            PlayerThreeOfAKind = false;
            PlayerTwoPair = false;
            PlayerOnePair = false;
            if(StraightHigh > PlayerStraightHigh) {
                PlayerStraightHigh = StraightHigh;
            }
        }
        if(StraightChecker(three, four, five, six, seven, eight, nine)) {
            OpponentStraight = true;
            OpponentThreeOfAKind = false;
            OpponentTwoPair = false;
            OpponentOnePair = false;
            if(StraightHigh > OpponentStraightHigh) {
                OpponentStraightHigh = StraightHigh;
            }
        }

        if(PlayerHearts >= 5 || PlayerDiamonds >= 5 || PlayerSpades >= 5 || PlayerClubs >= 5) {
            PlayerFlush = true;
            PlayerStraight = false;
            PlayerThreeOfAKind = false;
            PlayerTwoPair = false;
            PlayerOnePair = false;
            if(PlayerHearts >= 5) {
                PlayerFlushHigh = PlayerFlushHighHeart;
            }
            else if(PlayerDiamonds >= 5) {
                PlayerFlushHigh = PlayerFlushHighDiamond;
            }
            else if(PlayerSpades >= 5) {
                PlayerFlushHigh = PlayerFlushHighSpade;
            }
            else if(PlayerClubs >= 5) {
                PlayerFlushHigh = PlayerFlushHighClub;
            }
        }
        if(OpponentHearts >= 5 || OpponentDiamonds >= 5 || OpponentSpades >= 5 || OpponentClubs >= 5) {
            OpponentFlush = true;
            OpponentStraight = false;
            OpponentThreeOfAKind = false;
            OpponentTwoPair = false;
            OpponentOnePair = false;
            if(OpponentHearts >= 5) {
                OpponentFlushHigh = OpponentFlushHighHeart;
            }
            else if(OpponentDiamonds >= 5) {
                OpponentFlushHigh = OpponentFlushHighDiamond;
            }
            else if(OpponentSpades >= 5) {
                OpponentFlushHigh = OpponentFlushHighSpade;
            }
            else if(OpponentClubs >= 5) {
                OpponentFlushHigh = OpponentFlushHighClub;
            }
        }

        if(PlayerFullHouse(str1, str2, str5, str6, str7, str8, str9)) {
            PlayerFullHouse = true;
            PlayerFlush = false;
            PlayerStraight = false;
            PlayerThreeOfAKind = false;
            PlayerTwoPair = false;
            PlayerOnePair = false;
        }
        if(OpponentFullHouse(str3, str4, str5, str6, str7, str8, str9)) {
            OpponentFullHouse = true;
            OpponentFlush = false;
            OpponentStraight = false;
            OpponentThreeOfAKind = false;
            OpponentTwoPair = false;
            OpponentOnePair = false;
        }

        if(PlayerFourOfAKind(str1, str2, str5, str6, str7, str8, str9)) {
            PlayerFourOfAKind = true;
            PlayerFullHouse = false;
            PlayerFlush = false;
            PlayerStraight = false;
            PlayerThreeOfAKind = false;
            PlayerTwoPair = false;
            PlayerOnePair = false;
        }
        if(OpponentFourOfAKind(str3, str4, str5, str6, str7, str8, str9)) {
            OpponentFourOfAKind = true;
            OpponentFullHouse = false;
            OpponentFlush = false;
            OpponentStraight = false;
            OpponentThreeOfAKind = false;
            OpponentTwoPair = false;
            OpponentOnePair = false;
        }

        if(PlayerStraightFlush(str1, str2, str5, str6, str7, str8, str9)) {
            PlayerStraightFlush = true;
            PlayerFourOfAKind = false;
            PlayerFullHouse = false;
            PlayerFlush = false;
            PlayerStraight = false;
            PlayerThreeOfAKind = false;
            PlayerTwoPair = false;
            PlayerOnePair = false;
            PlayerStraightFlushHigh = PlayerStraightHigh;
            if(PlayerStraightFlushHigh == 14) {
                PlayerRoyalFlush = true;
                PlayerStraightFlush = false;
            }
        }
        if(OpponentStraightFlush(str3, str4, str5, str6, str7, str8, str9)) {
            OpponentStraightFlush = true;
            OpponentFourOfAKind = false;
            OpponentFullHouse = false;
            OpponentFlush = false;
            OpponentStraight = false;
            OpponentThreeOfAKind = false;
            OpponentTwoPair = false;
            OpponentOnePair = false;
            OpponentStraightFlushHigh = OpponentStraightHigh;
            if(OpponentStraightFlushHigh == 14) {
                OpponentRoyalFlush = true;
                OpponentStraightFlush = false;
            }
        }

        if(!PlayerOnePair && !PlayerTwoPair && !PlayerThreeOfAKind && !PlayerStraight && !PlayerFlush && !PlayerFullHouse && !PlayerFourOfAKind && !PlayerStraightFlush && !PlayerRoyalFlush) {
            PlayerHighCard = true;
            PlayerHighCard(str1, str2, str5, str6, str7, str8, str9);
        }
        if(!OpponentOnePair && !OpponentTwoPair && !OpponentThreeOfAKind && !OpponentStraight && !OpponentFlush && OpponentFullHouse && !OpponentFourOfAKind && !OpponentStraightFlush && !OpponentRoyalFlush) {
            OpponentHighCard = true;
            OpponentHighCard(str3, str4, str5, str6, str7, str8, str9);
        }


        int PlayerValue = 0;
        int OpponentValue = 0;

        if(PlayerHighCard) {
            PlayerValue = 1;
        }
        if(OpponentHighCard) {
            OpponentValue = 1;
        }
        if(PlayerOnePair) {
            PlayerValue = 2;
        }
        if(OpponentOnePair) {
            OpponentValue = 2;
        }
        if(PlayerTwoPair) {
            PlayerValue = 3;
        }
        if(OpponentTwoPair) {
            OpponentValue = 3;
        }
        if(PlayerThreeOfAKind) {
            PlayerValue = 4;
        }
        if(OpponentThreeOfAKind) {
            OpponentValue = 4;
        }
        if(PlayerStraight) {
            PlayerValue = 5;
        }
        if(OpponentStraight) {
            OpponentValue = 5;
        }
        if(PlayerFlush) {
            PlayerValue = 6;
        }if(OpponentFlush) {
            OpponentValue = 6;
        }
        if(PlayerFullHouse) {
            PlayerValue = 7;
        }
        if(OpponentFullHouse) {
            OpponentValue = 7;
        }
        if(PlayerFourOfAKind) {
            PlayerValue = 8;
        }
        if(OpponentFourOfAKind) {
            OpponentValue = 8;
        }
        if(PlayerStraightFlush) {
            PlayerValue = 9;
        }
        if(OpponentStraightFlush) {
            OpponentValue = 9;
        }
        if(PlayerRoyalFlush) {
            PlayerValue = 10;
        }
        if(OpponentRoyalFlush) {
            OpponentValue = 10;
        }

        if(PlayerValue > OpponentValue) {
            PlayerWin = true;
        }
        else if(PlayerValue < OpponentValue) {
            OpponentWin = true;
        }
        else if(PlayerValue == OpponentValue) {
            if(PlayerValue == 1) {
                if(PlayerHighCardValue > OpponentHighCardValue) {
                    PlayerWin = true;
                }
                else if(PlayerHighCardValue < OpponentHighCardValue){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 2) {
                if(PlayerOnePairHigh > OpponentOnePairHigh) {
                    PlayerWin = true;
                }
                else if(PlayerOnePairHigh < OpponentOnePairHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 3) {
                if(PlayerTwoPairHigh > OpponentTwoPairHigh) {
                    PlayerWin = true;
                }
                else if(PlayerTwoPairHigh < OpponentTwoPairHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 4) {
                if(PlayerThreeOfAKindHigh > OpponentThreeOfAKindHigh) {
                    PlayerWin = true;
                }
                else if(PlayerThreeOfAKindHigh < OpponentThreeOfAKindHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 5) {
                if(PlayerStraightHigh > OpponentStraightHigh) {
                    PlayerWin = true;
                }
                else if(PlayerStraightHigh < OpponentStraightHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 6) {
                if(PlayerFlushHigh > OpponentFlushHigh) {
                    PlayerWin = true;
                }
                else if(PlayerFlushHigh < OpponentFlushHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 7) {
                if(PlayerFullHouseHigh1 > OpponentFullHouseHigh1) {
                    PlayerWin = true;
                }
                else if(PlayerFullHouseHigh1 < OpponentFullHouseHigh1){
                    OpponentWin = true;
                }
                else if(PlayerFullHouseHigh2 > OpponentFullHouseHigh2) {
                    PlayerWin = true;
                }
                else if(PlayerFullHouseHigh2 < OpponentFullHouseHigh2) {
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 8) {
                if(PlayerFourOfAKindHigh > OpponentFourOfAKindHigh) {
                    PlayerWin = true;
                }
                else if(PlayerFourOfAKindHigh < OpponentFourOfAKindHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
            else if(PlayerValue == 9) {
                if(PlayerStraightFlushHigh > OpponentStraightFlushHigh) {
                    PlayerWin = true;
                }
                else if(PlayerStraightFlushHigh < OpponentStraightFlushHigh){
                    OpponentWin = true;
                }
                else {
                    Chop = true;
                }
            }
        }

        String[] win = {"High Card", "One Pair", "Two Pair", "Three Of A Kind", "Straight", "Flush", "Full House", "Four Of A Kind", "Straight Flush", "Royal Flush"};

        if(PlayerWin) {
            BuyIn += PlayerBetTotal;
            opponentStack -= OpponentBetTotal;
            System.out.println("\nYou win with a " + win[PlayerValue - 1] + "!");
            System.out.println("You won $" + PlayerBetTotal + "!");
            System.out.println("Your stack is now $" + BuyIn + ".");
            System.out.println("Opponent's stack is now $" + opponentStack + ".");
            deckReset++;
        }
        else if(OpponentWin) {
            BuyIn -= PlayerBetTotal;
            opponentStack += OpponentBetTotal;
            System.out.println("\nYou lose to your opponent's " + win[OpponentValue - 1] + ".");
            System.out.println("You lost $" + PlayerBetTotal + ".");
            System.out.println("Your stack is now $" + BuyIn + ".");
            System.out.println("Opponent's stack is now $" + opponentStack + ".");
            deckReset++;
        }
        else if(Chop) {
            System.out.println("\nYou chop the pot with a " + win[PlayerValue - 1] + ".");
            System.out.println("Your stack is still $" + BuyIn + ".");
            System.out.println("Opponent's stack is still $" + opponentStack + ".");
            deckReset++;
        }

        if(BuyIn == 0) {
            System.out.println("\nYou're out of money. Game Over.");
            System.exit(0);
        }
        if(opponentStack == 0) {
            System.out.println("\nOpponent is out of money. You win!");
            System.exit(0);
        }
    }
    
}