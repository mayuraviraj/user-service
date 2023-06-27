package com.mayura.online.banking.userservice.infarstructure.web;

import lombok.Builder;

@Builder
public record UserVO(Long id,
                     String extId,
                     String firstName,
                     String lastName,
                     String email,
                     AddressVO address) {
}
