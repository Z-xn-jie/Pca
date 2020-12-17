package com.example.pca.interfaces.net;

public interface INetWorkInterface {
    <T> void get(String url,INetCallBack<T> callBack);
}
