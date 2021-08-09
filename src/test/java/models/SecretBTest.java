package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecretBTest {

    @Mock
    Word word;

    @InjectMocks
    private Secret secret;

    @Test
    public void givenContainCharWhenInputCharacterIsPresentThenReturnTrue() throws IOException {
        String stringMocked = "secreta";
        when(this.word.getWord()).thenReturn(stringMocked);
        SecretB secretB = new SecretB(); //todo ¿hace falta crear objeto con @InjectMocks?
        assertThat(secretB.containsChar('s'), is(true));
    }
}
