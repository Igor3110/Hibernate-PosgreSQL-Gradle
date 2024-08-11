package by.trofimov.hibernate.dto;

public record UserCreateDto(Integer id,
                            String firstName,
                            String lastName,
                            Integer age,
                            String company) {
}