package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecretTest {

    @InjectMocks
    private Secret secret = new Secret();

    @Mock
    Word word;

    @BeforeEach
    public void init(){
        when(this.word.getWord()).thenReturn("secreta");
        this.secret.setWord();
        System.out.println(this.word.getWord());
        System.out.println(this.secret.getSecret());
    }

    @Test
    public void givenContainCharWhenInputCharacterIsPresentOnSecretThenReturnTrue() throws IOException {
        assertThat(this.secret.isEqualCharInAnyPosition('s'), is(true));

    }

    @Test
    public void givenIsEqualWordWhenInputIsSameWordThatSecretThenReturnTrue(){
        assertThat(this.secret.isEqualWord("secreta"), is(true));
   }

    @Test
    public void givenIsEqualWordWhenInputIsDiferentWordThatSecretThenReturnFalse(){
        assertThat(this.secret.isEqualWord("secretilla"), is(false));
    }

    @Test
    public void givenIsEqualCharInConcretePositionWhenInputIsEqualCharInSamePositionOnSecretThenReturnTrue(){
        assertThat(this.secret.isEqualCharInConcretePosition(0,'s'), is(true));
    }

    @Test
    public void givenIsEqualCharInConcretePositionWhenInputIsEqualCharInOutOfBoundPositionOnSecretThenReturnFalse(){
        assertThat(this.secret.isEqualCharInConcretePosition(10,'s'), is(false));
    }
}
