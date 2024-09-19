package com.example.demo_jour_2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class LoggingExample {
    private static final Logger accessLog = LoggerFactory.getLogger("com.example.access");
    private static final Logger errorLog = LoggerFactory.getLogger("com.example.error");
    private static final Logger debugLog = LoggerFactory.getLogger("com.example.debug");
    private static final Logger auditLog = LoggerFactory.getLogger("com.example.audit");
    private static final Logger regulatoryLog = LoggerFactory.getLogger("com.example.regulatory");

    public void logAccess() {
        accessLog.info("User accessed the system.");
    }

    public void logError() {
        errorLog.error("An error occurred while processing the request.");
    }

    public void logDebug() {
        debugLog.debug("Debugging application performance.");
    }

    public void logAudit() {
        auditLog.info("Audit log: User action recorded.");
    }

    public void logRegulatory() {
        regulatoryLog.info("Regulatory log: Compliance action recorded.");
    }
}
