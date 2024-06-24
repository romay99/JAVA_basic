package designPattern;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        Teacher teacher = new JavaTeacher();
        teacher.수업시작();
    }
}


abstract class Teacher{
    private void 입장하기() {
        System.out.println("쌤 입장");
    }
    private void 출석부르기() {
        System.out.println("출석 부르기");
    }

    // 정의되지 않은 메서드는 자식 클래스에게 미룬다.
    abstract void 강의하기();

    private void 퇴장하기() {
        System.out.println("쌤 퇴장");
    }

    public void 수업시작() {
        입장하기();
        출석부르기();
        강의하기();
        퇴장하기();
    }
}

class JavaTeacher extends Teacher{
    // 재정의하기
    void 강의하기() {
        System.out.println("JAVA 강의하기");
    }
}