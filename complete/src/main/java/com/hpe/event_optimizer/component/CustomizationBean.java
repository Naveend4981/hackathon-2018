package com.hpe.event_optimizer.component;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean {
	public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8085);
        // Use port of your choice that is available
    }

}
