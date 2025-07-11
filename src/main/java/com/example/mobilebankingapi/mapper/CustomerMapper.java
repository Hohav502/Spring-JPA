package com.example.mobilebankingapi.mapper;

import com.example.mobilebankingapi.domain.Customer;
import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.dto.UpdateCustomerRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // Partially update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartially(UpdateCustomerRequest updateCustomerRequest,
                             @MappingTarget Customer customer);

    //DTO -> Model
    //Model -> DTO
    //return type is converted data
    //parameter is source data



    CustomerRespone fromCustomer(Customer customer);

    Customer toCustomer(CreateCustomerRequest createCustomerRequest);

}
