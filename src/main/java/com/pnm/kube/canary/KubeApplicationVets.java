package com.pnm.kube.canary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.opentelemetry.api.logs.GlobalLoggerProvider;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class KubeApplicationVets {

	public static void main(String[] args) {

		String oltpEndpointEnv = "my-otel-demo-otelcol-contrib"; // System.getenv("OTEL_EXPORTER_OTLP_ENDPOINT")
		String oltpEndpoint = "http://101.132.174.5:4317/";

		GlobalLoggerProvider
				.set(SdkLoggerProvider.builder()
						.setResource(Resource.getDefault().toBuilder()
								.put(ResourceAttributes.SERVICE_NAME, "doc-service").build())
						.addLogRecordProcessor(
								BatchLogRecordProcessor
										.builder(OtlpGrpcLogRecordExporter.builder()
												.setEndpoint(oltpEndpoint).build())
										.build())
						.build());

		log.debug("In Testing Logs KubeApplicationVets Service. debug");
		log.trace("In Testing Logs KubeApplicationVets Service. trace");
		log.info("In Testing Logs KubeApplicationVets Service. info");
		SpringApplication.run(KubeApplicationVets.class, args);

	}

}
