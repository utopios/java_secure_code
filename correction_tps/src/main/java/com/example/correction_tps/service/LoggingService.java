package com.example.correction_tps.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class LoggingService {
    private static final Logger accessLog = LoggerFactory.getLogger("com.example.access");
    private static final Logger errorLog = LoggerFactory.getLogger("com.example.error");
    private static final Logger debugLog = LoggerFactory.getLogger("com.example.debug");
    private static final Logger auditLog = LoggerFactory.getLogger("com.example.audit");
    private static final Logger regulatoryLog = LoggerFactory.getLogger("com.example.regulatory");

    public void logAccess(String message) {
        accessLog.info("User accessed the system. "+message);
    }

    public void logError(String message) {
        errorLog.error("An error occurred while processing the request." +message);
    }

    public void logDebug(String message) {
        debugLog.debug("Debugging application performance. "+message);
    }

    public void logAudit(String message) {
        auditLog.info("Audit log: User action recorded. "+message);
    }

    public void logRegulatory(String message) {
        regulatoryLog.info("Regulatory log: Compliance action recorded. "+message);
    }
}
