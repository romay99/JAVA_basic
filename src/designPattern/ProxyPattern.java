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

class DoorManProxy extends DoorMan {
    @Override
    public void 쫓아내(Animal animal) {
        System.out.println("안녕, "+ animal.getName());
        super.쫓아내(animal);
    }
}