package br.com.leonardocoelho.library_api.application.book;

public record PublisherCommand(String name, String country, Integer foundationYear) {
}
