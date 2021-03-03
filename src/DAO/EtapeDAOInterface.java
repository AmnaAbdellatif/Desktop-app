package DAO;



/**
 *
 * @author hp
 * @param <T>
 */
public interface EtapeDAOInterface<T> {
    public void insert(T t);
    public void delete (T t);
    public void update (T t);
   
}
