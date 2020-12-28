package org.cy.base.core.util;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeCommandExector {
    private static final RuntimeCommandExector INSTANCE = new RuntimeCommandExector();
    private int exitValue;

    private RuntimeCommandExector() {
    }

    public InputStream exec(String command, RuntimeCommandExecCallback callback) throws Exception {
        Process p = Runtime.getRuntime().exec(command);
        InputStream info = p.getInputStream();
        InputStream error = p.getErrorStream();
        p.waitFor();
        if (p.exitValue() != 0) {
            callback.onFaild(error, exitValue);
            return error;
        }
        callback.onSuccess(info);
        return info;
    }

    public static RuntimeCommandExector getINSTANCE() {
        return INSTANCE;
    }
}
