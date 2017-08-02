package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

/**
 * Created by zhangchun on 2017/3/9.
 */
public interface ItemService {
    public TbItem getItemById(long itemId);

    public EUDataGridResult getItemList(int page, int rows);

    public TaotaoResult addItem(TbItem item, String desc, String itemParam);

    public TaotaoResult insetItemParamItem(long itemId, String itemParam);

    public TaotaoResult insertItemDesc(long itemId, String desc);

}
