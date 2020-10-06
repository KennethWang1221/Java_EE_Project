package cart.test;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
	static {
		books.put("1", new Book("1","Java编程思想",65.8f));
		books.put("2", new Book("2","Java核心技术",98.6f));
		books.put("3", new Book("3","Java Web开发",78.8f));
		books.put("4", new Book("4","安卓技术大全",56.8f));
		books.put("5", new Book("5","C#案例大全",48.5f));
		books.put("6", new Book("6",".NET开发技术",56.5f));
	}
	
	public static Collection<Book> getAll(){
		return books.values();
	}
	
	public static Book getBook(String id){
		return books.get(id);
	}
	
}
