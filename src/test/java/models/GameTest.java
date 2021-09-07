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

    @InjectMocks
    private Game game = new Game();

    @Mock
    Word word;

    @BeforeEach
    public void beforeEach() {
        String stringMocked = "secreta";
        when(this.word.getWord()).thenReturn(stringMocked);
        System.out.println("last player name is: " + this.game.getLastPlayer().getName());
        //this.secret = new Secret(this.word); //todo ¿hace falta crear objeto con @InjectMocks?
    }

    @Test
    public void givenIsUserInputPresentOnSecretWhenGetUserInputCharacterIsPresentOnSecretThenReturnTrue() {
        //System.out.println(this.secret.getLength());
        //System.out.println(this.secret.getWord());
        this.game.addPlayer("xavi");
        this.game.setSecretForPlayer(this.game.getLastPlayer());
        //this.gameMock.setSecretForPlayer(new Player("xavi"), this.secret);
        //assertThat(this.gameMock.isUserInputPresentOnSecret('s'), is(true));
        assertThat(this.game.isUserInputPresentOnSecret('s'), is(true));
    }

}
