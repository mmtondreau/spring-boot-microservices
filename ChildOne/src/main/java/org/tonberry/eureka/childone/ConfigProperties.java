package org.tonberry.eureka.childone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@ConfigurationProperties(prefix = "my")
public class ConfigProperties {
    private String pingMessage;

    public String getPingMessage() {
        return pingMessage;
    }

    public void setPingMessage(String pingMessage) {
        this.pingMessage = pingMessage;
    }
}
