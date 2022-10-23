package com.business_helper.backend_application.exception

import java.lang.RuntimeException

class WorkerNotFoundException (s: String) : RuntimeException(s) {
}
