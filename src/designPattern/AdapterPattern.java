package designPattern;

public class AdapterPattern {
    public static void main(String[] args) {
        DoorMan doorMan = new DoorManProxy();
        TigerAdapter outerTiger = new TigerAdapter(new OuterTiger());
        doorMan.쫓아내(outerTiger);

    }
}


/**
 * OuterTiger 는 외부팀에서 만든 라이브러리 or 옛날에 만든 레거시 코드 라고 가정
 */
class OuterTiger {
    private final String fullName ="호랑이";

    public String getFullName() {
        return fullName;
    }
}

/**
 * 위의 OuterTiger 클래스를 수정한느것은 OCP 원칙에 위배되기 때문에
 * TigerAdapter 클래스를 생성
 */
class TigerAdapter extends Animal {
    private OuterTiger outerTiger;
    public TigerAdapter(OuterTiger outerTiger) {
        this.outerTiger = outerTiger;
    }

    @Override
    public String getName() {
        return outerTiger.getFullName();
    }
}
