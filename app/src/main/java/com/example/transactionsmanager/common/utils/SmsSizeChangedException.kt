package com.example.transactionsmanager.common.utils

import java.lang.Exception

class SmsSizeChangedException : Exception
{
    constructor() : super()
    constructor(errorInfo: String) : super(errorInfo)
    constructor(errorInfo: String, cause: Throwable) : super(errorInfo, cause)
    constructor(cause: Throwable) : super(cause)
}