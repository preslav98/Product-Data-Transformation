package com.endava.ProductDataTransformation.routes;

import com.endava.ProductDataTransformation.model.ProductDataInput;
import com.endava.ProductDataTransformation.model.ProductDataOutput;
import com.endava.ProductDataTransformation.processor.LoggingErrorProcessor;
import com.endava.ProductDataTransformation.processor.ProductDataProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataRouteBuilder extends RouteBuilder {

    @Autowired
    private ProductDataProcessor processor;

    @Override
    public void configure() throws Exception {

        from("file:C:/ProductData/input?noop=true")
                .unmarshal(new JacksonDataFormat(ProductDataInput.class))
                .bean(processor)
                .errorHandler(deadLetterChannel("file:C:/ProductData/output/error").useOriginalMessage().onExceptionOccurred(new LoggingErrorProcessor()))
                .setHeader("fileName", simple("${body.sku}"))
                .marshal(new JacksonDataFormat(ProductDataOutput.class))
                .to("file:C:/ProductData/output?fileName=${header.fileName}.json")
                .end();

    }
}
