/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova.inappbrowser;

import android.app.AlertDialog;
import android.app.Dialog;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eghl.android.sdk.R;
import com.eghl.sdk.interfaces.CaptureCallback;
import com.eghl.sdk.interfaces.MasterpassCallback;
import com.eghl.sdk.interfaces.QueryCallback;
import com.eghl.sdk.masterpass.MasterPassActivity;
import com.eghl.sdk.params.CaptureParams;
import com.eghl.sdk.params.MasterpassParams;
import com.eghl.sdk.params.Params;
import com.eghl.sdk.params.PaymentParams;
import com.eghl.sdk.params.QueryParams;
import com.eghl.sdk.payment.PaymentActivity;
import com.eghl.sdk.response.CaptureResponse;
import com.eghl.sdk.response.QueryResponse;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by Oliver on 22/11/2013.
 */
public class InAppBrowserDialog extends Dialog {
    Context context;
    InAppBrowser inAppBrowser = null;
    private static final String TAG = "EGHL";

    public InAppBrowserDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public void setInAppBroswer(InAppBrowser browser) {
        this.inAppBrowser = browser;
    }

    public void onBackPressed () {
      ELogger.e(TAG, "back pressed" , e);
        if (this.inAppBrowser == null) {
            this.dismiss();
        } else {
            // better to go through the in inAppBrowser
            // because it does a clean up
            if (this.inAppBrowser.hardwareBack() && this.inAppBrowser.canGoBack()) {
                this.inAppBrowser.goBack();
            }  else {
                this.inAppBrowser.closeDialog();
            }
        }
    }
}
