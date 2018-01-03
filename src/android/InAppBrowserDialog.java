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

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

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

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.*;


/**
 * Created by Oliver on 22/11/2013.
 */
public class InAppBrowserDialog extends Dialog {
    Context context;
    InAppBrowser inAppBrowser = null;

    // Define a static logger variable so that it references the
   // Logger instance named "MyApp".
   static Logger logger = Logger.getLogger(InAppBrowserDialog.class);

    //Logger logger = Logger.getLogger(InAppBrowserDialog.class.getName());

    public InAppBrowserDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;

        //SimpleLogger thing = new SimpleLogger();
        //thing.onBackPressed();
    }

    public void setInAppBroswer(InAppBrowser browser) {
        this.inAppBrowser = browser;

        // Set up a simple configuration that logs on the console.
     BasicConfigurator.configure();
    }

    public void onBackPressed () {
      
     //fLogger.finest("back pressed");
       logger.info("Entering application.");

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
