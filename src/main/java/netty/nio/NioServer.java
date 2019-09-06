package netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * nio服务端
 *
 * 对于bio来说，每来一个socket连接，服务端都要创建一个线程来维护这个连接，如果有一万个客户端请求服务端，就有一万个连接，服务端就要维护一万个线程，
 * 这些连接建立后，不一定一直有数据流通，所以这些线程很多都一直while循环检查是否有数据可读，浪费系统资源
 *
 * nio中，只需要两个线程就可以解决，其中一个轮询检查是否有新连接，另一个轮询检查当前连接是否有数据可读；
 * 第一个while循环，每来一个socket连接，都注册到selectorA上；
 * 第二个循环，轮询检查selectorA上的连接是否有数据可读，可读就创建线程操作该连接
 *
 * 所以nio相比bio，能大量减少无用线程开销，减少cpu空循环的开销，减少线程切换带来cpu上下文切换，提高处理速度
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-09-06
 */
public class NioServer {
    public static void main(String[] args) throws Exception {

        //轮询检查是否有新的连接
        Selector serverSelector = Selector.open();

        //轮询检查是否有数据可读
        Selector clientSelector = Selector.open();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                    serverSocketChannel.socket().bind(new InetSocketAddress(8080));
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                    while (true) {
                        //轮询监测是否有新的连接
                        if (serverSelector.select(1) > 0) {
                            Set<SelectionKey> selectionKeys = serverSelector.selectedKeys();
                            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                            while (keyIterator.hasNext()) {
                                SelectionKey selectionKey = keyIterator.next();
                                if (selectionKey.isAcceptable()) {
                                    try {
                                        //每来一个新连接不需要创建一个线程而是直接注册到clientSelector
                                        SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                                        socketChannel.configureBlocking(false);
                                        socketChannel.register(clientSelector, SelectionKey.OP_READ);
                                    } finally {
                                        keyIterator.remove();
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {

                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        //轮询是否有数据可读
                        if (clientSelector.select(1) > 0) {
                            Set<SelectionKey> selectionKeys = clientSelector.selectedKeys();
                            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                            while (keyIterator.hasNext()) {
                                SelectionKey selectionKey = keyIterator.next();
                                if (selectionKey.isReadable()) {
                                    try {
                                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                        //读取数据以块为单位，效率高于按字节流读取
                                        socketChannel.read(byteBuffer);
                                        byteBuffer.flip();
                                        System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                    } finally {
                                        keyIterator.remove();
                                        selectionKey.interestOps(SelectionKey.OP_READ);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {

                }
            }
        }).start();
    }
}
