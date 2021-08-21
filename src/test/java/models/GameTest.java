package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.HangedParts;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    public void beforeEach(){
        this.game = new Game();
    }


}
