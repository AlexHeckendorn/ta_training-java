package com.epam.training.Alexander_Heckendorn.meet_an_agent;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MeetAnAgentTest {

    @ParameterizedTest
    @MethodSource("getParameters")
    public void correctPasswordTest(int userInput, String expected) throws Exception {

        String actual = tapSystemOut(
                () -> withTextFromSystemIn(Integer.toString(userInput))
                        .execute(() -> MeetAnAgent.main(new String[]{}))
        );

        assertEquals(expected, actual.strip());
    }

    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(MeetAnAgent.PASSWORD, "Hello, Agent"),
                Arguments.of(MeetAnAgent.PASSWORD + 1, "Access denied"),
                Arguments.of(MeetAnAgent.PASSWORD + MeetAnAgent.PASSWORD, "Access denied"),
                Arguments.of(100 + MeetAnAgent.PASSWORD, "Access denied")
        );
    }
}
