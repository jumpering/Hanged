package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
public class SecretTest {

    @InjectMocks
    private Secret secret = new Secret();

    @Mock
    Word word;

    @BeforeEach
    public void init(){

    }

    @Test
    public void givenContainCharWhenInputCharacterIsPresentOnSecretThenReturnTrue() throws IOException {
        when(word.getWord()).thenReturn("secreta");
        this.secret.setWord();
        System.out.println(word.getWord());
        System.out.println(secret.getSecret());
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
