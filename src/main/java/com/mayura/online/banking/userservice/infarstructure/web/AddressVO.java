package com.mayura.online.banking.userservice.infarstructure.web;

import lombok.Builder;

@Builder
public record AddressVO(String id,
                        String addressLineOne,
                        String addressLineTwo,
                        String city,
                        String country) {
}

