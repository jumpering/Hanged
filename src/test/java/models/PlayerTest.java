package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.HangedParts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void before(){
        this.player = new Player("test");
    }

    @Test
    public void givenIncreaseHangedPartStateWhenPartStateIsBoardPaperThenGetBase(){
        this.player.increaseHangedPartState();
        assertThat(this.player.getHangedPartState(), is(HangedParts.BASE));
    }

}
