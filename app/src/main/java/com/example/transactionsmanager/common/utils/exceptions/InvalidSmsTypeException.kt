package com.example.transactionsmanager.common.utils.exceptions

import java.lang.Exception

class InvalidSmsTypeException : Exception
{
    constructor() : super()
    constructor(errorInfo: String) : super(errorInfo)
    constructor(errorInfo: String, cause: Throwable) : super(errorInfo, cause)
    constructor(cause: Throwable) : super(cause)
}