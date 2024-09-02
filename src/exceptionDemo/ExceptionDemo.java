package exceptionDemo;

public class ExceptionDemo {
    static boolean checkedTen(int ten){
        if(ten == 10){
            return true;
        }
        throw new NotTenException();
    }
    public static void main(String[] args) {
        // 1. 예외
        // 0으로 나누기
        try{
            int a = 5 / 0;
        } catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
            System.out.println(e);
        } finally {
            System.out.println("0으로 나누기 연습 종료");
        }

        // 배열 인덱스 초과
        int[] b = new int[1];
        try{
            b[3] = 1;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열 인덱스 초과 예외");
            System.out.println(e);
        } finally {
            System.out.println("배열 인덱스 초과 예외 연습 종료");
        }

        try{
            checkedTen(10);
            checkedTen(11);
        } catch (NotTenException e){
            System.out.println("10 이 아닙니다!!!");
            System.out.println(e);
        }

    }
}

class NotTenException extends RuntimeException{

}
