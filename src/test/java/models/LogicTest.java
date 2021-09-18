package models;

import controllers.Controller;
import controllers.ProposeController;
import controllers.StartController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogicTest {

    @InjectMocks
    private Logic logic = new Logic();

    @Mock
    private Game game;

    @BeforeEach
    public void init(){

    }

    @Test
    public void givenGetControllerWhenGetControllerAtInitGameThenReturnNewController(){
        assertThat(this.logic.getController().getClass(), is(StartController.class));
    }

    @Test
    public void givenGetControllerWhenGameChangeStateValueToProposeControllerThenReturnNewProposeController(){
        when(this.game.getStateValue()).thenReturn(StateValue.PROPOSE);
        assertThat(this.logic.getController().getClass(), is(ProposeController.class));
    }

    @Test
    public void givenGetControllerWhenGameChangeStateValueToNullThenCatchError(){
        when(this.game.getStateValue()).thenReturn(null);
        assertThrows(AssertionError.class, () -> this.logic.getController()); //AssertionError.class no funciona
    }
}
