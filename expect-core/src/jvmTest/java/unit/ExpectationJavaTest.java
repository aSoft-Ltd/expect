package unit;

import expect.BasicAssertion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static expect.Builders.expect;

public class ExpectationJavaTest {
    @Test
    public void toBe_should_behave_the_same() {
        expect(1 + 1).toBe(2);
        (new BasicAssertion<>(1 + 1)).toBe(2);
    }

    @Test
    public void toBe_of_collection_behave_as_intended() {
        expect(List.of(1, 2, 3)).toBeInstanceOf(List.class);
        expect(List.of(4, 5, 6)).toContain(5);
    }

    @Test
    public void should_fail() {
        expect(() -> {
            throw new RuntimeException("Not implemented");
        }).toFail();
    }
}
