package com.mayura.online.banking.userservice.infarstructure.web;

import lombok.Builder;

@Builder
public record UserVO(String id,
                     String firstName,
                     String lastName,
                     String email,
                     AddressVO address) {
}
