/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.google.samples.apps.nowinandroid.core.network.di

import android.util.Log
import androidx.tracing.trace
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class NetworkTracingInterceptor: Interceptor {
    override fun intercept(chain: Chain): Response {
        val request = chain.request()
        Log.e("NETWORK", "NETWORK: ${request.url}")
        return trace("NETWORK: ${request.url}".take(126)) {
            chain.proceed(request)
        }
    }
}