package com.falsepattern.whitelistfixer;

import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.response.Response;

import java.net.Proxy;
import java.net.URL;

public final class YggdrasilAuthenticationService extends com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService {
    public YggdrasilAuthenticationService(Proxy proxy, String clientToken) {
        super(proxy, clientToken);
    }

    @Override
    public GameProfileRepository createProfileRepository() {
        return new YggdrasilGameProfileRepository(this);
    }

    protected <T extends Response> T makeRequest(URL url, Object input, Class<T> classOfT) throws AuthenticationException {
        return super.makeRequest(url, input, classOfT);
    }
}