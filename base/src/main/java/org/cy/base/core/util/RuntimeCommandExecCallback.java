package org.cy.base.core.util;

import java.io.InputStream;

public interface RuntimeCommandExecCallback {

    void onSuccess(InputStream info) throws Exception;

    void onFaild(InputStream error, int exitValue) throws Exception;
}