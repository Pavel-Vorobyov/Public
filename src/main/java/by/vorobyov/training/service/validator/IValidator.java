package by.vorobyov.training.service.validator;

/**
 * Interface for validator that describes
 * method
 *
 * @param <E> a type of some entity.
 */
public interface IValidator<E> {
    /**
     * Gets an entity that contains parameters.
     *
     *
     * @param entity
     * @return
     */
    boolean checkEntity(E entity);
}
