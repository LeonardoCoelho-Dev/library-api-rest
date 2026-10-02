package br.com.leonardocoelho.library_api.domain.shared;

/**
 * Guard clauses used by entities and value objects to protect their invariants.
 */
public final class Guard {

    private Guard() {
    }

    public static <T> T notNull(T value, String field) {
        if (value == null) {
            throw new DomainException(field + " must not be null");
        }
        return value;
    }

    public static String notBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new DomainException(field + " must not be blank");
        }
        return value;
    }

    public static Integer inRange(Integer value, int min, int max, String field) {
        notNull(value, field);
        if (value < min || value > max) {
            throw new DomainException(field + " must be between " + min + " and " + max);
        }
        return value;
    }
}
