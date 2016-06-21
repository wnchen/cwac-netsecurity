/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.commonsware.cwac.netseccfg.config;
import android.os.Environment;
import android.os.UserHandle;
import java.io.File;
/**
 * {@link CertificateSource} based on the system trusted CA store.
 * @hide
 */
public final class SystemCertificateSource extends DirectoryCertificateSource {
  private static final SystemCertificateSource INSTANCE = new SystemCertificateSource();
//  private final File mUserRemovedCaDir;
  private SystemCertificateSource() {
    super(new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts"));
//    File configDir = Environment.getUserConfigDirectory(UserHandle.myUserId());
//    mUserRemovedCaDir = new File(configDir, "cacerts-removed");
  }
  public static SystemCertificateSource getInstance() {
    return INSTANCE;
  }
  @Override
  protected boolean isCertMarkedAsRemoved(String caFile) {
    //return new File(mUserRemovedCaDir, caFile).exists();
    return(false);
  }
}