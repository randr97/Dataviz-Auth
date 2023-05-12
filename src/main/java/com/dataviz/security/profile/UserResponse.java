package com.dataviz.security.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

  @JsonProperty("message")
  private String message;
//   @JsonProperty("refresh_token")
//   private String refreshToken;
}
