package com.example.pca.interfaces.net;

import com.example.pca.model.data.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET
    Observable<BannerBean> get(String url);
}
