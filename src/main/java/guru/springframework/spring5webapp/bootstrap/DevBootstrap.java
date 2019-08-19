package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap( AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent contextRefreshedEvent ) {
        initData();
    }

    private void initData() {

        Publisher publisher=new Publisher();
        publisher.setName("Harper Collins");
        publisher.setAddress("4817 Sheboygan Ave");
        publisherRepository.save(publisher);
        //Shaw
        Author shaw = new Author("Shaw", "Wang");
        Book book1 = new Book("I Am Not Kind", "1112", publisher);
        shaw.getBooks().add(book1);
        book1.getAuthors().add(shaw);
        authorRepository.save(shaw);
        bookRepository.save(book1);


        //Dorothy
        Author dorothy = new Author("Dorothy", "Dong");
        Book book2 = new Book("I Am Not Cute", "0625", publisher);
        dorothy.getBooks().add(book2);
        book2.getAuthors().add(dorothy);
        authorRepository.save(dorothy);
        bookRepository.save(book2);
    }
}
