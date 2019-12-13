package com.appskc.business.frameworks;

import com.mongodb.MongoException;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import com.appskc.business.TicTacToeGameMove;
import com.appskc.business.TicTacToeGameState;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.debugging.VerboseMockInvocationLogger;
import org.mockito.internal.invocation.finder.VerifiableInvocationsFinder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Demo for mocking framework JMockit
 */
public class TicTacToeGameStateJMockitTest {

    private TicTacToeGameState state;

    @Mocked
    private MongoCollection mongoCollection;

    private TicTacToeGameMove move;

    @Before
    public void setUp() {
        move = new TicTacToeGameMove(3, 'X', 2, 1);

        // instantiate class to test
        state = new TicTacToeGameState();
        
        // use Deencapsulation to set private field mongoCollection

    }

    // check save invocation.
    // use NonStrictExpectations and times to mock mongoCollection.save
    @Test
    public void whenSave_ThenInvokeMongoCollectionSaveAndReturnTrue() throws Exception {
    	new NonStrictExpectations() {{
    		mongoCollection.save(any);
    		times = 1;
    	}
    	};
    	boolean result = state.save(move);
    	assertThat(result, equalTo(true));
    }

    // check when exception occurs during save, then save returns false
    // use Expectations and result to mock mongoCollection.save
    @Test
    public void givenMongoException_WhenSave_ThenReturnFalse() {
    	new NonStrictExpectations() {{
    		mongoCollection.save(any);
    		result = new MongoException("failed");
    	}
    	};
    	boolean result = state.save(move);
    	assertThat(result, equalTo(false));
    }

    // check clear invocation
    // use Expectations to mock mongoCollection.drop()
    @Test
    public void whenClear_ThenInvokeMongoCollectionDrop() {
    	boolean result = state.clear();
    	assertThat(result, equalTo(true));
    	new Verifications() {{
    		mongoCollection.drop();
    		times = 1;
    	}
    	};
    }

    // check when exception occurs during clear, then clear returns false
    // use Expectations and result to mock mongoCollection.drop
    @Test
    public void givenMongoException_WhenClear_ThenReturnFalse() {

    }
}
