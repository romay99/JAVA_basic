package designPattern;

import org.w3c.dom.ls.LSOutput;

public class ProxyPattern {
    public static void main(String[] args) {
        /**
         * DoorManProxy 클래스를 DoorMan 이라는 상위클래스로 선언
         */
        DoorMan doorManProxy = new DoorManProxy();
        doorManProxy.쫓아내(new Cat());
    }
}

/**
 * 기존 클래스에 기능을 추가하고 싶을때, 기존 코드를 수정하지않고, 새로운 Proxy클래스를 만듬
 * O -> OCP 원칙
 */
class DoorManProxy extends DoorMan {
    @Override
    public void 쫓아내(Animal animal) {
        System.out.println("안녕, "+ animal.getName());
        super.쫓아내(animal);
    }
}