package by.vorobyov.training.validator;

public interface IValidator<E> {
    boolean checkEntity(E entity);
}
