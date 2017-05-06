package algorithm;

/**
 * @author jiseonoh
 */
class ReverseString {
    public void reverseString(String input) {
        for(int i=(input.length()-1); i>=0; i--) {
            System.out.println(input.charAt(i));
        }
    }
    public void reverseBuffer(String input) {
        // 버퍼 생성
        StringBuffer stringBuffer = new StringBuffer();
        // 버퍼에 변환할 문자열을 넣고,
        stringBuffer.append(input);
        // 버퍼 안의 reverse()를 이용해 거꾸로 출력.
        System.out.print(stringBuffer.reverse());
    }
}
