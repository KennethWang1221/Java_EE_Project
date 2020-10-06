package cart.test;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
	static {
		books.put("1", new Book("1","Java���˼��",65.8f));
		books.put("2", new Book("2","Java���ļ���",98.6f));
		books.put("3", new Book("3","Java Web����",78.8f));
		books.put("4", new Book("4","��׿������ȫ",56.8f));
		books.put("5", new Book("5","C#������ȫ",48.5f));
		books.put("6", new Book("6",".NET��������",56.5f));
	}
	
	public static Collection<Book> getAll(){
		return books.values();
	}
	
	public static Book getBook(String id){
		return books.get(id);
	}
	
}
