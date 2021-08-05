package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecretTest {

    @Mock
    private Word word;

    //@InjectMocks
    //private Secret secret;

    @BeforeEach
    public void before(){

    }
    @Test
    public void givenContainCharWhenInputCharacterIsPresentThenReturnTrue() throws IOException {
        String stringMocked = "secreta";
        when(this.word.getWord()).thenReturn(stringMocked);
        Secret secret = new Secret(this.word);
        assertThat(secret.containsChar('s'), is(true));
//        assertThat(this.word.getWord(), is("secreta"));
//        assertThat(secret.getSecret(),is("secreta"));

    }
}
