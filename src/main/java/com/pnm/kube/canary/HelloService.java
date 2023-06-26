package com.pnm.kube.canary;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.api.logs.GlobalLoggerProvider;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloService {

	@RequestMapping("/svc")
	public String hello() throws IOException {

		log.debug("In Testing Logs HelloService Service. debug");
		log.trace("In Testing Logs HelloService Service. trace");
		log.info("In Testing Logs HelloService Service. info");
		return String.format("doctor-service This is hello from doctor service!!");

	}
}
