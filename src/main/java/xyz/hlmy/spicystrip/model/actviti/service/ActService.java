package xyz.hlmy.spicystrip.model.actviti.service;

import java.io.IOException;

public interface ActService {
    byte[] getFlowImgByProcInstId(String procInstId) throws IOException;
}
