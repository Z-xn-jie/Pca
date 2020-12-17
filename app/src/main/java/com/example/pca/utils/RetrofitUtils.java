package com.example.pca.utils;

import com.example.pca.interfaces.net.ApiService;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.interfaces.net.INetWorkInterface;
import com.example.pca.interfaces.net.URLConstant;
import com.example.pca.model.data.BannerBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
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
        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(URLConstant.BASEURL).build();
        this.apiService = retrofit.create(ApiService.class);
    }

    @Override
    public <T> void get(String url, INetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, t);
                            callBack.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
