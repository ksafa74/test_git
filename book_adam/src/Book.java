import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {

    private String book_Id;
    private String book_name;
    private String book_Author;
    private String book_Catagory;

    public Book(String book_Id, String book_name, String book_Author, String book_Catagory) {
        this.book_Id = book_Id;
        this.book_name = book_name;
        this.book_Author = book_Author;
        this.book_Catagory = book_Catagory;
    }

    public String getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(String book_Id) {
        this.book_Id = book_Id;
    }


    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_Author() {
        return book_Author;
    }

    public void setBook_Author(String book_Author) {
        this.book_Author = book_Author;
    }

    public String getBook_Catagory() {
        return book_Catagory;
    }

    public void setBook_Catagory(String book_Catagory) {
        this.book_Catagory = book_Catagory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_Id=" + book_Id +
                ", book_name='" + book_name + '\'' +
                ", book_Author='" + book_Author + '\'' +
                ", book_Catagory='" + book_Catagory + '\'' +
                '}';
    }
}
     class Library
    {
        private static List<Book> books = new ArrayList<>();

        //static block to load the book file
        static
        {
            try
            {
                load_books_from_file("/Users/safamac/ideaprojects/book_adam/src/Books.txt");
            } catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }




        private static void load_books_from_file (String filename) throws FileNotFoundException
        {
            Scanner scanner = new Scanner(new File(filename));
            if(scanner.hasNextLine())
            {
                scanner.nextLine();
            }

            while (scanner.hasNextLine())
            {

                //String line = scanner.nextLine();
                String id = scanner.nextLine().trim();
                if(id.isEmpty())
                    break;

                String name = scanner.nextLine().trim();
                String author = scanner.nextLine().trim();
                String category = scanner.nextLine().trim();
                books.add(new Book(id, name, author, category));
            }
            scanner.close();
            System.out.println(books.toArray().length);



        }

        //for getting the book info by id
        public static Book getBookID (int a)
        {
            for (Book each : books)
            {
                if (each.getBook_Id().equals(Integer.toString(a)) )
                    return each;
            }
            return null;

        }

        public static void testLibrary()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please Enter the book id");
            int bookId = scanner.nextInt();
        }

        public static void totalBooks()
        {
            System.out.println(books.size());
        }


        public static void main(String[] args) {

            System.out.println(Library.getBookID(1));

        }

    }




