package cn.dfordog.common.exception

import java.lang.RuntimeException

class TokenExpireException : RuntimeException() {

    override val cause: Throwable?
        get() = super.cause
    override val message: String?
        get() = super.message
}