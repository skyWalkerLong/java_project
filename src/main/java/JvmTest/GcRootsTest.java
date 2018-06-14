package JvmTest;

/**
 * GC ROOTS对象包含：
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象；
 * 2.方法区（jdk1.8替换为元空间）中的类静态属性引用的对象；
 * 3.方法区（jdk1.8替换为元空间）中常量（jdk1.8字符串常量移动到堆中）引用的对象；
 * 4.本地方法栈中JNI（即一般说的Native方法）中引用的对象
 * @author longchao
 * @date 2018/6/14.
 */
public class GcRootsTest {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static GcRootsTest t;

    public GcRootsTest(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        //大对象（长字符串和数组）直接进入老年代，t和t2直接进入老年代
        GcRootsTest t2 = new GcRootsTest(10 * _10MB);
        t2.t = new GcRootsTest(4 * _10MB);
        t2 = null;//t2=null，不再引用常量_10MB，会被回收
//        t = null;
        System.gc();
    }
/**
    [GC（停顿类型） (System.gc()) [PSYoungGen: 4373K（回收前年轻代内存占用）->1204K（回收后年轻代内存占用）(36352K（年轻代总内存）)] 147733K（回收前java堆内存占用）->144572K（回收后java堆内存占用）(222720K（java堆总内存）), 0.0021958 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [Full GC（停顿类型，stop the word） (System.gc()) [PSYoungGen（年轻代）: 1204K->0K(36352K)] [ParOldGen（老年代）: 143368K->42074K(186368K)] 144572K->42074K(222720K), [Metaspace（元空间）: 3531K->3531K(1056768K)], 0.0123274 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
    Heap
    PSYoungGen      total 36352K, used 312K [0x00000000d7c00000, 0x00000000da480000, 0x0000000100000000)
    eden space 31232K, 1% used [0x00000000d7c00000,0x00000000d7c4e2b8,0x00000000d9a80000)
    from space 5120K, 0% used [0x00000000d9a80000,0x00000000d9a80000,0x00000000d9f80000)
    to   space 5120K, 0% used [0x00000000d9f80000,0x00000000d9f80000,0x00000000da480000)
    ParOldGen       total 186368K, used 42074K [0x0000000087400000, 0x0000000092a00000, 0x00000000d7c00000)
    object space 186368K, 22% used [0x0000000087400000,0x0000000089d16960,0x0000000092a00000)
    Metaspace       used 3539K, capacity 4500K, committed 4864K, reserved 1056768K
    class space    used 390K, capacity 392K, committed 512K, reserved 1048576K
*/
}
