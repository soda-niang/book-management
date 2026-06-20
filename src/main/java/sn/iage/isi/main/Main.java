package sn.iage.isi.main;

import sn.iage.isi.entities.Category;
import sn.iage.isi.repositories.CategoryRepository;
import sn.iage.isi.entities.Book;
import sn.iage.isi.repositories.BookRepository;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        for (Category c : categoryRepository.search("nou")){
            System.out.println(c);
        }

        BookRepository bookRepository = new BookRepository();

        // createBook
        Book book = new Book();
        book.setTitle("Une si longue lettre");
        book.setAuthor("Mariama Bâ");
        book.setPublicationYear(1979);
        book.setCountPages(160);

        Book createdBook = bookRepository.createBook(book);
        System.out.println("createBook -> " + createdBook);

        // findBookById
        Book foundById = bookRepository.findBookById(createdBook.getId());
        System.out.println("findBookById -> " + foundById);

        // findBookByIsbn
        Book foundByIsbn = bookRepository.findBookByIsbn(createdBook.getIsbn());
        System.out.println("findBookByIsbn -> " + foundByIsbn);

        // updateBook
        Book newData = new Book();
        newData.setTitle("Une si longue lettre (édition revue)");
        newData.setAuthor("Mariama Bâ");
        newData.setPublicationYear(1980);
        newData.setCountPages(170);

        Book updatedBook = bookRepository.updateBook(createdBook.getId(), newData);
        System.out.println("updateBook -> " + updatedBook);

        // listBooksByCategory (probablement vide tant qu'on n'assigne pas de catégorie)
        List<Book> booksInCategory = bookRepository.listBooksByCategory("Roman");
        System.out.println("listBooksByCategory -> " + booksInCategory);

        // searchBooksByTitle
        List<Book> byTitle = bookRepository.searchBooksByTitle("longue");
        System.out.println("searchBooksByTitle -> " + byTitle);

        // searchBooksByAuthor
        List<Book> byAuthor = bookRepository.searchBooksByAuthor("Mariama");
        System.out.println("searchBooksByAuthor -> " + byAuthor);

        // searchBooksAfterYear
        List<Book> afterYear = bookRepository.searchBooksAfterYear(1975);
        System.out.println("searchBooksAfterYear -> " + afterYear);

        // countBooksByCategory
        List<Object[]> countByCategory = bookRepository.countBooksByCategory();
        System.out.println("countBooksByCategory -> " + countByCategory);

        // countAllBooks
        int total = bookRepository.countAllBooks();
        System.out.println("countAllBooks -> " + total);

        // deleteBook
        bookRepository.deleteBook(createdBook.getId());
        System.out.println("deleteBook -> livre supprimé (id " + createdBook.getId() + ")");

        // vérification finale
        int totalApresSuppression = bookRepository.countAllBooks();
        System.out.println("countAllBooks après suppression -> " + totalApresSuppression);
    }
}