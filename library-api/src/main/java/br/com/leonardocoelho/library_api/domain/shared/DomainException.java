package br.com.leonardocoelho.library_api.domain.shared;

/**
 * Raised when a business rule (invariant) of the domain is violated.
 */
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
