import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试
 * </p >
 *
 * @author Long Chao
 * @version 1.0
 * @date 2018/10/29
 */
public class Test2 {
    private static ExecutorService executorService = new ThreadPoolExecutor(5,20,60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));

    private Long time1 = System.currentTimeMillis();
    private static Long time2 = System.currentTimeMillis();

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //TestPO t = new TestPO(null, null);
        //System.out.println(t.getName() + "------" + t.getValue());
        //Map<String, String> map = Maps.newHashMap();
        //map.put("22", "22");
        //String a = map.get("22") == null ? "3" : map.get("22");
        //System.out.println(a);
        //
        //Map<ImmutablePair<String, String>, String> map2 = Maps.newHashMap();
        //ImmutablePair<String, String> immutablePair = new ImmutablePair("null", null);
        //System.out.println("is null ? :" + (immutablePair == null));
        //map2.put(immutablePair, "3434");
        //Iterator mapIter = map2.entrySet().iterator();
        //while (mapIter.hasNext()) {
        //    Map.Entry entry = (Map.Entry) mapIter.next();
        //    ImmutablePair rr = (ImmutablePair) entry.getKey();
        //    String p = (String) rr.getRight();
        //    String q = (String) rr.getLeft();
        //    System.out.println(p + "----" + q + "---" + entry.getValue());
        //}
        //map2.put(null, "212");
        //System.out.println(map2.size());
        //map2.remove(immutablePair);
        //map2.remove(null);
        //map.put("33",null);
        //System.out.println(map2.size());
        //
        //
        //Map<String, List<Long>> map3 = Maps.newHashMap();
        //System.out.println("IIIII"+ map3.size());
        //for (Map.Entry<String, List<Long>> i : map3.entrySet()) {
        //    List<Long> replysIds = i.getValue();
        //    System.out.println("----" + replysIds);
        //}
        //List<TestPO1> list = Lists.newArrayList();
        //for(TestPO1 r : list) {
        //    System.out.println(r);
        //}
        //
        ////executorService.execute(new Runnable() {
        ////    @Override
        ////    public void run() {
        ////        String hh = null;
        ////        System.out.println(hh.equals("33"));
        ////    }
        ////});
        //try{
        //    try{
        //        String jj = null;
        //        System.out.println(jj.equals("e"));
        //    } catch (Exception e){
        //        //e.printStackTrace();
        //    }
        //} catch (Exception e) {
        //    System.out.println("+++++" + e);
        //}
        //
        //
        //Set<Long> itemsInDb = new HashSet<>();
        //
        //System.out.println("------"+ itemsInDb.contains(3L));
        //
        //Long hhh = 98738478374L;
        //String nnn = String.valueOf(hhh);
        //System.out.println(String.valueOf(nnn));
        //
        //System.out.println(1%1000);
        //
        //
        //TestPO testPO = new TestPO();
        //testPO.setValue(2);
        //System.out.println(testPO.getValue());
        //TestPO ttttt = new TestPO();
        //BeanUtils.copyProperties(ttttt,testPO);
        //System.out.println(ttttt.getValue()+ttttt.getName());
        //ttttt.setValue(3);
        //System.out.println(ttttt.getValue()+ttttt.getName());
        //
        //System.out.println(testPO.getValue());

        List<TestPO> list = new ArrayList<TestPO>();
        list.add(new TestPO("lc",2));
        list.add(new TestPO("ll",3));
        for(final TestPO l : list) {
            l.setValue(22);
            System.out.println(l.getValue());
        }
        System.out.println(System.currentTimeMillis());

        //final TestPO testPO1 = new TestPO("lc",2);
        //TestPO testPO2 = new TestPO("ll",3);
        //testPO1 = testPO2; //不能为final修饰的引用再次分配值
        //testPO2 = testPO1; //普通引用可以指向final修饰的引用

        //JSONObject jsonObject = new JSONObject();
        //jsonObject.put("isLogin",Boolean.TRUE);
        //System.out.println(jsonObject.getBoolean("isLogin") == Boolean.FALSE);
        //System.out.println(jsonObject.getString("3e"));

        //try {
        //    Thread.sleep(3000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //
        //System.out.println(new Test2().time1+"=="+System.currentTimeMillis()+"=="+time2);

        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("name","zhangsan");
        jsonObject.put("value",20);
        jsonObject.put("age",11);
        System.out.println(jsonObject.toJSONString());
        TestPO testPO = JSONObject.parseObject(jsonObject.toJSONString(),TestPO.class);
        System.out.println(testPO.getName()+"--"+testPO.getValue());

        System.out.println(Runtime.getRuntime().availableProcessors());

        for(int i=0;i<60;i++) {
            System.out.print(i+",");
        }

    }




}
