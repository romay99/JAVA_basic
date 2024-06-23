package designPattern;

public class SingletonPattern {

    private static SingletonPattern singletonPattern = new SingletonPattern();

    /**
     * 생성자를 private 로 선언하여 클래스 생성을 막음
     */
    private SingletonPattern() {
    }

    /**
     * get 메서드를 이용하여 객체를 반환하는 형식
     */
    public static SingletonPattern getInstance(){
        return singletonPattern;
    }


}
