package com.atlaz.atlaz_biblioteca.application.usecase.book;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookUseCase {

    private final BookRepository bookRepository;

    public UpdateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(Long id, Book bookUpdate) {
        // busca um livro existente
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setBookCode(bookUpdate.getBookCode());
                    existingBook.setTitle(bookUpdate.getTitle());
                    existingBook.setAuthor(bookUpdate.getAuthor());
                    existingBook.setGenre(bookUpdate.getGenre());
                    existingBook.setImageId(bookUpdate.getImageId());
                    existingBook.setBookStatus(bookUpdate.getBookStatus());

                    //salva versão atualizada
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado"));
    }
}
