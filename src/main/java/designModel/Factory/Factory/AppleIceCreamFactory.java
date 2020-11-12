package designModel.Factory.Factory;

public class AppleIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream createIceCream() {
        return new AppleIceCream();
    }
}
