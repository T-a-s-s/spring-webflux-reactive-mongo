package br.com.neoholding.oi.garcom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.ipc.netty.NettyContext;
import reactor.ipc.netty.http.server.HttpServer;

@ComponentScan(basePackages = {"br.com.neoholding.oi.garcom"})
@EnableWebFlux
public class OiGarcomApiApplication {

	@Bean
	public NettyContext nettyContext(ApplicationContext context) {
		HttpHandler handler = WebHttpHandlerBuilder
				.applicationContext(context).build();
		ReactorHttpHandlerAdapter adapter
				= new ReactorHttpHandlerAdapter(handler);
		HttpServer httpServer = HttpServer.create("localhost", 8080);
		return httpServer.newHandler(adapter).block();
	}

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context
					 = new AnnotationConfigApplicationContext(
				OiGarcomApiApplication.class)) {

			context.getBean(NettyContext.class).onClose().block();
		}
	}
}
