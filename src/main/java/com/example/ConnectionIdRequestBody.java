package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.UUID;

@JsonPropertyOrder({"connectionId"})
public class ConnectionIdRequestBody {
    public static final String JSON_PROPERTY_CONNECTION_ID = "connectionId";
    private UUID connectionId;

    public ConnectionIdRequestBody() {
    }

    public ConnectionIdRequestBody connectionId(UUID connectionId) {
        this.connectionId = connectionId;
        return this;
    }

    @Nonnull
    @JsonProperty("connectionId")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public UUID getConnectionId() {
        return this.connectionId;
    }

    @JsonProperty("connectionId")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public void setConnectionId(UUID connectionId) {
        this.connectionId = connectionId;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ConnectionIdRequestBody connectionIdRequestBody = (ConnectionIdRequestBody)o;
            return Objects.equals(this.connectionId, connectionIdRequestBody.connectionId);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.connectionId});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionIdRequestBody {\n");
        sb.append("    connectionId: ").append(this.toIndentedString(this.connectionId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
