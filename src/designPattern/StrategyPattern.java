package designPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Cat cat = new Cat();
        DoorMan doorMan = new DoorMan();

        /**
         * Animal 이라는 추상클래스를 만들어서 다형성을 이용한다.
         * Cat 과 Mouse 모두 이 Animal 이라는 파라미터로 이용할 수 있다.
         * Tartget 을 Cat 과 Mouse 가 아닌 Animal 이라는 클래스로 전환하는것.
         * SOLID 의 D -> DIP
         */
        doorMan.쫓아내(mouse);
        doorMan.쫓아내(cat);

    }
}

abstract class Animal {
    public abstract String getName();
}

class Mouse extends Animal {
    private final String name = "쥐";

    @Override
    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    private final String name = "고양이";

    @Override
    public String getName() {
        return name;
    }
}

class DoorMan{
    public void 쫓아내(Animal animal) {
        System.out.println(animal.getName() + " 을 쫓아내!");
    }
}
