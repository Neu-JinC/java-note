package book.jvm.chapter.two;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib创建动态class，使方法区出现内存溢出异常
 * VM Args: -Xms=10M -Xmx=10M -XX:HeapDumpOnOutOfMemoryError
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (Boolean.TRUE) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(Boolean.FALSE);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(object, args);
                }
            });
            enhancer.create();
        }
    }
}
