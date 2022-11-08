package service;

import java.util.List;

public interface IService<T> {
    List<T> showAll();
    T findById(int id);
    boolean deleteById(int id, T t);
    boolean editById(int id, T t);

}
