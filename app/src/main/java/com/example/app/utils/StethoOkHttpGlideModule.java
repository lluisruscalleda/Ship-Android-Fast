/*
 *     Copyright (c) 2015-present Victor Hidalgo Lorenzo
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.example.app.utils;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp.OkHttpGlideModule;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;
import java.io.InputStream;

/**
 * Author: Victor Hidalgo
 * Date: 10.06.15.
 */
public class StethoOkHttpGlideModule extends OkHttpGlideModule {
  @Override
  public void applyOptions(Context context, GlideBuilder builder) {
  }

  @Override
  public void registerComponents(Context context, Glide glide) {
    OkHttpClient client = new OkHttpClient();
    client.networkInterceptors().add(new StethoInterceptor());
    glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(client));
  }
}
