package com.endava.ProductDataTransformation.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingErrorProcessor implements Processor {
    private Logger logger = Logger.getLogger(LoggingErrorProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.debug(exchange.getProperty(Exchange.EXCEPTION_CAUGHT));
    }
}
