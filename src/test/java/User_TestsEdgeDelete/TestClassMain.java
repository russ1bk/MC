package User_TestsEdgeDelete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestClassMain {
    static int a=10;
    int b=20;

    static void m1(){System.out.println("this is m1");}
    void m2(){System.out.println("this is m2");}


    public static void main() {
        WebDriver driver = new ChromeDriver();

        Actions nact = new Actions(driver);

    }
 /*   void main(int x){System.out.println(x);}
    void main(String s){System.out.println(s);}
    void main(double d1,double d2){System.out.println(d1+d2);}

    @Test
    public  static void main()
    {
        TestClassMain ov = new TestClassMain();
        ov.main(100);
        ov.main("Ruslan");
        ov.main(3.5,8.22);
*/
    }

 /*   private int a;
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private String b;
@Test
    public  static void main(){
        int a[]={10,20,30,40,50};
        int element =30;
        boolean status= false;
        for(int x:a)
        {
            if (x==element) {
                System.out.println("element found");
                status=true;
                break;
            }
        }
        if(status==false) {
            System.out.println("element not found");
        }
    }
    @Test
    public static void test2(){
    String s="ruslan_mishiyev@globetax.com";
    String Change= s.replace("_","");
    System.out.println(Change);
    String arr1[] =Change.split("@");
     for (String Change1:arr1){
         System.out.println(Change1);

     }
}
    @Test
    void test3(){
    TestClass stu1=new TestClass();
    stu1.a=100;
    stu1.b="test";

    }
    @Test
    TestClass(int id, String name);
    {
        a = id;
        b= name;
    }
*/





