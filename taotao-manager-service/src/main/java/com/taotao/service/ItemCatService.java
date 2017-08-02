package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by zhangchun on 2017/3/28.
 */
public interface ItemCatService {
    public List<EUTreeNode> getItemCatList(long parentId);
}
