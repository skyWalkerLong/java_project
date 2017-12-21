package MultiThread;

/**
 * @Author longchao
 * @Date 2017/12/19.
 */
public class MyThread extends Thread {

    private String name;
    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println("name="+name+currentThread());
    }
}
