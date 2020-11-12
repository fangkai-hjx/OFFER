package designModel.Factory.Factory;

public class OrangeIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream createIceCream() {
        return new OrangeIceCream();
    }
}
