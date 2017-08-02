package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangchun on 2017/3/9.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public TbItem getItemById(long itemId) {

        //TbItem item = itemMapper.selectByPrimaryKey(itemId);
        //添加查询条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            TbItem item = list.get(0);
            return item;
        }
        return null;
    }

    @Override
    public EUDataGridResult getItemList(int page, int row){
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(page, row);
        List<TbItem> list = itemMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult addItem(TbItem item, String desc, String itemParam) {
        try {
            //生成商品id
            //可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
            Long itemId = IDUtils.genItemId();
            //补全不完整的字段
            item.setId(itemId);
            item.setStatus((byte) 1);
            Date date = new Date();
            item.setCreated(date);
            item.setUpdated(date);
            //把数据插入到商品表
            itemMapper.insert(item);

            //把数据插入到商品描述表
            insertItemDesc(itemId, desc);
            //商品规格数据
            insetItemParamItem(itemId, itemParam);

        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "商品添加错误");
        }

        return TaotaoResult.ok();

    }

    @Override
    public TaotaoResult insertItemDesc(long itemId, String desc){
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setCreated(new Date());
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        itemDesc.setItemId(itemId);
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insetItemParamItem(long itemId, String itemParam){
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setCreated(new Date());
        itemParamItem.setParamData(itemParam);
        itemParamItem.setUpdated(new Date());
        itemParamItem.setItemId(itemId);
        itemParamItemMapper.insert(itemParamItem);
        return TaotaoResult.ok();
    }


}

