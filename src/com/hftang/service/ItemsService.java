package com.hftang.service;

import com.hftang.pojo.Items;

import java.util.List;

public interface ItemsService {
    List<Items> list() throws Exception;

    Items findItemById(int i);

    void updateItems(Items items);
}
