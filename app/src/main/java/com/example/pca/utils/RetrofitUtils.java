package com.example.pca.utils;

import com.example.pca.interfaces.net.ApiService;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.interfaces.net.INetWorkInterface;
import com.example.pca.model.data.BannerBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.example.pca.interfaces.net.URLConstant.BASEURL;

public class RetrofitUtils implements INetWorkInterface {
    private static RetrofitUtils retrofitUtils;
    private ApiService apiService;
    public static RetrofitUtils getInstant(){
        if(retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils == null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public RetrofitUtils() {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(BASEURL).build();
        this.apiService = retrofit.create(ApiService.class);
    }

    @Override
    public <T> void get(String url, INetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BannerBean bannerBean) {
                        
                        callBack.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
