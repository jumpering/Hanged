package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Mock
    Word word;

    private Secret secret;
    @InjectMocks
    private Game game;

    @BeforeEach
    public void beforeEach() {
        this.game = new Game();
        String stringMocked = "secreta";
        this.game.addPlayer("xavi");
        when(this.word.getWord()).thenReturn(stringMocked);
        this.game.setSecretForPlayer(this.game.getLastPlayer());
        System.out.println("last player name is: " + this.game.getLastPlayer().getName());

        this.secret = new Secret(this.word); //todo ¿hace falta crear objeto con @InjectMocks?
    }

    @Test
    public void givenIsUserInputPresentOnSecretWhenGetUserInputCharacterIsPresentOnSecretThenReturnTrue() {
        System.out.println(this.secret.getLength());
        System.out.println(this.secret.getWord());
        //this.gameMock.setSecretForPlayer(new Player("xavi"), this.secret);
        //assertThat(this.gameMock.isUserInputPresentOnSecret('s'), is(true));
        assertThat(this.game.isUserInputPresentOnSecret('s'), is(true));
    }

}
