package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    public void beforeEach(){
        this.turn = new Turn();
    }

    @Test
    public void givenNegativeNumberOfPlayersWhenSetNumberOfPlayersThenGetErrorNegativeArraySizeException(){
        assertThrows(NegativeArraySizeException.class, () -> this.turn.setNumberOfPlayers(-1));
    }

    @Test
    public void givenZeroNumberWhenSetNumberOfPlayersThenGetError(){
        assertThrows(AssertionError.class, () -> this.turn.setNumberOfPlayers(0));
    }

    @Test
    public void givenPositiveNumberWhenSetNumberOfPlayersThenGetSameNumberOfPlayers(){
        this.turn.setNumberOfPlayers(6);
        assertThat(this.turn.getNumberOfPlayers(), is(6));
    }

}
