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
    public void givenRemovePlayerWhenNoPlayersLeftThenGetError(){
        assertThrows(IndexOutOfBoundsException.class, () -> this.turn.removeCurrentPlayer());
    }

    @Test
    public void givenRemovePlayerWhenAddPlayersLeftToListCollectionThenRemovePlayerOk(){
        this.turn.addPlayer("test");
        this.turn.removeCurrentPlayer();
        assertThat(this.turn.getCurrentNumberOfPlayer(), is(0));
    }
}
