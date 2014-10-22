package pointofsale;

import org.junit.Assert;
import org.junit.Test;


public class MoneyTest {
    @Test
    public void canRenderAsText() {
        Assert.assertEquals("$0.42", new Money(42).asText());
    }

    @Test
    public void canAddAnotherMoney() {
        Assert.assertEquals("$0.43", new Money(42).add(new Money(1)).asText());
    }

    @Test
    public void canProduceNegative() {
        Assert.assertEquals("($1.00)", new Money(100).negate().asText());
    }
}
