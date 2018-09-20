package com.hftang.service;

import com.hftang.dao.ItemsMapper;
import com.hftang.pojo.Items;
import com.hftang.pojo.ItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;


    @Override
    public List<Items> list() throws Exception {

        ItemsExample example = new ItemsExample();
        List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public Items findItemById(int id) {

        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItems(Items items) {
        int i = itemsMapper.updateByPrimaryKeyWithBLOBs(items);

        System.out.print(i);


    }
}
