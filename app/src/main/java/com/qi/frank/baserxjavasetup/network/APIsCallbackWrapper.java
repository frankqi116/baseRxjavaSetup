package com.qi.frank.baserxjavasetup.network;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.qi.frank.baserxjavasetup.base.BaseView;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

public abstract class APIsCallbackWrapper<T extends Response> extends DisposableObserver<T> {

    private static final String TAG = "APIsCallbackWrapper";

    private Gson gson = new Gson();

    private BaseView view;

    public APIsCallbackWrapper(BaseView view) {
        this.view = view;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            Response response = ((HttpException) t).response();
            if (response != null) {
                view.onShowError(getErrorMessage(response.errorBody()));
            } else {
                view.onShowError("Unexpected response");
            }
        } else if (t instanceof SocketTimeoutException) {
            view.onTimeout();
        } else if (t instanceof IOException) {
            view.onNetworkError();
        } else {
            view.onShowError("Unexpected response");
        }
    }

    @Override
    public void onComplete() {
        view.hideLoading();
    }

    protected abstract void onSuccess(T t);

    private String getErrorMessage(ResponseBody errorBody) {
        String message = "Unexpected response";
        if (errorBody != null) {
            String body = null;
            try {
                body = errorBody.string();
            } catch (IOException e) {
                Log.d(TAG, "parseErrorMessage() called with: errorBody = [" + errorBody + "] IOException is: " + e.getMessage());
            }
            try {
                if (!TextUtils.isEmpty(body)) {
                    APIArrayError error = gson.fromJson(body, APIArrayError.class);
                    message = error.getMessage();
                } else {
                    message = "Network error";
                }
            } catch (JsonSyntaxException e) {
                message = "Data structure issue";
            }
        }
        return message;
    }
}
