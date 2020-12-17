package com.example.pca.interfaces.net;

public interface INetCallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
