package com.example.weekthree.data.api.service;

import com.example.weekthree.data.api.pojo.RequestPojo;

import retrofit2.http.GET;
import rx.Single;

public interface GetAllRoutesService {

    @GET("trips")
    Single<RequestPojo> getAllRoutesRequestPojoSingle();
}
