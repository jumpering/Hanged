package controllers;

import models.Game;
import models.ReturnInputValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProposeControllerTest {

    private ProposeController proposeController;
    private Game game;

    @BeforeEach
    public void beforeEach(){
        this.game = new Game();
        this.proposeController = new ProposeController(game);
    }

    @Test
    public void givenIsValidCharOrWordWhenInsertStringWithNumbersThenGetFalse(){
        String sample = "123test123";
        assertThat(this.proposeController.isValidCharacterOrString(sample), is (false));
    }

    @Test
    public void givenIsValidCharOrWordWhenInsertStringWithSimbolsThenGetFalse(){
        String sample = "?test?#";
        assertThat(this.proposeController.isValidCharacterOrString(sample), is (false));
    }

    @Test
    public void givenIsValidCharOrWordWhenInsertStringWithSpacesThenGetFalse(){
        String sample = "test test";
        assertThat(this.proposeController.isValidCharacterOrString(sample), is (false));
    }

    @Test
    public void givenIsValidCharOrWordWhenInsertStringWithOutNumbersAndSimbolsAndSpacesThenGetTrue(){
        String sample = "tést";
        assertThat(this.proposeController.isValidCharacterOrString(sample), is (true));
    }

    @Test
    public void givenIsEqualWithSecretWhenGetUserInputCharacterIsPresentOnSecretThenReturnTrue(){
        ReturnInputValue returnInputValue = new ReturnInputValue();
        returnInputValue.setCharacter('c');
        boolean test = this.proposeController.isEqualWithSecret(returnInputValue);
        System.out.println(test);
        assertThat(test, is(true));
    }
}
