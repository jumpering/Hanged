package fields;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class XDoubleTest {

	@Mock
	Z z;

	@Mock
	Y y;

	@InjectMocks
	X x = new X();

//	@Before
//  public void before() {
//      initMocks(this);
//	}
	
	@Test
	public void testM() {
		when(y.m()).thenReturn(0);
		when(z.m()).thenReturn(0);
		this.x.m();
	}
	
}
