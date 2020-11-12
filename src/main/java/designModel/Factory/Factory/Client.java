package designModel.Factory.Factory;

/**
 * 二、工厂方法模式
 * 用了简单方法模式后，顾客们方便多了，想要哪种口味的冰激凌就直接点一下按钮即可直接购买。
 * 现在，该机器只能卖三种口味的冰激凌，并没有满足很多顾客的需求，
 * 管理员打算再添加一种草莓味的冰激凌来满足更多顾客。问题来了，整个机器已经做成了，按钮数目为3也已经固定了，
 * 如果想要再添加一种口味，那么就要打开机器内部，往里边添加制作草莓味冰激凌的原料以及制作工艺，
 * 还要在机器外部再增加一个按钮。这可麻烦了，毕竟整个机器的布局什么的都固定下来了。
 *
 * 其实，这正是简单工厂模式的缺点，其违背了开闭原则，扩展性差。观察简单工厂模式的工厂类代码，我们可以发现，
 * 其内部做了很多逻辑的处理，通过switch值的不同来创建不同的对象。现在，如果要新增草莓味的冰激凌，
 * 首先要新增StrawberryIceCream，并且，还要在switch里边，新增一个case分支，来判断是否生产StrawberryIceCream，
 * 所以不是很合理。
 *
 * 通过 工厂方法模式 ，我们就能解决这一问题。
 * 仔细研究，之所以会产生上面的问题，是因为我们只有一个“工厂”，无论何种口味的冰激凌生产，都交给这个工厂去处理导致的。
 * 那么，现在，我们可以，设计多个“工厂”，每种工厂只负责生产一种口味的冰激凌。
 * 回到商场来，还是在商场入场处，我们购置多台生产冰激凌的机器，每台机器只能生产一种口味的冰激凌，每台机器有一个按钮，
 * 点击下去就会吐出该口味冰激凌，然后将这些机器一个挨着一个排列起来就行。现在，如果要添加一种新的口味，
 * 那么只要再购置一台机器，然后挨着放进去即可。
 * 可以看到，每个工厂只生产一种产品，客户端通过不同的工厂去生产不同的产品，
 * 而生产哪一产品的逻辑交给客户端这边去处理了。
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //生产苹果味冰激凌
        IceCreamFactory appleFactory = new AppleIceCreamFactory();
        IceCream appleIceCream = appleFactory.createIceCream();
        appleIceCream.taste();

        //生产香蕉口味冰激凌
        IceCreamFactory  bananaFactory = new BananaIceCreamFactory();
        IceCream bananaIceCream = bananaFactory.createIceCream();
        bananaIceCream.taste();

        //生产橘子口味冰激凌
        IceCream orangeIceCream = new OrangeIceCreamFactory().createIceCream();
        orangeIceCream.taste();
    }
}
