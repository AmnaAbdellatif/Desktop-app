package DAO;



/**
 *
 * @author hp
 * @param <T>
 */
public interface SousVariantDAOInterface<T> {
    public void insert(T t);
    public void delete (T t);
    public void update (T t);
   
}
