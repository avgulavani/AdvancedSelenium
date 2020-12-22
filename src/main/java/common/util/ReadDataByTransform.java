package common.util;

import java.util.Locale;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableTransformer;
import pageObjects.Book;

public class ReadDataByTransform implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(Book.class, new BookTableTransformer()));

	}

	  private static class BookTableTransformer implements TableTransformer<Book> {
		  @Override
	        public Book transform(DataTable table) throws Throwable {

					  Book book =new Book(null, null);
					  table.cells()
		              .stream()
		              .skip(1)        // Skip header row
		              .map(fields -> new Book(fields.get(0),fields.get(1)));
					return book;
					
		  }
	  }
	
}
