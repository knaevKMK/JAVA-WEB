package com.exam.examandery01.service;


import com.exam.examandery01.model.services.ItemServiceModel;
import com.exam.examandery01.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    String add(ItemServiceModel map);

    ItemViewModel GetItemById(String id);

    List<ItemViewModel> getAll();

    void delete(String id);
}
