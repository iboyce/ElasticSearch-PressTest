package es.oper;

public class ThreadES extends Thread {
	
	private String name;
    public ThreadES(String name) {
       this.name=name;
    }
    
    
    /*
	public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
	}
	*/
    
    public void run()
    {
    	int i_docs= 2000;
        
        ESBase es1 = new ESBase();
        es1.init();
        es1.createIndex(i_docs);
        es1.close();
    }
    

}
