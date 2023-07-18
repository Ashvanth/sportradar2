package sportradar.exc.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sportradar.exc.pojo.Match;
import sportradar.exc.service.FootballScoreBoard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FootballScoreBoardTest {

    private FootballScoreBoard scoreBoard;

    @BeforeEach
    public void setUp() {
        scoreBoard = new FootballScoreBoard();
    }

    @Test
    public void testStartGame() {
        scoreBoard.startGame("Germany", "Canada");
        List<Match> summary = scoreBoard.getSummaryByTotalScore();
        assertEquals(1, summary.size());
        assertEquals("Canada", summary.get(0).getAwayTeam());
        assertEquals("Germany", summary.get(0).getHomeTeam());
        assertEquals(0,summary.get(0).getHomeScore());
        assertEquals(0,summary.get(0).getAwayScore());
    }

    @Test
    public void testUpdateGame() {
        scoreBoard.startGame("Germany", "Canada");
        scoreBoard.updateScore("Germany", "Canada",5,10);

        List<Match> summary = scoreBoard.getSummaryByTotalScore();
        assertEquals("Canada", summary.get(0).getAwayTeam());
        assertEquals("Germany", summary.get(0).getHomeTeam());
        assertEquals(5,summary.get(0).getHomeScore());
        assertEquals(10,summary.get(0).getAwayScore());
    }
}
