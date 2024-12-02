//package final_proj;
//
//import java.util.*;
//
//public class GameController {
//    private List<MonsterCard> player1Deck;
//    private List<MonsterCard> player2Deck;
//    private List<MonsterCard> player1Field;
//    private List<MonsterCard> player2Field;
//    private int player1LifePoints;
//    private int player2LifePoints;
//    private int turnCounter;
//
//    public GameController(List<MonsterCard> player1Deck, List<MonsterCard> player2Deck) {
//        this.player1Deck = new ArrayList<>(player1Deck);
//        this.player2Deck = new ArrayList<>(player2Deck);
//        this.player1Field = new ArrayList<>();
//        this.player2Field = new ArrayList<>();
//        this.player1LifePoints = 2000; // simplified life points
//        this.player2LifePoints = 2000;
//        this.turnCounter = 1;
//
//        shuffleDeck(player1Deck);
//        shuffleDeck(player2Deck);
//    }
//
//    private void shuffleDeck(List<MonsterCard> deck) {
//        Collections.shuffle(deck);
//    }
//
//    public void startGame() {
//        System.out.println("Game started!");
//        while (player1LifePoints > 0 && player2LifePoints > 0) {
//            playTurn();
//        }
//        determineWinner();
//    }
//
//    private void playTurn() {
//        System.out.println("Turn " + turnCounter);
//        if (turnCounter % 2 != 0) {
//            System.out.println("Player 1's turn.");
//            playerTurn(player1Deck, player1Field, player2Field, player2LifePoints);
//        } else {
//            System.out.println("Player 2's turn.");
//            playerTurn(player2Deck, player2Field, player1Field, player1LifePoints);
//        }
//        turnCounter++;
//    }
//
//    private void playerTurn(List<MonsterCard> deck, List<MonsterCard> myField, List<MonsterCard> opponentField, int opponentLifePoints) {
//        if (!deck.isEmpty()) {
//            MonsterCard drawnCard = deck.remove(0);
//            System.out.println("Drew card: " + drawnCard.getName());
//            myField.add(drawnCard); // simplified: automatically place on the field
//        }
//        
//        // Simplified attack phase
//        if (!myField.isEmpty() && !opponentField.isEmpty()) {
//            MonsterCard attacker = myField.get(0); // feirst monster attacks
//            MonsterCard defender = opponentField.get(0);
//
//            System.out.println(attacker.getName() + " attacks " + defender.getName());
//
//            if (attacker.getAttack() > defender.getDefense()) {
//                System.out.println(defender.getName() + " is destroyed!");
//                opponentField.remove(defender);
//                opponentLifePoints -= (attacker.getAttack() - defender.getDefense());
//            } else {
//                System.out.println("Attack failed. No damage dealt.");
//            }
//        } else if (!myField.isEmpty()) {
//            MonsterCard attacker = myField.get(0); // direct attak
//            System.out.println(attacker.getName() + " attacks directly!");
//            opponentLifePoints -= attacker.getAttack();
//        }
//
//        System.out.println("Opponent Life Points: " + opponentLifePoints);
//    }
//
//    private void determineWinner() {
//        if (player1LifePoints <= 0) {
//            System.out.println("Player 2 wins!");
//        } else if (player2LifePoints <= 0) {
//            System.out.println("Player 1 wins!");
//        }
//    }
//}
//
//       
