package designModel.Factory.simpleFactory;

/**
 * 客户
 * 可以看到，简单工厂模式确实很“简单”。
 * 一般，简单工厂方法模式中，工厂类中有一个方法，
 * 通过switch中不同的值或者if else语句来创建不同的对象并返回，
 * 通常这个方法是一个静态方法，(顺便一提:简单工厂模式也被称作
 * “静态工厂模式”)在客户端直接调用工厂类的该方法就可以。
 * 整个冰激凌的生产(创建不同口味冰激凌的过程)被这个工厂类封装了，客户端不用去关注这些细节。
 */
public class Client {
    public static void main(String[] args) {
        IceCream apple = IceCreamFactory.creamIceCream("Apple");
        apple.taste();
        IceCream orange = IceCreamFactory.creamIceCream("Orange");
        orange.taste();
        IceCream banana = IceCreamFactory.creamIceCream("Banana");
        banana.taste();
    }
}
