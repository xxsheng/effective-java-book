package chapter1.callback;

public abstract class AbstractConsumer implements Consumer{
    @Override
    public void consume() {
        try {
            doConsumer();
        } catch (Throwable e) {
            if (!getCallBack().onFailed(e, null)) {
                throw e;
            }
        }
    }

    public abstract void doConsumer();
}
