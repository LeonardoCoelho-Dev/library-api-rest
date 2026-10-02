package br.com.leonardocoelho.library_api.interfaces.book;

import br.com.leonardocoelho.library_api.application.book.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public void register(@RequestBody @Valid DataBookRegistration data) {
        service.register(data.toCommand());
    }

    @GetMapping
    public Page<DataBookListing> list(@PageableDefault(size = 10, sort = {"title"}) Pageable pageable) {
        return service.list(pageable).map(DataBookListing::new);
    }

    @PutMapping
    public void update(@Valid @RequestBody DataBookUpdate data) {
        service.update(data.toCommand());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
