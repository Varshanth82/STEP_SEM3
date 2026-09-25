package SRC.MAIN.JAVA.WEEK1;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(Random random) {

        String[] moves = {"Rock", "Paper", "Scissors"};

        int index = random.nextInt(moves.length);

        return moves[index];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int round = 0; round < rounds; round++) {

            System.out.print("Round " + (round + 1)
                    + " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine();

            String computerMove = generateComputerMove(random);

            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("----------- FINAL SUMMARY -----------");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int round = 0; round < rounds; round++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    round + 1,
                    playerMoves[round],
                    computerMoves[round],
                    results[round]);
        }

        System.out.println("-------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}