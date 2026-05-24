package br.com.leonardocoelho.library_api.controller;

import br.com.leonardocoelho.library_api.book.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataBookRegistration data) {
        repository.save(new Book(data));

    }

    @GetMapping
    public Page<DataBookListing> list(@PageableDefault(size = 10, sort = {"title"}) Pageable pageable) {
        return repository.findAll(pageable).map(DataBookListing::new);
    }

    @PutMapping
    @Transactional
    public void update(@Valid @RequestBody DataBookUpdate data) {
        var book = repository.getReferenceById(data.id());
        book.updateInformation(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var book = repository.getReferenceById(id);
        repository.delete(book);
    }

}
