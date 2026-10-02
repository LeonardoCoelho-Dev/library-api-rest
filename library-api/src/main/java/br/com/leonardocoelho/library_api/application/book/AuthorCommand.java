package br.com.leonardocoelho.library_api.application.book;

public record AuthorCommand(String name, Integer age, Integer birthYear, String country) {
}
