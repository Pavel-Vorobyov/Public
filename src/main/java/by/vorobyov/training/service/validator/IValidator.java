package by.vorobyov.training.service.validator;

public interface IValidator<E> {
    boolean checkEntity(E entity);
}
