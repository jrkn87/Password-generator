package pl.passwordgenerator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

    private static final String str = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,r,s,t,u,w,v,x,y,z,1,2,3,4,5,6,7,8,9,0,!,@,#,$,%,^,&,*,(,)";
    private static final String[] alfabet = str.split(",");
    private static final Pattern pattern = Pattern.compile("[a-z]");

    private static Random rand = new Random();

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(0, 10);
        intStream.forEach(i -> System.out.println(generatePass()));
    }

    private static String toCaseCheck(String s) {
        String result = "";
        if (pattern.matcher(s).matches() && rand.nextBoolean())
            result = s.toUpperCase();
        else
            result = s;
        return result;
    }

    private static String generatePass() {
        String password = "";
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(alfabet.length);
            password += toCaseCheck(alfabet[x]);
        }
        return password;
    }
}
