package coreTechCode.equals;

import java.util.Objects;

/**
 * @author longchao
 * @date 2018/2/11.
 */
public class Car {

    /**
     * 车辆生产批次
     */
    private int batch;

    public Car(int batch) {
        this.batch = batch;
    }

    /**
     * 希望同一批次即相等：equals方法为true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            //obj 是否是Car的一个实例
            if (obj instanceof Car) {
                return ((Car) obj).batch == this.batch;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(batch);
    }

    public static void main(String[] args) {
        Car e1 = new Car(1);
        Car e2 = new Car(1);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode() + "  " +e2.hashCode());
    }
}
