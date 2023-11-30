import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private int gameCount;
    private int playerScore;
    private int dealerScore;
    private Random random;
    private Scanner scanner;

    public CardGame() {
        gameCount = 1;
        playerScore = 0;
        dealerScore = 0;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("간단 카드 게임을 시작합니다.");

        while (true) {
            playGame();

            System.out.println("현재 전적: " + playerScore + "승 " + dealerScore + "패");
            gameCount++;

            if (!askForAnotherGame()) {
                break;
            }
        }

        System.out.println("게임을 종료합니다.");
        System.out.println("플레이해주셔서 감사합니다.");
    }

    private void playGame() {
        int playerCard = random.nextInt(11) + 1;
        int dealerCard = random.nextInt(11) + 1;

        System.out.println("Game " + gameCount);
        System.out.println("You   : [" + playerCard + "]");
        System.out.println("Dealer: [" + dealerCard + "]");

        if (playerCard > dealerCard) {
            playerScore++;
            System.out.println("당신이 이겼습니다.");
        } else if (dealerCard > playerCard) {
            dealerScore++;
            System.out.println("딜러가 이겼습니다.");
        } else {
            System.out.println("비겼습니다.");
        }
    }

    private boolean askForAnotherGame() {
        String answer = "";

        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
            answer = scanner.nextLine();

            if (!answer.equals("Y") && !answer.equals("N")) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }

        return answer.equals("Y");
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.start();
    }
}