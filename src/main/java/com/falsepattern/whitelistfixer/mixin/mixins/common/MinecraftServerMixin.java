package com.falsepattern.whitelistfixer.mixin.mixins.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.server.MinecraftServer;

import java.net.Proxy;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @WrapOperation(method = "<init>",
                   at = @At(value = "NEW",
                            target = "(Ljava/net/Proxy;Ljava/lang/String;)Lcom/mojang/authlib/yggdrasil/YggdrasilAuthenticationService;"),
                   require = 1)
    private YggdrasilAuthenticationService replaceAuthService(Proxy proxy, String clientToken, Operation<YggdrasilAuthenticationService> original) {
        return new com.falsepattern.whitelistfixer.YggdrasilAuthenticationService(proxy, clientToken);
    }
}
