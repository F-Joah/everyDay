package com.joah.everyday.N2020.N202001.N20200119.springMvc.servlet;

import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomController;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomRequestMapping;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomService;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.controller.MyController;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.handlerAdapter.HandlerAdapterService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Joah
 * @time 2020/1/19 13:48
 */
@Slf4j
public class DispatcherServlet extends HttpServlet {

    // 存储当前加载的所有的类
    List<String> classNames = new ArrayList<>();

    // 存储IOC容器的map
    Map<String,Object> beans = new HashMap<>();

    // 存储路径和方法的映射关系
    Map<String,Object> handlerMap = new HashMap<>();

    public DispatcherServlet() {

        System.out.println("DispatcherServlet()......");
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        System.out.println("init()......");

        // 1、扫描需要实例化的类
        doScanPackage("com.joah.everyday.N20200119.springMvc");
        System.out.println("当前文件下的Class类...");
        classNames.forEach(System.out::println);

        // 2、实例化
        doInstance();
        System.out.println("当前实例化的对象是...");
        for (Map.Entry<String,Object> map : beans.entrySet()){
            System.out.println("key:" + map.getKey() + ";value:" + map.getValue());
        }

        // 3、将IOC 容器中的service对象设置给controller层定义的 field 上
        doIOC();

        // 4、建立path和method的映射关系
        handlerMapping();
        System.out.println("Controller 层的path和方法映射...");
        for (Map.Entry<String, Object> map : handlerMap.entrySet()){
            System.out.println("key:" + map.getKey() + "; value:" + map.getValue());
        }
    }


    /**
     * 扫描需要实例化的类
     * @param basePackage
     */
    private void doScanPackage(String basePackage) {
        URL resource = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.","/"));
        String fileStr = resource.getFile();
        File file = new File(fileStr);
        String[] listFiles = file.list();
        for (String path : listFiles){
            File filePath = new File(fileStr + path);
            // 如果是当前目录，则 递归
            if (filePath.isDirectory()){
                doScanPackage(basePackage + "." + path);
            } else {
                // 如果是文件 则添加到 classNames
                classNames.add(basePackage + "." + filePath.getName());
            }
        }
    }

    /**
     * 实例化
     * 通过存储的 classNames 的类字符串来反射实例化对象，并存储与beans的Map中
     */
    private void doInstance() {
        if (classNames.isEmpty()){
            System.out.println("doInstance fail...");
        }

        for (String className : classNames){
            String cn = className.replaceAll(".class","");

            try {
                Class<?> clazz = Class.forName(cn);
                // 判断当前类是否有注解 @CustomController 类，获取设置的 CustomRequestMapping 的值
                if (clazz.isAnnotationPresent(CustomController.class)){
                    // 通过 CustomRequestMapping 获取值，作为 beans 的 key
                    CustomRequestMapping requestMapping = clazz.getAnnotation(CustomRequestMapping.class);
                    String key = requestMapping.value();
                    // beans 的 value 为实例化的对象
                    Object value = clazz.newInstance();
                    beans.put(key, value);
                    // 判断当前类注解是否有 @CustomService 类（考虑Service层），获取值
                }else if (clazz.isAnnotationPresent(CustomService.class)){
                    // 通过 CustomService 获取值，作为 beans 的 key
                    CustomService customService = clazz.getAnnotation(CustomService.class);
                    String key = customService.value();
                    // beans 的 value 为实例化的对象
                    Object value = clazz.newInstance();
                    beans.put(key, value);
                }else {
                    continue;
                }

            } catch (ClassNotFoundException e) {
                log.error(e.getMessage());
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                log.error(e.getMessage());
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                log.error(e.getMessage());
            }
        }
    }

    /**
     *  将IOC 容器中的service对象设置给controller层定义的 field 上
     */
    private void doIOC() {
        if (beans.isEmpty()){
            System.out.println("no class is instance...");
            return;
        }

        for (Map.Entry<String, Object> map : beans.entrySet()){
            // 获取实例
            Object instance = map.getValue();
            // 获取类
            Class<?> clazz = instance.getClass();
            // 如果当前是 CustomController 类，则获取类中定义的 field 来设置其对象
            if (clazz.isAnnotationPresent(CustomController.class)){

            }
        }
    }

    /**
     *  建立path和method的映射关系
     */
    private void handlerMapping() {

        if (beans.isEmpty()){
            System.out.println("no class is instance...");
            return;
        }
        for (Map.Entry<String, Object> map : beans.entrySet()){
            // 获取当前的对象
            Object instance = map.getValue();
            // 获取当前类
            Class<?> clazz = instance.getClass();
            // 获取当前 @CustomController 的类
            if (clazz.isAnnotationPresent(CustomController.class)){
                // 获取类上的路径
                CustomRequestMapping clazzRm = clazz.getAnnotation(CustomRequestMapping.class);
                String clazzPath = clazzRm.value();
                // 处理方法
                Method[] methods = clazz.getMethods();
                for (Method method : methods){
                    // 判断注解为 RequestMapping
                    if (method.isAnnotationPresent(CustomRequestMapping.class)){
                        // 获取方法的路径
                        CustomRequestMapping methodRm = method.getAnnotation(CustomRequestMapping.class);
                        String methodPath = methodRm.value();
                        // 将 类上的路径 + 方法上的路径 设置为 key ,方法设置成 value
                        handlerMap.put(clazzPath + methodPath, method);
                    }else {
                        continue;
                    }
                }
            }else {
                continue;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()...");
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("doPost()...");
        // 通过 request 获取 uri / maven_handMvc / custom / query
        String uri = request.getRequestURI();
        // maven_handMvc
        String context = request.getContextPath();
        String path = uri.replaceAll(context, "");
        // 通过当前的 path 获取 handlerMap 的方法名
        Method method = (Method) handlerMap.get(path);
        // 获取 beans 容器中的 bean
        MyController instance = (MyController) beans.get("/" + path.split("/")[1]);
        // 处理参数
        HandlerAdapterService ha = (HandlerAdapterService) beans.get("customHandlerAdapter");
        Object[] args = ha.handle(request, response, method, beans);

        try {
            method.invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy(){
        System.out.println("destroy()...");
    }

}
