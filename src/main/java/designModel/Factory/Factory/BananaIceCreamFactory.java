package designModel.Factory.Factory;

public class BananaIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream createIceCream() {
        return new BananaIceCream();
    }
}
