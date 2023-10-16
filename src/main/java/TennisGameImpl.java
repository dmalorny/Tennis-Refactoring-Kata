import static java.lang.Math.abs;

public class TennisGameImpl implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    private static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    @Override
    public String getScore()
    {
        if (player1Score == player2Score) {
            return getTieScore();
        }

        if (player1Score > 3 || player2Score > 3) {
            return getEndGameScore();
        }

        return getRegularScore();
    }

    private String getTieScore() {
        if (player1Score > 2) {
            return "Deuce";
        }

        return SCORES[player1Score] + "-All";
    }

    private String getEndGameScore() {
        final String betterPlayer = player1Score > player2Score ? player1Name : player2Name;
        final String prefix = abs(player1Score - player2Score) > 1 ? "Win for" : "Advantage";

        return prefix + " " + betterPlayer;
    }

    private String getRegularScore() {
        var score1 = SCORES[player1Score];
        var score2 = SCORES[player2Score];

        return score1 + "-" + score2;
    }

}
