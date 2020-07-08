package hackerrank.easy;

public class timeconversion {
    String timeConversion(String str) {
        if(str.equals("12:00:00AM"))return "00:00:00";
        if(str.equals("12:00:00PM"))return "12:00:00";

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length()-2;i++)
            ans.append(str.charAt(i));

        if(str.charAt(8)=='A'){
            int lsb=(int)(str.charAt(1)-'0');
            int msb=(int)(str.charAt(0)-'0');
            int num=(msb*10)+lsb;
            if(num==12) {
                num -= 12;
                msb = num / 10;
                lsb = num % 10;
                ans.setCharAt(0, (char) (msb + '0'));
                ans.setCharAt(1, (char) (lsb + '0'));
            }
        }
        if(str.charAt(8)=='P'){
            int lsb=(int)(str.charAt(1)-'0');
            int msb=(int)(str.charAt(0)-'0');
            int num=(msb*10)+lsb;
            if(num!=12) {
                num += 12;
                msb = num / 10;
                lsb = num % 10;
                ans.setCharAt(0, (char) (msb + '0'));
                ans.setCharAt(1, (char) (lsb + '0'));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        timeconversion obj=new timeconversion();
        System.out.println(obj.timeConversion("12:30:00PM"));
//        System.out.println(obj.timeConversion("01:00:00PM"));
    }
}
