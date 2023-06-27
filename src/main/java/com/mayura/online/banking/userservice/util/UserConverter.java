package com.mayura.online.banking.userservice.util;

import com.mayura.online.banking.userservice.domain.Address;
import com.mayura.online.banking.userservice.domain.User;
import com.mayura.online.banking.userservice.infarstructure.web.AddressVO;
import com.mayura.online.banking.userservice.infarstructure.web.UserVO;

public class UserConverter {

    public static UserVO toUserValueObject(User domainUser){
        if(domainUser == null){
            return null;
        } else {
            return UserVO.builder()
                    .id(domainUser.getId())
                    .extId(domainUser.getExtId())
                    .email(domainUser.getEmail())
                    .firstName(domainUser.getFirstName())
                    .lastName(domainUser.getLastName())
                    .address(toAddressValueObject(domainUser.getAddress()))
                    .build();
        }
    }

    private static AddressVO toAddressValueObject(Address domainUserAddress) {
        if(domainUserAddress == null){
            return null;
        } else {
            return AddressVO.builder()
                    .id(domainUserAddress.getId())
                    .addressLineOne(domainUserAddress.getAddressLineOne())
                    .addressLineTwo(domainUserAddress.getAddressLineTwo())
                    .city(domainUserAddress.getCity())
                    .country(domainUserAddress.getCountry())
                    .build();
        }
    }

    public static User toUserDomainObject(UserVO user) {
        if(user == null){
            return null;
        } else {
            return User.builder()
                    .extId(user.extId())
                    .firstName(user.firstName())
                    .lastName(user.lastName())
                    .email(user.email())
                    .address(toAddressDomainObject(user.address()))
                    .build();
        }
    }

    public static Address toAddressDomainObject(AddressVO addressVO){
        if(addressVO == null){
            return null;
        } else {
            return Address.builder()
                    .addressLineOne(addressVO.addressLineOne())
                    .addressLineTwo(addressVO.addressLineTwo())
                    .city(addressVO.city())
                    .country(addressVO.country())
                    .build();
        }
    }
}
