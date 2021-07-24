package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StateTest {

    private State state;

    @BeforeEach
    public void beforeEach(){
        this.state = new State();
    }

    @Test
    public void givenGetStateValueWhenExerciseMethodThenReturnActualStateValue(){
        assertThat(this.state.getStateValue(), is(StateValue.START));
    }

    @Test
    public void giveResetStateWhenGetStateValueThenReturnStateValueSTART(){
        this.state.next();
        this.state.reset();
        assertThat(this.state.getStateValue(), is (StateValue.START));
    }

    @Test
    public void givenNewStateWhenConstructThenStateValueIsSTART(){
        assertThat(this.state.getStateValue(), is(StateValue.START));
    }

    @Test
    public void givenNextStateWhenFirstNextStateThenStateIsUSER_PROPOSE(){
        this.state.next();
        assertThat(this.state.getStateValue(), is(StateValue.USER_PROPOSE));
    }

    @Test
    public void givenNextStateWhenSecondNextStateThenStateIsRESUME(){
        this.state.next();
        this.state.next();
        assertThat(this.state.getStateValue(), is(StateValue.RESUME));
    }

    @Test
    public void givenNextStateWhenThirdNextStateThenStateIsEXIT(){
        this.state.next();
        this.state.next();
        this.state.next();
        assertThat(this.state.getStateValue(), is(StateValue.EXIT));
    }

    @Test
    public void givenNextStateWhenFourthNextStateThenStateReturnErrorArrayIndexOutOfBoundsException(){
        this.state.next();
        this.state.next();
        this.state.next();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> this.state.next()); //AssertionError.class no funciona
    }
}
