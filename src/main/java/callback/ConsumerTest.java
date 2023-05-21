package callback;

public class ConsumerTest extends AbstractConsumer{
    @Override
    public void doConsumer() {

    }

    @Override
    public TestCallBack getCallBack() {
        return (e, event) -> false;
    }
}
