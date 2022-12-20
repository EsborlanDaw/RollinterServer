
package net.ausiasmarch.rollinter.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


public class UserBean {

    @Schema(example = "esbo")
    private String username;
    @Schema(example = "7590df9224ab787197af9237b0c46d032fa9f8f631fa23bb5045311eeb4e813d")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
