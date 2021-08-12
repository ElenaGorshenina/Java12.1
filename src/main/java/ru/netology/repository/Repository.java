package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    private Product[] items = new Product[0];
//    private Repository repository = new Repository();

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] findById(int id) {
        Product[] t = new Product[1];
        for (Product item : items) {
            if (item.getId() == id) {
                t[0] = item;
            }
        }
        return t;
    }

    public Product[] removeById(int id) {
//        if (repository.findById() = null) {
//            throw new NotFoundIdException("Element with id: " + id + " not found");
//        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        return items = tmp;
    }
}
