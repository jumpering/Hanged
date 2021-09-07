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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecretTest {

    @InjectMocks
    private Secret secret = new Secret();

    @Mock
    Word word;

    @BeforeEach
    public void init(){
        String stringMocked = "secreta";
        when(this.word.getWord()).thenReturn(stringMocked);
    }

    @Test
    public void givenContainCharWhenInputCharacterIsPresentOnSecretThenReturnTrue() throws IOException {
        System.out.println(this.word.getWord());
        System.out.println(this.secret.getSecret());
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
