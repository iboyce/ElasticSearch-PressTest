package es.oper;

import java.util.Scanner;

public class App 
{

    public static void main( String[] args )
    {
    	int num_Thd = 10;
        
        ThreadES esthreads[]= new ThreadES[num_Thd];
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入压力线程数(defalut:10)：");
        num_Thd = scanner.nextInt();
        
        while ( num_Thd == 0 )
        {
        	System.out.print("非法输入，请输入压力线程数(defalut:10)：");
        	num_Thd = scanner.nextInt();
        }
        
        System.out.print("线程数:"+ num_Thd + "开始压测。。。");
        
        long startTime=System.currentTimeMillis();
        
        /*单线程跑
        int i_docs= 2000;
        
        ESBase es1 = new ESBase();
        es1.init();
        es1.createIndex(i_docs);
        es1.close();
        、		*/
        for( int i = 0; i < num_Thd; i++)
        {
        	esthreads[i] = new ThreadES( String.valueOf(i) );
        	
        	esthreads[i].start();
        }
        
        //等待所有线程结束
        while (true)
        {
            if ( Thread.activeCount() == 1 ) break;
        }
        
        long endTime=System.currentTimeMillis(); 
        long spendTime=endTime-startTime;
        float speed = (float)((2000*num_Thd*1000)/spendTime);

        System.out.println("程序运行时间： "+spendTime+"ms"); 
        System.out.println("入索引速度： "+speed+"doc/s"); 
        
    }
}
