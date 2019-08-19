package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap( AuthorRepository authorRepository, BookRepository bookRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void onApplicationEvent( ContextRefreshedEvent contextRefreshedEvent ) {
        initData();
    }

    private void initData() {

        //Shaw
        Author shaw = new Author("Shaw", "Wang");
        Book book1 = new Book("I Am Not Kind", "1112", "Harper Collins");
        shaw.getBooks().add(book1);
        book1.getAuthors().add(shaw);
        authorRepository.save(shaw);
        bookRepository.save(book1);

        //Dorothy
        Author dorothy = new Author("Dorothy", "Dong");
        Book book2 = new Book("I Am Not Cute", "0625", "Harper Collins");
        dorothy.getBooks().add(book2);
        book2.getAuthors().add(dorothy);
        authorRepository.save(dorothy);
        bookRepository.save(book2);
    }
}
