package com.alibaba.dubbo.rpc.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * Author: 游锋锋
 * Time: 2017-08-05 15:42
 * Copyright (C) 2017 Xiamen Yaxon Networks CO.,LTD.
 */
@Activate(group = {Constants.PROVIDER})
public class AsyncFilter implements Filter{
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext.getContext().getAttachments().remove(Constants.ASYNC_KEY);
        return invoker.invoke(invocation);
    }
}
