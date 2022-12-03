import java.awt.print.Book;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepository implements IRepository<Book> {
        @Override
        public ArrayList<Book> all() {
            ArrayList<Book> ls = new ArrayList<>();
            try {
                Connector connector = Connector.getInstance();
                String sql = "select * from book";
                ResultSet rs = connector.query(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    int price = rs.getInt("price");
                    Book s = new Book(id, name, author, price);
                    ls.add(s);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return ls;
        }

