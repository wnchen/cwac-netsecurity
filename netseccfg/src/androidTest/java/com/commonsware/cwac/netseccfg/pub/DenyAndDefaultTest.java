package com.commonsware.cwac.netseccfg.pub;

import com.commonsware.cwac.netseccfg.TrustManagerBuilder;

public class DenyAndDefaultTest extends SimpleHTTPSTest {
  @Override
  protected TrustManagerBuilder getBuilder() throws Exception {
    return(new TrustManagerBuilder().denyAll().and().useDefault());
  }

  @Override
  protected boolean isPositiveTest() {
    return(false);
  }
}