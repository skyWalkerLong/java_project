package MultiThread;

/**
 * @Author longchao
 * @Date 2017/12/19.
 */
public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name=name;
    }
    @Override
    public void run(){
        System.out.println("name="+name+Thread.currentThread());
    }
}
