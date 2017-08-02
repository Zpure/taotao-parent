package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by zhangchun on 2017/4/6.
 */
public interface ItemParamService {
    public EUDataGridResult getItemParamList(int page, int rows);

    public TaotaoResult getItemParamByCid(long cid);

    public TaotaoResult addItemParam(TbItemParam itemParam);
}
