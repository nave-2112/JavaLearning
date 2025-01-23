import java.util.ArrayList;
import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;  
    }

    
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently unavailable.");
        }
    }

    public void returnBook() {
        if (isAvailable=false) {
            isAvailable = true;
            System.out.println("You have successfully returned: " + title);
        } else {
            System.out.println("The book \"" + title + "\" was not borrowed.");
        }
    }

    public void displayDetails() {
        String availability = isAvailable ? "Available" : "Not Available";
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + availability);
        System.out.println("--------------------------");
    }

    public String getTitle() {
        return title;
    }


    public String getISBN() {
        return ISBN;
    }

 
    public boolean isAvailable() {
        return isAvailable;
    }
}


class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        boolean found = false;
        System.out.println("Available books in the library:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    public void borrowBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in the library.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in the library.");
    }


    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("Moby Dick", "Herman Melville", "9781503280786"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Search a book by title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book you want to borrow: ");
                    String borrowISBN = sc.nextLine();
                    library.borrowBook(borrowISBN);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book you want to return: ");
                    String returnISBN = sc.nextLine();
                    library.returnBook(returnISBN);
                    break;
                case 4:
                    System.out.print("Enter the title of the book you want to search: ");
                    String title = sc.nextLine();
                    Book foundBook = library.searchBookByTitle(title);
                    if (foundBook != null) {
                        foundBook.displayDetails();
                    } else {
                        System.out.println("Book with title \"" + title + "\" not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}