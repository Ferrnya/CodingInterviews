package chapter2;

public class P32_singleton {
	private volatile static P32_singleton singletonInstance;
	private P32_singleton(){
		
	}
	public static P32_singleton getSingletonInstance() {
		if (singletonInstance==null) {
			synchronized(P32_singleton.class) {
				if (singletonInstance==null) {
					singletonInstance = new P32_singleton();
				}
			}
		}
		return singletonInstance;
	}

}
