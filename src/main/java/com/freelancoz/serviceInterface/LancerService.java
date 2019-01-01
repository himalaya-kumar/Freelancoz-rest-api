package com.freelancoz.serviceInterface;


import com.freelancoz.model.Client;

public interface LancerService {
//No of projects associated to it.
    Integer projectCount();
    Integer projectAssociatedToSpecificClient(Client client);
}