package cn.yangjian.rpc.client.proxy;

import cn.yangjian.rpc.client.RPCFuture;

public interface IAsyncObjectProxy {
    public RPCFuture call(String funcName, Object... args);
}
